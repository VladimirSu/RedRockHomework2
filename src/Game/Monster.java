package Game;

public class Monster {
    private String name;
    private int health;
    private int attack;
    private int num;

    public Monster() {
    }

    public Monster(int num,String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.num = num;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
