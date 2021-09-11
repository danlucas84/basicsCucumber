package steps;

import drivers.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BackgroundSteps {

    @Before
    public void before() {
        System.out.println(String.format("|*** | Starting tests"));
    }

    @After
    public void after() {
        System.out.println(String.format("|*** | Ending tests"));
    }

    @After(order = 20)
    public void afterCloseDriver() {
        DriverProvider.flush();
    }
}