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
import ru.iteco.fmhandroid.ui.steps.AboutPageSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для вкладки About мобильного приложения Мобильный хоспис.")
public class AboutPageTests {
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


    @Story("ТК№10. Просмотр ссылки \"Политика конфиденциальности\" во вкладке \"About\"")
    @Test
    public void checkLinkPrivatePolicy() {
        MainSteps.goToTheAbout();
        AboutPageSteps.goToTheLinkPrivacyPolicy();
    }

    @Story("ТК№11. Просмотр ссылки \"Пользовательское соглашение\" во вкладке \"About\"")
    @Test
    public void checkLinkTermsOfUse() {
        MainSteps.goToTheAbout();
        AboutPageSteps.goToTheLinkTermsOfUse();

    }

}
