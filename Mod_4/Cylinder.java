package Mod_4;

public class Cylinder extends Shape{
	
	/*
	 * Volume of the cylinder V = PI * r^2 * h
	 * Surface area 2 * PI * r* h + 2 PI r^2
	 * 
	 * Output correctly.
	 * */

	private double radius;
	private double height;
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	public String toString() {
		return "Surface area: "+ this.surface_area() + 
				"\nVolume: " + this.volume();
	}

	@Override
	double surface_area() {
		return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));
	}

	@Override
	double volume() {
		
		return Math.PI * Math.pow(radius, 2) * height;
	}
	
}
