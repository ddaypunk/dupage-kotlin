package com.ddaypunk.dupagekotlin

import org.junit.Test

class ReactPlaygroundTest : BaseTest() {

    @Test
    fun userIsAbleToFindLearnReactButton() {
        val playgroundPage = PlaygroundPage(driver)
        playgroundPage.clickLearnReact()
    }
}
