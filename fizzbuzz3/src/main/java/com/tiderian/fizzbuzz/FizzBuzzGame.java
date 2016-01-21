package com.tiderian.fizzbuzz;

/**
 * Created by tiderian on 20/01/2016.
 */
public class FizzBuzzGame {

    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int FIVE = 5;

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String LUCKY = "lucky";

    private static final String SPACE = " ";

    private final int startNumber;
    private final int endNumber;

    private FizzBuzzReport fizzBuzzReport;

    /**
     * Constructor
     *
     * @param startNumber - start of count
     * @param endNumber - end of count (inclusive)
     */
    public FizzBuzzGame(final int startNumber, final int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        fizzBuzzReport = new FizzBuzzReport();
    }

    /**
     * play - launches the game based on the number range it was created with
     */
    public void play() {

        System.out.println("Lets Play FizzBuzz");

        String outputValue;
        for (int i=startNumber; i<= endNumber; i++) {

            outputValue = getOutputValue(i);

            fizzBuzzReport.incrementValue(outputValue);
            System.out.print(outputValue + SPACE);
        }

        System.out.println();
        fizzBuzzReport.print();
    }

    /**
     * getOutputValue - determines what value should be printed to the console based on the passed in number
     *
     * @param number
     * @return String
     */
    protected String getOutputValue(int number) {

        // version 2 check if the number contains a 3
        if (String.valueOf(number).contains(String.valueOf(THREE))) {
            return LUCKY;
        }

        if (isMultipleOfFifteen(number)) {
            return FIZZ + BUZZ;
        }

        if (isMultipleOfThree(number)) {
            return FIZZ;
        }

        if (isMultipleOfFive(number)) {
            return BUZZ;
        }

        return String.valueOf(number);
    }

    /**
     * isMultipleOfThree - determines whether the passed in number is a multiple of 3
     *
     * @param number
     * @return boolean
     */
    protected boolean isMultipleOfThree(int number) {
        return number % THREE == ZERO;
    }

    /**
     * isMultipleOfFive - determines whether the passed n number is a multiple of 5
     *
     * @param number
     * @return boolean
     */
    protected boolean isMultipleOfFive(int number) {
        return number % FIVE == ZERO;
    }

    /**
     * isMultipleOfFifteen - determines whether the passed in number is a multiple of 15
     *  if the number is a multiple of 3 and 5 then it has to be a multiple of 15
     *
     * @param number
     * @return boolean
     */
    protected boolean isMultipleOfFifteen(int number) {
        return isMultipleOfThree(number) && isMultipleOfFive(number);
    }
}
