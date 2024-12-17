package tests;

import org.junit.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.MapPage;
import pages.SearchPage;

import java.util.ArrayList;

public class TestBooking extends BaseTest {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    MapPage mapPage = new MapPage();
    HotelPage hotelPage = new HotelPage();

    private final String city = "Анталья";

    @Test
    public void testRating() {
        homePage.openHomePage().acceptCookies().hideMenu().chooseCity(city).searchHotels();
        searchPage.checkCityName(city).hideMenu().setStarFilter().hideMenu().checkHotelStar();
    }

    @Test
    public void testFirstHotel() {
        ArrayList<String> infoMap = new ArrayList<String>();
        ArrayList<String> infoHotel = new ArrayList<String>();
        homePage.openHomePage().acceptCookies().hideMenu().chooseCity(city).chooseData().searchHotels();
        searchPage.checkCityName(city).hideMenu().showMap().hideMenu();
        mapPage.hideMenu().saveInfo(infoMap).openHotel();
        hotelPage.compareInfo(infoHotel,infoMap);
    }

}
