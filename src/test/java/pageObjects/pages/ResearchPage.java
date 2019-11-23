package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;

public class ResearchPage {
    private By researchPageLocator = By.xpath("//*[@class='oJ34o']");
    private Banner researchPage = new Banner("Research Page Banner",researchPageLocator);

    public boolean researchPageIsDisplayed(){
        return researchPage.isDisplayed();
    }
}
