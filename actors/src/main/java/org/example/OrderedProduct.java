package org.example;



import java.util.List;


public class OrderedProduct {
    private Long id;
    private Integer total;
    private String orderStatus;
    private Client client;

    private List<Product> products;
    private ShippingAddress address;

    public OrderedProduct() {
    }

    public OrderedProduct(Long id, Integer total, String orderStatus, Client client, List<Product> products, ShippingAddress address) {
        this.id = id;
        this.total = total;
        this.orderStatus = orderStatus;
        this.client = client;
        this.products = products;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShippingAddress getAddress() {
        return address;
    }

    public void setAddress(ShippingAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Заказанные товары{" +
                "id=" + id +
                ", total=" + total +
                ", статус заказа='" + orderStatus + '\'' +
                ", клиент=" + client +
                ", заказы=" + products +
                ", адрес=" + address +
                '}';
    }
}
