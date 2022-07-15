package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection fazerConexao() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/futebol?useTimezone=true&serverTimezone=UTC",
                "root",
                "root");
    }

}
