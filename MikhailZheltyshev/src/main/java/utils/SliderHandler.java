package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SliderHandler {

    private SelenideElement sliderRange = $(".range");


    private Double getPosition(SelenideElement handle) {
        double sliderPosition = Double.parseDouble(handle.getCssValue("left")
                .replaceAll("px", ""));
        return (sliderPosition / getStep());
    }

    private Double getStep() {
        return (double) sliderRange.getSize().width / 100;
    }

    public void setSliderPosition(SelenideElement leftHandle, int leftPosition, SelenideElement rightHandle, int rightPosition) {
        Actions actions = new Actions(getWebDriver());

        Double currentL = Double.parseDouble(leftHandle.getCssValue("left").replaceAll("px", "")) / getStep();
        int xOffsetL = (int) ((leftPosition - currentL - 1) * getStep());
        actions.dragAndDropBy(leftHandle, xOffsetL, 0).perform();

        Double currentR = Double.parseDouble(rightHandle.getCssValue("left").replaceAll("px", "")) / getStep();
        int xOffsetR = (int) ((rightPosition - currentR - 1) * getStep());
        actions.dragAndDropBy(rightHandle, xOffsetR, 0).perform();
    }


}