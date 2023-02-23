import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1928x1080";
    }

    @Test
    void fillFormTest(){

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Maksim");
        $("#lastName").setValue("Smirnov");
        $("#userEmail").setValue("MaksimSmirnov@gmail.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("9506495064");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $x("//div[.='7']");

        $("#subjectsInput").setValue("English");
        $(".subjects-auto-complete__menu").$(byText("English")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#currentAddress").setValue("street, 89");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Maksim"));
        $(".table-responsive").shouldHave(text("Smirnov"));

        $("#closeLargeModal").click();
    }

}
