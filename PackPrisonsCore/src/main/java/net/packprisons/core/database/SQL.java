package net.packprisons.core.database;

import net.packprisons.core.utils.ChatUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {

    public String host, password, database, username;
    public int port;
    public Connection connection;

    public SQL (String host, String database, String username, String password, int port) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;

        try {
            openConnection();

            ChatUtil.log("&aSuccessfully connected to " + this.database + " database!");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws SQLException {

        if (connection != null && !connection.isClosed())
            return;


        connection = DriverManager.getConnection("jdbc://mysql://" +
                        this.host + ":" +
                        this.port + "/" +
                        this.database,
                        this.username,
                        this.password);
    }
}
