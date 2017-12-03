package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;
import main.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle, quantity )" +
            "values (NULL,?,?,?,?,?,?,?,?,?,?,?)";


    public GommaDAO() {

    }

    public List<Gomma> getAllGommeForManufacturer(String brand, String typeVehicle){

        String QUERY = "select * from contrader.gomme where manufacturer = ? and vehicle = ?";
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, brand);
            statement.setString(2, typeVehicle);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                int idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String vehicle = resultSet.getString("vehicle");
                int quantity = resultSet.getInt("quantity");


                gomme.add(new Gomma(idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle, quantity ));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gomme;


    }

    public List<String> getAllManufacturerForType(String type){

        String QUERY = "select distinct manufacturer from contrader.gomme where vehicle = ?";
        List<String> manufacturers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                manufacturers.add(resultSet.getString("manufacturer"));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return manufacturers;

    }

    public List<Gomma> getAllGomme () {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {

               int idGomme = resultSet.getInt("idGomme");
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               double width = resultSet.getDouble("width");
               double height = resultSet.getDouble("height");
               double diameter = resultSet.getDouble("diameter");
               double weight = resultSet.getDouble("weight");
               String speed = resultSet.getString("speed");
               String season = resultSet.getString("season");
               String vehicle = resultSet.getString("vehicle");
               int quantity = resultSet.getInt("quantity");


               gomme.add(new Gomma(idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle, quantity ));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public boolean insertGomma(Gomma gomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, gomma.getModel());
            preparedStatement.setString(2, gomma.getManufacturer());
            preparedStatement.setDouble(3, gomma.getPrice());
            preparedStatement.setDouble(4, gomma.getWidth());
            preparedStatement.setDouble(5, gomma.getHeight());
            preparedStatement.setDouble(6, gomma.getDiameter());
            preparedStatement.setDouble(7, gomma.getWeight());
            preparedStatement.setString(8, gomma.getSpeed());
            preparedStatement.setString(9, gomma.getSeason());
            preparedStatement.setString(10, gomma.getVehicle());
            preparedStatement.setInt(11, gomma.getQuantity());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public List<Gomma> getGommeForSize( double pWidth, double pHeight, double pDiameter, String pSeason, double pWeight, String pSpeed, String typeVehicle){

        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        ResultSet resultSet;

        try {

            if(typeVehicle.equals("auto")) {
                String QUERY = "select * from contrader.gomme where width = ? and height = ? and " +
                        "diameter = ? and season = ? and vehicle = ?";

                PreparedStatement statement = connection.prepareStatement(QUERY);
                statement.setDouble(1, pWidth);
                statement.setDouble(2, pHeight);
                statement.setDouble(3, pDiameter);
                statement.setString(4, pSeason);
                statement.setString(5, typeVehicle);
                resultSet = statement.executeQuery();
            } else {
                String QUERY = "select * from contrader.gomme where width = ? and height = ? and " +
                        "diameter = ? and weight = ? and speed = ? and vehicle = ?";

                PreparedStatement statement = connection.prepareStatement(QUERY);
                statement.setDouble(1, pWidth);
                statement.setDouble(2, pHeight);
                statement.setDouble(3, pDiameter);
                statement.setDouble(4, pWeight);
                statement.setString(5, pSpeed);
                statement.setString(6, typeVehicle);
                resultSet = statement.executeQuery();
            }

            while (resultSet.next()){

                int idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String vehicle = resultSet.getString("vehicle");
                int quantity = resultSet.getInt("quantity");


                gomme.add(new Gomma(idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle, quantity ));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gomme;

    }

    public List<Integer> getCompatibilyGommeId(Integer pIdVehicle){
        List<Integer> gommeId = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        ResultSet resultSet;

        try {

            String QUERY = "select * from compatibility where idVehicle = ?";

            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setInt(1, pIdVehicle);
            resultSet = statement.executeQuery();

            while (resultSet.next()){

                Integer idGomme = resultSet.getInt("idGomme");
                gommeId.add(idGomme);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gommeId;
    }

    public Gomma getGommeById( Integer pIdGomma){

        Gomma gomma = null;
        Connection connection = ConnectionSingleton.getInstance();
        ResultSet resultSet;

        try {

            String QUERY = "select * from contrader.gomme where idGomme = ?";

            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setDouble(1, pIdGomma);
            resultSet = statement.executeQuery();

            while (resultSet.next()){

                Integer idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String vehicle = resultSet.getString("vehicle");
                int quantity = resultSet.getInt("quantity");

                gomma = new Gomma(idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle, quantity);


            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gomma;

    }
}
