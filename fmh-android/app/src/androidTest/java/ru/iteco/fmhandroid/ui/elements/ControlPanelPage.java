package ru.iteco.fmhandroid.ui.elements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.steps.TimeoutEspresso.onViewWithTimeout;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.TimeoutEspresso;

public class ControlPanelPage {


    public static ViewInteraction ButtonCreateNews = onView(withId(R.id.add_news_image_view));


    public static ViewInteraction switchAction = onView(withId(R.id.switcher));

    public static Matcher<View> ButtonChoseCategory() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> categoryAnnouncement() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> ButtonPublishDate() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public static Matcher<View> ButtonAgreement() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> ButtonChooseTime() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public static Matcher<View> ButtonDescription() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public static Matcher<View> ButtonSave() {
        return allOf(withId(R.id.save_button));
    }

    public static Matcher<View> titleCreate() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }


    public static TimeoutEspresso.TimedViewInteraction newsRecyclerList = onViewWithTimeout(10000, withId(R.id.news_list_recycler_view));
    public static ViewInteraction ButtonAppearNews = onView(withId(R.id.view_news_item_image_view));

    public static ViewInteraction pageControlPanel = onView(withId(R.id.news_list_recycler_view));
}
