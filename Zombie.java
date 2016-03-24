import java.util.Random;

//Zombie class is a subclass of Character
public class Zombie extends Character{

	//constructor method for Zombie
	public Zombie(int lifePoints, String name, int strength, String photo) {
		super(lifePoints, name, strength, photo);
		
	}//end constructor method for zombie

	//generates a random number
	private Random randomNumber = new Random();
	
	//overrides the attack abstract method from Character class
	@Override
	public int attack(Character otherPlayer) {
		
		int attack = randomNumber.nextInt(11) * this.getStrength();
		otherPlayer.setLifePoints(otherPlayer.getLifePoints()-attack);
		
		return attack;
	}//end method attack
	
}//end class Zombie
