package com.lugowoy.helper.models.matrices;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.utils.Capacity;

import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 22.10.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 2.0
 */
//TODO review documentation
public class AbstractMatrix implements Model {

    /**
     * Default rows of the matrix.
     */
    public static final int DEFAULT_ROWS = 10;
    /**
     * Default columns of the matrix.
     */
    public static final int DEFAULT_COLUMNS = 10;

    private int rows;
    private int columns;

    public AbstractMatrix() {
        this.rows = DEFAULT_ROWS;
        this.columns = DEFAULT_COLUMNS;
    }

    public AbstractMatrix(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        this.rows = rows;
        this.columns = columns;
    }

    public AbstractMatrix(final AbstractMatrix matrix) {
        Objects.requireNonNull(matrix, "Matrix is null.");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractMatrix)) {
            return false;
        }
        final AbstractMatrix that = (AbstractMatrix) o;
        return this.rows == that.rows && this.columns == that.columns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rows, this.columns);
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(final int rows) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(final int columns) {
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        this.columns = columns;
    }

}
