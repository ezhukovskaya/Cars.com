package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class DropDown extends BaseElement {

    public DropDown(String name, By locator) {
        super(name, locator);
    }

    public void select(String key) {
        new Select(Browser.getBrowser().findElement(buttonLocator)).selectByVisibleText(key);
    }

    public void select(int index){
        new Select(Browser.getBrowser().findElement(buttonLocator)).selectByIndex(index);
    }

    public Select getSelectElements(){
        return new Select(Browser.getBrowser().findElement(buttonLocator));
    }

}
