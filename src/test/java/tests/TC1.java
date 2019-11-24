package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.forms.Cars;
import pageObjects.pages.*;

import java.io.IOException;

public class TC1 extends BaseTest {
    MainPage mainPage = new MainPage();
    Steps testSteps = new Steps();
    ResearchPage researchPage = new ResearchPage();
    CompareTrimsPage compareTrimsPage = new CompareTrimsPage();
    SideBySidePage sideBySidePage = new SideBySidePage();
    CompareCarsPage compareCarsPage = new CompareCarsPage();
    @Test
    public void carsComparisonTest() throws InterruptedException, IOException {
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        Cars firstCar = testSteps.getSelectedCar();
        compareTrimsPage.clickMainPage();
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        Cars secondCar = testSteps.getSelectedCar();
        compareTrimsPage.clickMainPage();
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        mainPage.getMainMenu().mainMenuButtonClick();
        Assert.assertTrue(researchPage.researchPageIsDisplayed(), "Research Page is not opened");
        researchPage.getTools().toolsFormButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(sideBySidePage.isSideBySidePageDisplayed(), "Side-by-Side page is not opened");
        sideBySidePage.getSearchPanel().searchPanelSelectElement(firstCar);
        Thread.sleep(5000);
        Assert.assertTrue(compareCarsPage.comparePageIsDisplayed(firstCar), "Car 1 is not on the compare page");
        compareCarsPage.getCompareWrapper().getAnotherCarSearch().searchPanelSelectElement(secondCar);
        Thread.sleep(5000);
        Assert.assertTrue(compareCarsPage.getCompareWrapper().isSecondCarInTheCompare(), "Car 2 is not on the compare page");
        Assert.assertTrue(compareCarsPage.getCompareWrapper().isEngineTheSame(firstCar,secondCar),"Engines are not right");
        Assert.assertTrue(compareCarsPage.getCompareWrapper().isTransTheSame(firstCar, secondCar), "Trans are not right");
    }
}
