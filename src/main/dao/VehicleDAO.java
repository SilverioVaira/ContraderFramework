package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;
import main.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public List<Vehicle> getAllVehicle(){

        String QUERY = "select * from vehicle";
        List<Vehicle> vehicles = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {

                int idVehicle = resultSet.getInt("idVehicle");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String fuel  = resultSet.getString("fuel");
                String version = resultSet.getString("version");
                String capacity = resultSet.getString("capacity");



                vehicles.add(new Vehicle(idVehicle, brand, model, fuel, version, capacity));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public boolean insert(Vehicle vehicle){

        String QUERY = "insert into vehicle(idVehicle, brand, model, fuel, version, capacity) values (NULL,?,?,?,?,?) ";

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, vehicle.getBrand());
            preparedStatement.setString(2, vehicle.getModel());
            preparedStatement.setString(3, vehicle.getFuel());
            preparedStatement.setString(4, vehicle.getVersion());
            preparedStatement.setString(5, vehicle.getCapacity());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public Integer getIdVehicle (String brand, String model, String fuel, String version, String capacity) {

        String QUERY = "select * from vehicle where brand = ? and model = ? and fuel = ? and version = ? and capacity = ?";
        Integer idVehicle = null;

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, brand);
            statement.setString(2, model);
            statement.setString(3, fuel);
            statement.setString(4, version);
            statement.setString(5, capacity);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                idVehicle = resultSet.getInt("idVehicle");
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idVehicle;

    }



}
