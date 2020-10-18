package com.ddaypunk.dupagekotlin

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.junit.Before
import java.net.URI
import java.util.concurrent.TimeUnit

abstract class BaseTest {
    lateinit var driver: WebDriver
        private set

    @Before
    fun setup() {
        System.setProperty(PropManager.getProp("nameDriver"),
                PropManager.getProp("pathDriver") + PropManager.getProp("exeDriver"))
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver?.manage()?.window()?.maximize()
        driver?.get(URI(PropManager.getProp("pageURL")).toString())
    }

    @After
    fun driverClose() {
        driver?.close();
    }
}