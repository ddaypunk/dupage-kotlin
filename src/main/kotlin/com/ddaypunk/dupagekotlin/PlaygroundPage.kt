package com.ddaypunk.dupagekotlin

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class PlaygroundPage(private val driver: WebDriver) {
    fun clickLearnReact() {
        val button = driver.findElement(By.cssSelector("[data-test-button='Learn React']"))
        button.click()
    }
}
