package tests;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchPage;

import java.util.ArrayList;

public class TestBooking extends BaseTest {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    private final String city = "Анталья";

    @Test
    @DisplayName("Рбаота фильтра выбора 5-звездочных отелей")
    public void testRating() {
        homePage.openHomePage().acceptCookies().hideMenu().chooseCity(city).searchHotels();
        searchPage.checkCityName(city).hideMenu().setStarFilter().hideMenu().checkHotelStar();
    }


}
