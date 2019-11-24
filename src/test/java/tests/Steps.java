package tests;

import org.testng.Assert;
import pageObjects.forms.Cars;
import pageObjects.pages.CarPage;
import pageObjects.pages.CompareTrimsPage;
import pageObjects.pages.MainPage;
import pageObjects.pages.ResearchPage;

import java.io.IOException;

public class Steps {
    MainPage mainPage = new MainPage();
    ResearchPage researchPage = new ResearchPage();
    CarPage carPage = new CarPage();
    CompareTrimsPage compareTrimsPage = new CompareTrimsPage();
    public Cars getSelectedCar() throws InterruptedException, IOException {
        mainPage.getMainMenu().mainMenuButtonClick();
        Assert.assertTrue(researchPage.researchPageIsDisplayed(), "Research Page is not opened");
        researchPage.getSearchPanel().searchPanelSelectElement();
        Cars car = new Cars(researchPage.getSearchPanel().getFullCarName());
        String nameFromSearch = researchPage.getSearchPanel().getFullCarNameForAssets();
        String nameFromCarPage = carPage.getName();
        Assert.assertEquals(nameFromCarPage, nameFromSearch, "The chosen car page is not opened");
        carPage.clickOnCompareTrims();
        String trimsPageForChosenCar = compareTrimsPage.getTrims();
        Assert.assertTrue(trimsPageForChosenCar.contains(nameFromCarPage), "Compare trims for chosen car is not opened");
        car.setCarData(compareTrimsPage.getTrimTable().getTextFromCarData());
        Assert.assertTrue(compareTrimsPage.isSaved(), "Data is not saved");
        return car;
    }
}
