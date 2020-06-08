import acm.util.*;
import java.util.*;


class RowColumnPair {

/*
 * Creates a new RowColumnPair for the coordinates m[i, j].
 *
 * @param i The row number
 * @param j The column number
 */
	public RowColumnPair(int i, int j) {
		row = i;
		column = j;
	}

/**
 * Gets the row number from a RowColumnPair.
 * @return The row number of this pair
 */
	public int getRow() {
		return row;
	}

/**
 * Gets the column number from a RowColumnPair.
 * @return The column number of this pair
 */
	public int getColumn() {
		return column;
	}

/**
 * Returns true if this RowColumnPair is equal to the specified
 * object.
 *
 * @param obj The value to which this object is being compared
 * @return A boolean value indicating whether this pair is equal to obj
 */
	public boolean equals(Object obj) {
		if (obj instanceof RowColumnPair) {
			RowColumnPair pair = (RowColumnPair) obj;
			return this.row == pair.row && this.column == pair.column;
		} else {
			return false;
		}
	}

/**
 * Returns a hash code for this RowColumnPair.
 *
 * @return An integer hash code for this object
 */
	public int hashCode() {
		return new Integer(row).hashCode() ^ (37 * new Integer(column).hashCode());
	}

/* Private instance variables */
	private int row;
	private int column;

}
