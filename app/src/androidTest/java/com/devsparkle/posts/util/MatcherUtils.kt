package com.devsparkle.posts.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

class MatcherUtils private constructor() {
    companion object {
        fun hasRecyclerItemCount(itemCount: Int): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

                override fun describeTo(description: Description) {
                    description.appendText("has $itemCount items")
                }

                override fun matchesSafely(view: RecyclerView): Boolean {
                    return view.adapter?.itemCount == itemCount
                }
            }
        }
    }
}