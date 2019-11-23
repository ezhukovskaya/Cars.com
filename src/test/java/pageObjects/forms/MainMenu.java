package pageObjects.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class MainMenu {
    private String mainMenuLocator = "//*[@class='_2Qal_']";

    private Button getMenuButton(String buttonName, String locator) {
        By elementLocator = By.xpath(String.format(locator + "//a[contains(text(), '%s')]", buttonName));
        return new Button(buttonName, elementLocator);
    }

    public void mainMenuButtonClick(){
        Button research = getMenuButton("Research", mainMenuLocator);
        research.click();
    }
}
