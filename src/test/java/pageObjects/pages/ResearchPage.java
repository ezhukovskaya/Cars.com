package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import org.openqa.selenium.By;
import pageObjects.forms.SearchPanel;
import pageObjects.forms.ToolsForm;

public class ResearchPage {
    private By researchPageLocator = By.xpath("//*[@class='m6uQf']");
    private Banner researchPage = new Banner(researchPageLocator, "Research Page Banner");
    private By sideNySideCompareLocator = By.xpath("//*[contains(@class, '_1dRAW')]");
    private Button sideBySide = new Button(sideNySideCompareLocator, "Side-by-Side Compare");
    SearchPanel searchPanel = new SearchPanel();

    public boolean researchPageIsDisplayed(){
        return researchPage.isDisplayed();
    }

    public SearchPanel getSearchPanel(){
        return searchPanel;
    }

    public ToolsForm getTools(){
        return new ToolsForm();
    }
}
