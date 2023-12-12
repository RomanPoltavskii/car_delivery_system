import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ConsoleRead {


    public static void start(PostgreSQLConnection postgresqlConnection) throws Exception {
        boolean flag = true;
        while (flag){
            flag = nextCommand(postgresqlConnection);
        }
    }
    private static boolean nextCommand(PostgreSQLConnection postgresqlConnection) throws Exception {
        System.out.println("wait command...");
        String command = new Scanner(System.in).nextLine().trim();
        System.out.println("wait table name...");
        String tableName = new Scanner(System.in).nextLine().trim();
        if(command.equals("find all")){
            printResultSet(
                    postgresqlConnection.executeQuaery(SQLRquests.find(tableName)),
                    Reflection.createClass(tableName)
            );
        } else if (command.equals("find")) {
            System.out.println("wait id");
            int id = new Scanner(System.in).nextInt();
            printResultSet(
                    postgresqlConnection.executeQuaery(SQLRquests.find(tableName, id)),
                    Reflection.createClass(tableName)
            );
        } else if (command.equals("delete")) {
            System.out.println("wait id");
            int id = new Scanner(System.in).nextInt();
            postgresqlConnection.execute(SQLRquests.delete(tableName, id));
        } else if (command.equals("insert")) {
            Object obj = read(tableName);
            postgresqlConnection.execute(SQLRquests.insert(obj));
        } else if (command.equals("update")) {
            System.out.println("wait id");
            int id = new Scanner(System.in).nextInt();
            Object obj = read(tableName);
            postgresqlConnection.execute(SQLRquests.update(tableName, id, obj));
        }


        return true;
    }



    private static void printResultSet(ResultSet rs, Class c) throws SQLException {
        List<Field> fields = Reflection.getFields(c);
        while (rs.next()){
            for (Field f:fields) {
                System.out.println(
                        "%s: %s".formatted(f.getName(), rs.getObject(f.getName()))
                );
            }
            System.out.println();
        }
    }
    private static Object read(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Object o = Reflection.createObject(name);
        Scanner scanner = new Scanner(System.in);
        for (Field f: Reflection.getFields(o.getClass())) {
            System.out.print("wait " + f.getName());
            String value = scanner.nextLine().trim();
            if(value.isEmpty())
                continue;
            Reflection.setValue(o, f.getName(), convertValue(value, f.getType()));;
        }
        return o;
    }
    private static Object convertValue(String val, Class type){
        if (type.equals(Integer.class) || type.equals(int.class))
            return Integer.parseInt(val);
        if (type.equals(Long.class) || type.equals(long.class))
            return Long.parseLong(val);
        return val;
    }



}
