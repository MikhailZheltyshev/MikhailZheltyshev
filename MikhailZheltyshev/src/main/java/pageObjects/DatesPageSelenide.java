package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;
import utils.SliderHandler;

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
    private final SliderHandler SLIDER_HANDLER = new SliderHandler();

    //=====================================================METHODS======================================================
    public void setSlidersFrom0To100() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 0);
        SLIDER_HANDLER.setPosition(sliders.get(1), 100);
    }

    public void setSlidersFrom0To0() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 0);
        SLIDER_HANDLER.setPosition( sliders.get(1), 0);
    }

    public void setSlidersFrom100To100() {
        SLIDER_HANDLER.setPosition(sliders.get(1), 100);
        SLIDER_HANDLER.setPosition(sliders.get(0), 100);
    }

    public void setSlidersFrom30To70() {
        SliderHandler sliderHandler = new SliderHandler();
        sliderHandler.setPosition(sliders.get(0), 30);
        sliderHandler.setPosition(sliders.get(1), 70);
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

    public void checkSlidersAreSetFrom0To100Log(){
        assertTrue(LOG_PARSER.getStateByRecord(1, FROM, 0));
        assertTrue(LOG_PARSER.getStateByRecord(0, TO, 100));
    }
    public void checkSlidersAreSetFrom0To0Log(){
        assertTrue(LOG_PARSER.getStateByRecord(1, FROM, 0));
        assertTrue(LOG_PARSER.getStateByRecord(0, TO, 0));
    }

    public void checkSlidersAreSetFrom100To100Log(){
        assertTrue(LOG_PARSER.getStateByRecord(0, FROM, 100));
        assertTrue(LOG_PARSER.getStateByRecord(1, TO, 100));
    }

    public void checkSlidersAreSetFrom30To70Log(){
        assertTrue(LOG_PARSER.getStateByRecord(1, FROM, 30));
        assertTrue(LOG_PARSER.getStateByRecord(0, TO, 70));
    }
}
