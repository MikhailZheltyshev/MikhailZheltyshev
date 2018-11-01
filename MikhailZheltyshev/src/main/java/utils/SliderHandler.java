package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SliderHandler {

    private SelenideElement sliderRange = $(".range");

    private SelenideElement sliderHandle = $(".ui-slider");

    private Double getStep () {
        return (double) sliderRange.getSize().width / 100;
    }

    public void setPosition ( SelenideElement handle, int targetPosition ) {
        Actions actions = new Actions(getWebDriver());

        double halfSliderWidth = handle.getSize().getWidth() / 2;
        double sliderPosition = sliderHandle.getLocation().x;
        double current = handle.getLocation().x + halfSliderWidth;
        double xOffset = sliderPosition - current + targetPosition * getStep();

        actions.dragAndDropBy(handle, (int) Math.ceil(xOffset), 0).perform();
    }

    public Double getCurrentPosition ( SelenideElement handle ) {
        return Double.parseDouble(handle.getCssValue("left").replaceAll("px", "")) / getStep();
    }

}