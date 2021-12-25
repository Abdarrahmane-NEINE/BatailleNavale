package com.company;

import java.util.*;

/**
 * 
 */
public class PositionInformation {

    /**
     * @param p_iPosX
     * @param p_iPosY
     * @param p_eOrientation
     */
    public PositionInformation(int p_iPosX, int p_iPosY, Orientation p_eOrientation) {
        m_iX = p_iPosX;
        m_iY = p_iPosY;
        m_eOrientation = p_eOrientation;
    }
    /**
     *
     */
    private int m_iX;

    /**
     *
     */
    private int m_iY;


    /**
     *
     */
    private Orientation m_eOrientation;

    /**
     * @param p_iPosX
     * @param p_iPosY
     */
    public void setNewPosition(int p_iPosX, int p_iPosY) {
        m_iX = p_iPosX;
        m_iY = p_iPosY;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        String returnedString = " coordinates ( " + m_iX + ", " + m_iY +" )";
        if(m_eOrientation != Orientation.NOT_RELEVANT)
        {
            returnedString += "in " + m_eOrientation.toString();
        }
        return  returnedString;
    }
}