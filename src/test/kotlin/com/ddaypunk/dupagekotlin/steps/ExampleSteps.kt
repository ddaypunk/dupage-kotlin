package com.ddaypunk.dupagekotlin.steps

import io.cucumber.java8.En

class ExampleSteps : En {
    fun StepDefinitions() {
        Given("I have {int} cukes in my belly") { cukes: Int? ->
            System.out.format("Cukes: %n\n", cukes)
        }
    }
}
