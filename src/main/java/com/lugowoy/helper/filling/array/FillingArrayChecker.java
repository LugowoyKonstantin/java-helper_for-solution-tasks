package com.lugowoy.helper.filling.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 09-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 *
 * The interface provides a static functional for various checks
 * that are used to implement the filling of data objects or data structures (arrays).
 */

public interface FillingArrayChecker {

    /**
     * The method that check that an object of the {@link Array} class is not equal to null.
     *
     * @param array The object of class Array for checking.
     * @return Result of checking.
     */
    static <T> boolean checkNonNullArrayObject(Array<T> array) {
        return array != null;
    }

    /**
     * The method that check that an array of objects of the {@link Number} class is not equal to null.
     *
     * @param numbers The array for checking.
     * @return Result of checking.
     */
    static boolean checkNonNullArrayNumbers(Number[] numbers) {
        return numbers != null;
    }

    /**
     * The method that check that an array of objects of the {@link Point} class is not equal to null.
     *
     * @param points The array for checking.
     * @return Result of checking.
     */
    static <T extends Number> boolean checkNonNullArrayPoints(Point<T>[] points) {
        return points != null;
    }

    /**
     * The method that checks that the value of "lengthArray" is greater than "0" and less than "32767".
     *
     * @param lengthArray The value for checking.
     * @return Result of checking.
     */
    static boolean checkLengthArray(int lengthArray) {
        return ((lengthArray > 0) && (lengthArray <= Short.MAX_VALUE));
    }


    /**
     * The method checks that the value "boundValue" is a positive number and less than "32767".
     *
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean checkBoundValueIsPositive(Number boundValue) {
        return (boundValue != null) && ((boundValue.doubleValue() > 0) && (boundValue.doubleValue() <= Short.MAX_VALUE));
    }

    /**
     * The method checks that the value "boundValue" is a negative number and greatest than "-32768".
     *
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean checkBoundValueIsNegative(Number boundValue) {
        return (boundValue != null) && ((boundValue.doubleValue() < 0) && (boundValue.doubleValue() >= Short.MIN_VALUE));
    }

    /**
     * The method checks that the value "boundValue" is in the range of values from "-32768" to "32767".
     *
     * @param boundValue The value for checking.
     * @return Result of checking.
     */
    static boolean checkBoundValueIsInCorrectRange(Number boundValue) {
        return (boundValue != null) && (boundValue.doubleValue() >= Short.MIN_VALUE && boundValue.doubleValue() <= Short.MAX_VALUE);
    }

    /**
     * The method checks the value "startBound" is not greater than "endBound".
     *
     * @param startBound The value for checking.
     * @param endBound The value for checking.
     * @return Result of checking.
     * */
    static boolean checkStartBoundValueLessThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.doubleValue() < endBound.doubleValue();
    }

    /**
     * The method checks the value "startBound" is greater than "endBound".
     *
     * @param startBound The value for checking.
     * @param endBound The value for checking.
     * @return Result of checking.
     * */
    static boolean checkStartBoundValueGreatestThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.doubleValue() > endBound.doubleValue();
    }

}