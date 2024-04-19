package ru.iteco.fmhandroid.ui.tests;


import android.view.View;

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

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "ТК по процессу Авторизация, аутентификация.")
public class AuthorizationTests {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    String validLogin = "login2";
    String notRegisteredLogin = "Valeron777";
    String validPassword = "password2";
    private View decorView;


    @Before
    public void setUp() {
        AuthorizationSteps.appDownload();
        try {
            AuthorizationSteps.loadAuthPage();

        } catch (Exception e) {
            AuthorizationSteps.logOut();
            AuthorizationSteps.loadAuthPage();
        }
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Story("ТК№1. Авторизация в мобильном приложении(зарегистрированный пользователь")
    @Test
    public void authorizationRegisteredUser() {
        AuthorizationSteps.login(validLogin, validPassword);
        AuthorizationSteps.checkLogoMainPage();
        AuthorizationSteps.logOut();

    }

    @Story("Выход из учётной записи")
    @Test
    public void logOut() {
        AuthorizationSteps.login(validLogin, validPassword);
        AuthorizationSteps.checkLogoMainPage();
        AuthorizationSteps.logOut();

    }

    @Story("Авторизация в мобильном приложении незарегистрированного пользователя")
    @Test
    public void authorizationNotRegisteredUser()  {
        AuthorizationSteps.login(notRegisteredLogin, validPassword);
        AuthorizationSteps.checkInformationMessageNotRegisteredUser("Something went wrong. Try again later.", decorView);

    }


}
