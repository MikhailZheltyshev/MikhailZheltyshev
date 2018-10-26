package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import enums.DatesPageSliderTypes;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import utils.ElementsLogHelper;
import utils.SliderHandler;

import static enums.DatesPageSliderTypes.FROM;
import static enums.DatesPageSliderTypes.TO;
import static org.testng.Assert.assertEquals;

public class DatesPageSelenide {

    //============================================WEB-ELEMENTS AND CONSTANTS============================================
    @FindBy(css = ".ui-slider-handle")
    ElementsCollection sliders;

    private final ElementsLogHelper LOG_PARSER = new ElementsLogHelper();
    private final SliderHandler SLIDER_HANDLER = new SliderHandler();

    //=====================================================METHODS======================================================
    @Step("Set slider's range From 0 To 100")
    public void setSlidersFrom0To100() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 0);
        SLIDER_HANDLER.setPosition(sliders.get(1), 100);
    }

    @Step("Set slider's range From 0 To 0")
    public void setSlidersFrom0To0() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 0);
        SLIDER_HANDLER.setPosition(sliders.get(1), 0);
    }

    @Step("Set slider's range From 100 To 100")
    public void setSlidersFrom100To100() {
        SLIDER_HANDLER.setPosition(sliders.get(1), 100);
        SLIDER_HANDLER.setPosition(sliders.get(0), 100);
    }

    @Step("Set slider's range From 30 To 70")
    public void setSlidersFrom30To70() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 30);
        SLIDER_HANDLER.setPosition(sliders.get(1), 70);
    }

    @Step("Check that slider's setting From 0 to 100 was properly logged")
    public void checkSlidersAreSetFrom0To100Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 0));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 100));
    }

    @Step("Check that slider's setting From 0 to 0 was properly logged")
    public void checkSlidersAreSetFrom0To0Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 0));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 0));
    }

    @Step("Check that slider's setting From 100 to 100 was properly logged")
    public void checkSlidersAreSetFrom100To100Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 100));
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 100));
    }

    @Step("Check that slider's setting From 30 to 70 was properly logged")
    public void checkSlidersAreSetFrom30To70Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 30));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 70));
    }
}
