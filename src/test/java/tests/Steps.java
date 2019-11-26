package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import pageObjects.forms.Cars;
import pageObjects.pages.CarPage;
import pageObjects.pages.CompareTrimsPage;
import pageObjects.pages.MainPage;
import pageObjects.pages.ResearchPage;

public class Steps {
    MainPage mainPage = new MainPage();
    ResearchPage researchPage = new ResearchPage();
    CarPage carPage = new CarPage();
    CompareTrimsPage compareTrimsPage = new CompareTrimsPage();
    static final Logger log = Logger.getLogger(Steps.class);
    public Cars getSelectedCar() {
        log.info("Research button click");
        mainPage.getMainMenu().mainMenuResearchButtonClick();
        log.info("Check if research page is displayed");
        Assert.assertTrue(researchPage.researchPageIsDisplayed(), "Research Page is not opened");
        researchPage.getSearchPanel().searchPanelSelectElement();
        Cars car = new Cars(researchPage.getSearchPanel().getFullCarName());
        log.info("Get name of the car");
        String nameFromSearch = researchPage.getSearchPanel().getFullCarNameForAssets();
        String nameFromCarPage = carPage.getName();
        log.info("Check if right car page is displayed");
        Assert.assertEquals(nameFromCarPage, nameFromSearch, "The chosen car page is not opened");
        log.info("Click compare trims");
        carPage.clickOnCompareTrims();
        String trimsPageForChosenCar = compareTrimsPage.getTrims();
        log.info("Check if compare trims page is displayed");
        Assert.assertTrue(trimsPageForChosenCar.contains(nameFromCarPage), "Compare trims for chosen car is not opened");
        car.setCarData(compareTrimsPage.getTrimTable().getTextFromCarData());
        log.info("Check if car info is saved");
        Assert.assertTrue(compareTrimsPage.isSaved(), "Data is not saved");
        return car;
    }
}
