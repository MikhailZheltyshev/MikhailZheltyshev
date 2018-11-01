package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @FindBy(id = "Name")
    private TextField name;

    @FindBy(id = "Password")
    private TextField password;

    @Css("[type=submit]")
    private Button enter;
}

