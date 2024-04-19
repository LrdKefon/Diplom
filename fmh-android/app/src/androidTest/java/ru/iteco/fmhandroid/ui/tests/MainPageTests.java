package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для вкладки Main мобильного приложения Мобильный хоспис.")
public class MainPageTests {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        AuthorizationSteps.appDownload();
        try {
            AuthorizationSteps.loadAuthPage();
        } catch (Exception e) {
            AuthorizationSteps.logOut();
            AuthorizationSteps.loadAuthPage();
        }
        AuthorizationSteps.login("login2", "password2");

    }

    @Story("ТК№6. Переход во вкладку \"News\" через главное меню мобильного приложения")
    @Test
    public void goToTheNewsPage() {
        MainSteps.goToTheNews();
    }

    @Story("ТК№7. Переход во вкладку \"About\" через главное меню мобильного приложения")
    @Test
    public void goToTheAboutPage() {
        MainSteps.goToTheAbout();
    }

    @Story("ТК№8. Переход во вкладку «Тематические цитаты» через главное меню мобильного приложения")
    @Test
    public void goToTheQuotationPage() {
        MainSteps.goToTheQuotation();

    }

}