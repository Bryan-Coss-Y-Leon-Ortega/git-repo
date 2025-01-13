package Mod_4;

public class Sphere extends Shape {

	/*
	 * Sphere class extends the shape class. 
	 * 
	 * A sphere's volume is calculated as V = (4/3)(PI)(r^3)
	 * A sphere's surface area is A = 4(PI)(r^2)
	 * 
	 * Calculated correctly Sphere.
	 * */
	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	
	public String toString() {
		return "Surface area: " + this.surface_area() +
				"\nVolume: " + this.volume();
		
	}

	@Override
	double surface_area() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	double volume() {
		return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
	}
	
	
}
