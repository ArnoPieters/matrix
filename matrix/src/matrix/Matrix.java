package matrix;
/**
 * elke instantie stelt een matrix voor
 * 
 */
public class Matrix {
	/**
	 * @invar | mayorRowOrder != null
	 * @representationObject
	 */
	private double[] mayorRowOrder;
	/**
	 * @pre | rows >= 0
	 */
	private int rows;
	/**
	 * @pre | columns >= 0
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
	 * @post | getArrayOfRows()[row][column] == result
	 * 
	 */
	public double getElement(int row, int column) {
		int index_row = (row-1)*getColumns();
		
		return mayorRowOrder[index_row+column];
	}
	

	public double[] getMayorRow() {
		return mayorRowOrder;
	}
	
	public double[] getMayorColumn() {
		double [] mayorColumn = new double[getMayorRow().length];
		for(int i=0;i<getRows();i++) {
			double[] newColumn = new double[getRows()];
			for(int j=0;j<getMayorRow().length;j+=2) {
				return null;
			}
			
		}
		return null;
	}
	
	public double[][] getArrayOfRows(){
		return null;
	}
	/**
	 * 
	 * @pre | 0 <= rows && rows <= elements.length
	 * @pre | 0 <= columns && columns <= elements.length
	 * @post | getRows() == rows
	 * @post| getColumns() == columns
	 * @post | getMayorRow() == elements
	 */
	public Matrix(int rows, int columns, double[] elements) {
		this.mayorRowOrder = elements.clone();
		this.rows = rows;
		this.columns = columns;
	}
}
