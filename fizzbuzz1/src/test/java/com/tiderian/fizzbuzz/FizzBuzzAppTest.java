package com.tiderian.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by tiderian on 20/01/2016.
 */
public class FizzBuzzAppTest {

    @Test(expected = InstantiationException.class)
    public void testInstantiation() throws InstantiationException {

        try {
            new FizzBuzzApp();
            fail();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
            throw ie;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFizzBuzzApp_noArguments() {

        try {
            FizzBuzzApp.main(new String[]{});
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFizzBuzzApp_NotEnoughArguments() {
        try {
            FizzBuzzApp.main(new String[]{"1"});
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFizzBuzzApp_TooManyArguments() {
        try {
            FizzBuzzApp.main(new String[]{"1","20","30"});
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFizzBuzzApp_ArgOneNotANumber() {
        try {
            FizzBuzzApp.main(new String[]{"ABC","20"});
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFizzBuzzApp_ArgTwoNotANumber() {
        try {
            FizzBuzzApp.main(new String[]{"1","DEF"});
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    @Test
    public void testFizxBuzzApp_validArguments() {
        FizzBuzzApp.main(new String[]{"1","20"});
    }
}
