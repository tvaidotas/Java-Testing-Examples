# Selenium

## Check what chrome version do you have
1. Launch Google Chrome.
2. Click on the icon in the upper right corner that looks like 3 short bars.
3. Select About Google Chrome to display the version number.

## Download the appropriate chrome driver
Based on the version of your chrome installed, download the appropriate chrome driver from:
http://chromedriver.chromium.org/downloads

## Update the path to the chrome driver

My path to the chrome driver is as follows, you will need to update it to match yours
``` java
System.setProperty("webdriver.chrome.driver","C:\\Users\\tadas\\IdeaProjects\\testingexamples\\src\\test\\java\\resources\\chromedriver.exe");
``` 

