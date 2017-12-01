package main.service;

import main.dao.GommaDAO;
import main.model.Gomma;

import java.util.List;

public class GommaService {

    private GommaDAO gommaDAO;

    public GommaService() {
        this.gommaDAO = new GommaDAO();
    }

    public List<Gomma> getAllGomme () {
        return this.gommaDAO.getAllGomme();
    }

    public boolean insertGomma (Gomma gomma) {
        return this.gommaDAO.insertGomma(gomma);
    }

    public List<Gomma> getAllGommeForManufacturer(String brand, String type){
        return this.gommaDAO.getAllGommeForManufacturer(brand, type);
    }

    public List<String> getAllManufacturerForType(String type){
        return this.gommaDAO.getAllManufacturerForType(type);
    }


    public List<Gomma> getGommeForSize( double pWidth, double pHeight, double pDiameter,String pSeason, double pWeight, String pSpeed, String typeVehicle){
        return this.gommaDAO.getGommeForSize(pWidth, pHeight, pDiameter, pSeason, pWeight, pSpeed, typeVehicle);
    }
}


