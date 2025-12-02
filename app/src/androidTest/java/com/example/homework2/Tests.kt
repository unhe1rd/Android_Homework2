package com.example.homework2

import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.homework2.ui.layout.Paddings
import com.example.homework2.ui.layout.Size
import com.example.homework2.viewModel.CatViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class Tests {

    @Test
    fun test_catsMessagesIds() {
        val catMessageIds = listOf(
            R.string.catMessage_1,
            R.string.catMessage_2,
            R.string.catMessage_3,
            R.string.catMessage_4,
            R.string.catMessage_5,
            R.string.catMessage_6,
            R.string.catMessage_7,
            R.string.catMessage_8,
            R.string.catMessage_9,
            R.string.catMessage_10,
        )

        val sut = CatViewModel()

        assertEquals(catMessageIds, sut.catMessageIds)
    }

    @Test
    fun test_smallPadding() {
        val sut = Paddings
        assertEquals(8.dp, sut.small)
    }

    @Test
    fun test_mediumPadding() {
        val sut = Paddings
        assertEquals(16.dp, sut.medium)
    }

    @Test
    fun test_loaderSize() {
        val sut = Size
        assertEquals(80.dp, sut.loaderSize)
    }
}