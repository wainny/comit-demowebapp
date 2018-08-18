package org.comit.demowebapp.login;

import org.comit.demowebapp.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public boolean login(String username, String password) {
        boolean loginSuccessful = false;
        Connection connection = Database.getConnection();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                loginSuccessful = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loginSuccessful;
    }
}
