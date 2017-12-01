package main.model;

public class Gomma {

    private Integer idGomme;
    private String model;
    private String manufacturer;
    private double price;
    private double width;
    private double height;
    private double diameter;
    private double weight;
    private String speed;
    private String season;
    private String vehicle;
    private int quantity;


    public Gomma(Integer idGomme, String model, String manufacturer, double price, double width, double height, double diameter, double weight, String speed, String season, String vehicle, int quantity) {
        this.idGomme = idGomme;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
        this.speed = speed;
        this.season = season;
        this.vehicle = vehicle;
        this.quantity = quantity;
    }

    public Integer getIdGomme() {
        return idGomme;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gomma gomma = (Gomma) o;

        if (Double.compare(gomma.price, price) != 0) return false;
        if (model != null ? !model.equals(gomma.model) : gomma.model != null) return false;
        return manufacturer != null ? manufacturer.equals(gomma.manufacturer) : gomma.manufacturer == null;
    }



    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    @Override
    public String toString() {
        return  "IdGomme: " + idGomme + "\n" +
                "Model: " + model + "\n" +
                "Manufacturer: " + manufacturer +"\n" +
                "Price: " + price + "\n" +
                "Width: " + width + "\n" +
                "Height: " + height + "\n" +
                "Diameter: " + diameter + "\n" +
                "Weight: " + weight + "\n" +
                "Speed: " + speed + "\n" +
                "Season: " + season + "\n" +
                "Vehicle: " + vehicle + "\n" +
                "Quantity: " + quantity + "\n";
    }
}
