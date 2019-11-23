package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.CarPage;
import pageObjects.pages.CompareTrimsPage;
import pageObjects.pages.MainPage;
import pageObjects.pages.ResearchPage;

import java.io.IOException;

public class TC1 extends BaseTest {
    MainPage mainPage = new MainPage();
    ResearchPage researchPage = new ResearchPage();
    CarPage carPage = new CarPage();
    CompareTrimsPage compareTrimsPage = new CompareTrimsPage();
    @Test
    public void carsComparisonTest() throws InterruptedException, IOException {
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        mainPage.getMainMenu().mainMenuButtonClick();
        Assert.assertTrue(researchPage.researchPageIsDisplayed(), "Research Page is not opened");
        researchPage.getSearchPanel().searchPanelSelectElement();
        String nameFromSearch = researchPage.getSearchPanel().getFullCarName();
        String nameFromCarPage = carPage.getName();
        Assert.assertEquals(nameFromCarPage,nameFromSearch,"The chosen car page is not opened");
        carPage.clickOnCompareTrims();
        String trimsPageForChosenCar = compareTrimsPage.getTrims();
        Assert.assertTrue(trimsPageForChosenCar.contains(nameFromCarPage),"Compare trims for chosen car is not opened");
        compareTrimsPage.getTrimTable().getTextFromCarData();
        Assert.assertTrue(compareTrimsPage.isSaved(),"Data is not saved");
        compareTrimsPage.clickMainPage();
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
    }
}
