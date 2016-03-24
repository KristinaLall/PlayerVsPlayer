import java.util.ArrayList;
import java.util.Random;

//Human class is a subclass of Character
public class Human extends Character{

	//generates a random number
	private Random randomNumber = new Random();
	
	//declaring variables
	private Weapon weaponChosen;
	
	//constructor method for Human
	public Human(int lifePoints, String name, int strength, String photo) {
		super(lifePoints, name, strength, photo);
		
		//sets default weapon to fist, with 0 cost and 1 damage point
		weaponChosen = new Weapon();
		weaponChosen.setName("Fist");
		weaponChosen.setCost(0);
		weaponChosen.setDamageAmount(1);
		
	}//end constructor method Human

	//setters and getters for Weapon Chosen
	public Weapon getWeaponChosen() {
		return weaponChosen;
	}
	public void setWeaponChosen(Weapon weaponChosen) {
		this.weaponChosen = weaponChosen;
	}
	
	//overrides the attack abstract method from Character class
	@Override
	public int attack(Character otherPlayer) {
		
		int attack = randomNumber.nextInt(11) * (this.getStrength() + weaponChosen.getDamageAmount());
		otherPlayer.setLifePoints(otherPlayer.getLifePoints()-attack);
		
		return attack;
	}//end method attack
	
}//end class Human
