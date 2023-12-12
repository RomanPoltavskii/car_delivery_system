import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private PostgreSQLConnection connection;
    private Class table;

    public Servlet(PostgreSQLConnection connection, Class table) {
        this.connection = connection;
        this.table = table;
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("Id"));
        ResultSet resultSet;

        if(id == null)
            resultSet = connection.executeQuaery(
                    SQLRquests.find(table)
            );
        else
            resultSet = connection.executeQuaery(
                    SQLRquests.find(table, id)
            );

        HttpHelper.printResultSet(resultSet, table, response);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object object = HttpHelper.readObj(request, table, "_");
        connection.execute(
                SQLRquests.insert(object)
        );
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("Id"));

        connection.execute(
                SQLRquests.delete(table, id)
        );
    }
    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("Id"));
        Object object = HttpHelper.readObj(request, table, "_");
        connection.execute(
                SQLRquests.update(table, id, object)
        );
    }


}
