package pageObjects.forms;

import framework.elements.Banner;
import framework.elements.Button;
import org.openqa.selenium.By;
import regEx.RegEx;

public class CompareWrapper {
    private By addAnotherCarLocator = By.xpath("//*[@id = 'add-from-your-favorite-cars-link']");
    private Button addAnotherCar = new Button("Add another car",addAnotherCarLocator);
    private By secondCarCheckLocator = By.xpath("//*[contains(@class,'listing-name')]");
    private Banner secondCar = new Banner("Second Car", secondCarCheckLocator);
    private By engineInfoLocator = By.xpath("//*[@header='Engine']");
    private By transmissionInfoLocator = By.xpath("//*[@header='Transmission']");
    private Banner engineInfo = new Banner("Engine Info",engineInfoLocator);
    private Banner transmissionInfo = new Banner("Transmission Info", transmissionInfoLocator);

    public AnotherCarSearch getAnotherCarSearch(){
        addAnotherCar.click();
        return new AnotherCarSearch();
    }

    public boolean isSecondCarInTheCompare(){
        return secondCar.isDisplayed();
    }

    public boolean isEngineTheSame(Cars firstCar, Cars secondCar){
        return RegEx.getModifiedValue(engineInfo.getText()).contains(RegEx.getModifiedValue(firstCar.getEngineData()));
    }

    public boolean isTransTheSame(Cars firstCar, Cars secondCar){
        return RegEx.getModifiedValue(transmissionInfo.getText()).contains(RegEx.getModifiedValue(firstCar.getTransData()));
    }
}
