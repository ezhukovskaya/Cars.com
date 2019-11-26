package pageObjects.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class MainMenu {
    private String mainMenuLocator = "//*[@class='_1U4gk']";

    private Button getMenuButton(String buttonName, String locator) {
        By elementLocator = By.xpath(String.format(locator + "//a[contains(text(), '%s')]", buttonName));
        return new Button(elementLocator, buttonName);
    }

    public void mainMenuResearchButtonClick(){
        Button research = getMenuButton("Research", mainMenuLocator);
        research.click();
    }
}
