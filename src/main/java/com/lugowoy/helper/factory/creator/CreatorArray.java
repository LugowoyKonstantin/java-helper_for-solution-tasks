package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * Abstract class declaring a contract for the implementation of the functional that creates objects of type {@link Array}.
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 *
 * @param <T> The type of objects that the class object {@link Array} stores.
 */

public abstract class CreatorArray<T> extends Creator<Array<T>> implements CreatingArray<T>{

    /**
     * <p>
     * A constructor called to create a class object {@link Array} using its constructor without parameters {@link Array}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     */
    public CreatorArray() {
        this.create();
    }

    /**
     * <p>
     * A constructor with a parameter, the use of which creates a class object {@link Array} invoking its constructor {@link Array#Array(T[])}
     *  into which an array of objects is transferred which will be encapsulated in the created object.
     * </p>
     * @since 1.0
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     */
    public CreatorArray(final T[] tArray) {
        this.create(tArray);
    }

    /**
     * <p>
     * A constructor with a parameter, the use of which creates a class object {@link Array} invoking its constructor {@link Array#Array(int)}
     *  into which the length of an array of objects is transferred which will be encapsulated in the created object.
     * </p>
     * @since 1.0
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     *
     */
    public CreatorArray(final int lengthArray) {
        this.create(lengthArray);
    }

    /**
     * <p>
     * The method creates an object of the {@link Array} type that calls the default constructor {@link Array#Array()}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     * @see com.lugowoy.helper.factory.creator.Creating
     *
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @return The created object of type {@link Array}.
     */
    @Override
    public abstract Array<T> create();

    /**
     * <p>
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(T[])}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     *
     * @return The created object of type {@link Array}.
     */
    public abstract Array<T> create(final T[] tArray);

    /**
     * <p>
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(int)}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     *
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     */
    public abstract Array<T> create(final int lengthArray);

}