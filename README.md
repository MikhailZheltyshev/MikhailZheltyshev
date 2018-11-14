# MikhailZheltyshev
### HW 3 Mobile TA

   1.	Add support of appPackage and appActivity parameters for Android devices 
   (reading from a .properties file and then setting in the    DesiredCapabilities). Locally
   installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.
       
    Done, corresponding fields and its initializations are added to Driver.class. 
    Driver URL was changed to the mobileFarm url with a valid token added.

   a.	Or try to use autoLaunch capability with app as before. Does this approach work?    
    
    No, this approach doesn’t work. Server returns the following response:
    {  
    "status":13,
    "value":{  
          "message":"An unknown server-side error occurred while processing the command. 
          Original error: The desired capabilities must  include either an app, appPackage or browserName"
       },
       "sessionId":null
    }
    
   2.	Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass? 
   
    Done and test passed. “devicename” value was changed and “udid” key with corresponding target device’s udid value.
   
   3.	Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?
               
    Test passed. 
        
  4.	What’s wrong with our code? How to fix/improve it? Implement your suggestions.
    
    1.	Currently it is not convenient to change properties each time we want to run our tests on
    different device. We should store our devices with corresponding capabilities and properties as 
    objects in some .json or .xml files.
        Solution:
        Properties replaced with JSON config files (are placed in “/src/test/resources/appium/deviceConfigs”), 
        each of which contains number of capabilities specified for the particular device. Gson library is used 
        to deserialize this json configs to POJO of the custom Device.class, which object stores all caps of the target device. 
        Now we can easily reuse predefined configs for test devices with power of flexible json format. 
    
    In addition, I’ve implemented corresponding testNG suiteXml config files to run tests using different configurations
    of devices (there are testNG configs for tests on emulator, real local or remote devices added to the test resources
    directory). E.g., now you can start running of the native test by executing following command in CMD (from the project’s root):

        mvn clean test -DsuiteXmlFile=/appium/spb_farm_android_nexus5s_native.xml

    To start running of the web test on remote iOS device on SPb Mobile Farm, execute:

        mvn clean test -DsuiteXmlFile=/appium/spb_farm_ios_iphone5s_web.xml

    For more available configs see _“/src/test/resources/appium” package._

    2.	It is better to replace (where possible) all “green” colored hardcoded values to Enums or constants. 
    I’ve implemented enums for storing browser’s names, common constants (path to resources, https prefix for 
    sut in our tests), error’s texts (unclear type of mobile device, unclear type of mobile platfrom) 
    – see /src/main/java/appium_enums/ package. 
