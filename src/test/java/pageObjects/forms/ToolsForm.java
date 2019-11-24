package pageObjects.forms;

import framework.base.BaseForm;
import framework.elements.Button;

public class ToolsForm extends BaseForm {
    private String researchPageLocator = "//*[@class='m6uQf']";
    private Button sideBySide = getFormElement("Side-by-side Comparisons",researchPageLocator);

    public void toolsFormButtonClick(){
        sideBySide.click();
    }
}
