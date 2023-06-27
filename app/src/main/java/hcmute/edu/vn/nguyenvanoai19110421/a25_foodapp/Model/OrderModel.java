package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model;

public class OrderModel {
    private int orderId;
    private int userId;
    private int phone;
    private int amount;
    private String description;
    private int status;

    public OrderModel(int orderId, int userId, int phone, int amount, String description, int status) {
        this.orderId = orderId;
        this.userId = userId;
        this.phone = phone;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
