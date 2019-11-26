package pageObjects.pages;

import framework.elements.Banner;
import framework.elements.Button;
import framework.utils.FileManager;
import org.openqa.selenium.By;
import pageObjects.forms.TrimTable;
import regEx.RegEx;

public class CompareTrimsPage {
    private By goBackToMainPageButtonLocator = By.xpath("//*[@data-linkname='header-home']");
    private By compareTrimsForChosenCarLocator = By.xpath("//*[contains(@class, 'cui-heading-1')]");
    private Banner compareTrimsForChosenCar = new Banner(compareTrimsForChosenCarLocator, "compareTrimsForChosenCar");
    private Button goBackToMainPageButton = new Button(goBackToMainPageButtonLocator, "Main Page");

    public String getTrims(){
        return RegEx.getModifiedValue(compareTrimsForChosenCar.getText());
    }

    public TrimTable getTrimTable(){
        return new TrimTable();
    }

    public boolean isSaved(){
        return FileManager.isSaved(System.getProperty("user.dir"),"firstCarData.txt");
    }

    public void clickMainPage(){
        goBackToMainPageButton.click();
    }

}
