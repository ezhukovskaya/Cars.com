package pageObjects.forms;

import framework.elements.Button;
import framework.elements.DropDown;
import org.openqa.selenium.By;

public class AnotherCarSearch extends SearchPanel {
    private DropDown makeId = getSelectDropDown("makeDropdown");
    private DropDown modelId = getSelectDropDown("modelDropdown");
    private DropDown yearId = getSelectDropDown("yearDropdown");
    private By doneLocator = By.xpath("//*[contains(@class,'modal-button')]");
    private Button done = new Button(doneLocator, "Done");

    private void selection(DropDown dropDown, String choice) {
        dropDown.click();
        dropDown.select(choice);
    }

    public void searchPanelSelectElement(Cars car) {
        selection(makeId, car.getCarName());
        selection(modelId, car.getCarModel());
        selection(yearId, car.getModelYear());
        done.click();
    }

}
