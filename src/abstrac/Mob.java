package abstrac;


public abstract class Mob {

    protected int health;

    public Mob(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }
    public abstract void move();
}
