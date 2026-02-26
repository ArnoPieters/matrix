package matrix;

import java.util.stream.IntStream;

/**
 * elke instantie stelt een matrix voor
 * 
 */
public class Matrix {
	/**
	 * @invar | mayorRowOrder != null //wnr invar en wnr pre
	 * @representationObject
	 */
	private double[] mayorRowOrder;
	/**
	 * @invar | rows >= 0
	 * @representationObject
	 */
	private int rows;
	/**
	 * @invar | columns >= 0
	 * @representationObject
	 */
	private int columns;
	/**
	 * 
	 * @post | result >= 0
	 */
	public int getRows() {
		return rows;
	}
	/**
	 * @post | result >= 0
	 * 
	 */
	public int getColumns() {
		return columns;
	}
	
	/**
	 * @pre | 0<= row && row <= getRows()
	 * @pre | 0<= column && column <= getColumns()
	 * @post | getArrayOfRows()[row-1][column-1] == result
	 * 
	 */
	public double getElement(int row, int column) {
		
		
		return getArrayOfRows()[row-1][column-1];
	}
	
	/**
	 * geeft mayorRowOrder terug
	 */
	public double[] getMayorRow() {
		return mayorRowOrder;
	}
	
	public double[] getMayorColumn() {
		int rows = getRows();
		int col = getColumns();
		double[] mayorColumn = new double[mayorRowOrder.length];
		int index = 0;
		for(int j=0;j<col;j++) {
			for(int i=0;i<rows;i++) {
				mayorColumn[index] = mayorRowOrder[i*col+j];
				index++;
			}
		}
			
		return mayorColumn;
	}
	
	public double[][] getArrayOfRows(){
		int rows = getRows();
		int cols = getColumns();
		double[][] arrayOfRows = new double[rows][cols];
		for(int j=0;j<cols;j++) {
			for(int i=0;i<rows;i++) {
				arrayOfRows[i][j] = getMayorRow()[i*cols+j];
				
			}
		}
		return arrayOfRows;
	}
	
	/**
	 * @inspects |this
	 * @post | IntStream.range(0,getMayorRow().length).allMatch(i -> result.getMayorRow()[i] == getMayorRow()[i]*scaler)
	 */
	public Matrix scaled(int scaler) {
		double[] newElements = new double[getMayorRow().length];
		for(int i=0;i<getMayorRow().length;i++) {
			newElements[i] = getMayorRow()[i]*scaler;
		}
		return new Matrix(getRows(),getColumns(),newElements);
	}
	
	/**
	 * @inspects |this
	 * @pre | matrix2.getMayorRow().length == getMayorRow().length
	 * @post | IntStream.range(0,getMayorRow().length).allMatch(i -> 
	 * | result.getMayorRow()[i] == getMayorRow()[i]+matrix2.getMayorRow()[i])
	 */
	public Matrix add(Matrix matrix2) {
		double[] newElements = new double[getMayorRow().length];
		for(int i=0;i<getMayorRow().length;i++) {
			newElements[i] = getMayorRow()[i] + matrix2.getMayorRow()[i];
		}
		return new Matrix(getRows(),getColumns(),newElements);
	}
	/**
	 * @pre | elements != null
	 * @pre | 0 <= rows && rows <= elements.length
	 * @pre | 0 <= columns && columns <= elements.length
	 * @post | getRows() == rows
	 * @post| getColumns() == columns
	 * @post  getMayorRow() == elements
	 */
	public Matrix(int rows, int columns, double[] elements) {
		this.mayorRowOrder = elements.clone(); //vragen of dit mag
		this.rows = rows;
		this.columns = columns;
	}
	
}
