// Alec Buchinski
// Project start date: 8/10/2018
// Last update: 9/8/2018
/**
 *  look into 'json' and save state in different formats
 *  how state machines work, and incorporation
 *  
 */



import java.util.Scanner;
import java.util.Random;
public class Game {
	public static void main(String[] args) {
		
		// System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		String input;
		// Monster objects - skeleton, zombie, assassin, warrior. 4 monsters for the game. Format = (health,damage,name);
		// Counters created for each monster defeated, can be displayed at end of the game.
		Monster currentMonster;
		int numSkeletonDefeated = 0;
		int numZombieDefeated = 0;
		int numWarriorDefeated = 0;
		int numAssassinDefeated = 0;
		
		// Player variables
		int maxHealth = 100;				// Maximum health
		int health = 100;					// Starting health
		int attackDamage = 40;				// Max damage
		int numHealthPotions = 3;			// Starting
		int healthPotionHealAmount = 30;	// Heal amount
		int healthPotionDropChance = 50;	// Percentage
		
		
		
		boolean running = true;
		System.out.println("Welcome to the Dungeon!");
		
		GAME:
		while(running)	{
			System.out.println("----------------------------------------");
			
			currentMonster = generateRandomMonster();
			int enemyHealth = currentMonster.getEnemyHealth();
			String enemy = currentMonster.getEnemyName();
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			
			while (enemyHealth > 0) {
				System.out.println("\tYour HP: "+ health);
				System.out.println("\t"+currentMonster.getEnemyName()+"'s HP: "+enemyHealth);
				System.out.println("\tNumber of potions: " + numHealthPotions);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				
				input = in.nextLine();
				if(input.equals("1"))	{
					int damageDealt = 10+rand.nextInt(attackDamage);
					int damageTaken = currentMonster.getEnemyAttackDamage();
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You recieve " + damageTaken + " in retailation!");
					
					if(health <1) {
						System.out.println("\t> You have taken too much damage, you are too weak to go on!");
						break;
					}
				}
				
				else if (input.equals("2"))	{
					if(numHealthPotions>0) {
						
						if(health == maxHealth) {
							System.out.println("\t>You are already at max health!");
						}
						else if (health+healthPotionHealAmount > maxHealth) {
							int diffHealth = maxHealth - health;
							health = maxHealth;
							numHealthPotions--;
							System.out.println("\t>You can only heal " + diffHealth + " points!");
							System.out.println("\t> You drink a health potion, healing yourself for " + diffHealth +"."
									+ "\n\t> You now have " + health + " HP."
									+"\n\t> You have " + numHealthPotions + " health potions left.\n");
						}
						else{
							health += healthPotionHealAmount;
							numHealthPotions--;
							System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount +"."
									+ "\n\t> You now have " + health + " HP."
									+"\n\t> You have " + numHealthPotions + " health potions left.\n");
						}
						
					}
					else {
						System.out.println("\t> You have no health potions left! Defeat enemies to try and get one!");
					}
				}
				else if (input.equals("3"))	{
					System.out.println("\t> You run away from the " + enemy + "!");
					continue GAME;
				}
				else {
					System.out.println("\tThat is not a valid command.");
				}
				
			}
			
			if (health < 1)	{
				System.out.println("You limp away, weak from battle, to live another day."
									+ "\nOn your journey, you have defeated "
									+ "\n "+numZombieDefeated+ " Zombie(s)"
									+ "\n "+numAssassinDefeated+ " Assassin(s)"
									+ "\n "+numWarriorDefeated+ " Warrior(s) and"
									+ "\n "+numSkeletonDefeated+ " Skeleton(s).");
				break;
			}
			
			System.out.println("----------------------------------------");
			System.out.println(" # " + enemy + " was defeated! #");
			if (enemy == "Zombie") {
				numZombieDefeated ++;
			}
			else if (enemy == "Assassin") {
				numAssassinDefeated ++;
			}
			else if (enemy == "Warrior") {
				numWarriorDefeated ++;
			}
			else if (enemy == "Skeleton") {
				numSkeletonDefeated ++;
			}
			else {
				
			}
			System.out.println(" # You have " + health + " HP left. #");
			if(rand.nextInt(100) < healthPotionDropChance)	{
				numHealthPotions++;
				System.out.println(" # The " + enemy + " droped a health potion! #");
				System.out.println(" # You have " + numHealthPotions + " health potion(s). #");
			}
			System.out.println("----------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");
			
			input = in.nextLine();
			
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("That is not a valid command.");
				input = in.next();
			}
			
			if (input.equals("1"))	{
				System.out.println("You continue on your adventure!");
			}
			else if (input.equals("2"))	{
				System.out.println("Are you sure you wish to leave the dungeon?"
									+ "\n1. Yes, Exit Dungeon"
									+ "\n2. Nope!");
				input = in.nextLine();
				while (!input.equals("1") && !input.equals("2")) {
					System.out.println("That is not a valid command.");
					input = in.next();
			}
				if (input.equals("1")) {
					System.out.println("You exit the dungeon, weary from your adventures."
							+ "\nOn your journey, you have defeated "
							+ "\n "+numZombieDefeated+ " Zombie(s)"
							+ "\n "+numAssassinDefeated+ " Assassin(s)"
							+ "\n "+numWarriorDefeated+ " Warrior(s) and"
							+ "\n "+numSkeletonDefeated+ " Skeleton(s).");
					break;
				}
				else if(input.equals("2")){
					
				}
			}
		}
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");
		in.close();
	}
	
	// other methods
	
	public static Monster generateRandomMonster() {
		// Creates a monster of class Monster, (enemyHealth, enemyAttackDamage, enemyName)
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		if(randomNumber < 40) {
			Monster skeleton = new Monster(40+random.nextInt(5),10+random.nextInt(5),"Skeleton");
			return skeleton;
		}
		else if(randomNumber <60 && randomNumber > 40) {
			Monster zombie = new Monster(75+random.nextInt(5),5+random.nextInt(3),"Zombie");
			return zombie;
		}
		else if(randomNumber <80 && randomNumber > 60) {
			Monster warrior = new Monster(40+random.nextInt(5),20+random.nextInt(3),"Warrior");
			return warrior;
		}
		else {
			Monster assassin = new Monster(30+random.nextInt(5),25+random.nextInt(5),"Assassin");
			return assassin;
		}
	}

}
