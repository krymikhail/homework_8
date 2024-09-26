package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Deku extends Hero {
    public Deku(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.RANDOM_DAMAGE_BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int randomBoost = RPG_Game.random.nextInt(3);
        int boostPercentage = 0;
        int healthLoss = 0;

        switch (randomBoost) {
            case 0:
                boostPercentage = 20;
                healthLoss = 10;
                break;
            case 1:
                boostPercentage = 50;
                healthLoss = 20;
                break;
            case 2:
                boostPercentage = 100;
                healthLoss = 30;
                break;
        }

        if (RPG_Game.random.nextBoolean()) {
            int boostedDamage = this.getDamage() + (this.getDamage() * boostPercentage / 100);
            boss.setHealth(boss.getHealth() - boostedDamage);
            this.setHealth(this.getHealth() - healthLoss);
            System.out.println(this.getName() + " boosted damage by " + boostPercentage +
                    "% and lost " + healthLoss + " HP.");
        }
    }
}