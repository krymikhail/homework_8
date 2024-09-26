package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int boostAmount = RPG_Game.random.nextInt(10) + 1;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && hero != this) {
                hero.setDamage(hero.getDamage() + boostAmount);
            }
        }
        System.out.println(this.getName() + " boosted heroes' damage by " + boostAmount);
    }
}