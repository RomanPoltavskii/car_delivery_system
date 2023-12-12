import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.*;

import java.io.FileInputStream;
import java.util.List;

public class InsertDriver {
    public static void main(String[] args) throws Exception {
        PostgreSQLConnection postgresqlConnection = new PostgreSQLConnection();


        postgresqlConnection.execute(SQLRquests.drop(Client.class));
        postgresqlConnection.execute(SQLRquests.drop(ShippingAddress.class));
        postgresqlConnection.execute(SQLRquests.drop(OrderedProduct.class));
        postgresqlConnection.execute(SQLRquests.drop(Product.class));
        postgresqlConnection.execute(SQLRquests.drop(Provider.class));
        postgresqlConnection.execute(SQLRquests.drop(Storehouse.class));

        postgresqlConnection.execute(SQLRquests.create(Client.class));
        postgresqlConnection.execute(SQLRquests.create(ShippingAddress.class));
        postgresqlConnection.execute(SQLRquests.create(OrderedProduct.class));
        postgresqlConnection.execute(SQLRquests.create(Product.class));
        postgresqlConnection.execute(SQLRquests.create(Provider.class));
        postgresqlConnection.execute(SQLRquests.create(Storehouse.class));


        List<OrderedProduct> ordersProducts = new ObjectMapper().readValue(new FileInputStream("orderProducts.json"),
                new TypeReference<List<OrderedProduct>>() {});

        for (OrderedProduct o:ordersProducts) {
            postgresqlConnection.execute(SQLRquests.insert(o));
            postgresqlConnection.execute(SQLRquests.insert(o.getClient()));
            for (Product p:o.getProducts()) {
                postgresqlConnection.execute(SQLRquests.insert(p));
                postgresqlConnection.execute(SQLRquests.insert(p.getProvider()));
                postgresqlConnection.execute(SQLRquests.insert(p.getStorehouse()));
            }
            postgresqlConnection.execute(SQLRquests.insert(o.getAddress()));
        }


    }
}
