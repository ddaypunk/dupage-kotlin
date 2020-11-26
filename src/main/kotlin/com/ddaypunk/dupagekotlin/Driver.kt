package com.ddaypunk.dupagekotlin

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.net.URI
import java.util.concurrent.TimeUnit

object Driver {
    var driver: WebDriver

    init {
        driver = createDriver()
    }

    private fun createDriver(): WebDriver {
        val isLocal = PropManager.getProp("local").toBoolean()

        if (isLocal) {
            return getChromeDriver()
        }

        return getChromeDriver()
    }

    private fun getChromeDriver(): ChromeDriver {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.position = Point(0, 0)
        driver.manage()?.window()?.size = Dimension(1280, 1080)
        driver.get(URI(PropManager.getProp("host")).toString())

        return driver as ChromeDriver
    }
}
