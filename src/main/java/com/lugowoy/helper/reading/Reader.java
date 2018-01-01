package com.lugowoy.helper.reading;

/**
 * Created by Konstantin Lugowoy on 26.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 28.12.2017
 * <p>
 *     A class is a container that encapsulates a specific implementation of a functional to read different data.
 * </p>
 * @see com.lugowoy.helper.reading.Reading
 */

public class Reader implements Reading {

    private Reading reading;

    /**
     * <p>
     *     A constructor that initializes the created object with a specific implementation of the functional to read different data.
     * </p>
     * @param reading Specific implementation of the functional to read different data.
     *                 The parameter must implement the interface Reading.
     */
    public Reader(Reading reading) {
        this.reading = reading;
    }

    /**
     * <p>
     *     Read data by byte type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public byte readByte() {
        return this.reading.readByte();
    }

    /**
     * <p>
     *     Read data by short type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public short readShort() {
        return this.reading.readShort();
    }

    /**
     * <p>
     *     Read data by int type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public int readInt() {
        return this.reading.readInt();
    }

    /**
     * <p>
     *     Read data by long type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public long readLong() {
        return this.reading.readLong();
    }

    /**
     * <p>
     *     Read data by char type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public char readChar() {
        return this.reading.readChar();
    }

    /**
     * <p>
     *     Read data by float type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public float readFloat() {
        return this.reading.readFloat();
    }

    /**
     * <p>
     *     Read data by double type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public double readDouble() {
        return this.reading.readDouble();
    }

    /**
     * <p>
     *     Read data by String type by delegating execution to an encapsulated object.
     * </p>
     * @return Returns the result of reading.
     */
    @Override
    public String readString() {
        return this.reading.readString();
    }

}
