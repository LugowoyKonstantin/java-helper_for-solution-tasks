package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.checkNonNullArrayObject;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 15-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 *
 * The class is the heir of the {@link FillingArrayPointsCoordinatesReadValues} class and implements it's contract.
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with an object of the {@link Point} class with numeric coordinates of type {@link Integer}
 * using the data read by the object of the class {@link Reader} encapsulated in this class.
 * Also implements the contract declared by the {@link FillingArrayPoints} interface.
 *
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPointsCoordinatesReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 */

public class FillingArrayPointsCoordinatesReadIntegerNumbers extends FillingArrayPointsCoordinatesReadValues<Integer>
                                                                   implements FillingArrayPoints<Integer> {

    /**
     * Constructs a new object {@link FillingArrayPointsCoordinatesReadIntegerNumbers} class,
     *  initializing an object of {@link Reader} class encapsulated in parent class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in parent class to read data to fill array.
     */
    public FillingArrayPointsCoordinatesReadIntegerNumbers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object {@link FillingArrayPointsCoordinatesReadIntegerNumbers} class,
     * initializing an object of {@link Reader} class encapsulated in parent class
     * of the concrete implementation of the contract declared in the interface {@link Reading} to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in parent class to read the data to be fill array.
     */
    public FillingArrayPointsCoordinatesReadIntegerNumbers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param array The object of class {@link Array} to be filled.
     * @throws IllegalArgumentException The argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
            array.setArray(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array of objects of the {@link Point} class with numeric coordinates of type {@link Integer} using the data read
     * by the object of the class {@link Reader} encapsulated in parent class.
     *
     * @param points The array to be filled.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with an objects of the {@link Point} class with numeric coordinates of type {@link Integer}
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @return Created and filled array of the objects of the {@link Point} class
     *         with random numeric coordinates of type {@link Double}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthArray) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(points);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param bound The value of the end of the range boundary
     *              of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           bound);
                array.setArray(points);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     * @param points The array to be filled.
     * @param bound  The value of the end of the range boundary
     *               of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer}  in the range from "0" to "bound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND}.
     *
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param bound       The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with random numeric coordinates of type {@link Integer}.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer bound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points, bound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(points,
                                                                                                                       DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return points;
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     *
     * @param array The object of the {@link Array} class to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound The value of the end of the range boundary
     *                 of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException If argument object is null;
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public void fill(Array<Point<Integer>> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Point<Integer>[] points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, array.getLength());
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound, endBound);
                array.setArray(points);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND);
                array.setArray(points);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound",
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param points     The array to be filled.
     * @param startBound The value of the start of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary
     *                   of numerical values by which the coordinates of points in the array will be initialized.
     * @throws IllegalArgumentException The argument array is null.
     */
    @Override
    public void fill(Point<Integer>[] points, Integer startBound, Integer endBound) throws IllegalArgumentException {
        if (checkNonNullArrayPoints(points)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound, endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with objects of the {@link Point} class
     * with numeric coordinates of type {@link Integer} in the range from "startBound" to "endBound" parameter,
     * using the data read by the object of the class {@link Reader} encapsulated in parent class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with an objects of the {@link Point} class
     * with numerical coordinates from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesOfArray#DEFAULT_INTEGER_NEGATIVE_BOUND}
     * and {@link DefaultValuesOfArray#DEFAULT_INTEGER_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled.
     * @param startBound  The value of the start of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary
     *                    of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array of objects of the {@link Point} class with numerical coordinates.
     */
    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public Point<Integer>[] fill(int lengthArray, Integer startBound, Integer endBound) {
        Point<Integer>[] points;
        if (checkLengthArray(lengthArray)) {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, lengthArray);
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            startBound, endBound);
            } else {
                this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND);
            }
        } else {
            points = (Point<Integer>[]) java.lang.reflect.Array.newInstance(Point.class, DEFAULT_LENGTH_ARRAY);
            this.initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(points,
                                                                                                                        DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                        DEFAULT_INTEGER_POSITIVE_BOUND);
        }
        return points;
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbers(Point<Integer>[] points) {
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point<>(super.getReader().readInt(), super.getReader().readInt());
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromZeroToPositiveBound(Point<Integer>[] points,
                                                                                                                       int bound) {
        for (int i = 0; i < points.length; i++) {
            int valueCoordinateX = checkReadValueIsInRange(super.getReader().readInt(), DEFAULT_START_BOUND, bound);
            int valueCoordinateY = checkReadValueIsInRange(super.getReader().readInt(), DEFAULT_START_BOUND, bound);
            points[i] = new Point<>(valueCoordinateX, valueCoordinateY);
        }
    }

    private void initializeArrayElementsToObjectOfPointsWithFilledCoordinatesReadIntegerNumbersFromStartBoundToEndBound(Point<Integer>[] points,
                                                                                                                        int startBound,
                                                                                                                        int endBound) {
        for (int i = 0; i < points.length; i++) {
            int valueCoordinateX = checkReadValueIsInRange(super.getReader().readInt(), startBound, endBound);
            int valueCoordinateY = checkReadValueIsInRange(super.getReader().readInt(), startBound, endBound);
            points[i] = new Point<>(valueCoordinateX, valueCoordinateY);
        }
    }

    private int checkReadValueIsInRange(final int enteredValue, final int startBound, final int endBound) {
        return (enteredValue >= startBound) && (enteredValue <= endBound) ? enteredValue : DEFAULT_INTEGER_VALUE;
    }

}