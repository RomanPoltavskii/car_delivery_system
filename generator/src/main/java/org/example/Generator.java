package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static List<OrderedProduct> generating(long count) {


        List<OrderedProduct> orderedProduct = new ArrayList<>();


        for (long i = 0; i < count; i++) {
            OrderedProduct orderProduct = new OrderedProduct();
            orderProduct.setId(i);
            orderProduct.setTotal(new Random().nextInt());
            orderProduct.setOrderStatus("STATUS");

            Client client = new Client();
            client.setId((i+1)*1000);
            client.setName("CLIENT");
            client.setMail("MAIL@MAIL.RU");
            client.setOrderId(i);

            orderProduct.setClient(client);

            Product product = new Product();
            product.setId((i+1)*1000);
            product.setOrderId(orderProduct.getId());
            product.setName("NAME");
            product.setPrice(Math.abs(new Random().nextInt()));

            Provider provider = new Provider();
            provider.setId((i+1)*1000);
            provider.setName("SUPPLIER");
            provider.setProductId(product.getId());
            provider.setOrderId(orderProduct.getId());

            product.setProvider(provider);

            Storehouse storehouse = new Storehouse();
            storehouse.setId((i+1)*1000);
            storehouse.setAddress("ADDRESS");
            storehouse.setProductId(product.getId());
            storehouse.setOrderId(orderProduct.getId());

            product.setStorehouse(storehouse);

            orderProduct.setProducts(List.of(product));

            ShippingAddress shippingAddress = new ShippingAddress();
            shippingAddress.setId(i);
            shippingAddress.setAddress("ADDRESS");
            shippingAddress.setOrderId(orderProduct.getId());

            orderProduct.setAddress(shippingAddress);

            orderedProduct.add(orderProduct);
        }

        return orderedProduct;
    }
}
