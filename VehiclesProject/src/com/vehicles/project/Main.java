package com.vehicles.project;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

		public static void main (String[] args)  {
			
	//FASE 3. car or bike option
			
		String newRide = selectVehicle();
	//	System.out.println(newRide);
		boolean rightRide = checkRide(newRide);
			while(rightRide != true) {
				System.out.println("Invalid vehicle choice.");
				String ride = selectVehicle();
				boolean tVh = checkRide(ride);
				if (tVh = true) {	
					System.out.println("You selected a "+ ride);
					break;
				} 
			}
			
		
	//#1 Ask User to provide plate, brand and color
		
		String plate=enterPlate();
		//System.out.println(plate);
		boolean validPlate = validatePlate(plate);
		//System.out.println(validPlate);
		
			while (validPlate == false) {
					System.out.println("Invalid plate number.");
					String plt = enterPlate();
					boolean bn = validatePlate(plt);
					if (bn == false) {
						System.out.println("Invalid plate number.");
					} else {
						System.out.println("Valid plate number.");
						break;
					}
			} 
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Please, enter vehicle brand: ");
		String brand = sc.next();
		System.out.println("Please, enter vehicle color: ");
		String color = sc.next();
		
	//#2 Create a vehicle with the provided data
		//Vehicle vhcl = new Vehicle (plate, brand, color); abstract classes cannot be instatiated...
		
		switch (newRide) {
			case "car":
				Car newCar = new Car(plate, brand, color);
				System.out.println("New car plate is: "+plate);
				System.out.println("New car brand is: "+brand);
				System.out.println("New car color is: "+color);
				System.out.println("Please, enter front wheels brand: ");
				String fwBrand = Wheel.enterWheelBrand();
				System.out.println("Please, enter front wheels diameter. Diameter must be between 0.4 and 4.0: ");
				//Watch out for Locale format for decimal delimiter: use USA decimal delimiter ("."). So as to fix this, a .useLocale() was added to the Scanner sc back at the #1
				double fwDiamtr = Wheel.enterWheelDiameter();
		 		System.out.println(fwDiamtr);
		 		
			 		while (fwDiamtr<0.4 || fwDiamtr>4.0) {
			 			System.out.println("Invalid wheel diameter. Please enter a valid value (0.4 - 4.0).");
			 			fwDiamtr = Wheel.enterWheelDiameter();
			 			if (fwDiamtr >0.4 && fwDiamtr <4.0) {
			 				System.out.println("Valid diameter.");
			 			} 	
			 			break;
			 		} 			 
		 		
				Wheel frWheel = new Wheel (fwBrand,fwDiamtr);
				Wheel flWheel = new Wheel (fwBrand,fwDiamtr);
						
				List<Wheel>frontWheels = new ArrayList<Wheel>();
					frontWheels.add(frWheel);
					frontWheels.add(flWheel);
				System.out.println("Front wheels are "+fwBrand+" of " + fwDiamtr);
						
			//#4 Add two back wheels asking brand and diameter
				
				System.out.println("Please, enter back wheels brand: ");
				String bckBrand = Wheel.enterWheelBrand();
				
				System.out.println("Please, enter back wheels diameter. Diameter must be between 0.4 and 4.0: ");
				
				double bckDiamtr = Wheel.enterWheelDiameter();
		 		System.out.println(bckDiamtr);
		 		
			 		while (bckDiamtr<0.4 || bckDiamtr>4.0) {
			 			System.out.println("Invalid wheel diameter. Please enter a valid value (0.4 - 4.0).");
			 			bckDiamtr = Wheel.enterWheelDiameter();
			 			if (bckDiamtr >0.4 && bckDiamtr <4.0) {
			 				System.out.println("Valid diameter.");
			 			} 	
			 			break;
			 		} 			 
				
				Wheel brWheel = new Wheel (bckBrand,bckDiamtr);
				Wheel blWheel = new Wheel (bckBrand,bckDiamtr);
				
				List<Wheel>backWheels= new ArrayList<Wheel>();
					backWheels.add(brWheel);
					backWheels.add(blWheel);
				System.out.println("Back wheels are "+bckBrand+" of " + bckDiamtr);
								
				try {
					newCar.addWheels(frontWheels, backWheels);
					System.out.println("The car has been successfully equiped");
					
				} catch (Exception e ) {
				
					System.out.println("Warning: wheels mount not executed! \n"+e);
				}
				break;
			case "bike":
				Bike newBike = new Bike (plate, brand, color);
				System.out.println("New bike plate is: "+plate);
				System.out.println("New bike brand is: "+brand);
				System.out.println("New bike color is: "+color);
				System.out.println("Please, enter front wheel brand: ");
				String fwBkBrand = Wheel.enterWheelBrand();
				System.out.println("Please, enter front wheel diameter. Diameter must be between 0.2 and 3.5: ");
				//Watch out for Locale format for decimal delimiter: use USA decimal delimiter ("."). So as to fix this, a .useLocale() was added to the Scanner sc back at the #1
				double fwBkDiamtr = Wheel.enterWheelDiameter();
		 		System.out.println(fwBkDiamtr);
		 		 		while (fwBkDiamtr<0.2 || fwBkDiamtr>3.5) {
			 			System.out.println("Invalid wheel diameter. Please enter a valid value (0.2 - 3.5).");
			 			fwBkDiamtr = Wheel.enterWheelDiameter();
			 			if (fwBkDiamtr >0.2 && fwBkDiamtr <3.5) {
			 				System.out.println("Valid diameter.");
			 			} 	
			 			break;
		 		 		} 			 
		 		
				Wheel fwWheel = new Wheel (fwBkBrand,fwBkDiamtr);
				System.out.println("Front wheel is "+fwBkBrand+" of " + fwBkDiamtr);
						
			//#4 Add two back wheel asking brand and diameter
				
				System.out.println("Please, enter back wheel brand: ");
				String bckBkBrand = Wheel.enterWheelBrand();
				
				System.out.println("Please, enter back wheels diameter. Diameter must be between 0.2 and 3.5: ");
				
				double bckBkDiamtr = Wheel.enterWheelDiameter();
		 		System.out.println(bckBkDiamtr);
		 		
			 		while (bckBkDiamtr<0.2 || bckBkDiamtr>3.5) {
			 			System.out.println("Invalid wheel diameter. Please enter a valid value (0.2 - 3.5).");
			 			bckBkDiamtr = Wheel.enterWheelDiameter();
			 			if (bckBkDiamtr >0.2 && bckBkDiamtr <3.5) {
			 				System.out.println("Valid diameter.");
			 			} 	
			 			break;
			 		} 			 
				
				Wheel bckWheel = new Wheel (bckBkBrand,bckBkDiamtr);
				System.out.println("Back wheel is "+bckBkBrand+" of " + bckBkDiamtr);
				
							try {
								newBike.addWheelsBike(fwWheel, bckWheel);
								System.out.println("The bike has been successfully equiped");
								
							} catch (Exception e ) {
							
								System.out.println("Warning: wheels mount not executed! \n"+e);
							} 
							break;		
						} 

			} 
	
	public static String selectVehicle () {
		@SuppressWarnings("resource")
		Scanner vh = new Scanner(System.in);
		System.out.println("Enter vehicle: car or bike.");
		String selectedVehicle = vh.next();
		return selectedVehicle;
	}
		
	public static boolean checkRide (String selectedVehicle) {
		boolean rightRide = Pattern.matches("^[car,Car,bike,Bike]{3,4}$", selectedVehicle);
		System.out.println(rightRide);
		return rightRide;
	}
	
	public static String enterPlate () {
		@SuppressWarnings("resource")
		Scanner ep =  new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Please, enter a valid plate. Plate must have first four numbers and two to three letters: ");
		String enteredPlate = ep.next();
		return enteredPlate; 
	}
		
	public static boolean validatePlate(String enteredPlate) {
		boolean validPlate = Pattern.matches("^[0-9]{4}[A-Za-z]{2,3}$", enteredPlate);
		return validPlate;
	}
		
}