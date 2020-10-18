package com.ddaypunk.dupagekotlin

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object PropManager {

    private var properties: Properties? = null

    fun loadProps() {
        try {
            properties = Properties()
            properties?.load(FileInputStream("config.properties"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getProp(properties: String): String {
        loadProps()
        return this.properties?.getProperty(properties).toString()
    }
}