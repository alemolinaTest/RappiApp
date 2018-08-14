package com.test.molina.rappiapp

import com.test.molina.rappiapp.data.remote.AppApiHelper
import com.test.molina.rappiapp.utils.CommonUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Test
    fun capital_ShouldIncorrect() {
        assertEquals(true, CommonUtils.checkCapital("m"))
    }

    @Test
    fun capital_ShouldCorrect() {
        assertEquals(true, CommonUtils.checkCapital("M"))
    }

    @Test
    fun capital_TryNull() {
        assertEquals(false, CommonUtils.checkCapital(null))
    }

    @Test
    fun valid_Email() {
        assertEquals(true, CommonUtils.isEmailValid("ale@gmail.com"))
        assertEquals(false, CommonUtils.isEmailValid("ale@gmail"))
        assertEquals(true, CommonUtils.isEmailValid("ale@gmail"))
    }
   

}
