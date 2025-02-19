package com.rushikesh.testingpractice


import com.rushikesh.testingpractice.util.EmailValidator
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class EmailValidatorTest(val expected: Boolean, val input: String) {
    @Test
    fun emailValidator_emptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_validEmail_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("rushikesh@gmail.com"))
    }

    @Test
    fun emailValidator_correctEmailSubdomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("rushikesh@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("rushikesh@email"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUserName_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("rushikesh@email..com"))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    // Part Of Parameterized Test Cases
    @Test
    fun emailValidator_isValid() {
        val result = EmailValidator.isValidEmail(input)
        assertEquals(expected, result)
    }

    // Part Of Parameterized Test Cases
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Expected {0}, Input {1}")
        fun data() =
            listOf<Array<Any>>(arrayOf(false, "gmail.com"), arrayOf(true, "rushikesh@gmail.com"))
    }
}