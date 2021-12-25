package com.company;

import java.util.*;

/**
 * 
 */
public class Board {

    /**
     * Default constructor
     */
    public Board() {
        m_VesselsArrayList = new ArrayList<>();
    }

    /**
     * 
     */
    public static int s_iWidth;

    /**
     * 
     */
    public static int s_iHeight;


    /**
     * 
     */
    public ArrayList<SeaVessel> m_VesselsArrayList;

    /**
     * @param p_Player
     * @param p_iNbWarBoat
     * @param p_iNbSubs
     */
    public void setupVessels(Player p_Player, int p_iNbWarBoat, int p_iNbSubs) {
        for (int i = 0; i < p_iNbWarBoat; i++) {
            m_VesselsArrayList.add(new WarBoat());
        }

        for (int i = 0; i < p_iNbSubs; i++) {
            var sub = new Submarine(p_Player);
            m_VesselsArrayList.add(sub);
            p_Player.addDetectable(sub);
        }
    }

    public List<SeaVessel> getVessels() {
        return m_VesselsArrayList;
    }
}