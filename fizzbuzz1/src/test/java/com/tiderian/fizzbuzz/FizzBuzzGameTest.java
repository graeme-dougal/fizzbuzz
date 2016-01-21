package com.tiderian.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by tiderian on 20/01/2016.
 */
public class FizzBuzzGameTest {

    private FizzBuzzGame fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzzGame(1,20);
    }

    @Test
    public void testIsMultipleOfThree() {
        assertEquals("Should be multiple of 3", true, fizzBuzz.isMultipleOfThree(3));
        assertEquals("Should not be multiple of 3", false, fizzBuzz.isMultipleOfThree(5));
        assertEquals("Should be multiple of 3", true, fizzBuzz.isMultipleOfFive(15));
    }

    @Test
    public void testIsMultipleOfFive() {
        assertEquals("Should be multiple of 5", true, fizzBuzz.isMultipleOfFive(5));
        assertEquals("Should not be multiple of 5", false, fizzBuzz.isMultipleOfFive(3));
        assertEquals("Should be multiple of 5", true, fizzBuzz.isMultipleOfFive(15));
    }

    @Test
    public void testIsMultipleOfFifteen() {
        assertEquals("Should be multiple of 15", true, fizzBuzz.isMultipleOfFifteen(15));
        assertEquals("Should not be multiple of 15", false, fizzBuzz.isMultipleOfFifteen(3));
        assertEquals("Should not be multiple of 15", false, fizzBuzz.isMultipleOfFifteen(5));
        assertEquals("Should not be multiple of 15", false, fizzBuzz.isMultipleOfFifteen(19));

    }

    @Test
    public void testGetOutputValue() {
        assertEquals("Should be the number", "1", fizzBuzz.getOutputValue(1));
        assertEquals("Should be fizz", "fizz", fizzBuzz.getOutputValue(3));
        assertEquals("Should be buzz", "buzz", fizzBuzz.getOutputValue(5));
        assertEquals("Should be fizzbuzz", "fizzbuzz", fizzBuzz.getOutputValue(15));
    }

    @Test
    public void testPlay() {

        FizzBuzzGame mockFizzBuzzGame = Mockito.spy(new FizzBuzzGame(1,20));
        when(mockFizzBuzzGame.getOutputValue(anyInt())).thenReturn("");
        mockFizzBuzzGame.play();

        verify(mockFizzBuzzGame, times(21)).getOutputValue(anyInt());
    }
}
