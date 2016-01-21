package com.tiderian.fizzbuzz;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

/**
 * Created by tiderian on 20/01/2016.
 */
public class FizzBuzzReport {

    private HashMap<String, Integer> reportMap;

    protected static final String FIZZ = "fizz";
    protected static final String BUZZ = "buzz";
    protected static final String FIZZBUZZ = FIZZ + BUZZ;
    protected static final String LUCKY = "lucky";
    protected static final String INTEGER = "integer";

    /**
     * Constructor
     */
    public FizzBuzzReport() {
        reportMap = new HashMap<String, Integer>();

        reportMap.put(FIZZ, new Integer(0));
        reportMap.put(BUZZ, new Integer(0));
        reportMap.put(FIZZBUZZ, new Integer(0));
        reportMap.put(LUCKY, new Integer(0));
        reportMap.put(INTEGER, new Integer(0));
    }

    /**
     * incrementValue
     *
     * @param value
     */
    public void incrementValue(String value) {

        // integer value (unchanged)
        if (StringUtils.isNumeric(value)) {
            value = INTEGER;
        }

        if (reportMap.containsKey(value)) {
            int count = reportMap.get(value);
            reportMap.put(value, count +1);
        }
    }

    /**
     * getReportData
     */
    public void print() {
        System.out.println(FIZZ + ": " + getCount(FIZZ));
        System.out.println(BUZZ + ": " + getCount(BUZZ));
        System.out.println(FIZZBUZZ + ": " + getCount(FIZZBUZZ));
        System.out.println(LUCKY + ": " + getCount(LUCKY));
        System.out.println(INTEGER + ": " + getCount(INTEGER));
    }

    /**
     * getCount
     * @param value
     * @return
     */
    protected Integer getCount(String value) {
        return reportMap.get(value);
    }
}
