package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import site.sections.MetalsAndColorsForm;
import site.sections.ResultsSection;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPageJdi extends WebPage {

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @FindBy(css = ".results")
    public ResultsSection results;

    @FindBy(css=".form")
    public MetalsAndColorsForm metalsAndColorsForm;

    //==================================================ACTIONS=========================================================

}


