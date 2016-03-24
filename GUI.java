import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;


public class GUI extends JFrame {

	//Declaring Constants
	private final int LIFE_POINTS_COST = 50;
	private final int LIFE_POINTS_AMOUNT = 100;
	private final int STRENGTH_POINTS_COST = 40;
	private final int STRENGTH_POINTS_AMOUNT = 1;
	
	//Declaring JPanels
	private JPanel contentPane;
	private JPanel splashPage;
	private JPanel characterSelection;
	private JPanel buildCharacter;
	private JPanel battle;
	private JPanel winLose;
	
	//Declaring JLabels
	private JLabel lblSplash;
	private JLabel lblSelectCharacters;
	private JLabel lblYourCharacter;
	private JLabel lblOpponent;
	private JLabel lblYourCharacterPic;
	private JLabel lblOpponentPic;
	private JLabel lblYourCharacterBattle;
	private JLabel lblBuildCharacter;
	private JLabel lblSelectedCharacterPic;
	private JLabel lblKnife;
	private JLabel lblAxe;
	private JLabel lblCrossbow;
	private JLabel lblGun;
	private JLabel lblCoinsBuild;
	private JLabel lblCoinsAmountBuild;
	private JLabel lblYourOpponentBattle;
	private JLabel lblBuildCharacterBox;
	private JLabel lblWeaponsBox;
	private JLabel lblBuildCharacterName;
	private JLabel lblSword;
	private JLabel lblBattleCharacterName;
	private JLabel lblBattleOpponentName;
	private JLabel lblDamagaGun;
	private JLabel lblDamageSword;
	private JLabel lblLifePointsUpdateCharacter;
	private JLabel lblLifePointsUpdateOpponent;
	private JLabel lblLifePointsRemainChar;
	private JLabel lblLifePointsRemainOpp;
	private JLabel lblErrorMessage;
	private JLabel lblErrorCoins;
	private JLabel lblWinLose;
	
	//Declaring JLists
	private JList listOpponent;
	private JList listYourCharacter;
	
	//Declaring JTextAreas
	private JTextArea textAreaOpponentStats;
	private JTextArea textbattle;
	private JTextArea textAreaBuildStats;
	private JTextArea textAreaCharacterStats;
	private JTextArea textAreaWeapons;
	
	//Declaring JButtons
	private JButton btnProceedBuild;
	private JButton btnBuildBack;
	private JButton btnFight;
	private JButton btnBeginFight;
	private JButton btnBuyAxe;
	private JButton btnBuyCrossbow;
	private JButton btnBuyGun;
	private JButton btnNewGame;

	//Declaring Objects
	private Random randomNumber = new Random();
	private Game newGame = new Game();
	private Weapon knife;
	private Weapon axe;
	private Weapon crossbow;
	private Weapon gun;
	private Weapon sword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}//end method main
	

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		splashPage = new JPanel();
		contentPane.add(splashPage, "name_35826776720708");
		splashPage.setLayout(null);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setForeground(new Color(0, 0, 0));
		btnPlay.setFocusable(false);
		
		//When the button is clicked, this initializes a new game 
		//and goes to the next page.
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newGame = new Game();
				goToCharacterSelection();
			}
		});//end Play button clicked btnPlay
		
		btnPlay.setFont(new Font("Stencil", Font.BOLD, 35));
		btnPlay.setBackground(new Color(128, 0, 0));
		btnPlay.setBounds(352, 488, 143, 59);
		splashPage.add(btnPlay);
		
		//Creating the splash page
		JLabel lblSplash = new JLabel("New label");
		lblSplash.setBounds(0, 0, 854, 580);
		splashPage.add(lblSplash);
		
		//setting the splash page background photo.
		 Icon myIcon = new ImageIcon(getClass().getResource("rickWithGun.jpg"));
		 lblSplash.setIcon(myIcon);
		
		 //creating the character selection page.
		characterSelection = new JPanel();
		characterSelection.setBackground(new Color(201, 200, 182));
		contentPane.add(characterSelection, "name_35831960030298");
		characterSelection.setLayout(null);
		
		//labels for the character selection page.
		lblSelectCharacters = new JLabel("Select Characters to battle!");
		lblSelectCharacters.setFont(new Font("Stencil", Font.BOLD, 21));
		lblSelectCharacters.setBounds(253, 11, 398, 39);
		characterSelection.add(lblSelectCharacters);
		
		lblYourCharacter = new JLabel("Your Character:");
		lblYourCharacter.setFont(new Font("Calibri", Font.BOLD, 19));
		lblYourCharacter.setBounds(38, 61, 200, 50);
		characterSelection.add(lblYourCharacter);
		
		lblOpponent = new JLabel("Your Opponent:");
		lblOpponent.setFont(new Font("Calibri", Font.BOLD, 19));
		lblOpponent.setBounds(451, 61, 200, 50);
		characterSelection.add(lblOpponent);
		
		//lists for character selection page.
		listYourCharacter = new JList();
		listYourCharacter.setSelectionForeground(Color.WHITE);
		listYourCharacter.setSelectionBackground(new Color(125, 54, 50));
		listYourCharacter.setBounds(40, 134, 132, 85);
		listYourCharacter.setBackground(UIManager.getColor("Button.light"));
		listYourCharacter.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listYourCharacter.setForeground(Color.BLACK);
		listYourCharacter.setFont(new Font("Arial", Font.BOLD, 13));
		
		//This creates an array of Humans for the new initialized game.
		final Human[] listCharacterNames = newGame.createCharacter();
		
		listYourCharacter.setBorder(new LineBorder(new Color(0, 0, 0)));
		characterSelection.add(listYourCharacter);
		
		//This sets the names of the characters in the list for character selection.
		listYourCharacter.setModel(new AbstractListModel() {
			
			public int getSize() {
				return listCharacterNames.length;
			}
			public Object getElementAt(int index) {
				return listCharacterNames[index].getName();
			}
		});//end listYourCharacter listbox.
		
		//sets more labels for character selection page.
		lblYourCharacterPic = new JLabel("");
		lblYourCharacterPic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblYourCharacterPic.setBounds(199, 134, 200, 149);
		characterSelection.add(lblYourCharacterPic);
		
		//sets the textboxes for the character selection page for their statistics.
		textAreaCharacterStats = new JTextArea();
		textAreaCharacterStats.setEditable(false);
		textAreaCharacterStats.setForeground(Color.WHITE);
		textAreaCharacterStats.setBackground(Color.BLACK);
		textAreaCharacterStats.setBounds(199, 294, 200, 110);
		characterSelection.add(textAreaCharacterStats);
		
		//sets the textboxes with the opponents statistics.
		listOpponent = new JList();
		listOpponent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOpponent.setBorder(new LineBorder(new Color(0, 0, 0)));
		listOpponent.setSelectionBackground(new Color(125, 54, 50));
		listOpponent.setSelectionForeground(Color.WHITE);
		listOpponent.setBackground(UIManager.getColor("Button.light"));
		listOpponent.setFont(new Font("Arial", Font.BOLD, 13));
		
		//creats the array of Opponent characters
		final Character[] listOpponentNames = newGame.createOpponent();
		
		//this sets the names of the opponents in the opponents list box.
		listOpponent.setModel(new AbstractListModel() {
		
			public int getSize() {
				return listOpponentNames.length;
			}
			public Object getElementAt(int index) {
				return listOpponentNames[index].getName();
			}
		});//end listOpponent listbox.
		
		listOpponent.setBounds(459, 134, 132, 85);
		characterSelection.add(listOpponent);
		

		lblOpponentPic = new JLabel("");
		lblOpponentPic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOpponentPic.setBounds(612, 134, 200, 149);
		characterSelection.add(lblOpponentPic);
		
		//sets the opponents stats in the textbox.
		textAreaOpponentStats = new JTextArea();
		textAreaOpponentStats.setEditable(false);
		textAreaOpponentStats.setForeground(Color.WHITE);
		textAreaOpponentStats.setBackground(Color.BLACK);
		textAreaOpponentStats.setBounds(612, 294, 200, 110);
		characterSelection.add(textAreaOpponentStats);
		
		//"Proceed" Button on character selection page.
		btnProceedBuild = new JButton("Proceed");
		btnProceedBuild.setBackground(new Color(125, 54, 50));
		btnProceedBuild.setFont(new Font("Stencil", Font.BOLD, 18));
		btnProceedBuild.addActionListener(new ActionListener() {
			
			//if the button is clicked, will check if selections were made for characters and opponents
			//else will display error messages. Also checks if a character is dead.
			
			public void actionPerformed(ActionEvent arg0) {
				
				if ((listYourCharacter.isSelectionEmpty() == true)||(listOpponent.isSelectionEmpty()==true))
				{
					lblErrorMessage.setText("Please choose a character and an opponent!");
				}
				else if (newGame.getSelectedCharacter().getLifePoints() <= 0)
				{
					lblErrorMessage.setText("This character is dead. Please choose another!");
				}
				else if (newGame.getSelectedOpponent().getLifePoints() <= 0)
				{
					lblErrorMessage.setText("This opponent is dead. Please choose another!");
				}
				//if character is chosen and not dead, proceed to build character page.
				else
				{	
					goToBuildCharacter();
				}
			}
		});
		btnProceedBuild.setBounds(685, 530, 148, 39);
		characterSelection.add(btnProceedBuild);
		
		JLabel lblYourCharacterBox = new JLabel("");
		lblYourCharacterBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblYourCharacterBox.setBounds(21, 61, 398, 444);
		characterSelection.add(lblYourCharacterBox);
		
		JLabel lblOpponentBox = new JLabel("");
		lblOpponentBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblOpponentBox.setBounds(435, 61, 398, 444);
		characterSelection.add(lblOpponentBox);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setBounds(186, 530, 477, 31);
		characterSelection.add(lblErrorMessage);
		
		//Build character control settings
		buildCharacter = new JPanel();
		buildCharacter.setBackground(new Color(201, 200, 182));
		contentPane.add(buildCharacter, "name_35834689289218");
		buildCharacter.setLayout(null);
		
		btnBuildBack = new JButton("Back");
		btnBuildBack.setFocusable(false);
		btnBuildBack.setBackground(new Color(125, 54, 50));
		btnBuildBack.setFont(new Font("Stencil", Font.BOLD, 18));
		
		//if the back button is clicked, go back to the character selection page.
		btnBuildBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				goToCharacterSelection();
			}
		});
		btnBuildBack.setBounds(0, 541, 113, 39);
		buildCharacter.add(btnBuildBack);
		
		btnFight = new JButton("Fight!");
		btnFight.setFocusable(false);
		btnFight.setBackground(new Color(125, 54, 50));
		btnFight.setFont(new Font("Stencil", Font.BOLD, 18));
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToBattle();
			}
		});
		btnFight.setBounds(751, 541, 103, 39);
		buildCharacter.add(btnFight);
		
		//Build character selection page.
		lblBuildCharacter = new JLabel("Build Character");
		lblBuildCharacter.setFont(new Font("Stencil", Font.BOLD, 21));
		lblBuildCharacter.setBounds(313, 11, 235, 31);
		buildCharacter.add(lblBuildCharacter);
		
		lblSelectedCharacterPic = new JLabel("");
		lblSelectedCharacterPic.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSelectedCharacterPic.setBounds(36, 109, 180, 150);
		buildCharacter.add(lblSelectedCharacterPic);
		
		textAreaBuildStats = new JTextArea();
		textAreaBuildStats.setEditable(false);
		textAreaBuildStats.setForeground(Color.WHITE);
		textAreaBuildStats.setBackground(new Color(0, 0, 0));
		textAreaBuildStats.setBounds(226, 109, 160, 150);
		buildCharacter.add(textAreaBuildStats);
		
		JButton btnBuyLifePoints = new JButton("Buy 100 Life Point: 50 Coins");
		
		//if the buy life points button is selected, will go to method
		//that updates the life points of the character as well as the
		//total amount of coins.
		btnBuyLifePoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pointsClicked(LIFE_POINTS_COST, LIFE_POINTS_AMOUNT, 0);
				goToBuildCharacter();
			}
		});//end button clicked life points.
		
		btnBuyLifePoints.setBounds(590, 109, 215, 46);
		buildCharacter.add(btnBuyLifePoints);
		
		JButton btnBuyStrength = new JButton("Buy 1 Strength: 40 Coins");
		
		//if the buy strength points button is selected, will go to method
		//that updates the strength points of the character as well as the
		//total amount of coins.
		btnBuyStrength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pointsClicked(STRENGTH_POINTS_COST, 0, STRENGTH_POINTS_AMOUNT);
				goToBuildCharacter();
			}
		});//end button clicked strength points.
		
		btnBuyStrength.setBounds(590, 166, 215, 46);
		buildCharacter.add(btnBuyStrength);
		
		//sets labels and button specifications for the weapons.
		JLabel lblWeapons = new JLabel("Weapons:");
		lblWeapons.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWeapons.setBounds(36, 287, 96, 32);
		buildCharacter.add(lblWeapons);
		
		lblKnife = new JLabel("knife");
		lblKnife.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblKnife.setBounds(36, 317, 142, 110);
		buildCharacter.add(lblKnife);
		
		//Knife Button selection
		 Icon knifeIcon = new ImageIcon(getClass().getResource("knife.jpg"));
		 lblKnife.setIcon(knifeIcon);
		
		lblAxe = new JLabel("Axe");
		lblAxe.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAxe.setBounds(188, 317, 139, 110);
		buildCharacter.add(lblAxe);
		
		//axe button selection
		Icon axeIcon = new ImageIcon(getClass().getResource("axe.jpg"));
		lblAxe.setIcon(axeIcon);
		
		lblCrossbow = new JLabel("crossbow");
		lblCrossbow.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrossbow.setBounds(337, 317, 176, 111);
		buildCharacter.add(lblCrossbow);
		
		//crossbow button selection
		Icon crossbowIcon = new ImageIcon(getClass().getResource("crossbow.jpg"));
		lblCrossbow.setIcon(crossbowIcon);
		
		lblGun = new JLabel("gun");
		lblGun.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblGun.setBounds(523, 317, 138, 110);
		buildCharacter.add(lblGun);
		
		//gun button selection
		Icon gunIcon = new ImageIcon(getClass().getResource("gun.jpg"));
		lblGun.setIcon(gunIcon);
		
		lblSword = new JLabel("sword");
		lblSword.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSword.setBounds(671, 317, 153, 110);
		buildCharacter.add(lblSword);
		
		//sword button selection
		Icon swordIcon = new ImageIcon(getClass().getResource("sword.jpg"));
		lblSword.setIcon(swordIcon);
		
		JButton btnBuyKnife = new JButton("Buy Knife: 50 Coins");
		btnBuyKnife.setHorizontalTextPosition(SwingConstants.LEFT);
		
		//creates a new Knife weapon when clicked.
		btnBuyKnife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				knife = new Weapon();
				knife.setName("Knife");
				knife.setCost(50);
				knife.setDamageAmount(2);
				
				weaponClicked(knife);
				goToBuildCharacter();
				
			}
		});
		btnBuyKnife.setBounds(36, 451, 142, 31);
		buildCharacter.add(btnBuyKnife);
		
		btnBuyAxe = new JButton("Buy Axe: 60 Coins");
		btnBuyAxe.setHorizontalTextPosition(SwingConstants.LEFT);
		
		//creates a new axe weapon when clicked.
		btnBuyAxe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				axe = new Weapon();
				axe.setName("Axe");
				axe.setCost(60);
				axe.setDamageAmount(3);
				
				weaponClicked(axe);
				goToBuildCharacter();
			}
		});
		btnBuyAxe.setActionCommand("Buy Axe");
		btnBuyAxe.setBounds(188, 451, 142, 31);
		buildCharacter.add(btnBuyAxe);
		
		btnBuyCrossbow = new JButton("Buy Crossbow: 70 Coins");
		btnBuyCrossbow.setHorizontalTextPosition(SwingConstants.LEFT);
		
		//creates a new crossbow weapon when clicked.
		btnBuyCrossbow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crossbow = new Weapon();
				crossbow.setName("Crossbow");
				crossbow.setCost(70);
				crossbow.setDamageAmount(4);
				
				weaponClicked(crossbow);
				goToBuildCharacter();
			}
		});
		btnBuyCrossbow.setActionCommand("Buy Axe");
		btnBuyCrossbow.setBounds(337, 451, 176, 31);
		buildCharacter.add(btnBuyCrossbow);
		
		btnBuyGun = new JButton("Buy Gun: 80 Coins");
		btnBuyGun.setHorizontalTextPosition(SwingConstants.LEFT);
		
		//creates a new gun weapon when clicked.
		btnBuyGun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gun = new Weapon();
				gun.setName("Gun");
				gun.setCost(80);
				gun.setDamageAmount(5);
				
				weaponClicked(gun);
				goToBuildCharacter();
			}
		});
		btnBuyGun.setBounds(523, 451, 138, 31);
		buildCharacter.add(btnBuyGun);
		
		JButton btnBuySword = new JButton("Buy Sword: 90 Coins");
		btnBuySword.setHorizontalTextPosition(SwingConstants.LEFT);
		
		//creates a new Sword Weapon when clicked.
		btnBuySword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sword = new Weapon();
				sword.setName("Sword");
				sword.setCost(90);
				sword.setDamageAmount(6);
				
				weaponClicked(sword);
				goToBuildCharacter();
			}
		});
		btnBuySword.setBounds(671, 451, 153, 31);
		buildCharacter.add(btnBuySword);
		
		//total coins label
		lblCoinsBuild = new JLabel("COINS:");
		lblCoinsBuild.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCoinsBuild.setBounds(24, 38, 76, 22);
		buildCharacter.add(lblCoinsBuild);
		
		lblCoinsAmountBuild = new JLabel("");
		lblCoinsAmountBuild.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoinsAmountBuild.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCoinsAmountBuild.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblCoinsAmountBuild.setBackground(Color.ORANGE);
		lblCoinsAmountBuild.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.GRAY));
		lblCoinsAmountBuild.setBounds(85, 39, 58, 25);
		buildCharacter.add(lblCoinsAmountBuild);
		
		lblBuildCharacterName = new JLabel("");
		lblBuildCharacterName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBuildCharacterName.setBounds(36, 87, 113, 23);
		buildCharacter.add(lblBuildCharacterName);
		
		//text areas for weapons
		textAreaWeapons = new JTextArea();
		textAreaWeapons.setEditable(false);
		textAreaWeapons.setText("Weapons:");
		textAreaWeapons.setForeground(Color.WHITE);
		textAreaWeapons.setBackground(Color.BLACK);
		textAreaWeapons.setBounds(396, 109, 152, 150);
		buildCharacter.add(textAreaWeapons);
		
		JLabel lblDamageKnife = new JLabel("Damage: 2 pts");
		lblDamageKnife.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamageKnife.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDamageKnife.setBounds(36, 427, 142, 22);
		buildCharacter.add(lblDamageKnife);
		
		JLabel lblDamageAxe = new JLabel("Damage: 3 pts");
		lblDamageAxe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDamageAxe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamageAxe.setBounds(188, 427, 139, 22);
		buildCharacter.add(lblDamageAxe);
		
		JLabel lblDamageCrossbow = new JLabel("Damage: 4 pts");
		lblDamageCrossbow.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDamageCrossbow.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamageCrossbow.setBounds(337, 427, 176, 22);
		buildCharacter.add(lblDamageCrossbow);
		
		lblDamagaGun = new JLabel("Damage: 5 pts");
		lblDamagaGun.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDamagaGun.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamagaGun.setBounds(523, 427, 132, 22);
		buildCharacter.add(lblDamagaGun);
		
		lblDamageSword = new JLabel("Damage: 6 pts");
		lblDamageSword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDamageSword.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamageSword.setBounds(671, 427, 153, 22);
		buildCharacter.add(lblDamageSword);
		
		lblBuildCharacterBox = new JLabel("");
		lblBuildCharacterBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBuildCharacterBox.setBounds(24, 83, 808, 192);
		buildCharacter.add(lblBuildCharacterBox);
		
		lblWeaponsBox = new JLabel("");
		lblWeaponsBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblWeaponsBox.setBounds(24, 286, 808, 214);
		buildCharacter.add(lblWeaponsBox);
		
		lblErrorCoins = new JLabel("");
		lblErrorCoins.setForeground(Color.RED);
		lblErrorCoins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblErrorCoins.setBounds(159, 44, 302, 14);
		buildCharacter.add(lblErrorCoins);
		
		battle = new JPanel();
		battle.setBackground(new Color(201, 200, 182));
		contentPane.add(battle, "name_35837360555389");
		battle.setLayout(null);
		
		btnBeginFight = new JButton("START");
		btnBeginFight.setFocusable(false);
		
		//this button begins the game when the user has already chosen 
		//and built their character.
		btnBeginFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnBeginFight.setEnabled(false);
				newGame.startGame(textbattle, lblLifePointsUpdateCharacter, lblLifePointsUpdateOpponent);
				btnNewGame.setEnabled(true);
			}
		});//end button Fight.
		
		btnBeginFight.setBackground(new Color(125, 54, 50));
		btnBeginFight.setFont(new Font("Stencil", Font.BOLD, 18));
		btnBeginFight.setBounds(66, 517, 126, 36);
		battle.add(btnBeginFight);
		
		lblYourCharacterBattle = new JLabel("");
		lblYourCharacterBattle.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblYourCharacterBattle.setBounds(66, 52, 222, 200);
		battle.add(lblYourCharacterBattle);
		
		lblYourOpponentBattle = new JLabel("");
		lblYourOpponentBattle.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblYourOpponentBattle.setBounds(544, 52, 222, 200);
		battle.add(lblYourOpponentBattle);
		
		//adds a scross pane to the text area where the battle is displayed.
		JScrollPane scrollPaneBattle = new JScrollPane();
		scrollPaneBattle.setBounds(66, 283, 703, 223);
		battle.add(scrollPaneBattle);
		
		//Battle page
		textbattle = new JTextArea();
		textbattle.setForeground(Color.WHITE);
		textbattle.setBackground(new Color(0, 0, 0));
		scrollPaneBattle.setViewportView(textbattle);
		textbattle.setEditable(false);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Stencil", Font.BOLD, 50));
		lblVs.setBounds(381, 107, 87, 97);
		battle.add(lblVs);
		
		//labels for battle page
		lblBattleCharacterName = new JLabel("");
		lblBattleCharacterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattleCharacterName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBattleCharacterName.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblBattleCharacterName.setBounds(66, 11, 225, 30);
		battle.add(lblBattleCharacterName);
		
		lblBattleOpponentName = new JLabel("");
		lblBattleOpponentName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBattleOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattleOpponentName.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblBattleOpponentName.setBounds(544, 11, 225, 30);
		battle.add(lblBattleOpponentName);
		
		btnNewGame = new JButton("Continue");
		
		//is executed when the continue button is selected. will go back
		//to the character selection page unless you win or lose the game.
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//booleans to store if characters or opponents are dead or alive
				boolean isOneCharacterDead = true;
				boolean isOneOpponentDead = true;
				
				//This for loop checks to see if any characters are still alive.
				for (int i=0;i<listCharacterNames.length;i++)
				{
					if (listCharacterNames[i].getLifePoints() != 0)	
					{
						isOneCharacterDead = false;
					}//end if
				}//end for loop
				
				//This for loop checks to see if any opponents are still alive.
				for (int i=0;i<listOpponentNames.length;i++)
				{
					if (listOpponentNames[i].getLifePoints() != 0)	
					{
						isOneOpponentDead = false;
					}//end if
				}//end for loop
				
				//executes if all characters are dead.
				if  (isOneCharacterDead == true)
				{
					lblWinLose.setText("You Lose!");
					splashPage.setVisible(false);
					characterSelection.setVisible(false);
					buildCharacter.setVisible(false);
					battle.setVisible(false);
					winLose.setVisible(true);
				}
				else if (isOneOpponentDead == true) //executes if all opponents are dead.
				{
					lblWinLose.setText("You Win!");
					splashPage.setVisible(false);
					characterSelection.setVisible(false);
					buildCharacter.setVisible(false);
					battle.setVisible(false);
					winLose.setVisible(true);
				}
				else //else continues the game.
				{
					btnBeginFight.setEnabled(true);
					goToCharacterSelection();
				}
			}
		});//end button continue.
		
		btnNewGame.setFocusable(false);
		btnNewGame.setEnabled(false);
		btnNewGame.setFont(new Font("Stencil", Font.BOLD, 18));
		btnNewGame.setBackground(new Color(125, 54, 50));
		btnNewGame.setBounds(620, 517, 149, 36);
		battle.add(btnNewGame);
		
		//updates on the life points for the character and the opponent
		//Character life Points
		lblLifePointsUpdateCharacter = new JLabel("");
		lblLifePointsUpdateCharacter.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLifePointsUpdateCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifePointsUpdateCharacter.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLifePointsUpdateCharacter.setBounds(207, 258, 81, 14);
		battle.add(lblLifePointsUpdateCharacter);
		
		//Opponent life points
		lblLifePointsUpdateOpponent = new JLabel("");
		lblLifePointsUpdateOpponent.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLifePointsUpdateOpponent.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifePointsUpdateOpponent.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLifePointsUpdateOpponent.setBounds(685, 258, 81, 14);
		battle.add(lblLifePointsUpdateOpponent);
		
		lblLifePointsRemainChar = new JLabel("Life Points Remaining:");
		lblLifePointsRemainChar.setBounds(66, 258, 126, 14);
		battle.add(lblLifePointsRemainChar);
		
		lblLifePointsRemainOpp = new JLabel("Life Points Remaining:");
		lblLifePointsRemainOpp.setBounds(544, 258, 126, 14);
		battle.add(lblLifePointsRemainOpp);
		
		winLose = new JPanel();
		winLose.setBackground(new Color(201, 200, 182));
		contentPane.add(winLose, "name_131459369319504");
		winLose.setLayout(null);
		
		lblWinLose = new JLabel("");
		lblWinLose.setBorder(new LineBorder(new Color(128, 0, 0), 19));
		lblWinLose.setBackground(new Color(0, 0, 0));
		lblWinLose.setForeground(new Color(139, 0, 0));
		lblWinLose.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinLose.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWinLose.setFont(new Font("Stencil", Font.BOLD, 71));
		lblWinLose.setBounds(0, 97, 854, 296);
		winLose.add(lblWinLose);
		
		//when a character is selected, updates the photo and goes the character selection page to update.
		listYourCharacter.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				newGame.setSelectedCharacter(listCharacterNames[listYourCharacter.getSelectedIndex()]);
				goToCharacterSelection();		
			}
			
		});
		
		//when an opponent is selected, updates the photo and goes the character selection page to update.
		listOpponent.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				newGame.setSelectedOpponent(listOpponentNames[listOpponent.getSelectedIndex()]);
				goToCharacterSelection();	
			}
		});
	}//end contructor method GUI().
	
	//this method is executed whenever any weapon is clicked to be bought.
	//this method checks first is the user has enough coins to proceed with 
	//buying the desired weapon and then updates stats.
	//this method does not return a value.
	public void weaponClicked(Weapon selectedWeapon) {
		
		if (newGame.getTotalCoins() < selectedWeapon.getCost())
		{
			lblErrorCoins.setText("You do not have enough coins!");
		
		}//end if
		else
		{
			lblErrorCoins.setText("");
			newGame.setTotalCoins(newGame.getTotalCoins()- selectedWeapon.getCost());
			newGame.getSelectedCharacter().setWeaponChosen(selectedWeapon);
		}//end else
	}//end method weaponClicked
	
	//this method is executed whenever the user wants to purchase either lifepoints or strength.
	//this method does not return a value.
	public void pointsClicked(int cost, int lifeAmount, int strengthAmount){
		
		if (newGame.getTotalCoins() < cost)
		{
			lblErrorCoins.setText("You do not have enough coins!");
		
		}//end if
		else
		{
			lblErrorCoins.setText("");
			newGame.setTotalCoins(newGame.getTotalCoins()- cost);
			newGame.getSelectedCharacter().setLifePoints(newGame.getSelectedCharacter().getLifePoints() + lifeAmount);
			newGame.getSelectedCharacter().setStrength(newGame.getSelectedCharacter().getStrength() + strengthAmount);
			
		}//end else
	}//end method pointsClicked
	
	//This method refreshes the Character selection page.
	public void goToCharacterSelection() {
		
		lblErrorMessage.setText("");
		
		if (newGame.getSelectedCharacter() != null) {
			lblYourCharacterPic.setIcon(new ImageIcon(getClass().getResource(newGame.getSelectedCharacter().getPhoto())));
			textAreaCharacterStats.setText("Name: " + newGame.getSelectedCharacter().getName());
			textAreaCharacterStats.append("\nLife Points: " + newGame.getSelectedCharacter().getLifePoints());
			textAreaCharacterStats.append("\nStrength: " + newGame.getSelectedCharacter().getStrength());
		}//end if
		
		if (newGame.getSelectedOpponent() != null){
			lblOpponentPic.setIcon(new ImageIcon(getClass().getResource(newGame.getSelectedOpponent().getPhoto())));
			textAreaOpponentStats.setText("Name: " + newGame.getSelectedOpponent().getName());
			textAreaOpponentStats.append("\nLife Points: " + newGame.getSelectedOpponent().getLifePoints());
			textAreaOpponentStats.append("\nStrength: " + newGame.getSelectedOpponent().getStrength());
		}//end if
		
		//sets the character selection panel to be displayed.
		splashPage.setVisible(false);
		characterSelection.setVisible(true);
		buildCharacter.setVisible(false);
		battle.setVisible(false);
		winLose.setVisible(false);
		
	}//end method goToCharacterSelection
	
	//This method refreshes the build character page to be visible.
	public void goToBuildCharacter() {
		
			lblCoinsAmountBuild.setText(Integer.toString(newGame.getTotalCoins()));
			
		if (newGame.getSelectedCharacter() != null){
			lblBuildCharacterName.setText(newGame.getSelectedCharacter().getName());
			lblSelectedCharacterPic.setIcon(new ImageIcon(getClass().getResource(newGame.getSelectedCharacter().getPhoto())));
			textAreaBuildStats.setText("Name: " + newGame.getSelectedCharacter().getName());
			textAreaBuildStats.append("\nLife Points: " + newGame.getSelectedCharacter().getLifePoints());
			textAreaBuildStats.append("\nStrength: " + newGame.getSelectedCharacter().getStrength());
			textAreaWeapons.setText("Weapons: ");
			textAreaWeapons.append("\n" + newGame.getSelectedCharacter().getWeaponChosen().getName());	
		}//end if
		
		
		//sets the build character page to be visible.
		splashPage.setVisible(false);
		characterSelection.setVisible(false);
		buildCharacter.setVisible(true);
		battle.setVisible(false);
		winLose.setVisible(false);
		
	}//end method goToBuildCharacter
	
	//This method refreshes the battle page to be displayed.
	public void goToBattle() {
		
		if (newGame.getSelectedCharacter() != null){
			lblLifePointsUpdateCharacter.setText(Integer.toString(newGame.getSelectedCharacter().getLifePoints()));
			lblYourCharacterBattle.setIcon(new ImageIcon(getClass().getResource(newGame.getSelectedCharacter().getPhoto())));
			lblBattleCharacterName.setText(newGame.getSelectedCharacter().getName());
		}//end if
		
		if (newGame.getSelectedOpponent() != null){
			lblLifePointsUpdateOpponent.setText(Integer.toString(newGame.getSelectedOpponent().getLifePoints()));
			lblYourOpponentBattle.setIcon(new ImageIcon(getClass().getResource(newGame.getSelectedOpponent().getPhoto())));
			lblBattleOpponentName.setText(newGame.getSelectedOpponent().getName());
		}//end if
		
		//sets continue button to be enabled and the battle page to be visible
		btnNewGame.setEnabled(false);
		textbattle.setText("");
		splashPage.setVisible(false);
		characterSelection.setVisible(false);
		buildCharacter.setVisible(false);
		battle.setVisible(true);
		winLose.setVisible(false);
		
	}//end method goToBattle
	
}//end class GUI.


//References for Photos:

//Splash Page:
//http://www.wallconvert.com/search/the+walking+dead/

//Rick:
//https://twitter.com/itsmerickgrimes

//Michonne:
//http://walkingdead.wikia.com/wiki/File:TWD-Cast-S4-Michonne-590x375.jpg

//Daryl:
//http://miss-union-jack.deviantart.com/art/Midnight-Swim-Daryl-Dixon-X-Reader-411592966

//Maggie:
//http://tiviseries.mobi/walking-dead-maggie-greene-wallpapers/

//Governor:
//http://www.amctv.com/shows/the-walking-dead/cast/the-governor

//Gareth:
//http://comicbook.com/2014/10/20/gareth-will-be-far-deadlier-than-his-comic-book-counterpart-on-t/

//Zombie Woman:
//http://www.yellmagazine.com/wp-content/uploads/2013/07/The-Walking-Dead-Zombie-season-4-main.jpg

//Zombie Man:
//http://www.fanpop.com/clubs/zombies/images/32977131/title/zonbies-on-walking-dead-photo

//Knife
//http://www.thinkgeek.com/product/2018/

//Axe
//http://callofduty.wikia.com/wiki/Axe

//Crossbow
//http://blog.thecrossbowstore.com/2013/04/01/walking-dead-daryl-dixons-crossbow-revealed/

//Gun
//http://www.slate.com/articles/news_and_politics/crime/2013/12/unintentional_child_shootings_are_an_outrage_here_s_how_to_prevent_them.html

//Sword
//http://walkingdead.wikia.com/wiki/Katana


//References for Timer
//http://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html

//References for Icon code
//David Russell class lecture & Assignments folder ressources








