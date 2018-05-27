package sample;

/** TODO
 *** Решить проблему с регистрацией *

 1. Выходил текст вслучае одинаковых логинов *
 2. Убрать кнопку maximise в окне SignUP *
 3. Сделать базу данных подключаемой к интернету
 4. Сделать сохранение файлов
 5. Зашифровать данные
 */

import java.sql.*;

public class DataBaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection() {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                    + "?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.cj.jdbc.Driver");

            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return dbConnection;

    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" +
                Constants.USER_FIRSTNAME + "," + Constants.USER_LASTNAME + "," +
                Constants.USER_LOGIN + "," + Constants.USER_PASSWORD + ")" +
                "VALUE(?,?,?,?)";
        try {
            if(!user.getFirstName().equals("") && !user.getLastName().equals("")
                    && !user.getLogin().equals("") && !user.getPassword().equals("")) {

                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, user.getFirstName());
                prSt.setString(2, user.getLastName());
                prSt.setString(3, user.getLogin());
                prSt.setString(4, user.getPassword());

                prSt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE " + Constants.USER_LOGIN + "=? AND "
                + Constants.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());


            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getLogin(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE " + Constants.USER_LOGIN + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());

            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

