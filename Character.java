import java.util.ArrayList;

//creating abstract class Character for the characters of the game.
public abstract class Character  {
	
	//declaring variables
	private int lifePoints;
	private String name;
	private int strength;
	private String photo;
	
	//Constructor method for Character class.
	public Character(int lifePoints, String name, int strength, String photo) {
		super();
		this.lifePoints = lifePoints;
		this.name = name;
		this.strength = strength;
		this.photo = photo;
	}
	
	//setters and getters for lifePoints
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = Math.max(lifePoints, 0);
	}
	
	//setters and getters for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//setters and getters for strength
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	//setters and getters for photo
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	//abstract method for attack
	abstract public int attack(Character otherPlayer);	
	

}//end class Character
