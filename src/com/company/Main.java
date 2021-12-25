package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner s_Scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Board.s_iHeight = 20;
        Board.s_iWidth = 15;
        ////////////////////////////////////////
        //     QUESTION 1
        /////////////////////////////////////

//
//        WarBoat wb = new WarBoat();
//        System.out.println(wb);
//        Submarine sub = new Submarine(null);
//        System.out.println(sub);
//

        ////////////////////////////////////////
        //     QUESTION 2
        /////////////////////////////////////
//        Board.s_iHeight = 20;
//        Board.s_iWidth = 15;
//        var seavesselsInfos = getScannerInfo();
//        var names = getScannerInfo();
//        for(var name : names){
//            Player p = new Player(name);
//            p.prepareBoard();
//            for(int i = 0; i< Integer.parseInt(seavesselsInfos[0]); i++)
//            {
//                WarBoat wb = new WarBoat();
//                p.getBoard().getVessels().add(wb);
//            }
//            for(int i = 0; i< Integer.parseInt(seavesselsInfos[1]); i++)
//            {
//                Submarine sub = new Submarine( p);
//                p.getBoard().getVessels().add(sub);
//            }
//            System.out.println(p);
//        }

        ////////////////////////////////////////
        //     QUESTION 3
        /////////////////////////////////////
        // Game game = new Game();
        // game.displayGameInfo();


        ////////////////////////////////////////
        //     QUESTION 4
        /////////////////////////////////////
//        Game game = new Game();
//        game.initGame();
//        game.displayGameInfo();




        ////////////////////////////////////////
        //     QUESTION 5
        /////////////////////////////////////
//        Game game = new Game();
//        game.initGame();
//
//        for (int i = 0; i < game.m_Players.length; i++) {
//            System.out.println("List of detectable for player : " + game.m_Players[i].getName());
//            for (var det: game.m_Players[i].getDetectables() ) {
//                System.out.println(det);
//            }
//        }


        ////////////////////////////////////////
        //     QUESTION 6
        /////////////////////////////////////
        Game game = new Game();
        game.initGame();

        var infos = getScannerInfo();
        int nbTurns = Integer.parseInt(infos[0]);
        for (int i = 0; i < nbTurns; i++) {
            game.m_Players[i%2].shoot(i%3 == 0);
        }

    }

    public static String[] getScannerInfo() {
        var infos = Main.s_Scanner.nextLine();
        var infosArray = infos.split(",");
        return infosArray;
    }
}
