package quanghung.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duong
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String GET_LIST = "GetList";
    private static final String GET_LIST_CONTROLLER = "GetListController";
    private static final String GET_LIST_WAREHOUSE = "GetListWarehouse";
    private static final String GET_LIST_WAREHOUSE_CONTROLLER = "GetListWarehouseController";
    private static final String INPUT_DEVICE_INFORMATION = "InputDeviceInfo";
    private static final String INPUT_DEVICE_INFORMATION_CONTROLLER = "InputDeviceInfoController";
    private static final String CREATE_DEVICE = "CreateDevice";
    private static final String CREATE_DEVICE_CONTROLLER = "CreateDeviceController";
    private static final String CREATE_WAREHOUSE = "createWarehouse";
    private static final String CREATE_WAREHOUSE_CONTROLLER = "CreateWarehouseController";
    private static final String SEARCH_DEVICE = "SearchDevice";
    private static final String SEARCH_DEVICE_CONTROLLER = "SearchDeviceController";
    private static final String DELETE_WAREHOUSE = "DeleteWarehouse";
    private static final String DELETE_WAREHOUSE_CONTROLLER = "DeleteWarehouseController";
    private static final String UPDATE_WAREHOUSE = "UpdateWarehouse";
    private static final String UPDATE_WAREHOUSE_CONTROLLER = "UpdateWarehouseController";
    private static final String CREATE_CATEGORY = "CreateCategory";
    private static final String CREATE_CATEGORY_CONTROLLER = "CreateCategoryController";
    private static final String FIND_PRODUCT = "FindProduct";
    private static final String FIND_PRODUCT_CONTROLLER = "FindProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");

            if (CREATE_WAREHOUSE.equals(action)) {
                url = CREATE_WAREHOUSE_CONTROLLER;
            } else if (SEARCH_DEVICE.equals(action)) {
                url = SEARCH_DEVICE_CONTROLLER;
            } else if (DELETE_WAREHOUSE.equals(action)) {
                url = DELETE_WAREHOUSE_CONTROLLER;
            } else if (UPDATE_WAREHOUSE.equals(action)) {
                url = UPDATE_WAREHOUSE_CONTROLLER;
            } else if (FIND_PRODUCT.equals(action)) {
                url = FIND_PRODUCT_CONTROLLER;
            } else if (GET_LIST.equals(action)) {
                url = GET_LIST_CONTROLLER;
            } else if (INPUT_DEVICE_INFORMATION.equals(action)) {
                url = INPUT_DEVICE_INFORMATION_CONTROLLER;
            } else if (CREATE_CATEGORY.equals(action)) {
                url = CREATE_CATEGORY_CONTROLLER;
            } else if (GET_LIST_WAREHOUSE.equals(action)) {
                url = GET_LIST_WAREHOUSE_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
