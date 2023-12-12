package org.example;

public class Product {
    private Long id;
    private Long orderId;
    private String name;
    private Integer price;

    private Provider provider;

    private Storehouse storehouse;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    @Override
    public String toString() {
        return "Продукт{" +
                "id=" + id +
                ", Id Заказа=" + orderId +
                ", имя='" + name + '\'' +
                ", цена=" + price +
                ", продавец=" + provider +
                ", склад=" + storehouse +
                '}';
    }
}
