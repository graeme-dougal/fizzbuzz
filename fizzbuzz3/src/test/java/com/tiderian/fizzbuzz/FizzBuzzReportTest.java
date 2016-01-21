package com.tiderian.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by tiderian on 20/01/2016.
 */
public class FizzBuzzReportTest {

    private FizzBuzzReport fizzBuzzReport;

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Before
    public void setup() {
        fizzBuzzReport = new FizzBuzzReport();
    }

    /**
     * testInitialSetup
     */
    @Test
    public void testInitialSetup() {

        assertNotNull(fizzBuzzReport);

        // ensure report map has been initialised correctly
        assertEquals("Should be 0", new Integer(0), fizzBuzzReport.getCount(FizzBuzzReport.FIZZ));
        assertEquals("Should be 0", new Integer(0), fizzBuzzReport.getCount(FizzBuzzReport.BUZZ));
        assertEquals("Should be 0", new Integer(0), fizzBuzzReport.getCount(FizzBuzzReport.FIZZBUZZ));
        assertEquals("Should be 0", new Integer(0), fizzBuzzReport.getCount(FizzBuzzReport.LUCKY));
        assertEquals("Should be 0", new Integer(0), fizzBuzzReport.getCount(FizzBuzzReport.INTEGER));
    }

    @Test
    public void testIncrementValue() {

        // create a Mock Spy object so that the increment method calls can be verified
        FizzBuzzReport mockFizzBuzzReport = Mockito.spy(new FizzBuzzReport());
        assertEquals("Should be a SPY", true, new MockUtil().isSpy(mockFizzBuzzReport));
        assertNotNull(mockFizzBuzzReport);

        for (int i = 1; i <= 10; i++) {
            mockFizzBuzzReport.incrementValue(FizzBuzzReport.FIZZ);
            mockFizzBuzzReport.incrementValue(FizzBuzzReport.BUZZ);
            mockFizzBuzzReport.incrementValue(FizzBuzzReport.FIZZBUZZ);
            mockFizzBuzzReport.incrementValue(FizzBuzzReport.LUCKY);
            mockFizzBuzzReport.incrementValue(FizzBuzzReport.INTEGER);
        }

        verify(mockFizzBuzzReport, times(10)).incrementValue(FizzBuzzReport.FIZZ);
        verify(mockFizzBuzzReport, times(10)).incrementValue(FizzBuzzReport.BUZZ);
        verify(mockFizzBuzzReport, times(10)).incrementValue(FizzBuzzReport.FIZZBUZZ);
        verify(mockFizzBuzzReport, times(10)).incrementValue(FizzBuzzReport.LUCKY);
        verify(mockFizzBuzzReport, times(10)).incrementValue(FizzBuzzReport.INTEGER);
    }

    @Test
    public void testGetCount() {

        // populate report with data
        for (int i = 1; i <= 10; i++) {
            fizzBuzzReport.incrementValue(FizzBuzzReport.FIZZ);
            fizzBuzzReport.incrementValue(FizzBuzzReport.BUZZ);
            fizzBuzzReport.incrementValue(FizzBuzzReport.FIZZBUZZ);
            fizzBuzzReport.incrementValue(FizzBuzzReport.LUCKY);
            fizzBuzzReport.incrementValue(FizzBuzzReport.INTEGER);
        }

        // assert the counts for the various metrics
        assertEquals("Should be 10", new Integer(10), fizzBuzzReport.getCount(FizzBuzzReport.FIZZ));
        assertEquals("Should be 10", new Integer(10), fizzBuzzReport.getCount(FizzBuzzReport.BUZZ));
        assertEquals("Should be 10", new Integer(10), fizzBuzzReport.getCount(FizzBuzzReport.FIZZBUZZ));
        assertEquals("Should be 10", new Integer(10), fizzBuzzReport.getCount(FizzBuzzReport.LUCKY));
        assertEquals("Should be 10", new Integer(10), fizzBuzzReport.getCount(FizzBuzzReport.INTEGER));
    }

    /**
     * testPrintReport
     */
    @Test
    public void testPrintReport() {

        // populate the report with data
        assertNotNull(fizzBuzzReport);
        for (int i = 1; i <= 10; i++) {
            fizzBuzzReport.incrementValue(FizzBuzzReport.FIZZ);
            fizzBuzzReport.incrementValue(FizzBuzzReport.BUZZ);
            fizzBuzzReport.incrementValue(FizzBuzzReport.FIZZBUZZ);
            fizzBuzzReport.incrementValue(FizzBuzzReport.LUCKY);
            fizzBuzzReport.incrementValue(FizzBuzzReport.INTEGER);
        }

        /**
         * Override System.out to capture the output from FizzBuzzReport.print()
         * Then assert what would have been printed out.
         */
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        fizzBuzzReport.print();

        List<String> lines = Arrays.asList(baos.toString().split(LINE_SEPARATOR));
        assertNotNull(lines);
        assertEquals("Should be 5 lines", 5, lines.size());

        assertEquals("Should be 10 for fizz", FizzBuzzReport.FIZZ + ": 10", lines.get(0));
        assertEquals("Should be 10 for buzz", FizzBuzzReport.BUZZ + ": 10", lines.get(1));
        assertEquals("Should be 10 for fizzbuzz", FizzBuzzReport.FIZZBUZZ + ": 10", lines.get(2));
        assertEquals("Should be 10 for lucky", FizzBuzzReport.LUCKY + ": 10", lines.get(3));
        assertEquals("Should be 10 for integer", FizzBuzzReport.INTEGER + ": 10", lines.get(4));
    }
}
