package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SliderHandler {

    SelenideElement sliderRange = $(".range");

    SelenideElement leftHandle = $$(".ui-slider-handle").get(0);
    SelenideElement rightHandle = $$(".ui-slider-handle").get(1);

    private int getStep(){
        return sliderRange.getSize().width / 100;
    }

    public Double getPosition(SelenideElement handle) {
        Double sliderCenterPx = Double.parseDouble(handle.getCssValue("left")
                .replaceAll("px", "")) + handle.getSize().width / 2;
        return sliderCenterPx / getStep();
    }

    public void setSliderPosition(SelenideElement left, Integer leftPosition, SelenideElement right, Integer rightPosition) {
        Actions actions = new Actions(getWebDriver());

        double xOffsetL = (leftPosition - getPosition(left)) * getStep();
        actions.dragAndDropBy(left, (int)xOffsetL, 0).perform();

        double xOffsetR = (rightPosition - getPosition(leftHandle)) * getStep();
        actions.dragAndDropBy(right, (int)xOffsetR, 0).perform();
    }
}
