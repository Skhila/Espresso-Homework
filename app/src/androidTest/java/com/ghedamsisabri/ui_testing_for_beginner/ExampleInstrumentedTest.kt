package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIsViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun firstTestCase() {
        mainPage.assertIsViewDisplayed()
        nextButton.tap()

        secondPage.assertIsViewDisplayed()
        secondPageActivityText.assertIsViewDisplayed()

        Assert.assertTrue(isTextOnScreen(secondPageExpectedText))

        var secondPageText = secondPageActivityText.getText()
        Assert.assertEquals(secondPageText, secondPageExpectedText)

        backButton.assertIsViewDisplayed()
    }

    @Test
    fun secondTestCase(){
        mainPage.assertIsViewDisplayed()

        nextButton.tap()
        backButton.tap()

        mainPageActivityText.assertIsViewDisplayed()

        Assert.assertTrue(isTextOnScreen(mainPageExpectedText))

        var mainPageText = mainPageActivityText.getText()
        Assert.assertEquals(mainPageText, mainPageExpectedText)

        nextButton.assertIsViewDisplayed()
    }

    companion object{
        const val mainPageExpectedText = "MainActivity"
        const val secondPageExpectedText = "SecondaryActivity"

        val mainPage: Matcher<View> by lazy { withId(R.id.main) }
        val secondPage: Matcher<View> by lazy { withId(R.id.secondary)}

        val nextButton: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val backButton: Matcher<View> by lazy { withId(R.id.button_back) }

        val mainPageActivityText: Matcher<View> by lazy { withId(R.id.activity_main_title) }
        val secondPageActivityText: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
    }
}