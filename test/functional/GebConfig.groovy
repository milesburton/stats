/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver


baseUrl = System.getProperty('geb.http.baseurl') ?: "http://localhost:8080/stats/"
secureBaseUrl = System.getProperty('geb.https.baseurl') ?: "http://localhost:8080/stats/"

println "Using baseUrl: ${baseUrl}"

reportsDir = 'target/test-reports/screenshots'


// Use htmlunit as the default
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = {
    def driver = new HtmlUnitDriver()
    driver.javascriptEnabled = true
    driver
}

environments {

    // run as “grails -Dgeb.env=chrome test-app”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }

    // run as “grails -Dgeb.env=firefox test-app”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }

}