/*
 * File: MatrixPower.java
 * ---------------------------
 * This program uses a given SparseMatrix class to 
 * construct a two dimensional array in which all 
 * the elements of this array are zero except than 
 * the elements on the diagonal and anti-diagonal 
 * of the matrix. The value of the matrix elements 
 * are equal to their diagonal rank. The program 
 * prints out the constructed matrix along with 
 * the result of multiplication of the matrix by itself.  
 */

import acm.program.*;

public class MatrixPower extends ConsoleProgram {

	public void run() {
		SparseMatrix diagonal = createDiagonalMatrix(SIZE);
		printMatrix(diagonal);
		multiplymatrix(diagonal);
	}

/* Creates a matrix of the specified size, with 
 * diagonal and anti-diagonal elements equal to 
 * their diagonal rank. */
	private SparseMatrix createDiagonalMatrix(int size) {
		SparseMatrix matrix = new SparseMatrix(size, size);
		for (int i = 0; i < SIZE; i++) {
			matrix.set(i, i, i);
		}
		for (int i = 0; i < SIZE; i++) {
			matrix.set(i, SIZE-i-1, i);
		}
		return matrix;
	}

/* Prints out a matrix */
	private void printMatrix(SparseMatrix matrix) {
		for (int i = 0; i < matrix.getRowCount(); i++) {
			for (int j = 0; j < matrix.getColumnCount(); j++) {
				print(matrix.get(i, j) + "  ");
			}
			println();
		}
	}
	/*multiplies a matrix by itself*/
	private void multiplymatrix(SparseMatrix matrix){
		println();
		println("The result of multiplication is : ");
		println();
		
		for (int i = 0; i < matrix.getRowCount(); i++) {
			for (int j = 0; j < matrix.getColumnCount(); j++) {
				double result = 0;
				for (int k = 0; k < matrix.getColumnCount(); k++) {
					result += matrix.get(i, k) * matrix.get(k, j);
				}
				print(result + "  ");
			}
			println();
		}
	}

/* Private constants */
	private static final int SIZE = 10;

}
