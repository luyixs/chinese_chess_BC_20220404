package com.luyixs;

import javax.swing.*;

public class Chess {

    public static void main(String[] args)  {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            JFrame.setDefaultLookAndFeelDecorated(true);
        }catch(Exception e) {
            System.out.println(e);
        }
        ChessMainFrame chessMainframe = new ChessMainFrame("Chinese——chess_luyixs");
    }

}
