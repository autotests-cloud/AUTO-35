package cloud.autotests.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AppTests extends TestBase {
    @Test
    @Description("Проверка поиска на Ютубе")
    @DisplayName("YouTube search test")
    void generatedTest() {
        step("Open 'http://www.youtube.com/'", () -> {
            open("http://www.youtube.com/");
        });
        step("Fill search query 'Selenoid'", () -> {
            $("button[aria-label='Agree to the use of cookies and other data for the purposes described']").click();
            $("input[id = 'search']").setValue("Selenoid");
        });
        step("Press 'search' button", () -> {
            $("#search-icon-legacy").click();
        });
        step("Check result list contains video with title that contains 'Иван Крутов'", () -> {
            $$("#video-title").findBy(text("Иван Крутов")).shouldBe(visible);
        });
    }
}