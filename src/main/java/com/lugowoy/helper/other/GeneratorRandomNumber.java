package com.lugowoy.helper.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 *
 * The interface provides a functional for generating random integers and double numbers.
 *  Functionality is provided in a static context.
 */

public interface GeneratorRandomNumber {

    Random RANDOM = new Random();

    int SCALE = 2;

    int START_INT_BOUND = -128;
    int END_INT_BOUND = 127;

    double START_DOUBLE_BOUND = -128;
    double END_DOUBLE_BOUND = 127;

    /**
     * The method generate a random integer number in the range from {@link GeneratorRandomNumber#START_INT_BOUND}
     * to {@link GeneratorRandomNumber#END_INT_BOUND}.
     *
     * @return The generated integer number.
     */
    static int generateInt() {
        return getRandomInRangeIntValue(START_INT_BOUND, END_INT_BOUND);
    }

    /**
     * The method generate a random integer number in the range from "0" to parameter "bound".
     *
     * @return The generated integer number.
     */
    static int generateInt(final int bound) {
        return RANDOM.nextInt(bound);
    }

    /**
     * The method generate a random integer number in the range from parameter "startBound" to parameter "endBound" .
     *
     * @return The generated integer number.
     */
    static int generateInt(final int startBound, final int endBound) {
        return getRandomInRangeIntValue(startBound, endBound);
    }

    /**
     * The method generate a random double number in the range from {@link GeneratorRandomNumber#START_DOUBLE_BOUND}
     *  to {@link GeneratorRandomNumber#END_DOUBLE_BOUND}.
     *
     * @return The generated double number.
     */
    static double generateDouble() {
        return new BigDecimal(getRandomInRangeDoubleValue(START_DOUBLE_BOUND, END_DOUBLE_BOUND)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random double number in the range from "0" to parameter "bound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double bound) {
        return new BigDecimal(getRandomInRangeDoubleValue(0, bound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random integer number from parameter "startBound" to parameter "endBound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double startBound, double endBound) {
        return new BigDecimal(getRandomInRangeDoubleValue(startBound, endBound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    private static int getRandomInRangeIntValue(int startBound, int endBound) {
        return startBound + (RANDOM.nextInt((endBound - startBound) + 1));
    }

    private static double getRandomInRangeDoubleValue(double startBound, double endBound) {
        return startBound + (RANDOM.nextDouble() * (endBound - startBound));
    }

}