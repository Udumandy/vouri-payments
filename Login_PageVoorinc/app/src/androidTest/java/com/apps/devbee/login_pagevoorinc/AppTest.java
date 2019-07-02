package com.apps.devbee.login_pagevoorinc;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.apps.devbee.login_pagevoorinc.TransactionMatcher.isValidTransaction;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)

public class AppTest {

    @Rule
    public ActivityTestRule<LoginActivity> lActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginData() {
        TransactionsModel tm = new TransactionsModel(10);
        TransactionsModel tt = tm;

        TransactionsModel t1 = new TransactionsModel(10);
        TransactionsModel t2 = new TransactionsModel(5);

       /** onView(withId(R.id.loginEmail)).perform(typeText("example@email.com"),closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("password"),closeSoftKeyboard());
        onView(withId(R.id.login_button_two)).perform(click());*/

        assertThat(10, equalTo(10));
        assertThat("TransactionsModel Equal", tm, equalTo(tt));
        assertThat(t1,is(isValidTransaction()));
        assertThat(t2,is(isValidTransaction()));

}

    @Test
    public void recyclerViewTest(){

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycle), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(1,click()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView19), withText("Clicked! Dollar Amount"),
                        onChildClick(
                                onChildClick(
                                        withId(R.id.recycle),
                                1),
                        0),
                        isDisplayed()));
        textView.check(matches(withText("Clicked! Dollar Amount")));

    }
    private static Matcher<View> onChildClick(final Matcher<View> m, final int position){

        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                ViewParent parent = item.getParent();
                return parent instanceof ViewGroup && m.matches(parent)
                        && item.equals(((ViewGroup) parent).getChildAt(position));
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Transaction #"+position);
                m.describeTo(description);
            }
        };
    }

}

class TransactionMatcher extends TypeSafeMatcher<TransactionsModel> {

    @Override
    protected boolean matchesSafely(TransactionsModel item) {
        return item.transactionAmount > 0;
    }

    @Override
    public void describeTo(Description description) {

    }

    @Factory
    public static Matcher isValidTransaction(){

        return new TransactionMatcher();
    }

}
