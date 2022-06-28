import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTask {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void positiveTest() throws InterruptedException {
        open("/drag_and_drop");

        $("#column-a").dragAndDropTo($("#column-b"));

        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));

    }
}