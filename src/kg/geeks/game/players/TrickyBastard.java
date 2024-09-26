package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class TrickyBastard extends Hero {
    private boolean isPretendingDead;

    public TrickyBastard(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.PRETEND_DEAD);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.random.nextBoolean()) {
            isPretendingDead = true;
            System.out.println(this.getName() + " is pretending to be dead!");
        } else {
            isPretendingDead = false;
        }
    }

    @Override
    public void setHealth(int health) {
        if (!isPretendingDead) {
            super.setHealth(health);
        } else {
            System.out.println(this.getName() + " avoided damage by pretending to be dead!");
        }
    }

    @Override
    public void attack(Boss boss) {
        if (!isPretendingDead) {
            super.attack(boss);
        }
    }
}