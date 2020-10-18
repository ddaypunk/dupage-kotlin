package com.ddaypunk.dupagekotlin

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.junit.Before
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import java.net.URI
import java.util.concurrent.TimeUnit

abstract class BaseTest {
    lateinit var driver: WebDriver
        private set

    @Before
    fun setup() {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver?.manage()?.window()?.position = Point(0,0)
        driver?.manage()?.window()?.size = Dimension(1280,1080)
        driver?.get(URI(PropManager.getProp("host")).toString())
    }

    @After
    fun driverClose() {
        driver?.close();
    }
}