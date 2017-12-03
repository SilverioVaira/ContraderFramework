package main.service;

import main.dao.VehicleDAO;
import main.model.Vehicle;

import java.util.List;

public class VehicleService {

    private VehicleDAO vehicleDAO;

    public VehicleService(){
        vehicleDAO = new VehicleDAO();
    }

    public List<Vehicle> getAllVehicle(){ return this.vehicleDAO.getAllVehicle(); }

    public boolean insert(Vehicle vehicle){ return this.vehicleDAO.insert(vehicle);}

    public Integer getIdVehicle (String brand, String model, String fuel, String version, String capacity){
        return  this.vehicleDAO.getIdVehicle(brand,model,fuel,version,capacity);
    }


}
