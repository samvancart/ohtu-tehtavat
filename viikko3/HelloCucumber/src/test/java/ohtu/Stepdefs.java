package ohtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class Stepdefs {

    Counter counter;

    @Given("Counter is initialised")
    public void counterIsInitialized() {
        counter = new Counter();
    }

    @When("it is incremented")
    public void itIsIncremented() {
        counter.increase();
    }
    
    
    @When("it is incremented by {int}")
    public void itIsIncrementedBy(Integer val) {
        counter.increment(val);
    }

    @When("it is reset")
    public void itIsResetAfterIncrementingOnce() {
        counter.increase();
        counter.reset();
    }

    @When("it is incremented by {int} and it is reset")
    public void itIsResetAfterIncrementingSeveralTimes(Integer val) {
        counter.increment(val);
        counter.reset();
    }

    @Then("the value should be {int}")
    public void theValueShouldBe(Integer val) {
        assertEquals(val.intValue(), counter.value());
    }

}
