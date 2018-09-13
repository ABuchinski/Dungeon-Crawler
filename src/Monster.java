

// class for monsters to be created in the game
public class Monster {
	private String enemyName;
	private int enemyHealth;
	private int enemyAttackDamage;
	
	public Monster(int health, int damage, String name) {
		this.enemyHealth=health;
		this.enemyAttackDamage = damage;
		this.enemyName = name;
	}
	public int getEnemyHealth(){
		return this.enemyHealth;
	}
	public int getEnemyAttackDamage(){
		return this.enemyAttackDamage;
	}
	public String getEnemyName(){
		return this.enemyName;
	}
	public void setEnemyHealth(int newValue) {
		this.enemyHealth = newValue;
	}
	public void setEnemyAttackDamage(int newValue) {
		this.enemyAttackDamage = newValue;
	}
	
	public void setEnemyName(String newValue) {
		this.enemyName = newValue;
	}
	public String toString() {
		return (enemyName + " has " + enemyHealth + " health and deals " + enemyAttackDamage + " damage per hit!");
	}
}