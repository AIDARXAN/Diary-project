package sample;

import java.sql.*;

public class DataBaseHandler extends Configs{

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{

            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(dbURL, dbUser, dbPass);


        return dbConnection;
    }

    public void signUpUser(String firstName,
                           String lastName,
                           String login,
                           String password){
//        SignUpController signUpController = new SignUpController();
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" +
                Constants.USER_FIRSTNAME + "," +
                Constants.USER_LASTNAME + "," +
                Constants.USER_LOGIN + "," +
                Constants.USER_PASSWORD + ")" +
                "VALUE(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

