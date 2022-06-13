package quanghung.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quanghung.category.CategoryDAO;
import quanghung.category.CategoryDTO;
import quanghung.category.CategoryError;

public class CreateCategoryController extends HttpServlet {

    private static final String ERROR = "createCategory.jsp";
    private static final String SUCCESS = "createCategory.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        CategoryError categoryError = new CategoryError();
        try {
            boolean checkValidation = true;
            HttpSession session = request.getSession();
            CategoryDAO dao = new CategoryDAO();
            String cateID = request.getParameter("cateID");
            String cateName = request.getParameter("cateName");
            boolean checkDuplicate = dao.checkDuplicate(cateID);
            if (checkDuplicate) {
                categoryError.setCateIDError("Duplicate CateID");
                checkValidation = false;
            }
            if (cateID.length() > 10) {
                categoryError.setCateIDError("CateID must not exceed 10 characters");
                checkValidation = false;
            }
            if (cateName.length() > 50) {
                categoryError.setCateNameError("CateName must not exceed 50 characters");
                checkValidation = false;
            }
            if(checkValidation) {
                CategoryDTO category = new CategoryDTO(cateID, cateName, true);
                dao.createCategory(category);
                url = SUCCESS;
                session.setAttribute("CATEGORY", category);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                categoryError.getCateIDError("Duplicate Cate ID");
            }
            log("Error at Create Category Controller: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
