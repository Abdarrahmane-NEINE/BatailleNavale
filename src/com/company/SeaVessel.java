package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class SeaVessel {

    /**
     * Default constructor
     */
    public SeaVessel() {
        var infosArray = Main.getScannerInfo();
        m_iLifePoints = Integer.parseInt(infosArray[0]);
        if(m_iLifePoints<0)
        {
            System.out.println("Sorry only positive value for life points, by default it will be 1");
            m_iLifePoints = 1;
        }

        int posX = Integer.parseInt(infosArray[1]);
        int posY = Integer.parseInt(infosArray[2]);
        if(posX < 0 || posX > Board.s_iWidth)
        {
            System.out.println("Sorry only positive value and less than board width, X is set to 0");
            posX = 0;
        }
        if(posY < 0 || posY > Board.s_iHeight )
        {
            System.out.println("Sorry only positive value and less than board width, Y is set to 0");
            posY = 0;
        }

        if(!infosArray[3].equals("Horizontal") && !infosArray[3].equals("Vertical"))
            System.out.println("Orientation is not one of acceptable proposition, by default it will be Vertical");

        m_PosInfo = new PositionInformation(posX, posY, infosArray[3].equals("Horizontal") ? Orientation.HORIZONTAL : Orientation.VERTICAL);

        m_Missiles = new ArrayList<>();
        for (int i = 0; i < m_iLifePoints; i++) {
            List<Missile> missiles = new ArrayList<>();
            for (int j = 0; j < s_iNbMissilePerSlot; j++) {
                missiles.add(new Missile());
            }
            m_Missiles.add(missiles);
        }
    }

    /**
     *
     */
    protected int m_iLifePoints;


    /**
     *
     */
    public static int s_iNbMissilePerSlot;

    /**
     *
     */
    protected List<  List<Missile> > m_Missiles;


    /**
     *
     */
    protected PositionInformation m_PosInfo;


    /**
     * @return
     */
    public PositionInformation getPositionInformation() {
        return m_PosInfo;
    }

    /**
     * @return
     */
    public boolean isDestroyed() {
        return m_iLifePoints > 0;
    }

    /**
     * @param p_Player
     * @param p_iSlotNumber
     * @param p_TargetPosition
     * @return
     */
    public boolean shootMissile(Player p_Player, int p_iSlotNumber, PositionInformation p_TargetPosition) {
        if (m_Missiles.size() < p_iSlotNumber) {
            System.out.println("This vessel has not that many slot, select another value");
        } else {
            if (m_Missiles.get(p_iSlotNumber).size() <= 0) {
                System.out.println("Slot is empty no missile left, please choose another slot");
            } else {
                Missile missile = m_Missiles.get(p_iSlotNumber).remove(0);
                System.out.println("Missile is gone, " + m_Missiles.get(p_iSlotNumber).size() + " missile left for this slot");
                missile.setTargetPosition(p_TargetPosition);
                p_Player.receiveMissile(missile);
                return true;
            }
        }
        return false;
    }

    public int getNbMissilesLeft() {
        int total = 0;
        for (var missileslArray : m_Missiles) {
            total += missileslArray.size();
        }
        return total;
    }

    /**
     *
     */
    abstract public void specialAction(Player p_Player, PositionInformation p_TargetPositionInformation);

    /**
     * @return
     */
    public boolean isTouched(PositionInformation p_PositionInformation) {
        // TODO implement here
        return false;
    }

    /**
     * /**
     */
    public void applyDamages(Missile missile) {
        // TODO implement here
        //Destroy slot and remove missiles from missileArray
        //Find a way to know the slot was destroy (for message when trying to shoot a missile from this slot)
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " has " + m_iLifePoints + " life points, and is positionned " + m_PosInfo.toString();
    }
}