package com.lugowoy.helper.models.points;

import java.util.Objects;

/**
 * The class implements the 3D point model.
 * <p>Created by Konstantin Lugowoy on 27.12.2018.
 *
 * @param <T> The type of coordinates that initialize the coordinates of a 3D
 * point.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.points.Point
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.6
 */
//TODO review documentation
public class Point3D<T extends Number> extends Point2D<T> {

    private T z;

    /**
     * Constructs a new 3D point object.
     *
     * @param x Value to initialize X coordinate.
     * @param y Value to initialize Y coordinate.
     * @param z Value to initialize Z coordinate.
     */
    public Point3D(final T x, final T y, final T z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point3D)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Point3D<?> point3D = (Point3D<?>) o;
        return Objects.equals(getZ(), point3D.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getZ());
    }

    @Override
    public String toString() {
        return "Point3D[ " + "x=" + super.getX() + " y=" + super.getY() + " z="
               + this.z + " ]";
    }

    /**
     * Get the Z coordinate value.
     *
     * @return Z coordinate value.
     */
    public T getZ() {
        return this.z;
    }

    /**
     * Set the Z coordinate value.
     *
     * @param z Value to set the Y coordinate.
     */
    public void setZ(final T z) {
        this.z = z;
    }

}
