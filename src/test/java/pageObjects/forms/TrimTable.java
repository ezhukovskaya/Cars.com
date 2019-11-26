package pageObjects.forms;

import framework.elements.Banner;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class TrimTable {
    private String engineClass = "cell cell-bg grow-2";
    private String transClass = "cell grow-2";
    private ArrayList<String> carData = new ArrayList<>();
    private Banner engine = getCarDataBanner(engineClass);
    private Banner trans = getCarDataBanner(transClass);

    private Banner getCarDataBanner(String className){
        By carDataLocator = By.xpath(String.format("//*[@class='%s']", className));
        return new Banner(carDataLocator, "Car data");
    }

    public ArrayList<String> getTextFromCarData()  {
        carData.add(engine.getText());
        carData.add(trans.getText());
        return carData;
    }

}
