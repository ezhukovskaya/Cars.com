package pageObjects.forms;

import framework.elements.Banner;
import framework.utils.FileManager;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;

public class TrimTable {
    private String tableLocator = "//*[@id='trim-table']";
    private String engineClass = "cell cell-bg grow-2";
    private String transClass = "cell grow-2";
    ArrayList<String> carData = new ArrayList<>();

    private Banner getCarDataBanner(String className){
        By carDataLocator = By.xpath(String.format("//*[@class='%s']", className));
        return new Banner("Car data",carDataLocator);
    }

    public void getTextFromCarData() throws IOException {
        Banner engine = getCarDataBanner(engineClass);
        Banner trans = getCarDataBanner(transClass);
        carData.add(engine.getText());
        carData.add(trans.getText());
        FileManager.writer(carData);
    }

}
