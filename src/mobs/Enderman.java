package mobs;

import abstrac.HostilMob;


public class Enderman extends HostilMob {

    public Enderman() {
        super(14, 6);
    }

    @Override
    public void move() {
        System.out.println("El Enderman se teletransporta detrás del personaje");
    }
}
