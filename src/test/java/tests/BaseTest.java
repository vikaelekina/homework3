package tests;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;



public class BaseTest {



    @AfterAll
    public static void turnDown() {
        Selenide.closeWebDriver();
    }
}
