package com.company;
// try to debug
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Player {

    private Player m_EnemyPlayer;
    private List<IDetectable> m_DetectablesArray;
    /**
     *
     */
    private String m_sName;


    /**
     *
     */
    private Board m_Board;

    /**
     * Default constructor
     */
    public Player(String p_sName) {
        m_sName = p_sName;
        m_DetectablesArray = new ArrayList<>();
    }

    /**
     *
     */
    public void prepareBoard() {
        m_Board = new Board();
    }

    /**
     *
     */
    public void setEnemyPlayer(Player p_EnemyPlayer) {
        m_EnemyPlayer = p_EnemyPlayer;
    }

    /**
     *
     */
    public void shoot(boolean p_bSpecialAction) {
        var infos = Main.getScannerInfo();
        int vesselIndex = Integer.parseInt(infos[0]);


        System.out.println(m_sName + " is launching an attack on " + m_EnemyPlayer.m_sName);
        if (vesselIndex < getBoard().getVessels().size()) {
            var vessel = getBoard().getVessels().get(vesselIndex);
            var targetPosition = new PositionInformation(Integer.parseInt(infos[2]), Integer.parseInt(infos[3]), Orientation.NOT_RELEVANT);
            if (p_bSpecialAction) {
                vessel.specialAction(m_EnemyPlayer, targetPosition);
            } else {
                int nbMissileLeft = getBoard().getVessels().get(vesselIndex).getNbMissilesLeft();
                System.out.println("Nb missiles left for this boat: " + nbMissileLeft);
                int slotNumber = Integer.parseInt(infos[1]);
                vessel.shootMissile(m_EnemyPlayer, slotNumber, targetPosition);
                nbMissileLeft = getBoard().getVessels().get(vesselIndex).getNbMissilesLeft();
                System.out.println("Nb missiles left for this boat: " + nbMissileLeft);
            }
        } else {
            System.out.println("Sorry vessel index out of bound no shoot was made, you lost your turn");
        }
    }

    /**
     * @return
     */
    public Board getBoard() {
        return m_Board;
    }


    public void addDetectable(IDetectable p_Detectable) {
        m_DetectablesArray.add(p_Detectable);
    }

    public List<IDetectable> getDetectables() {
        return m_DetectablesArray;
    }

    public void receiveMissile(Missile missile) {
        int vesselTouchedIndex = isTouched(missile);
        if (vesselTouchedIndex >= 0) {
            getBoard().getVessels().get(vesselTouchedIndex).applyDamages(missile);
        }
    }

    /**
     * @return
     */
    public int isTouched(Missile missile) {
        // TODO implement here
        return -1;
    }

    @Override
    public String toString() {
        String returnedString = m_sName + " - has " + m_Board.getVessels().size() + " Sea Vessel setup as follow" + "\n";
        for (SeaVessel vessel : m_Board.getVessels()) {
            returnedString += " * " + vessel.toString() + "\n";
        }
        return returnedString;
    }

    public String getName() {
        return m_sName;
    }
}