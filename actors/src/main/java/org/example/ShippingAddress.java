package org.example;

public class ShippingAddress {
    private Long id;
    private String address;
    private Long orderId;

    public ShippingAddress() {
    }

    public ShippingAddress(Long id, String address, Long orderId) {
        this.id = id;
        this.address = address;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
