package com.ddaypunk.dupagekotlin

import org.junit.After
import org.junit.Before
import java.net.URI

abstract class BaseTest {
     val driver = Driver.driver

    @Before
    fun setup() {
        driver.get(URI(PropManager.getProp("host")).toString())
    }

    @After
    fun driverClose() {
        driver.close()
    }
}
