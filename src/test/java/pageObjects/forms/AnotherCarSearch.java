package pageObjects.forms;

import framework.elements.Button;
import framework.elements.DropDown;
import org.openqa.selenium.By;

public class AnotherCarSearch extends SearchPanel {
    private String compareMakeIdName = "makeDropdown";
    private String compareModelIdName = "modelDropdown";
    private String compareYearIdName = "yearDropdown";
    private DropDown makeId = getSelectDropDown(compareMakeIdName);
    private DropDown modelId = getSelectDropDown(compareModelIdName);
    private DropDown yearId = getSelectDropDown(compareYearIdName);
    private By doneLocator = By.xpath("//*[contains(@class,'modal-button')]");
    private Button done = new Button("Done", doneLocator);

    private void selection(DropDown dropDown, String choice) {
        dropDown.click();
        dropDown.select(choice);
    }

    public void searchPanelSelectElement(Cars car) throws InterruptedException {
        selection(makeId, car.getCarName());
        selection(modelId, car.getCarModel());
        selection(yearId, car.getModelYear());
        done.click();
    }

}
