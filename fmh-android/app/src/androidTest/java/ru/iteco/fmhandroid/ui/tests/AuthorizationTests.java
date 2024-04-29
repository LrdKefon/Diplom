package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Data.notRegisteredLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;

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
    AuthorizationSteps authStep = new AuthorizationSteps();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;


    @Before
    public void setUp() {
        authStep.appDownload();
        try {
            authStep.loadAuthPage();

        } catch (Exception e) {
            authStep.logOut();
            authStep.loadAuthPage();
        }
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Story("ТК№1. Авторизация в мобильном приложении(зарегистрированный пользователь")
    @Test
    public void authorizationRegisteredUser() {
        authStep.login(validLogin, validPassword);
        authStep.checkLogoMainPage();
        authStep.logOut();

    }

    @Story("Выход из учётной записи")
    @Test
    public void logOut() {
        authStep.login(validLogin, validPassword);
        authStep.checkLogoMainPage();
        authStep.logOut();

    }

    @Story("Авторизация в мобильном приложении незарегистрированного пользователя")
    @Test
    public void authorizationNotRegisteredUser() {
        authStep.login(notRegisteredLogin, validPassword);
        authStep.checkInformationMessageNotRegisteredUser("Something went wrong. Try again later.", decorView);

    }


}
