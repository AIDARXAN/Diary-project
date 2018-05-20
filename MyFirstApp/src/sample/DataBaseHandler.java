package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection()  {
        String connectionString = "jdbc:mysql://localhost:3306/mysql";
        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbConnection;

    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" +
                Constants.USER_FIRSTNAME + "," +
                Constants.USER_LASTNAME + "," +
                Constants.USER_LOGIN + "," +
                Constants.USER_PASSWORD + ")" +
                "VALUE(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}

