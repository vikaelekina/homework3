package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class MapPage {


    private final SelenideElement hideMenuButton = $(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']"));

//    private final SelenideElement firstHotel = $(By.xpath("//a[@data-testid='property-list-map-card']"));
    private final SelenideElement firstHotel = $x("//a[@aria-label='Карточка варианта жилья']");
    private final SelenideElement name = firstHotel.find((By.tagName("h2")));
    private final ElementsCollection stars = firstHotel.findAll(By.xpath(".//span[@data-testid='rating-stars']/span"));
    private final SelenideElement averageRating = firstHotel.find(By.xpath(".//div[@style='--bui_stack_spaced_gap--s: 2;']/div"));
    private final SelenideElement countOfReview = firstHotel.find(By.xpath(".//div[@style='--bui_stack_spaced_gap--s: 2;']/div[2]/div[2]"));
    private final SelenideElement cost = firstHotel.find(By.xpath(".//span[@data-testid='price-and-discounted-price']"));
    private final ElementsCollection markers = $$(By.xpath(".//div[@style='position: absolute; left: 0px; top: 0px; z-index: 106; width: 100%;']/div"));

    public MapPage saveInfo(ArrayList<String> info){
        sleep(5000);
        assert firstHotel.is(Condition.visible);
        info.add(name.shouldBe(Condition.visible).getText());
        if (stars.isEmpty()){info.add(null);}
        info.add(String.valueOf(stars.size()));
        String rating = averageRating.getText();
        info.add(rating.substring(rating.length()-3));
        info.add(countOfReview.getText().replaceAll(" ", ""));
        info.add(cost.getText().replaceAll(" ",""));
        System.out.println(info);
        return this;
    }


    public MapPage openHotel(){
        firstHotel.hover();
        markers.last().scrollTo().click();
        return this;
    }

    public MapPage hideMenu() {
        if(hideMenuButton.is(Condition.visible)){
            hideMenuButton.click();
        }
        return this;
    }

}
