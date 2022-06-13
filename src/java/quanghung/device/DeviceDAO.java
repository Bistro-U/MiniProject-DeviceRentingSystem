package quanghung.device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import quanghung.utils.DBUtils;

/**
 *
 * @author duong
 */
public class DeviceDAO {

    private static final String SEARCH_DEVICE = "SELECT deviceID, deviceName, warehouseID, brandID, quantity, cateID, status FROM device WHERE deviceName like ?";
    private static final String GET_LIST_DEVICE = "SELECT deviceID, deviceName, warehouseID, brandID, quantity, cateID, status FROM device";
    private static final String DELETE_DEVICE = "UPDATE device SET status=? WHERE deviceID=?";
    private static final String UPDATE_DEVICE = "UPDATE device SET deviceName=?, warehouseID=?, brandName=?, quantity=?, cateID=? WHERE deviceID=?";
    private static final String CREATE_DEVICE = "INSERT INTO device(deviceName,warehouseID,brandID,quantity,cateID,status) VALUES (?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT deviceID FROM device WHERE deviceName=? AND warehouseID=?";
    private static final String GET_DEVICE_ID = "SELECT deviceID FROM device WHERE deviceName=?";


    public boolean checkDuplicate(String deviceName, int warehouseID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, deviceName);
                ptm.setInt(2, warehouseID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public int getDeviceID(String deviceName) throws SQLException {
        int deviceID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_DEVICE_ID);
                ptm.setString(1, deviceName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    deviceID = rs.getInt("deviceID");
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
        return deviceID;
    }

    public boolean createDevice(String deviceName, int warehouseID, int brandID, int quantity, String cateID) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_DEVICE);
                ptm.setString(1, deviceName);
                ptm.setInt(2, warehouseID);
                ptm.setInt(3, brandID);
                ptm.setInt(4, quantity);
                ptm.setString(5, cateID);
                ptm.setBoolean(6, true);
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

    public boolean updateDevice(DeviceDTO device) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_DEVICE);
                ptm.setString(1, device.getDeviceName());
                ptm.setInt(2, device.getWarehouseID());
                ptm.setInt(3, device.getBrandID());
                ptm.setInt(4, device.getQuantity());
                ptm.setString(5, device.getCateID());
                ptm.setInt(8, device.getDeviceID());
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

    public boolean deleteDevice(String deviceID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_DEVICE);
                ptm.setBoolean(1, false);
                ptm.setString(2, deviceID);
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

    public List<DeviceDTO> getListDevice(String search) throws SQLException {
        List<DeviceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                if (search != "") {
                    ptm = conn.prepareStatement(SEARCH_DEVICE);
                    ptm.setString(1, "%" + search + "%");
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        boolean status = rs.getBoolean("status");
                        if (status) {
                            int deviceID = rs.getInt("deviceID");
                            String deviceName = rs.getString("deviceName");
                            int warehouseID = rs.getInt("warehouseID");
                            int brandID = rs.getInt("brandID");
                            int quantity = rs.getInt("quantity");
                            String cateID = rs.getString("cateID");
                            list.add(new DeviceDTO(deviceID, deviceName, warehouseID, brandID, quantity, cateID, status));
                        }
                    }
                } else {
                    ptm = conn.prepareStatement(GET_LIST_DEVICE);
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        boolean status = rs.getBoolean("status");
                        if (status) {
                            int deviceID = rs.getInt("deviceID");
                            String deviceName = rs.getString("deviceName");
                            int warehouseID = rs.getInt("warehouseID");
                            int brandID = rs.getInt("brandID");
                            int quantity = rs.getInt("quantity");
                            String cateID = rs.getString("cateID");
                            list.add(new DeviceDTO(deviceID, deviceName, warehouseID, brandID, quantity, cateID, status));
                        }
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
