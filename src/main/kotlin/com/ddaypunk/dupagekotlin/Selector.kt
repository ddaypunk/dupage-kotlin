package com.ddaypunk.dupagekotlin

import org.openqa.selenium.By

class Selector(private val attr: String, private val value: String?) {
    fun getBy(): By {
        return if (value == null) By.cssSelector("[$attr]")
        else By.cssSelector("[$attr=\'$value\']")
    }
}
