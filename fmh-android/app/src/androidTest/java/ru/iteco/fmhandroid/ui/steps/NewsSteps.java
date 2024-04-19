package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.ControlPanelPage;
import ru.iteco.fmhandroid.ui.elements.NewsPage;

public class NewsSteps {
    @Step("Переход на страницу Анель управления новостями")
    public static void clickButtonEditNews() {
        onView(NewsPage.buttonEditNews()).check(matches(isDisplayed()));
        onView(NewsPage.buttonEditNews()).perform(click());
        ControlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}