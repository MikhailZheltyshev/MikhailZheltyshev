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
        return sliderPosition / getStep();
    }

    private Double getStep() {
        return (double) sliderRange.getSize().width / 100;
    }


    public void setPosition(SelenideElement handle, int targetPosition) {
        Actions actions = new Actions(getWebDriver());

        Double current = Double.parseDouble(handle.getCssValue("left").replaceAll("px", "")) / getStep();
        int xOffset = (int) ((targetPosition - current - 1) * getStep());
        actions.dragAndDropBy(handle, xOffset, 0).perform();

    }

    //This method works more stable on Mac platform for some reason.
    public void setPositionExperimental(SelenideElement handle, int targetPosition) {
        Actions actions = new Actions(getWebDriver());
        Double current = Double.parseDouble(handle.getCssValue("left").replaceAll("px", "")) ;
        int xOffset;
        if(targetPosition == 0){
            xOffset = (int)-Math.ceil(current);
        } else if (targetPosition == 100){
            xOffset = (int)Math.ceil(sliderRange.getSize().width - current);
        } else {
            xOffset = (int) ((targetPosition - (current / getStep()) - 1) * getStep());
        }

        actions.dragAndDropBy(handle, xOffset, 0).perform();

    }


}