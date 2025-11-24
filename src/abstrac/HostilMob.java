package abstrac;

import interfaces.Combat;


public abstract class HostilMob extends Mob implements Combat {

    protected int strength;

    public HostilMob(int health, int strength) {
        super(health);
        this.strength = strength;
    }

    @Override
    public int attack() {
        return strength;
    }

    @Override
    public void receiveAttack(int attack) {
        health -= attack;
        if (health < 0) health = 0;
        System.out.println("[" + this.getClass().getSimpleName() + "] Recibe " + attack + " de daño. Salud restante: " + health);
    }
}
