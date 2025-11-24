package abstrac;

import interfaces.Damage;


public abstract class PacificMob extends Mob implements Damage {

    public PacificMob(int health) {
        super(health);
    }

    @Override
    public void receiveAttack(int attack) {
        health -= attack;
        if (health < 0) health = 0;
        System.out.println("[" + this.getClass().getSimpleName() + " (Pacífico)] Recibe " + attack + " de daño. Salud restante: " + health);
    }
}
