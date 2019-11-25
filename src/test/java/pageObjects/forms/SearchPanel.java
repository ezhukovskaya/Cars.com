package pageObjects.forms;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.utils.Rand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import regEx.RegEx;

import java.util.ArrayList;

public class SearchPanel extends BaseForm {
    private By searchButtonLocator = By.xpath("//*[contains(@class,'_3iP3L')]");
    private String makeIdName = "makeId";
    private String modelIdName = "modelId";
    private String yearName = "year";
    private Button search = new Button("Search", searchButtonLocator);
    private ArrayList<WebElement> selectElements;
    private int valueIndex = 0;
    ArrayList<String> fullCarName = new ArrayList<>();


    DropDown getSelectDropDown(String elementName) {
        By dropDownLocator = By.xpath(String.format("//*[contains(@name,'%s')]", elementName));
        return new DropDown(elementName, dropDownLocator);
    }

    private int getSelectedItemIndex(DropDown dropDown) {
        selectElements = (ArrayList<WebElement>) dropDown.getSelectElements().getOptions();
        valueIndex = Rand.getRandomIndex(selectElements.size() - 1);
        return valueIndex;
    }

    private String getValueOfSelected(int index) {
        return selectElements.get(index).getText();
    }

    private void selection(DropDown dropDown) {
        dropDown.click();
        dropDown.select(getSelectedItemIndex(dropDown));
        fullCarName.add(getValueOfSelected(valueIndex));
    }

    public String getFullCarNameForAssets() {
        StringBuilder full = new StringBuilder();
        full.setLength(0);
        for (int i = 0; i < fullCarName.size() - 1; i++) {
            full.append(fullCarName.get(i));
        }
        String name = RegEx.getModifiedValue(fullCarName.get(fullCarName.size() - 1) + full);
        fullCarName.clear();
        return name;
    }

    public ArrayList<String> getFullCarName() {
        return fullCarName;
    }

    public void searchPanelSelectElement() {
        DropDown makeId = getSelectDropDown(makeIdName);
        DropDown modelId = getSelectDropDown(modelIdName);
        DropDown yearId = getSelectDropDown(yearName);
        selection(makeId);
        selection(modelId);
        selection(yearId);
        search.click();
    }
}
