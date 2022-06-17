package quanghung.descriptionDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import quanghung.utils.DBUtils;

public class DescriptionDetailDAO {

    private static final String SEARCH_DESCRIPTION_DETAIL = "SELECT detailID, descriptionID, detailName, status FROM descriptionDetail WHERE detailName like ?";
    private static final String GET_LIST_DESCRIPTION_DETAIL = "SELECT detailID, descriptionID, detailName, status FROM descriptionDetail WHERE descriptionID=?";
    private static final String DELETE_DESCRIPTION_DETAIL = "UPDATE descriptionDetail SET status=? WHERE detailID=?";
    private static final String UPDATE_DESCRIPTION_DETAIL = "UPDATE descriptionDetail SET detailName=? WHERE detailID=?";
    private static final String CREATE_DESCRIPTION_DETAIL = "INSERT INTO descriptionDetail(descriptionID,detailName,status) VALUES (?,?,?)";
    private static final String GET_DESCRIPTION_NAME = "SELECT d.descriptionName FROM descriptionDetail dd, description d WHERE dd.detailID = ? AND d.descriptionID = dd.descriptionID";

    public String getDescriptionName(int detailID) throws SQLException {
        String descriptionName = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_DESCRIPTION_NAME);
                ptm.setInt(1, detailID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    descriptionName = rs.getString("descriptionName");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return descriptionName;
    }

    public boolean createDescriptionDetail(DescriptionDetailDTO detail) throws SQLException, NamingException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_DESCRIPTION_DETAIL);
                ptm.setInt(1, detail.getDescriptionID());
                ptm.setString(2, detail.getDetailName());
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

    public boolean deleteDescriptionDetail(String detailID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_DESCRIPTION_DETAIL);
                ptm.setBoolean(1, false);
                ptm.setString(2, detailID);
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

    public boolean updateDescriptionDetail(DescriptionDetailDTO detail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_DESCRIPTION_DETAIL);
                ptm.setString(1, detail.getDetailName());
                ptm.setInt(2, detail.getDetailID());
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

    public List<DescriptionDetailDTO> getListDescriptionDetail(int descriptionID) throws SQLException {
        List<DescriptionDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_DESCRIPTION_DETAIL);
                ptm.setInt(1, descriptionID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    boolean status = rs.getBoolean("status");
                    if (status) {
                        int detailID = rs.getInt("detailID");
                        String detailName = rs.getString("detailName");
                        list.add(new DescriptionDetailDTO(detailID, descriptionID, detailName, status));
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
