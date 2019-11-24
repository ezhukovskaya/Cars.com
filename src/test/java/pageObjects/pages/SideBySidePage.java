package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;
import pageObjects.forms.CompareSearchPanel;

public class SideBySidePage {
    private By pageLocator = By.xpath("//*[contains(@class, 'compare-head-h1-semi')]");
    private Banner pageBanner = new Banner("Compare Cars Side-by-Side",pageLocator);

    public boolean isSideBySidePageDisplayed(){
        return pageBanner.isDisplayed();
    }

    public CompareSearchPanel getSearchPanel(){
        return new CompareSearchPanel();
    }
}
