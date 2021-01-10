package com.vehicles.project;



import java.util.Locale;
import java.util.Scanner;

public class Wheel {
	private String brand;
	static double diameter;
//constructor method
	public Wheel(String brand, double diameter) {
		this.brand = brand;
		Wheel.diameter = diameter;
	}
//this is the .setDiameter() and .getDiameter()
	public static  double enterWheelDiameter() {
		@SuppressWarnings("resource")
		Scanner wd =  new Scanner(System.in).useLocale(Locale.US);
		double wheelDmtr = 0;
		try {
			wheelDmtr = wd.nextDouble();
		} catch (Exception e) {
			System.out.println("Values must comply parameters! \n"+e);
		}
		return wheelDmtr;
	}
	
	public static String enterWheelBrand() {
		Scanner wb = new Scanner(System.in);
		String wheelBrand = wb.next();
		return wheelBrand;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wheel other = (Wheel) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
			return false;
		return true;
	}
	
	
}