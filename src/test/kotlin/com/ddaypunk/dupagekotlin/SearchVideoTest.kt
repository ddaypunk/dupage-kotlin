package com.ddaypunk.dupagekotlin

import org.junit.Assert
import org.junit.Test

class SearchVideoTest() : BaseTest() {

    @Test
    fun searchVideo() {
        val homePage = HomePage(driver!!)
        homePage.searchVideo(PropManager.getProp("searchTerm"))

        val resultPage = ResultPage(driver!!)
        Assert.assertTrue(resultPage.isPageOpened())
    }

}