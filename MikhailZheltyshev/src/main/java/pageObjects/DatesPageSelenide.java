package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import enums.DatesPageSliderTypes;
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
    public void setSlidersFrom0To100() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 0);
        SLIDER_HANDLER.setPosition(sliders.get(1), 100);
    }

    public void setSlidersFrom0To0() {
        SLIDER_HANDLER.setPosition(sliders.get(0), 0);
        SLIDER_HANDLER.setPosition(sliders.get(1), 0);
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

    public void checkSlidersAreSetFrom0To100Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 0));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 100));
    }

    public void checkSlidersAreSetFrom0To0Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 0));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 0));
    }

    public void checkSlidersAreSetFrom100To100Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 100));
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 100));
    }

    public void checkSlidersAreSetFrom30To70Log() {
        assertEquals(LOG_PARSER.getActualLogRecord(1, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(FROM, 30));
        assertEquals(LOG_PARSER.getActualLogRecord(0, DatesPageSliderTypes.class),
                LOG_PARSER.generateExpectedRecord(TO, 70));
    }
}
