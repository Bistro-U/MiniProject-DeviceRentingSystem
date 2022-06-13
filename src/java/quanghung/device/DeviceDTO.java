package quanghung.device;

public class DeviceDTO {

    private int deviceID;
    private String deviceName;
    private int warehouseID;
    private int brandID;
    private int quantity;
    private String cateID;
    private boolean status;

    public DeviceDTO() {
        this.deviceID = 0;
        this.deviceName = "";
        this.warehouseID = 0;
        this.brandID = 0;
        this.quantity = 0;
        this.cateID = "";
        this.status = true;
    }

    public DeviceDTO(int deviceID, String deviceName, int warehouseID, int brandID, int quantity, String cateID, boolean status) {
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.warehouseID = warehouseID;
        this.brandID = brandID;
        this.quantity = quantity;
        this.cateID = cateID;
        this.status = status;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandName(int brandID) {
        this.brandID = brandID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
