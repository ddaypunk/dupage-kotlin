package com.ddaypunk.dupagekotlin

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import java.net.URI
import java.util.concurrent.TimeUnit

object Driver {
    var driver: WebDriver
    private val isLocal = PropManager.getProp("local").toBoolean()
    private val browser = PropManager.getProp("browser")

    init {
        driver = createDriver()
    }

    private fun createDriver(): WebDriver {
        return if (isLocal) {
            getLocalDriver()
        } else {
            getRemoteDriver()
        }
    }

    private fun getLocalDriver(): WebDriver {
        return when(browser.toLowerCase()) {
            "chrome" -> getChromeDriver() // not working correctly on linux
            "firefox" -> getFirefoxDriver() // works on linux
            else -> getFirefoxDriver() // default to Firefox for now
        }
    }

    private fun getRemoteDriver(): WebDriver {
        return getChromeDriver()
    }

    private fun getChromeDriver(): ChromeDriver {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver(getChromeOptions())
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.position = Point(0, 0)
        driver.manage()?.window()?.size = Dimension(1280, 1080)

        return driver as ChromeDriver
    }

    private fun getFirefoxDriver(): FirefoxDriver {
        WebDriverManager.firefoxdriver().setup()
        driver = FirefoxDriver()

        return driver as FirefoxDriver
    }

    private fun getChromeOptions(): ChromeOptions {
        val ops = ChromeOptions()
//        ops.addArguments("--disable-infobars") // disabling infobars
//        ops.addArguments("--disable-extensions") // disabling extensions
//        ops.addArguments("--disable-gpu") // applicable to windows os only
        ops.addArguments("--headless")
        ops.addArguments("--no-sandbox")
        ops.addArguments("--disable-dev-shm-usage")

        return ops
    }
}
