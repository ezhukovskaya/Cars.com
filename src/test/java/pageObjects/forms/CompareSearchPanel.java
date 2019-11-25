package pageObjects.forms;

import framework.elements.Button;
import framework.elements.DropDown;
import org.openqa.selenium.By;

public class CompareSearchPanel extends SearchPanel {
    private String compareMakeIdName = "makeDropdown";
    private String compareModelIdName = "modelDropdown";
    private String compareYearIdName = "yearDropdown";
    private By compareButtonLocator = By.xpath("//*[contains(@class,'done-button')]");
    private Button compareButton = new Button("Start Comparing", compareButtonLocator);
    private DropDown makeId = getSelectDropDown(compareMakeIdName);
    private DropDown modelId = getSelectDropDown(compareModelIdName);
    private DropDown yearId = getSelectDropDown(compareYearIdName);

    private void selection(DropDown dropDown, String choice) {
        dropDown.click();
        dropDown.select(choice);
    }

    public void searchPanelSelectElement(Cars car) {
        selection(makeId, car.getCarName());
        selection(modelId, car.getCarModel());
        selection(yearId, car.getModelYear());
        compareButton.click();
    }
}
