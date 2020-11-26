package com.ddaypunk.dupagekotlin

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

// TODO: use delegation pattern for components?
class Component(private val by: Selector) : RemoteWebElement() {
    private lateinit var root: WebElement

    /*fun getRoot() : WebElement {
        if (this.root == null) {
            setRoot()
        } else if (true) {

        }
    }

    fun setRoot() {
    }*/
}
