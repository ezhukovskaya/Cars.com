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
        Thread.sleep(2000);
        selection(modelId, car.getCarModel());
        Thread.sleep(2000);
        selection(yearId, car.getModelYear());
        Thread.sleep(2000);
        done.click();
    }

}
