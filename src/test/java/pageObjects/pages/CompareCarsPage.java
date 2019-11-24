package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import org.openqa.selenium.By;
import pageObjects.forms.AnotherCarSearch;
import pageObjects.forms.Cars;
import pageObjects.forms.CompareWrapper;
import regEx.RegEx;

public class CompareCarsPage {
    private By pageLocator = By.xpath("//*[contains(@class, 'compare-subhead-h2')]");
    private Banner compareCarBanner = new Banner("Model Compare",pageLocator);
    private By addAnotherCarLocator = By.xpath("//*[@id = 'add-from-your-favorite-cars-link']");
    private Button addAnotherCar = new Button("Add another car",addAnotherCarLocator);

    public boolean comparePageIsDisplayed(Cars car){
        return RegEx.getModifiedValue(compareCarBanner.getText()).contains(car.getCarName());
    }

    public CompareWrapper getCompareWrapper(){
        return new CompareWrapper();
    }



}
