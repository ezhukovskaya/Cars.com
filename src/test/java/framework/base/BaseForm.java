package framework.base;

import framework.elements.Button;
import org.openqa.selenium.By;

public abstract class BaseForm {
    protected Button getFormElement(String elementName, String locator) {
        By elementLocator = By.xpath(String.format(locator + "//*[contains(text(), '%s')]", elementName));
        return new Button(elementName, elementLocator);
    }
}
