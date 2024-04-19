package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.elements.MainPaige.logoEnter;
import static ru.iteco.fmhandroid.ui.steps.CustomViewActions.elementWaiting;
import static ru.iteco.fmhandroid.ui.steps.CustomViewActions.waitForElement;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.LoginPage;
import ru.iteco.fmhandroid.ui.elements.MainPaige;

public class AuthorizationSteps {


    @Step("Авторизация, на вход принимает логин и пароль")
    public static void login(String login, String password) {
        LoginPage.loginField.check(matches(isDisplayed()));
        LoginPage.loginField.perform(click());
        LoginPage.loginField.perform(replaceText(login));
        LoginPage.passwordField.check(matches(isDisplayed()));
        LoginPage.passwordField.perform(click());
        LoginPage.passwordField.perform(replaceText(password), closeSoftKeyboard());
        LoginPage.buttonSign.perform(click());

    }

    @Step("Проверка успешной авторизации")
    public static void checkLogoMainPage() {
        elementWaiting(withId(R.id.trademark_image_view), 5000);
        logoEnter.check(matches(isDisplayed()));
    }

    @Step("Информационное сообщение при входе не зарегистрированного пользователя")
    public static void checkInformationMessageNotRegisteredUser(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }


    @Step("Выход из УЗ")
    public static void logOut() {
        MainPaige.iconLogOut.check(matches(isDisplayed()));
        MainPaige.iconLogOut.perform(click());
        onView(isRoot()).perform(waitForElement(withText("Log out"), 5000));
        MainPaige.iconActionLogOut.check(matches(isDisplayed()));
        MainPaige.iconActionLogOut.perform(click());
        LoginPage.pageAuthorization.check(matches(isDisplayed()));

    }

    @Step("Загрузка приложение")
    public static void appDownload() {
        elementWaiting(withId(R.id.splashscreen_image_view), 5000);
    }

    @Step("Загрузка страницы авторизации")
    public static void loadAuthPage() {
        elementWaiting(withId(R.id.enter_button), 5000);
    }

}
