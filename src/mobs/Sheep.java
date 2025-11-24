package mobs;

import abstrac.PacificMob;

public class Sheep extends PacificMob {

    public Sheep() {
        super(5);
    }

    @Override
    public void move() {
        System.out.println("La Oveja se mueve tranquilamente por el campo");
    }
}
