package pageObjects;

import base.SelenideTestBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.DatesPageSliderTypes;
import javafx.scene.control.Slider;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;
import utils.SliderHandler;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.DatesPageSliderTypes.FROM;
import static enums.DatesPageSliderTypes.TO;
import static org.testng.Assert.assertTrue;

public class DatesPageSelenide {

    //==================================================WEB-ELEMENTS====================================================
    @FindBy(css = ".range")
    SelenideElement sliderRange;

    @FindBy(css = ".ui-slider-handle")
    ElementsCollection sliders;

    private final ElementsLogHelper LOG_PARSER = new ElementsLogHelper();

    //=====================================================METHODS======================================================
    public void setSlidersFrom0To100() {

        SliderHandler sliderHandler = new SliderHandler();
        sliderHandler.setSliderPosition(sliders.get(0), 0, sliders.get(1), 100);
    }

    public void setSlidersFrom0To0() {
        SliderHandler sliderHandler = new SliderHandler();
        sliderHandler.setSliderPosition(sliders.get(0), 0, sliders.get(1), 0);
    }

    public void setSlidersFrom100To100() {
        SliderHandler sliderHandler = new SliderHandler();
        sliderHandler.setSliderPosition(sliders.get(0), 100, sliders.get(1), 100);
    }

    public void setSlidersFrom30To70() {
        SliderHandler sliderHandler = new SliderHandler();
        sliderHandler.setSliderPosition(sliders.get(0), 30, sliders.get(1), 70);
    }

    public void checkFromSliderIsSetTo0() {
        assertTrue(LOG_PARSER.getStateByRecord(1, FROM, 0));
    }

    public void checkToSliderIsSetTo100() {
        assertTrue(LOG_PARSER.getStateByRecord(0, TO, 100));
    }

    public void checkToSliderIsSetTo0() {
        assertTrue(LOG_PARSER.getStateByRecord(0, TO, 0));
    }

    public void checkFromSliderIsSetTo100() {
        assertTrue(LOG_PARSER.getStateByRecord(1, FROM, 100));
    }

    public void checkToSliderIsSetTo70() {
        assertTrue(LOG_PARSER.getStateByRecord(0, TO, 70));
    }

    public void checkFromSliderIsSetTo30() {
        assertTrue(LOG_PARSER.getStateByRecord(1, FROM, 30));
    }
}
