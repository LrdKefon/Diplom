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


import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.LoginPage;
import ru.iteco.fmhandroid.ui.elements.MainPaige;

public class AuthorizationSteps {
    LoginPage loginPage = new LoginPage();
    CustomViewActions customViewActions = new CustomViewActions();
    MainPaige mainPaige = new MainPaige();


    @Step("Авторизация, на вход принимает логин и пароль")
    public void login(String login, String password) {
        loginPage.loginField.check(matches(isDisplayed()));
        loginPage.loginField.perform(click());
        loginPage.loginField.perform(replaceText(login));
        loginPage.passwordField.check(matches(isDisplayed()));
        loginPage.passwordField.perform(click());
        loginPage.passwordField.perform(replaceText(password), closeSoftKeyboard());
        loginPage.buttonSign.perform(click());

    }

    @Step("Проверка успешной авторизации")
    public void checkLogoMainPage() {
        customViewActions.elementWaiting(withId(R.id.trademark_image_view), 5000);
        mainPaige.logoEnter.check(matches(isDisplayed()));
    }

    @Step("Информационное сообщение при входе не зарегистрированного пользователя")
    public void checkInformationMessageNotRegisteredUser(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }


    @Step("Выход из УЗ")
    public void logOut() {
        mainPaige.iconLogOut.check(matches(isDisplayed()));
        mainPaige.iconLogOut.perform(click());
        onView(isRoot()).perform(customViewActions.waitForElement(withText("Log out"), 5000));
        mainPaige.iconActionLogOut.check(matches(isDisplayed()));
        mainPaige.iconActionLogOut.perform(click());
        loginPage.pageAuthorization.check(matches(isDisplayed()));

    }

    @Step("Загрузка приложение")
    public void appDownload() {

        customViewActions.elementWaiting(withId(R.id.splashscreen_image_view), 5000);
    }

    @Step("Загрузка страницы авторизации")
    public void loadAuthPage() {

        customViewActions.elementWaiting(withId(R.id.enter_button), 5000);
    }

}
