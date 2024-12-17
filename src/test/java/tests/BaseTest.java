package tests;


import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;


public class BaseTest {
    @Before
    public void setUp() {

    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
