package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws IOException {
        Player pla = new Player();
        ArrayList<Monster> monster = new ArrayList<>();
        ArrayList<Monster> monstername = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Monster monster1 = new Monster();
        System.out.println("请输入回合数：");           //输入回合数
        int round = sc.nextInt();

        /*
        开始输入主角属性
        */
        System.out.println("请输入主角名称：");
        String playerName = sc.next();
        System.out.println("------------------------------------------------------");
        System.out.println("请输入主角攻击力：");
        int playerAtk = sc.nextInt();
        System.out.println("------------------------------------------------------");
        System.out.println("请输入主角防御力：");
        int playerDfs = sc.nextInt();
        System.out.println("------------------------------------------------------");
        System.out.println("请输入主角生命值：");
        int playerHealth = sc.nextInt();
        Player player1 = new Player(playerName, playerHealth, playerAtk, playerDfs);
        pla.setName(playerName);                    //将主角属性传入Player
        pla.setAttack(playerAtk);
        pla.setDefence(playerDfs);
        pla.setHealth(playerHealth);

        /*
        开始输入怪兽属性
        */
        ArrayList<Monster> monsterproperty = new ArrayList<>();                     //调用方法将怪兽属性输入ArrayList
        monsterproperty = inputMonster(monster, monster1);

        showProperty(monster, pla);                 //展示双方属性

        int playerinjury = playerinjury(pla, monsterproperty);          //获取玩家受到的伤害

        int playerinjurysum = playerinjurysum(pla, monsterproperty, round);     //计算玩家受到的总伤害

        fight(round, monster1, pla, monsterproperty, playerinjury, monster);                 //进行战斗过程


    }

    public static void fight(int round, Monster monster1, Player pla, ArrayList<Monster> monsterproperty, int playerinjury, ArrayList<Monster> monster) throws IOException {
        int monseterinjurysum = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= round; i++) {
            System.out.println("------------------------------------------------------");
            System.out.println("开始第" + i + "回合");
            System.out.println("------------------------------------------------------");
            System.out.println("请选择攻击方式：");
            System.out.println("-------------------------------------------------------");
            System.out.println("| 1.指定攻击 |                | 2.随机攻击 |");
            System.out.println("-------------------------------------------------------");
            int atkWay = sc.nextInt();
            switch (atkWay) {
                case 1:
                    System.out.println("-------------------------------------------------------");
                    System.out.println("请输入攻击对象的编号：");
                    System.out.println("-------------------------------------------------------");
                    int num1 = sc.nextInt();
                    int monsterinjury1 = pla.getAttack();
                    if (monsterinjury1 < 1) {
                        monsterinjury1 = 1;
                    }
                    monseterinjurysum += monsterinjury1;
                    Monster monsterPPT2 = monsterproperty.get(num1 - 1);
                    System.out.println("-------------------------------------------------------");
                    System.out.println("|" + pla.getName() + "对" + monsterPPT2.getName() + "造成了" + monsterinjury1 + "点伤害。|");
                    System.out.println("-------------------------------------------------------");
                    for (int i1 = 0; i1 < monsterproperty.size(); i1++) {
                        Monster monsterPPT1 = monsterproperty.get(i1);
                        System.out.println("|" + monsterPPT1.getName() + "对" + pla.getName() + "造成了" + playerinjury + "点伤害。|");
                    }
                    System.out.println("-------------------------------------------------------");
                    booldCaulate(pla, monsterproperty, round, num1, monseterinjurysum);               //计算血量
                    System.out.println("-------------------------------------------------------");
                    break;
                case 2:
                    Random ran = new Random();
                    int num2 = ran.nextInt(monsterproperty.size()) + 1;
                    int monsterinjury2 = pla.getAttack();
                    if (monsterinjury2 < 1) {
                        monsterinjury2 = 1;
                    }
                    monseterinjurysum += monsterinjury2;
                    Monster monsterPPT3 = monsterproperty.get(num2 - 1);
                    System.out.println("-------------------------------------------------------");
                    System.out.println("|" + pla.getName() + "对" + monsterPPT3.getName() + "造成了" + monsterinjury2 + "点伤害。|");
                    System.out.println("-------------------------------------------------------");
                    for (int i1 = 0; i1 < monsterproperty.size(); i1++) {
                        Monster monsterPPT1 = monsterproperty.get(i1);
                        System.out.println("|" + monsterPPT1.getName() + "对" + pla.getName() + "造成了" + playerinjury + "点伤害。|");
                    }
                    System.out.println("-------------------------------------------------------");
                    booldCaulate(pla, monsterproperty, round, num2, monseterinjurysum);              //计算血量
                    System.out.println("-------------------------------------------------------");
                    break;
            }
            System.out.println("------------------------------------------------------");
            if (i == round) {
                System.out.println("游戏结束。");
            } else {
                System.out.println("按回车继续");
                new BufferedReader(new InputStreamReader(System.in)).readLine();
                }


        }
    }

    public static void showProperty(ArrayList<Monster> mon, Player pla) {                      //展示双方属性

        System.out.println("------------------------------------------------------");
        System.out.println("玩家属性如下：");
        System.out.println("------------------------------------------------------");
        System.out.println("玩家名称：" + pla.getName());
        System.out.println("生命值：" + pla.getHealth());
        System.out.println("攻击力：" + pla.getAttack());
        System.out.println("防御力：" + pla.getDefence());

        System.out.println("------------------------------------------------------");

        System.out.println("------------------------------------------------------");
        System.out.println("怪兽属性如下：");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < mon.size(); i++) {
            Monster monster = mon.get(i);
            System.out.println("怪兽名称：" + monster.getName());
            System.out.println("生命值：" + monster.getHealth());
            System.out.println("攻击力：" + monster.getAttack());
            System.out.println("==================================================");
        }
        System.out.println("");
    }

    public static int playerinjury(Player pla, ArrayList<Monster> monster) {            //计算玩家受到伤害
        int playerinjury = 0;
        for (int i = 0; i < monster.size(); i++) {
            Monster monster1 = monster.get(i);
            playerinjury = monster1.getAttack() - pla.getDefence();
            if (playerinjury < 1) {
                playerinjury = 1;
            }
        }

        return playerinjury;

    }

    public static int playerinjurysum(Player pla, ArrayList<Monster> monster, int round) {           //计算玩家受到的总伤害
        int playerinjurysum1 = 0;
        int playerinjurysum ;
        for (int i = 0; i < monster.size(); i++) {
            Monster monster1 = monster.get(i);
            int playerinjury = monster1.getAttack() - pla.getDefence();
            if (playerinjury < 1) {
                playerinjury = 1;
            }
            playerinjurysum1 += playerinjury;
        }


        return playerinjurysum1;

    }


    public static void booldCaulate(Player pla, ArrayList<Monster> monsterproperty, int round, int num, int monsterinjurysum) {       //计算剩余血量
        int playerinjurysum = playerinjurysum(pla, monsterproperty, round);
        int playerboold = pla.getHealth() - playerinjurysum;
        Monster monster = monsterproperty.get(num - 1);
        int monsterboold = monster.getHealth() - monsterinjurysum;
        System.out.println("=================================================");
        System.out.println(pla.getName() + "的剩余血量为 " + playerboold);
        System.out.println(monster.getName() + "的剩余血量为 " + monsterboold);
    }

    public static ArrayList inputMonster(ArrayList<Monster> monster, Monster monster1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想要对战的怪兽数量：");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            monster1.setNum(i);                                             //给怪兽编号
            System.out.println("请输入第" + i + "只怪兽的名称");
            monster1.setName(sc.next());

            System.out.println("请输入第" + i + "只怪兽的生命值");
            monster1.setHealth(sc.nextInt());
            System.out.println("请输入第" + i + "只怪兽的攻击力");
            monster1.setAttack(sc.nextInt());
            Monster monster2 = new Monster(monster1.getNum(), monster1.getName(), monster1.getHealth(), monster1.getAttack());
            monster.add(monster2);
        }
        return monster;
    }

}

