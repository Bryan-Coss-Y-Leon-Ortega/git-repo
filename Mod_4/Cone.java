package Mod_4;


public class Cone extends Shape{
	
	/*
	 * Volume of cone = V = PI * r^2 * h/3
	 * Surface Area = PI * r * (r + root(h^2 + r^2))
	 * 
	 * 
	 * This class works as intendedCOne.
	 * */
	

	private double radius, height ;
	
	public Cone(double radius, double height ) {
		this.radius = radius;
		this.height  = height ;		
	}
	
	public String toString() {
		return "Surface area: "+ this.surface_area() + 
				"\nVolume: " + this.volume();
	}

	@Override
	double surface_area() {
		
		return Math.PI * this.radius * 
				(this.radius + Math.sqrt((Math.pow(this.height, 2) + Math.pow(this.radius, 2))));
	}

	@Override
	double volume() {
		return Math.PI* Math.pow(this.radius, 2) * (this.height / 3.0);
	}
}
