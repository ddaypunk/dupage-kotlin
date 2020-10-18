package com.ddaypunk.dupagekotlin

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


class ResultPage(private val driver: WebDriver) {

    fun isPageOpened(): Boolean{
        val numResult = driver.findElement(By.id("result-stats"))
        return numResult?.text.toString().contains("About")
    }
}