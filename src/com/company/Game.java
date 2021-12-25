package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Game {
    /**
     *
     */
    public Player[] m_Players;
    public int m_iNbWarBoat;
    public int m_iNbSubs;
    /**
     * Default constructor
     */
    public Game() {
        var infosArray = Main.getScannerInfo();
        Board.s_iWidth = Integer.parseInt(infosArray[0]);
        Board.s_iHeight = Integer.parseInt(infosArray[1]);
        SeaVessel.s_iNbMissilePerSlot = Integer.parseInt(infosArray[2]);
        Radar.s_iSearchRadius =  Integer.parseInt(infosArray[3]);
        Submarine.s_iSpeed = Integer.parseInt(infosArray[4]);
        Torpido.s_iSpeed = Integer.parseInt(infosArray[5]);
        m_iNbWarBoat = Integer.parseInt(infosArray[6]);
        m_iNbSubs = Integer.parseInt(infosArray[7]);
    }

    public void initGame() {
        var infosArray = Main.getScannerInfo();
        m_Players = new Player[infosArray.length];
        for (int i = 0; i < m_Players.length; i++) {
            m_Players[i] = new Player(infosArray[i]);
            m_Players[i].prepareBoard();
            m_Players[i].getBoard().setupVessels(m_Players[i],m_iNbWarBoat,m_iNbSubs);
        }
        m_Players[0].setEnemyPlayer(m_Players[1]);
        m_Players[1].setEnemyPlayer(m_Players[0]);
    }


    /**
     *
     */
    public void startNewGame() {
        // TODO implement here
    }

    /**
     *
     */
    public void gameLoop() {
        // TODO implement here
    }

    public void displayGameInfo(){
        int i = 1;
        System.out.println("Boards are " + Board.s_iWidth + " x " + Board.s_iHeight +", there are " + SeaVessel.s_iNbMissilePerSlot + " missiles per slot, the Radar have a search Radius of "
        + Radar.s_iSearchRadius + ", Submarines have a speed of " + Submarine.s_iSpeed + " and the Torpedos a speed of " + Torpido.s_iSpeed);
        if(m_Players !=null) {
            for (Player player : m_Players) {
                System.out.print("Player " + i + " : ");
                System.out.println(player.toString());
                i++;
            }
        }
    }
}