package ru.iteco.fmhandroid.ui.elements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    public static ViewInteraction versionAboutPage = onView(withId(R.id.about_version_title_text_view));//к нему заякорил страницу
    public static ViewInteraction linkPrivacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction linkTermsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
    public static ViewInteraction policyInformation = onView(withText("Политика конфидециальности"));
    ;
    public static ViewInteraction termsInformation = onView(withText("Пользовательское соглашение"));

}
