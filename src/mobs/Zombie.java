package mobs;

import abstrac.HostilMob;


public class Zombie extends HostilMob {

    public Zombie() {
        super(10, 4);
    }

    @Override
    public void move() {
        System.out.println("El Zombie se mueve hacia el personaje principal");
    }
}
