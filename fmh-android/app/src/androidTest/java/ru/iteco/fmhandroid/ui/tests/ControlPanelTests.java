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
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для Панели Управления Новостей мобильного приложения Мобильный хоспис.")
public class ControlPanelTests {
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
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    String description = "Люблю я макароны";
    String changeDescription = "Не очень то и Люблю я макароны";
    private View decorView;
    String titleNameForCreate = "Новейшая Уникальная Новость";
    String titleNameForDelete = "Удали меня полностью";
    String titleNameForEdit = "Я не такая Меняй Скорее";
    String titleNameForChangeActive = "Компас Активности";

    @Story("ТК№32. Создание новости во вкладке \"Панель управления\"")
    @Test
    public void createNews() {
        MainSteps.goToTheNews();
        NewsSteps.clickButtonEditNews();
        ControlPanelSteps.clickCreateNewsButton();
        ControlPanelSteps.fillFieldsNews(description, titleNameForCreate);
        ControlPanelSteps.clickDeleteNewsButton(titleNameForCreate);

    }

    @Story("ТК№27. Удаление новости во вкладке \"Панель управления\"")
    @Test
    public void deleteNews() {
        MainSteps.goToTheNews();
        NewsSteps.clickButtonEditNews();
        ControlPanelSteps.clickCreateNewsButton();
        ControlPanelSteps.fillFieldsNews(description, titleNameForDelete);
        ControlPanelSteps.clickDeleteNewsButton(titleNameForDelete);
    }


    @Story("ТК№28. Редактирование новости во вкладке \"Панель управления\"")
    @Test
    public void editNews() {
        MainSteps.goToTheNews();
        NewsSteps.clickButtonEditNews();
        ControlPanelSteps.clickCreateNewsButton();
        ControlPanelSteps.fillFieldsNews(description, titleNameForEdit);
        ControlPanelSteps.clickEditButton(titleNameForEdit);
        ControlPanelSteps.editCreatedNews(changeDescription);
        ControlPanelSteps.clickDeleteNewsButton(titleNameForEdit);
    }

    @Story("ТК№29. Смена статуса новости, находящаяся в статусе \"Активна\" на статус \"Не активна\", во вкладке \"Панель управления\"")
    @Test
    public void changeStatusOfNews() {
        MainSteps.goToTheNews();
        NewsSteps.clickButtonEditNews();
        ControlPanelSteps.clickCreateNewsButton();
        ControlPanelSteps.fillFieldsNews(description, titleNameForChangeActive);
        ControlPanelSteps.clickEditButton(titleNameForChangeActive);
        ControlPanelSteps.clickSwitcherActive();
        ControlPanelSteps.clickDeleteNewsButton(titleNameForChangeActive);

    }

    @Story("ТК№33. Поле \"Категория\" пустое, при создании новости, во вкладке \"Панель управления\"")
    @Test
    public void createNewsFieldCategoryEmpty() {
        MainSteps.goToTheNews();
        NewsSteps.clickButtonEditNews();
        ControlPanelSteps.clickCreateNewsButton();
        ControlPanelSteps.fillFieldsNewsCategoryEmpty(description, titleNameForCreate);
        ControlPanelSteps.checkInformationMessageEmptyCategoryField("Fill empty fields", decorView);

    }

}