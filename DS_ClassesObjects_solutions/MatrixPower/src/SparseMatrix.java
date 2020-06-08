/*
 * File: SparseMatrix.java
 * -----------------------
 * This class implements a simple sparse matrix abstraction.
 */

import acm.util.*;
import java.util.*;


/**
 * This class implements a two-dimensional matrix of doubles in which
 * only the nonzero elements are stored.
 */
public class SparseMatrix {

/**
 * Creates a new sparse matrix with the specified number of rows and columns.
 *
 * @param rows The number of rows
 * @param cols The number of columns
 */
 	public SparseMatrix(int rows, int cols) {
 		nRows = rows;
 		nColumns = cols;
 		elements = new HashMap<RowColumnPair,Double>();
 	}

/**
 * Returns the number of rows.
 *
 * @return The number of rows
 */
	public int getRowCount() {
		return nRows;
	}

/**
 * Returns the number of columns.
 *
 * @return The number of columns
 */
	public int getColumnCount() {
		return nColumns;
	}

/**
 * Gets the element at m[i, j].
 *
 * @param i The row number
 * @param j The column number
 * @return The element at m[i, j]
 */
	public double get(int i, int j) {
		checkDimensions(i, j);
		Double element = elements.get(new RowColumnPair(i, j));
		return (element == null) ? 0.0 : element;
	}

/**
 * Sets the element at m[i, j] to value.
 *
 * @param i The row number
 * @param j The column number
 * @param value The new value for that element
 */
	public void set(int i, int j, double value) {
		checkDimensions(i, j);
		elements.put(new RowColumnPair(i, j), value);
	}

/*
 * Checks to make sure that the coordinate values
 * corresponding to m[i, j] are in range.  This method
 * throws an ErrorException if these values are illegal.
 */
	private void checkDimensions(int i, int j) {
		if (i < 0 || i >= nRows || j < 0 || j >= nColumns) {
			throw new ErrorException("Matrix indices out of bounds");
		}
	}

/* Private instance variables */
	private int nRows;
	private int nColumns;
	private HashMap<RowColumnPair,Double> elements;

}

/* Package-private class: RowColumnPair */
/*
 * This class implements a pair of integer coordinates.
 */
