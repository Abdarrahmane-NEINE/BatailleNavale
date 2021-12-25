package com.company;

/**
 * 
 */
public class Torpido extends Missile implements IDetectable {

    /**
     * Default constructor
     */
    public Torpido() {
    }

    /**
     * 
     */
    public static int s_iSpeed;

    /**
     * @param p_Radar
     * @return
     */
    public boolean IsDetected(Radar p_Radar) {
        return false;
    }

}