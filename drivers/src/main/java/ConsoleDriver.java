import org.example.Storehouse;

public class ConsoleDriver {
    public static void main(String[] args) throws Exception {

        System.out.println(Storehouse.class);
        PostgreSQLConnection postgresqlConnection = new PostgreSQLConnection();
        postgresqlConnection.execute(SQLRquests.drop(Storehouse.class));

        postgresqlConnection.execute(SQLRquests.create(Storehouse.class));


        ConsoleRead.start(postgresqlConnection);


        /*Warehouse warehouse = new Warehouse(111L, "adress", 222L, 333L);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(
                SQLQuaeryes.drop(warehouse.getClass())
        );

        System.out.println(SQLQuaeryes.create(warehouse.getClass()));

        System.out.println();
        System.out.println(SQLQuaeryes.insert(warehouse));
        System.out.println(SQLQuaeryes.delete(warehouse.getClass(), 11));
        System.out.println(SQLQuaeryes.update(warehouse.getClass(), 11, warehouse));


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");*/
    }
}
