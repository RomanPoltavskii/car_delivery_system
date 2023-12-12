package org.example;

public class Storehouse {
    private Long id;
    private String address;

    private Long productId;
    private Long orderId;

    public Storehouse() {
    }

    public Storehouse(Long id, String address, Long productId, Long orderId) {
        this.id = id;
        this.address = address;
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Склад{" +
                "id=" + id +
                ", адрес='" + address + '\'' +
                ", Id Продукта=" + productId +
                ", Id Заказа=" + orderId +
                '}';
    }
}
