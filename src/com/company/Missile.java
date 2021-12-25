package com.company;

/**
 *
 */
public class Missile {

    /**
     * Default constructor
     */
    public Missile() {
    }


    /**
     *
     */
    private PositionInformation m_TargetPosition;

    /**
     * @param p_TargetPosition
     */
    public void setTargetPosition(PositionInformation p_TargetPosition) {
        m_TargetPosition = p_TargetPosition;
    }

//    @Override
//    public String toString() {
//        if(m_TargetPosition != null)
//            return "Missile is targeting " + m_TargetPosition.toString();
//        else return "Missile has no target yet";
//
//    }
}