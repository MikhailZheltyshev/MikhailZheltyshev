package pageObjects;

import com.codeborne.selenide.ElementsCollection;
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
    private ElementsCollection sliders;

    private final ElementsLogHelper LOG_PARSER = new ElementsLogHelper();
    private final SliderHandler SLIDER_HANDLER = new SliderHandler();

    //=====================================================METHODS======================================================
    @Step("Check that slider's setting From {0} to {1} was properly logged")
    public void setSlidersPosition(int from, int to) {
        if (SLIDER_HANDLER.getCurrentPosition(sliders.get(0)) == 0 && SLIDER_HANDLER.getCurrentPosition(sliders.get(1)) == 0) {
            SLIDER_HANDLER.setPosition(sliders.get(1), to);
            SLIDER_HANDLER.setPosition(sliders.get(0), from);
        } else {
            SLIDER_HANDLER.setPosition(sliders.get(0), from);
            SLIDER_HANDLER.setPosition(sliders.get(1), to);
        }
    }

    @Step("Check that slider's setting From {0} to {1} was properly logged")
    public void checkSlidersSettingLog(int from, int to) {
        if (to == 100 && from == 100) {
            assertEquals(LOG_PARSER.getActualLogRecord(1),
                    LOG_PARSER.generateExpectedRecord(TO, to));
            assertEquals(LOG_PARSER.getActualLogRecord(0),
                    LOG_PARSER.generateExpectedRecord(FROM, from));
        } else {
            assertEquals(LOG_PARSER.getActualLogRecord(0),
                    LOG_PARSER.generateExpectedRecord(TO, to));
            assertEquals(LOG_PARSER.getActualLogRecord(1),
                    LOG_PARSER.generateExpectedRecord(FROM, from));
        }
    }
}

