package tests;


import com.codeborne.selenide.Selenide;
import org.junit.*;


public class BaseTest {
    @Before
    public void setUp() {

    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
