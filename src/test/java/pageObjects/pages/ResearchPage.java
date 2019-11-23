package pageObjects.pages;

import framework.elements.Banner;
import org.openqa.selenium.By;
import pageObjects.forms.SearchPanel;

public class ResearchPage {
    private By researchPageLocator = By.xpath("//*[@class='oJ34o']");
    private Banner researchPage = new Banner("Research Page Banner",researchPageLocator);
    SearchPanel searchPanel = new SearchPanel();

    public boolean researchPageIsDisplayed(){
        return researchPage.isDisplayed();
    }

    public SearchPanel getSearchPanel(){
        return searchPanel;
    }
}
