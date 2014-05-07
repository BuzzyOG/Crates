package red.reddington.Crates.util;

import red.reddington.Crates.Crates;

/**
 * Created by Ryan on 5/6/2014.
 */
public class Crate {
    private Crates instance = Crates.getInstance();
    private final String cratetype;
    private final double crateX;
    private final double crateY;
    private final double crateZ;
    private final String crateWorld;
    public Crate(String cratetype, double crateX, double crateY, double crateZ, String crateWorld){
        this.cratetype = cratetype;
        this.crateX = crateX;
        this.crateY = crateY;
        this.crateZ = crateZ;
        this.crateWorld = crateWorld;
    }

    public String getCrateType() {
        return cratetype;
    }

    public double getCrateX() {
        return crateX;
    }

    public double getCrateY() {
        return crateY;
    }

    public double getCrateZ() {
        return crateZ;
    }

    public String getCrateWorld() {
        return crateWorld;
    }
}
