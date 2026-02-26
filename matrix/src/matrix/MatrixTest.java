package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTest {
	Matrix matrix;
	double[] elements;
	@BeforeEach
	void constructor() {
		int rows = 3;
		int columns = 2;
		elements = new double[] {0.1,0.2,0.5,1.6,6.7,69};
		matrix = new Matrix(rows,columns,elements);
		
	}
	
	@Test
	void test() {
		assertEquals(matrix.getRows(),3);
		assertEquals(matrix.getColumns(),2);
		
		assertArrayEquals(matrix.getMayorRow(),new double[] {0.1,0.2,0.5,1.6,6.7,69});
		assertArrayEquals(new double[] {0.1,0.5,6.7,0.2,1.6,69},matrix.getMayorColumn());
		assertArrayEquals(new double[][] {{0.1,0.2},{0.5,1.6},{6.7,69}},matrix.getArrayOfRows());
		assertEquals(matrix.getElement(3,1),6.7);
		
		Matrix scaledMatrix = matrix.scaled(2);
		assertArrayEquals(new double[] {0.2,1.0,13.4,0.4,3.2,138},scaledMatrix.getMayorColumn());
		
		
	}
	
	@Test
	void sumTest() {
		Matrix scaledMatrix = matrix.scaled(2);
		
		Matrix sumMatrix = matrix.add(scaledMatrix);
		assertArrayEquals(new double[] {0.3,1.5,21.1,0.6,4.8,204},sumMatrix.getMayorColumn());
		// hier even vragen, wat te doen bij afrondingsfouten?
	}
	
	@Test
	void representationTest() {
		elements[0] = 2;
		assertArrayEquals(matrix.getMayorRow(),new double[] {0.1,0.2,0.5,1.6,6.7,69});
		
	}
}
