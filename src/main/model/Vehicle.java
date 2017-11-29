package main.model;

public class Vehicle {

    private int idVehicle;
    private String brand;
    private String fuel;
    private String version;
    private String capacity;

    public Vehicle(int idVehicle, String brand, String fuel, String version, String capacity) {
        this.idVehicle = idVehicle;
        this.brand = brand;
        this.fuel = fuel;
        this.version = version;
        this.capacity = capacity;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (brand != null ? !brand.equals(vehicle.brand) : vehicle.brand != null) return false;
        if (fuel != null ? !fuel.equals(vehicle.fuel) : vehicle.fuel != null) return false;
        if (version != null ? !version.equals(vehicle.version) : vehicle.version != null) return false;
        return capacity != null ? capacity.equals(vehicle.capacity) : vehicle.capacity == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }
}



