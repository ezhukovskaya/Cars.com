package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.MainPage;
import pageObjects.pages.ResearchPage;

public class TC1 extends BaseTest {
    MainPage mainPage = new MainPage();
    ResearchPage researchPage = new ResearchPage();
    @Test
    public void carsComparisonTest(){
        Assert.assertTrue(mainPage.mainPageIsDisplayed());
        mainPage.getMainMenu().mainMenuButtonClick();
        Assert.assertTrue(researchPage.researchPageIsDisplayed());
    }
}
