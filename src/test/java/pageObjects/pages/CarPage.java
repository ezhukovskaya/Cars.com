package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import org.openqa.selenium.By;
import regEx.RegEx;

public class CarPage {
    private By carNameLocator = By.xpath("//*[contains(@class,'cui-page-section__title')]");
    private By trimCompareLocator = By.xpath("//*[contains(@data-linkname, 'trim-compare')]");
    private Banner carName = new Banner(carNameLocator, "Car Name");
    private Button compareTrims = new Button(trimCompareLocator, "Compare Trims");

    public String getName(){
        return RegEx.getModifiedValue(carName.getText());
    }

    public void clickOnCompareTrims() {
        compareTrims.click();
    }
}
