package com.ddaypunk.dupagekotlin

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class HomePage(private val driver: WebDriver) {

    fun searchVideo(video: String) {
        val search = driver.findElement(By.cssSelector("[title='Search']"))
        search.click()
        search.sendKeys(video)
        search.sendKeys(Keys.ENTER)
    }
}