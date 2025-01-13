package Mod_4;

import java.util.ArrayList;

public class ShapeArray {

	public static void main(String[] args) {
		
		//These are the shapes that are created and will be added to the list. 
		Sphere sphere = new Sphere(5);
		Cylinder cylinder = new Cylinder(6,10);
		Cone cone = new Cone(10,10);
		
		//This is the array list that is created to hold all the created shapes above
		ArrayList<Shape> shapeList = new ArrayList<Shape>();
		
		//All shapes are added to the array list
		shapeList.add(sphere);
		shapeList.add(cylinder);
		shapeList.add(cone);
		
		//This is the advance for loop that will print out the class and the toString of each shape. 
		for(Shape shape: shapeList) {
			System.out.println("Shape " + shape.getClass()+ "\n" + shape.toString());
		}
		
		

	}

}
