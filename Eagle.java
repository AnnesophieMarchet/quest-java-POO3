public class Eagle extends Bird implements Fly {
    private static final int MAX_ALTITUDE = 150;
    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
//            System.out.printf("takes off in the sky.%n"+this.getName());
            System.out.printf("%s takes off into the sky.%n", this.getName());
        }
    }

    @Override
    public int ascend(int meters) {
        if (this.flying) {
//            this.altitude += meters;
            this.altitude = Math.min(this.altitude + meters, MAX_ALTITUDE);
            System.out.printf("%s ascends to an altitude of %d meters.%n", this.getName(), this.altitude);

        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s descends to an altitude of %d meters.%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void glide() {
        if (this.flying) {
            System.out.printf("%s is gliding at an altitude of %d meters.%n", this.getName(), this.altitude);
        }
    }

    @Override
    public void land() {
        if (this.flying) {
            this.altitude = 0;
            this.flying = false;
            System.out.printf("%s has landed and is now on the ground.%n", this.getName());
        }else {
            System.out.printf("%s is already on the ground.%n", this.getName());
        }
    }
}

