package pageObjects.forms;

import java.util.ArrayList;

public class Cars {
    private String carName;
    private String carModel;
    private String modelYear;
    private String engineData;
    private String transData;

    public String getCarName() {
        return carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getEngineData() {
        return engineData;
    }

    public String getModelYear() {
        return modelYear;
    }

    public String getTransData() {
        return transData;
    }

    public Cars(ArrayList<String> car){
        this.carModel = car.get(1);
        this.carName = car.get(0);
        this.modelYear = car.get(2);
    }

    public void setCarData(ArrayList<String> data) {
        this.engineData = data.get(0);
        this.transData = data.get(1);
    }
}
