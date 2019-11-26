package pageObjects.forms;

import framework.elements.Banner;
import framework.elements.Button;
import org.openqa.selenium.By;
import regEx.RegEx;

public class CompareWrapper {
    private By addAnotherCarLocator = By.xpath("//*[@id = 'add-from-your-favorite-cars-link']");
    private Button addAnotherCar = new Button(addAnotherCarLocator, "Add another car");
    private By secondCarCheckLocator = By.xpath("//*[contains(@class,'listing-name')]");
    private Banner secondCar = new Banner(secondCarCheckLocator, "Second Car");
    private By engineInfoLocator = By.xpath("//*[@header='Engine']");
    private By transmissionInfoLocator = By.xpath("//*[@header='Transmission']");
    private Banner engineInfo = new Banner(engineInfoLocator, "Engine Info");
    private Banner transmissionInfo = new Banner(transmissionInfoLocator, "Transmission Info");

    public AnotherCarSearch getAnotherCarSearch(){
        addAnotherCar.click();
        return new AnotherCarSearch();
    }

    public boolean isSecondCarInTheCompare(){
        return secondCar.isDisplayed();
    }

    public boolean isEngineTheSame(Cars firstCar, Cars secondCar){
        return RegEx.getModifiedValue(engineInfo.getText()).contains(RegEx.getModifiedValue(firstCar.getEngineData()+secondCar.getEngineData()));
    }

    public boolean isTransTheSame(Cars firstCar, Cars secondCar){
        return RegEx.getModifiedValue(transmissionInfo.getText()).contains(RegEx.getModifiedValue(firstCar.getTransData()+secondCar.getTransData()));
    }
}
