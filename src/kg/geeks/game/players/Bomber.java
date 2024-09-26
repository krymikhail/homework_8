package kg.geeks.game.players;

public class Bomber extends Hero {
    public Bomber(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.EXPLODE_ON_DEATH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() <= 0) {
            boss.setHealth(boss.getHealth() - 100);
            System.out.println(this.getName() + " exploded and dealt 100 damage to the boss!");
        }
    }
}