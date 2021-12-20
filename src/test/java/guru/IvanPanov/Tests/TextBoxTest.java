package guru.IvanPanov.Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static  com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void screensize(){
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Bob");
        $("#lastName").setValue("kol");
        $("#userEmail").setValue("bobkol@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("7900777999");

        $("#uploadPicture").scrollTo();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--029").click();


        $("#subjectsInput").setValue("Math").pressEnter();

        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFile( new File("src/test/resources/1.png"));

        $("#currentAddress").setValue("Moscow");


        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave
                (text("Bob"),
                text("kol"),
                text("bobkol@gmail.com"),
                text("Male"),
                text("7900777999"),
                text("29 August,2000"),
                text("Maths"),
                text("Sports, Reading, Music"),
                text("1.png"),
                text("Moscow"),
                text("Haryana Karnal"));
    }
}
