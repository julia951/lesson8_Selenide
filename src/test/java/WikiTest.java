import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest {

    @Test
    @DisplayName("Проверка наличия раздела JUnit5 в GitHUb/Selenide")
    void searchJUnit5Test() {

        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();

        $("#wiki-pages-filter").val("SoftAssertions").pressEnter();

        $(".wiki-pages-box").shouldHave(text("SoftAssertions"));

        $(byText("SoftAssertions")).click();

        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4")
                .shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
