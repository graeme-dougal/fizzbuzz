package com.tiderian.fizzbuzz;

import org.apache.commons.lang.StringUtils;

/**
 * Created by tiderian on 20/01/2016.
 */
public class FizzBuzzApp {

    /**
     * Constructor - Can't be instantiated.
     * @throws InstantiationException
     */
    public FizzBuzzApp() throws InstantiationException {
        throw new InstantiationException("Instantiation of this class not allowed - Utility Class");
    }

    /**
     * main method to launch the FizzBuzz Game
     *  Validates the input arguments and launches the FizzBuzz Game
     *
     * @param args - the range of numbers passed in as 2 args
     */
    public static void main(String[] args) {

        if ((args.length != 2)) {
            throw new IllegalArgumentException("Invalid arguments - number range must be in the format : start-end, e.g. 1 20");
        }

        if (!StringUtils.isNumeric(args[0])) {
            throw new IllegalArgumentException("Argument 1 is not a number : number range must be in the format : start end, e.g. 1 20");
        }

        if (!StringUtils.isNumeric(args[1])) {
            throw new IllegalArgumentException("Argument 2 is not a number : number range must be in the format : start end, e.g. 1 20");
        }

        int startNumber = Integer.parseInt(args[0]);
        int endNumber = Integer.parseInt(args[1]);

        FizzBuzzGame fizzBuzzGame = new FizzBuzzGame(startNumber, endNumber);
        fizzBuzzGame.play();
    }
}
