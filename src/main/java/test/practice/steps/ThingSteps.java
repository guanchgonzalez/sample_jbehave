package test.practice.steps;

import org.jbehave.core.annotations.Given;
//import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import test.practice.model.Thing;

public class ThingSteps {
  private final ThreadLocal<Thing> thingStash = new ThreadLocal<>();

  private Thing getThing() {
    return this.thingStash.get();
  }

  @Given("I have a Thing with an item named foo")
  public void givenIHaveAThingWithAnItemNamed(String name) {
    Thing thing = new Thing(name);
    thingStash.set(thing);
  }

  @When("I add an item named bar")
  public void whenIAddAnItemNamed(String name) {
    getThing().addThing(name);
  }

  @Then("My Thing has 2 items")
  public void thenThingHasName(int count) {
    Assert.assertEquals(getThing().getThingCount(), count);
  }

  @Then("My Thing has an item named bar")
  public void thenThingHasName(String name) {
    Assert.assertTrue(getThing().hasThing(name));
  }   
}
