package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

import java.sql.*;;
import java.util.*;

public class UserDAO {

    private final String QUERY_ALL = "select * from users";
    private final String QUERY_INSERT = "insert into users (idUser, username, password, " +
            "firstName, lastName, fiscalCode, dateOfBirth, businessName, " +
            " vat, town, postCode, city, address, telephone,  role) values (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


    public List<User> getAllUsers(){

        List<User> users =  new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);

            while (resultSet.next()) {

                int idUser = resultSet.getInt("idUser");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String fiscalCode = resultSet.getString("fiscalCode");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String businessName = resultSet.getString("businessName");
                String vat = resultSet.getString("vat");
                String town = resultSet.getString("town");
                String postCode = resultSet.getString("postCode");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String role = resultSet.getString("role");

                users.add(new User(idUser, username, password, firstName, lastName, fiscalCode, dateOfBirth, businessName, vat, town, postCode, city, address, telephone,  role));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }


    public boolean insertUser(User user){

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getFiscalCode());
            preparedStatement.setString(6, user.getDateOfBirth());
            preparedStatement.setString(7, user.getBusinessName());
            preparedStatement.setString(8, user.getVat());
            preparedStatement.setString(9, user.getTown());
            preparedStatement.setString(10, user.getPostCode());
            preparedStatement.setString(11, user.getCity());
            preparedStatement.setString(12, user.getAddress());
            preparedStatement.setString(13, user.getTelephone());
            preparedStatement.setString(14, user.getRole());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }


}
