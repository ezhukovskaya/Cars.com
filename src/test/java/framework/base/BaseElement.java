package framework.base;

import framework.browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {

    protected By buttonLocator;
    protected String elementName;
    static final Logger log = Logger.getLogger(BaseElement.class);
    private Actions actions = new Actions(Browser.getBrowser());

    public BaseElement(By locator, String name) {
        this.buttonLocator = locator;
        this.elementName = name;
    }

    public void click() {
        log.info(this.elementName + " click");
        Browser.getBrowser().findElement(buttonLocator).click();
    }

    public String getText() {
        return Browser.getBrowser().findElement(this.buttonLocator).getText();
    }

    public boolean isDisplayed() {
        return Browser.getBrowser().findElements(this.buttonLocator).size() > 0;
    }

}
