package com.company;

import java.util.List;

/**
 *
 */
public class Radar extends Missile {

    /**
     * Default constructor
     */
    public Radar() {
    }

    /**
     *
     */
    public static int s_iSearchRadius;


    /**
     *
     */
    public List<PositionInformation> searchDetectables(List<IDetectable> p_IDetecable) {
        System.out.println("Radar is searching all detectable entities in its radius");
        for (var det:p_IDetecable) {
            System.out.println("Trying to detect : " + det);
        }
        return null;
    }
}