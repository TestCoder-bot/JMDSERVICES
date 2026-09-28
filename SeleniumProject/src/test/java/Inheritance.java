
class vechicle{
	void speed() {
		System.out.println("The vechile moves faster than human");
	}
}
class car extends vechicle{
	void carspecification() {
		System.out.println("Car have better design");
	}
}
class bike extends vechicle{
	void bikespecification() {
		System.out.println("Bike is light weight");
	}
}
public class Inheritance {
public static void main (String [] args) {
	car mycar=new car();
	mycar.carspecification();
	mycar.speed();
	
	bike mybike=new bike();
	mybike.bikespecification();
	mybike.speed();
}
}
