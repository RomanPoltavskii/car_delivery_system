public class Main {
    public static void main(String[] args) throws Exception {
        PostgreSQLConnection postgresqlConnection = new PostgreSQLConnection();
        ServerContainer serverContainer = new ServerContainer(postgresqlConnection);
        serverContainer.serverDrive();
    }
}
