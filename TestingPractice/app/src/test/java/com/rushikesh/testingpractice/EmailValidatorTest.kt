package com.rushikesh.testingpractice

import com.rushikesh.testingpractice.util.EmailValidator
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Assert
import org.junit.Test

class EmailValidatorTest {
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
}