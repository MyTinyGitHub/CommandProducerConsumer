package main.database;

import java.sql.*;

public class Database {
    private Connection connection;
    private String driver = "org.h2.Driver";
    private String jdbcUrl="jdbc:h2:mem";
    private String username = "sa";
    private String password = "1234";

    private static Database instance;

    private Database() {
        createConnection();
    }

    public void createConnection(){
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
