package pageObjects.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class ToolsForm {
    private String researchPageLocator = "//*[@class='m6uQf']";
    private Button sideBySide = getFormElement(researchPageLocator, "Side-by-side Comparisons");

    private Button getFormElement(String locator, String elementName) {
        By elementLocator = By.xpath(String.format(locator + "//*[contains(text(), '%s')]", elementName));
        return new Button(elementLocator, elementName);
    }

    public void toolsFormSideBySideButtonClick(){
        sideBySide.click();
    }
}
