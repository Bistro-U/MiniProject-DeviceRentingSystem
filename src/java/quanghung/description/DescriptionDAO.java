package quanghung.description;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import quanghung.utils.DBUtils;

public class DescriptionDAO {

    private static final String GET_LIST_DESCRIPTION = "SELECT descriptionID, descriptionName, cateID, status FROM description WHERE cateID=?";
    private static final String DELETE_DESCRIPTION = "UPDATE description SET status=? WHERE descriptionID=?";
    private static final String UPDATE_DESCRIPTION = "UPDATE description SET descriptionName=? WHERE descriptionID=?";
    private static final String CREATE_DESCRIPTION = "INSERT INTO description(descriptionName,cateID,status) VALUES (?,?,?)";

    public boolean createDescription(DescriptionDTO description) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_DESCRIPTION);
                ptm.setString(1, description.getDescriptionName());
                ptm.setString(2, description.getCateID());
                ptm.setBoolean(3, true);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean deleteDescription(String descriptionID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_DESCRIPTION);
                ptm.setBoolean(1, false);
                ptm.setString(2, descriptionID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateCategory(DescriptionDTO description) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_DESCRIPTION);
                ptm.setString(1, description.getDescriptionName());
                ptm.setInt(2, description.getDescriptionID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<DescriptionDTO> getListDescription(String cateID) throws SQLException {
        List<DescriptionDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_DESCRIPTION);
                ptm.setString(1, cateID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    boolean status = rs.getBoolean("status");
                    if (status) {
                        int descriptionID = rs.getInt("descriptionID");
                        String descriptionName = rs.getString("descriptionName");
                        list.add(new DescriptionDTO(descriptionID, descriptionName, cateID, status));
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
