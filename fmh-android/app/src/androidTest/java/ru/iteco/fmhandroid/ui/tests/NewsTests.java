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
@Feature(value = "Тест-кейсы для вкладки News мобильного приложения Мобильный хоспис.")
public class NewsTests {
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

    @Story("ТК№14. Переход во вкладку «About» с вкладки «News»")
    @Test
    public void goToTheAboutPage (){
        MainSteps.goToTheNews();
        MainSteps.goToTheAbout();

    }
}