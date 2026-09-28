

class Animal{
	void sound(){
		System.out.println("Animal makes sound");
	}
}

	class dog extends Animal{
		@Override
		void sound() {
			System.out.println("Dog barks");
		}
		
	}
	class cat extends Animal{
		@Override
		void sound() {
			System.out.println("Cat mews");
		}
	}



public class PolymorphismOverriding {
public static void main (String [] args) {
	Animal myanimal = new Animal();
	myanimal= new dog();
	myanimal.sound();
	myanimal=new cat();
	myanimal.sound();
}
}
