package steps

import io.cucumber.java8.En

class ExampleSteps : En {
    init {
        Given("I have {int} cukes in my belly") { cukes: Int? ->
            print("Cukes: $cukes")
        }

        When("I wait {int} hour") { hours: Int? ->
            print("Hours: $hours")
        }
        Then("my belly should growl") {
            print("Growling tummy...")
        }
    }
}
