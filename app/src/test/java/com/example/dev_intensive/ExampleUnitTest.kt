package com.example.dev_intensive

import com.example.dev_intensive.models.User
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
       val user = User("1", firstName = "John", lastName = "Silverhead")
    }

    @Test
    fun test_factory() {
        val user1 = User.makeUeser("John Ratt")
        val user2 = User.makeUeser("John Catt")
        val user3 = User.makeUeser(" ")
    }
}
