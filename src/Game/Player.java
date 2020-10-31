package Game;

public class Player {
    private String name;
    private int health;
    private int attack;
    private int defence;

    public Player() {
    }

    public Player(String name, int health, int attack, int defence) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void test(int health,int attack,int defence) {
        if (health > 999 || attack > 999 || defence > 999) {
            System.out.println("数据不合法");
        }
    }
}
