import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

//this class is created for a new game.
public class Game {

	//Declaring variables
	private Human selectedCharacter;
	private Character selectedOpponent;
	private Timer theTimer;
	private final int WINNER_COINS = 50;
	private int totalCoins = 50;
	
	//setters and getters for totalCoins
	public int getTotalCoins() 
	{
		return totalCoins;
	}
	public void setTotalCoins(int totalCoins) 
	{
		this.totalCoins = totalCoins;
	}
	
	//setters and getters for getSelected Opponent
	public Character getSelectedOpponent() 
	{
		return selectedOpponent;
	}
	public void setSelectedOpponent(Character selectedOpponent) 
	{
		this.selectedOpponent = selectedOpponent;
	}
	
	//setters and getters for getSelectedCharacter
	public Human getSelectedCharacter() {
		return selectedCharacter;
	}
	public void setSelectedCharacter(Human selectedCharacter) {
		this.selectedCharacter = selectedCharacter;
	}
	
	//This method executes starting the a new game once character and opponent have been selected 
	//and the character has been built.
	public void startGame(final JTextArea textbattle, final JLabel lbllifePtsChar, final JLabel lbllifePtsOpp)
	{
	textbattle.setText("Battle Begins!");
	
	//timer for game
	theTimer  = new Timer(2000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//calls method start round to begin each round of batte.
			startRound(textbattle,lbllifePtsChar,lbllifePtsOpp);
			
			//checks if opponents are alive.
			if ((selectedCharacter.getLifePoints() <= 0)||(selectedOpponent.getLifePoints() <= 0)) 
			{
				theTimer.stop();
				
				if (selectedOpponent.getLifePoints() <= 0)
				{
					textbattle.append("\n" + selectedCharacter.getName() + " Wins!");
					textbattle.append("\nCollect 50 Coins.");
					totalCoins = totalCoins + WINNER_COINS;
				}//end if
				else if (selectedCharacter.getLifePoints() <= 0) 
				{
					textbattle.append ("\n" + selectedOpponent.getName() + " Wins!");
				}//end else
				
				textbattle.append("\nEnd Battle.");
			}//end if
			
		}
		});//end timer action listener
	
		theTimer.start();
		
	}//end method startGame

	//this method begins the round.
	//does not return a value.
	public void startRound(JTextArea textbattle, JLabel lbllifePtsChar, JLabel lbllifePtsOpp) {
		
		//calls on attack method from human class to be executed.
		int attack = selectedCharacter.attack(selectedOpponent);
		textbattle.append("\n" + selectedCharacter.getName() + " rolls an attack of: " + attack);
		lbllifePtsOpp.setText(Integer.toString(selectedOpponent.getLifePoints()));
		
		if (selectedOpponent.getLifePoints() > 0)
		{
			attack = selectedOpponent.attack(selectedCharacter);
			textbattle.append("\n" + selectedOpponent.getName() + " rolls an attack of: " + attack);
			lbllifePtsChar.setText(Integer.toString(selectedCharacter.getLifePoints()));
		}//end if
	}//end method startRound
	
	//this method creates all the human characters for the game using constructors with parameters.
	//returns an array of Humans.
	public Human[] createCharacter() {
		
		//Creating Human characters
		Human rick = new Human(200, "Rick", 10, "rick.jpg");
		Human michonne = new Human(400, "Michonne", 9, "michonne.jpg");
		Human daryl = new Human(600, "Daryl", 8, "daryl.jpg");
		Human maggie = new Human(800, "Maggie", 7, "maggie.jpg");
		
		Human[] yourCharacters = {rick, michonne, daryl, maggie};
		
		return yourCharacters;
		
	}//end method characterSelect()
	
	//This method creates all the opponent characters for the game using constructors with parameters.
	//returns an array of Opponent Characters
	public Character[] createOpponent() {
		
		//Create Opponents
		Character governor = new Human(300, "Governor", 9, "governor.jpg");
		Character gareth = new Human(500, "Gareth", 7, "gareth.jpg" );
		Character zombieWoman = new Zombie(700, "Zombie Woman", 10,"zombieWoman.jpg" );
		Character zombieMan = new Zombie(900, "Zombie Man", 8,"zombieMan.jpg" );
	
		Character[] yourOpponents = {governor, gareth, zombieWoman, zombieMan};
			
		return yourOpponents;
	}//end method createOpponent
	
	//This method creates a new weapon and sets its name, cost, and damage amount when it is called.
	//returns the weapon created.
	public Weapon createWeapon(String name, int cost, int damageAmount) {
	
		Weapon yourWeapon = new Weapon();
		
		yourWeapon.setName(name);
		yourWeapon.setCost(cost);
		yourWeapon.setDamageAmount(damageAmount);
		
		return yourWeapon;
	}//end method createWeapon
	
}//end class Game
