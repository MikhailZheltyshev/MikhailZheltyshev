# MikhailZheltyshev
HW 1 Mobile TA

*1.	Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.
    
    DONE - all tests run properly.

*2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?
   
    Added the following locators:

    By add_btn_xpath = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
    By add_btn_class_name = By.className("android.widget.Button");

*3.	Modify existing tests to run on a real device. What should be changed? 

    DONE - all tests run on real device. 
    “deviceName” capability value should be changed to particular real device name (e.g. my real device’s name is “aaf89146”).

*4.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?
    
    To allow our tests to control the real device we need to perform some preparations:
       - Unlock developer options in device preferences (by tapping multiple times on "Build Number" option in Preferences > About Phone section)
       - Enter unlocked Developer options and allow USB debuggin
       - Connect your device to the PC with adb drivers for your device installed
       - Start Appium server and start Appium inspector session
       - Change "deviceName" property to paricular real device name (to know device name execute command "adb devices" via cmd) in Appium session config and in DriverSetup.class caps of our project.
       - Establish session
       - Allow debugging session on your device if needed
       
    It does not seem there is any difference (except some real device manual preparations) for running appium session on real device.

*5.	What should be improved/changed in existing test code? Why, for what?
    
    1.  We have used absolute paths to our .apk file – so our test project won’t run properly on other PC since the absolute paths will differ on every machine. Therefore, we should replace the absolute paths with relative ones. It will allow us to run the tests on different machines with no dependency on absolute path to our project.
    
    2. Code comments need to be organized to provide our colleges with more documentation on our project to improve teamwork efficiency. 
    
    3. We need to avoid hardcoded values to ensure better flexibility (for possible future changes) and further code maintenance. For example, sut URL can be replaced with a constant variable.
    
    4. It is good practice to separate test logic from test data (PO pattern). Currently we declare button selector’s variables inside the Test methods, but what if we need to reuse some of them?
    
    5. Also it is better to move driver initialization class from scenarios folder to some other project outside the tests scope. 
    
    6. Thread.sleep() is not a good practice in real-life projects. It just blocks our application and stop particular thread running with pointless computer resources consumption. In addition, it really slows down our test application with pointless waits.
    
    7. No test asserts are presented, which makes our tests pointless.
 

