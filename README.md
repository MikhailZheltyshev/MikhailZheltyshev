# MikhailZheltyshev
HW 2 Mobile TA

*1. Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

    Done. Now there is only one driver object for every test suite.
    We have access to one common driver instance from all tests. In addition, we can control driver instance creation/modification easily.

*2. Suggest improvements for .properties reading. What are the purposes?

    It is better to replace inheritance of TestProperties.class by Driver.class with delegation of TestProperties object as declared field in Driver class. So it will prevent our Driver class from having unnecessary methods and variables from the parental class. 
    Also the using of inheritance in our class violates SOLID principles (because we have used inheritance for copying code but not for real functional extending of the parental class). 

*3. Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test

    1. Added checks for field’s titles.
    2. Added check for screen title.
    3. Added checks for fields are displayed.

*4. Optional: Add keyboard presence check in “native” test.

isKeyBoardShown() method is not implemented for AndroidDriver in latest appium-client (6.1.0) release.

    I’ve found the solution using .hideKeyboard() method with catching corresponding exception in case of no keyboard was   previously opened to hide. In order to check presence of the keyboard using this approach, I’ve implemented special KeyBoardHelper.class with checkKeyBoardAppears() method.

However, I am not sure that it is a good solution since we force closing of opened keyboard to check its presence.

*5. Which checks would you place in the “web” test?

    1. Check response code of the target page.
    2. Check header logo is displayed.
    3. Check there are three sections home-panels presented.
