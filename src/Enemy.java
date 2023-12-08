public class Enemy {
    String name;
    int health;
    int attack;

    Enemy(int id) {
        switch (id) {
            case 0:
                this.name = "Imp";
                this.health = 50;
                this.attack = 5;
                break;
            case 1:
                this.name = "Black Frost";
                this.health = 70;
                this.attack = 15;
                break;
            case 2:
                this.name = "Metatron";
                this.health = 400;
                this.attack = 10;
                break;
            case 3:
                this.name = "Lucifer";
                this.health = 200;
                this.attack = 20;
                break;
            case 4:
                this.name = "Brahman";
                this.health = 600;
                this.attack = 8;
                break;
            case 5:
                this.name = "Beelzebub";
                this.health = 500;
                this.attack = 25;
                break;
            case 6:
                this.name = "Mara";
                this.health = 600;
                this.attack = 30;
                break;
            case 7:
                this.name = "YHVH";
                this.health = 1200;
                this.attack = 50;
                break;
        }
    }

    public void attackPlayer(Player player) {
        player.health -= this.attack;
        System.out.println(this.name + " attacked you for " + this.attack + " damage.");
    }
}