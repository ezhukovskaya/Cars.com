package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;
import pageObjects.forms.MainMenu;

public class MainPage {
    private By mainPageBannerLocator = By.xpath("//*[contains(@class, '_17q4_ _1EK4-')]");
    private Banner mainPageBanner = new Banner("Main Page Banner", mainPageBannerLocator);

    public boolean mainPageIsDisplayed(){
        return mainPageBanner.isDisplayed();
    }

    public MainMenu getMainMenu(){
        return new MainMenu();
    }
}


