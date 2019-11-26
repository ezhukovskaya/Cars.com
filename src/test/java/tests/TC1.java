package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.forms.Cars;
import pageObjects.pages.*;

public class TC1 extends BaseTest {
    MainPage mainPage = new MainPage();
    Steps testSteps = new Steps();
    ResearchPage researchPage = new ResearchPage();
    CompareTrimsPage compareTrimsPage = new CompareTrimsPage();
    SideBySidePage sideBySidePage = new SideBySidePage();
    CompareCarsPage compareCarsPage = new CompareCarsPage();
    static final Logger log = Logger.getLogger(TC1.class);
    @Test
    public void carsComparisonTest(){
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        log.info("First Car search");
        Cars firstCar = testSteps.getSelectedCar();
        log.info("Main Page click");
        compareTrimsPage.clickMainPage();
        log.info("Check if main page is displayed");
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        log.info("Second Car search");
        Cars secondCar = testSteps.getSelectedCar();
        log.info("Main Page click");
        compareTrimsPage.clickMainPage();
        log.info("Check if main page is displayed");
        Assert.assertTrue(mainPage.mainPageIsDisplayed(), "Main page is not opened");
        log.info("Research click");
        mainPage.getMainMenu().mainMenuResearchButtonClick();
        log.info("Check if research page is displayed");
        Assert.assertTrue(researchPage.researchPageIsDisplayed(), "Research Page is not opened");
        log.info("Side-by-side tool click");
        researchPage.getTools().toolsFormSideBySideButtonClick();
        log.info("Check if side-by-side page is displayed");
        Assert.assertTrue(sideBySidePage.isSideBySidePageDisplayed(), "Side-by-Side page is not opened");
        log.info("Select first car on side-by-side page");
        sideBySidePage.getSearchPanel().searchPanelSelectElement(firstCar);
        log.info("Check if first car is chosen");
        Assert.assertTrue(compareCarsPage.comparePageIsDisplayed(firstCar), "Car 1 is not on the compare page");
        log.info("Select first car on side-by-side page");
        compareCarsPage.getCompareWrapper().getAnotherCarSearch().searchPanelSelectElement(secondCar);
        log.info("Check if second car is chosen");
        Assert.assertTrue(compareCarsPage.getCompareWrapper().isSecondCarInTheCompare(), "Car 2 is not on the compare page");
        log.info("Check if engine is the same with saved");
        Assert.assertTrue(compareCarsPage.getCompareWrapper().isEngineTheSame(firstCar,secondCar),"Engines are not right");
        log.info("Check if trans is the same with saved");
        Assert.assertTrue(compareCarsPage.getCompareWrapper().isTransTheSame(firstCar, secondCar), "Trans are not right");
    }
}
