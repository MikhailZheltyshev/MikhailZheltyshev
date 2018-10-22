package pageObjects;

import base.SelenideTestBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import utils.SliderHandler;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPageSelenide {

    //==================================================WEB-ELEMENTS====================================================
    @FindBy(css=".range")
    SelenideElement sliderRange;

    @FindBy(css=".ui-slider-handle")
    ElementsCollection sliders;







    //=====================================================METHODS======================================================
    public void setSlidersFrom0To100(){
        SliderHandler handler = new SliderHandler();
        System.out.println(handler.getPosition(sliders.get(0)));
        int a = 0;
    }
}
