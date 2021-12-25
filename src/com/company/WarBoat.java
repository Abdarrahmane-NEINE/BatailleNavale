package com.company;

/**
 *
 */
public class WarBoat extends SeaVessel {

    private Radar m_Radar;

    /**
     * Default constructor
     *
     */
    public WarBoat() {
        m_Radar = new Radar();
    }

    @Override
    public void specialAction(Player p_Player, PositionInformation p_Position) {
        if(m_Radar != null) {
            m_Radar.searchDetectables(p_Player.getDetectables());
            m_Radar = null;
        } else {
            System.out.println("Sorry radar was already used on this boat, nothing was done you lost your turn");
        }
    }

    /*
     * @return
     */
    public String toString() {
        if(m_Radar != null)
            return super.toString() + " and it still has its Radar";
        else
            return super.toString() + "it has no Radar left";

    }
}