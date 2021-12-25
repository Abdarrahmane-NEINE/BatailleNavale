package com.company;

/**
 * 
 */
public class Submarine extends SeaVessel implements IDetectable {


    /**
     * 
     */
    public static int s_iSpeed;

    /**
     * 
     */
    private Torpido m_Torpido;

    private Player m_PlayerOwner;
    /**
     * 
     */
    public MovementDirection m_eDirection;

    /**
     * Default constructor
     *
     * @param p_Player
     */
    public Submarine(Player p_Player) {
        m_PlayerOwner = p_Player;
        m_Torpido = new Torpido();
    }

    @Override
    public void specialAction(Player p_Player, PositionInformation p_Position) {
        if(m_Torpido != null) {
            System.out.println("Launching a Torpido at " + p_Position);
            m_Torpido.setTargetPosition(p_Position);
            m_PlayerOwner.addDetectable(m_Torpido);
            m_Torpido = null;
        }
        else{
            System.out.println("Sorry Torpido was already shot, nothing was done you lost your turn");
        }
    }

    /**
     * 
     */
    public void setEndPointTrajectory() {
        // TODO implement here
    }

    /**
     * 
     */
    public void move() {
        // TODO implement here
    }

    /**
     * @param p_Radar
     * @return
     */
    public boolean IsDetected(Radar p_Radar) {
        // TODO implement here
        return false;
    }

    @Override
    public String toString() {
        if(m_Torpido != null)
            return super.toString() + " and it still has its Torpido";
        else
            return super.toString() + " it has no Torpido left";

    }
}