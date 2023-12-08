import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        Player player = new Player();
        System.out.println();
        System.out.println("Welcome to the Amala Network");
        System.out.println();
        int floor = 1;
        while (true) {
            if (floor == 8) {
                System.out.println("Congratulations! You have defeated all enemies and won the game.");
                break;
            }
            generateFloorText(floor);
            Enemy[] enemies = generateEnemies(floor);
            for (int i = 0; i < floor + 1; i++) {
                System.out.println(enemies[i].name + " has appeared");
            }
            System.out.println();
            int enemyCount = floor + 1;
            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("1. Attack - 2. Defend - 3. Heal");
                int choice = in.nextInt();
                while (choice < 1 || choice > 3) {
                    System.out.println("Invalid option. Please choose a valid action.");
                    choice = in.nextInt();
                }
                if (choice == 1) {
                    System.out.println("Which enemy would you like to attack?");
                    for (int i = 0; i < enemyCount; i++) {
                        System.out.println((i + 1) + ". " + enemies[i].name);
                    }
                    int enemyChoice = in.nextInt();
                    while (enemyChoice < 1 || enemyChoice > enemyCount) {
                        System.out.println("Invalid option. Please choose a valid enemy.");
                        enemyChoice = in.nextInt();
                    }
                    player.attackEnemy(enemies[enemyChoice - 1]);
                    if (enemies[enemyChoice - 1].health <= 0) {
                        System.out.println(enemies[enemyChoice - 1].name + " has been defeated.");
                        Enemy[] aliveEnemies = new Enemy[enemyCount - 1];
                        for (int i = 0, j = 0; i < enemyCount; i++) {
                            if (enemies[i].health > 0) {
                                aliveEnemies[j++] = enemies[i];
                            }
                        }
                        enemies = aliveEnemies;
                        enemyCount--;
                        if (enemyCount == 0) {
                            floor++;
                            break;
                        }
                    }
                    for (int i = 0; i < enemyCount; i++) {
                        enemies[i].attackPlayer(player);
                    }
                    if (player.health <= 0) {
                        System.out.println("You have been defeated.");
                        System.exit(0);
                    }
                    if (player.healCooldown > 0) {
                        player.healCooldown--;
                    }
                } else if (choice == 2) {
                    int attacker = rand.nextInt(enemyCount);
                    player.defend(enemies[attacker]);

                    if (player.health <= 0) {
                        System.out.println("You have been defeated.");
                        System.exit(0);
                    }
                    if (player.healCooldown > 0) {
                        player.healCooldown--;
                    }
                } else {
                    player.heal();
                }
            }
        }
    }
    static void generateFloorText(int floor) {
        System.out.println("----------Floor " + floor + "----------");
        System.out.println();
    }

    static Enemy[] generateEnemies(int floor) {
        Random rand = new Random();
        if (floor < 7) {
            Enemy[] enemies = new Enemy[floor + 1];
            for (int i = 0; i < floor + 1; i++) {
                int random = rand.nextInt(7);
                enemies[i] = new Enemy(random);
            }
            return enemies;
        } else {
            return new Enemy[]{new Enemy(7)};
        }
    }
}
