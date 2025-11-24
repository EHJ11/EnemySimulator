package character;

import interfaces.Combat;

public class MainCharacter implements Combat {

    private int health = 12;
    private final int defense;
    private final int strength;

    public MainCharacter(int strength, int defense) {
        this.strength = strength;
        this.defense = defense;
    }

    @Override
    public int attack() {
        return strength;
    }

    @Override
    public void receiveAttack(int attack) {
        int realDamage = attack - defense;
        if (realDamage < 0) realDamage = 0;

        health -= realDamage;
        if (health < 0) health = 0;

        System.out.println("[Personaje] Daño recibido: " + realDamage + ". Salud restante: " + health);
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }
}
