package com.rpggame.main;

public class Player extends Character {
	
	// Integers to store number of upgrades/skills in each path
	public int numAtkUpgrades, numDefUpgrades;
	
	// Additional player stats
	int gold, restsLeft, pots;

	// Arrays to store skill names
	public String[] atkUpgrades = {"Forca",  "Poder", "Capacidade", "Forca divina"};
	public String[] defUpgrades = {"Resistencia", "Escudo de pedra", "Peitoral de escamas", "Armadura sagrada"};
	
	// Player specific constructor
	public Player(String name) {
		// Calling constructor of superclass
		// super(name, 100, 0, 100);
		super(name, 100, 0);
		
		// Set additional stats
		this.gold = 5;
		this.restsLeft = 1;
		this.pots = 0;
		
		// Setting # of upgrades to 0
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		// Let the player choose a trait when creating a new character
		chooseTrait();
	}
	
	// Player specific methods (more in the next part)
	@Override
	public int attack() {
		return (int) (Math.random() * (xp / 4 + numAtkUpgrades * 3 + 3) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
	}

	@Override
	public int defend() {
		return (int) (Math.random() * (xp / 4 + numDefUpgrades * 3 + 3) + xp / 10 + numDefUpgrades * 2 + numAtkUpgrades + 1);
	}
	
	// Let the player choose a trait of either skill path
	public void chooseTrait() {
		LogicController.clearConsole();
		LogicController.printHeading("Escolha uma caracteristica:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		
		// Get the players choice:
		int input = LogicController.readInt("-> ", 2);
		LogicController.clearConsole();
		
		// Deal with both cases
		if (input == 1) {
			LogicController.printHeading("Voce escolheu " + atkUpgrades[numAtkUpgrades] + "!");
			numAtkUpgrades ++;
		} else {
			LogicController.printHeading("Voce escolheu " + defUpgrades[numDefUpgrades] + "!");
			numDefUpgrades ++;
		}
		LogicController.anythingToContinue();
	}
}
