public class Player {
    int health = 1200;
    int attack = 30;
    int level = 1;
    int xp = 0;
    int mana = 0;

    void attackEnemy(Enemy enemy) {
        enemy.health -= this.attack;
        System.out.println("You attacked " + enemy.name + " for " + this.attack + " damage.");
        if (enemy.health <= 0) {
            gainXP(enemy);
        }
    }

    void defend(Enemy enemy) {
        int damage = enemy.attack / 2;
        this.health -= damage;
        System.out.println("You defended against " + enemy.name + "'s attack and took " + damage + " damage.");
    }

    void gainXP(Enemy enemy) {
        int xpGain = enemy.attack * 2;
        this.xp += xpGain;
        System.out.println("You gained " + xpGain + " XP.");
        if (this.xp >= this.level * 100) {
            levelUp();
        }
    }

    void levelUp() {
        this.level++;
        this.health += 20 * this.level;
        this.attack += 5 * this.level;
        this.mana += 10 * this.level;
        this.xp = 0;
        System.out.println("Congratulations! You leveled up to level " + this.level + ".");
    }
    int healCooldown = 0;

    void heal() {
        if (healCooldown == 0) {
            this.health += 50;
            this.healCooldown = 3;
            System.out.println("You healed for 50 health. Heal spell is now on a 3 turn cooldown.");
        } else {
            System.out.println("Heal spell is on cooldown. " + healCooldown + " turns remaining.");
        }
    }
}