package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;
import pageObjects.forms.Cars;
import pageObjects.forms.CompareWrapper;
import regEx.RegEx;

public class CompareCarsPage {
    private By pageLocator = By.xpath("//*[contains(@class, 'compare-subhead-h2')]");
    private Banner compareCarBanner = new Banner(pageLocator, "Model Compare");

    public boolean comparePageIsDisplayed(Cars car){
        return RegEx.getModifiedValue(compareCarBanner.getText()).contains(car.getCarName());
    }

    public CompareWrapper getCompareWrapper(){
        return new CompareWrapper();
    }



}
