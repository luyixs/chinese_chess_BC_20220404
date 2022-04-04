package com.luyixs;

import java.awt.event.MouseEvent;
import java.util.List;

public class ChessRule {

    public void cannonRule(ChessManBehavior play, ChessManBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList, int man) {
        int count = 0;
        int cx = me.getX();
        int cy = me.getY() + 30;
        if (cx - play.getX() >= 0 && cx - play.getX() < 57) {
            for (int i = 56; i <= 569; i += 57) {
                if (cy - i >= 0 && cy - i < 57) {
                    for (int j = 0; j < 32; j++) {
                        if (playQ[j].getX() == play.getX() && play.getName() != playQ[j].getName() && playQ[j].died == false) {
                            for (int k = i; k < play.getY(); k += 57) {
                                if (playQ[j].getY() == k) {
                                    count++;
                                }
                            }
                            for (int k = play.getY(); k < i; k += 57) {
                                if (playQ[j].getY() == k) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count == 0) {
                        ChessRegret chessRegret = new ChessRegret();
                        chessRegret.man = man;
                        chessRegret.cx = play.getX();
                        chessRegret.cy = play.getY();
                        chessRegretList.add(chessRegret);
                        play.setBounds(play.getX(), i, 55, 55);
                        play.playSounds(man);
                        return;
                    }
                }
            }
        }
        if (me.getY() - play.getY() + 30 >= 0 && me.getY() - play.getY() + 30 < 57) {
            for (int i = 24; i <= 480; i += 57) {
                if (me.getX() - i >= 0 && me.getX() - i < 57) {
                    for (int j = 0; j < 32; j++) {
                        if (playQ[j].getY() == play.getY() && play.getName() != playQ[j].getName() && playQ[j].died == false) {
                            for (int k = i; k < play.getX(); k += 57) {
                                if (playQ[j].getX() == k) {
                                    count++;
                                }
                            }
                            for (int k = play.getX(); k < i; k += 57) {
                                if (playQ[j].getX() == k) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count == 0) {
                        ChessRegret chessRegret = new ChessRegret();
                        chessRegret.man = man;
                        chessRegret.cx = play.getX();
                        chessRegret.cy = play.getY();
                        chessRegretList.add(chessRegret);
                        play.setBounds(i, play.getY(), 55, 55);
                        play.playSounds(man);
                        return;
                    }
                }
            }
        }
    }

    public void carRule(ChessManBehavior play, ChessManBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList, int man) {
        cannonRule(play, playQ, me, chessRegretList, man);
    }

    public void horseRule(ChessManBehavior play, ChessManBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList, int man) {
        int ex = 0, ey = 0, move = 0;
        ex = me.getX();
        ey = me.getY() + 30;
        if (play.getX() - ex > 0 && play.getX() - ex <= 57 && play.getY() - ey >= 59 && play.getY() - ey <= 114) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() && playQ[i].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 57, play.getY() - 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() > 59 && ex - play.getX() <= 114 && play.getY() - ey >= 59 && play.getY() - ey <= 114) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() && playQ[i].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 57, play.getY() - 114, 55, 55);
                play.playSounds(man);

            }
            return;
        }
        if (play.getX() - ex > 0 && play.getX() - ex <= 57 && ey - play.getY() >= 114 && ey - play.getY() <= 170) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() && playQ[i].getY() - play.getY() == 57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 57, play.getY() + 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() > 59 && ex - play.getX() <= 114 && ey - play.getY() >= 114 && ey - play.getY() <= 170) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() && playQ[i].getY() - play.getY() == 57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 57, play.getY() + 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (play.getX() - ex > 0 && play.getX() - ex <= 114 && play.getY() - ey > 0 && play.getY() - ey <= 57) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() - play.getX() == -57 && playQ[i].getY() == play.getY()) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 114, play.getY() - 57, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (play.getX() - ex > 0 && play.getX() - ex <= 114 && ey - play.getY() >= 57 && ey - play.getY() < 114) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() - play.getX() == -57 && playQ[i].getY() == play.getY()) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 114, play.getY() + 57, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() >= 114 && ex - play.getX() <= 170 && play.getY() - ey > 0 && play.getY() - ey <= 57) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() - play.getX() ==57 && playQ[i].getY() == play.getY()) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 114, play.getY() - 57, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() >= 114 && ex - play.getX() <= 170 && ey - play.getY() >= 57 && ey - play.getY() < 114) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() == play.getY() ) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 114, play.getY() + 57, 55, 55);
                play.playSounds(man);
                return;
            }
        }
    }

    public void elephantRule(ChessManBehavior play, ChessManBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList, int man) {
        int ex = me.getX();
        int ey = me.getY() + 30;
        int move = 0;
        if (play.getY() <= 284) {
            if (ey >= 341)
                return;
        }
        if (play.getY() >= 341) {
            if (ey < 341)
                return;
        }
        if (play.getX() - ex <= 114 && play.getX() - ex >= 58 && play.getY() - ey <= 114 && play.getY() - ey >= 58) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() - 57 && playQ[i].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 114, play.getY() - 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (play.getX() - ex <= 114 && play.getX() - ex >= 58 && ey - play.getY() >= 114 && play.getY() - ey <= 170) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() - 57 && playQ[i].getY() - play.getY() == 57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 114, play.getY() + 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() >= 114 && ex - play.getX() <= 170 && play.getY() - ey <= 114 && play.getY() - ey >= 58) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() + 57 && playQ[i].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 114, play.getY() - 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() >= 114 && ex - play.getX() <= 170 && ey - play.getY() >= 114 && ey - play.getY() <= 170) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].died == false && playQ[i].getX() == play.getX() + 57 && playQ[i].getY() - play.getY() == 57) {
                    move = 1;
                    break;
                }
            }
            if (move == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 114, play.getY() + 114, 55, 55);
                play.playSounds(man);
                return;
            }
        }
    }

    public void chapRule(ChessManBehavior play , ChessManBehavior playQ[] , MouseEvent me , List<ChessRegret> chessRegretList , int man){

        //判断是红色还是黑色士，黑色为1，红色为2
        int judge = play.getName().charAt(1) - '0';
        int ex = me.getX();
        int ey = me.getY() + 30;

        if (play.getY() <= 225){

            if (ey<=56 ||  ey >= 225)
                return;
        }
        if (play.getY() >= 455){
            if (ey>=624 || ey<= 455)
                return;
        }

        //右上
        if ( ex - play.getX() >= 57 && ex - play.getX() < 114 && play.getY() - ey >= 0 && play.getY() - ey < 57){

            if ( judge == 1 && play.getX() + 57 >= 252 && play.getX() + 57 <= 309){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.playSounds(man);
                play.setBounds(play.getX() + 57,play.getY() - 57,55,55);
            }

            if ( judge == 2 && play.getY() - 57 <= 512 && play.getY() - 57 >= 455 && play.getX() + 57 >= 252 && play.getX() + 57 <= 309){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.playSounds(man);
                play.setBounds(play.getX() + 57,play.getY() - 57,55,55);
            }
        }
        //右下
        if ( ex - play.getX() >= 57 && ex - play.getX() < 114 && ey - play.getY() >= 57 && ey - play.getY() < 114){

            if ( judge == 1 && play.getX() + 57 <= 309 && play.getX() + 57 >= 252){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
               play.playSounds(man);

                play.setBounds(play.getX() + 57,play.getY() + 57,55,55);
            }

            if (judge == 2 && play.getY() + 57 <= 569 && play.getY() + 57 >= 512 && play.getX() + 57 <= 309 && play.getX() + 57 >= 252){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
               play.playSounds(man);
                play.setBounds(play.getX() + 57,play.getY() + 57,55,55);
            }
        }
        //左上
        if ( play.getX() - ex >= 0 && play.getX() - ex < 57 && play.getY() - ey >= 0 && play.getY() - ey < 57){

            if ( judge == 1 && play.getX() <= 309 &&  play.getX() >= 252){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
               play.playSounds(man);
                play.setBounds(play.getX() - 57,play.getY() - 57,55,55);
            }

            if ( judge == 2 &&  play.getX() <= 309 &&  play.getX() >= 252 && play.getY() - 57 <= 512 && play.getY() - 57 >= 455){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
               play.playSounds(man);
                play.setBounds(play.getX() - 57,play.getY() - 57,55,55);
            }
        }
        //左下
        if ( play.getX() - ex >= 0 && play.getX() - ex < 57 && ey - play.getY() >= 57 && ey -  play.getY() < 114){

            if ( judge == 1 && play.getX() <= 309 &&  play.getX() >= 252){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
               play.playSounds(man);
                play.setBounds(play.getX() - 57,play.getY() + 57,55,55);
            }

            if ( judge == 2 && play.getY() + 57 <= 569 && play.getY() + 57 >= 512 && play.getX() <= 309 &&  play.getX() >= 252){
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
               play.playSounds(man);
                play.setBounds(play.getX() - 57,play.getY() + 57,55,55);
            }
        }
    }
    public void masterRule(ChessManBehavior play, ChessManBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList, int man) {
        int ex = me.getX();
        int ey = me.getY() + 30;
        int judge = play.getName().charAt(1) - '0';
        if (ex - play.getX() >= 0 && ex - play.getX() < 57 && play.getY() - ey > 0 && play.getY() - ey <= 57) {
            if (judge == 1 && (play.getX() == 195 || play.getX() == 252 || play.getX() == 309) && (play.getY() == 113 || play.getY() == 170)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX(), play.getY() - 57, 55, 55);
                play.playSounds(man);
                return;
            }
            if (judge == 2 && (play.getX() == 195 || play.getX() == 252 || play.getX() == 309) && (play.getY() == 512 || play.getY() == 569)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX(), play.getY() - 57, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() >= 0 && ex - play.getX() < 57 && ey - play.getY() >= 57 && ey - play.getY() <= 113) {
            if (judge == 1 && (play.getX() == 195 || play.getX() == 252 || play.getX() == 309) && (play.getY() == 56 || play.getY() == 113)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX(), play.getY() + 57, 55, 55);
                play.playSounds(man);
                return;
            }
            if (judge == 2 && (play.getX() == 195 || play.getX() == 252 || play.getX() == 309) && (play.getY() == 512 || play.getY() == 455)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX(), play.getY() + 57, 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (play.getX() - ex > 0 && play.getX() - ex <= 57 && ey - play.getY() >= 0 && ey - play.getY() <= 56) {
            if (judge == 1 && (play.getX() == 252 || play.getX() == 309) && (play.getY() == 56 || play.getY() == 113 || play.getY() == 170)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
            if (judge == 2 && (play.getX() == 252 || play.getX() == 309) && (play.getY() == 569 || play.getY() == 512 || play.getY() == 455)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (ex - play.getX() >= 57 && ex - play.getX() <= 113 && ey - play.getY() >= 0 && ey - play.getY() <= 56) {
            if (judge == 1 && (play.getX() == 252 || play.getX() == 195) && (play.getY() == 56 || play.getY() == 113 || play.getY() == 170)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
            if (judge == 2 && (play.getX() == 252 || play.getX() == 195) && (play.getY() == 569 || play.getY() == 512 || play.getY() == 455)) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
        }
    }

    public void soliderRule(ChessManBehavior play, ChessManBehavior playQ[], MouseEvent me, List<ChessRegret> chessRegretList, int man) {
        int ex = me.getX();
        int ey = me.getY() + 30;
        int judge = play.getName().charAt(1) - '0';
        if (judge == 1) {
            if (ex - play.getX() >= 0 && ex - play.getX() < 57 && ey - play.getY() >= 57 && ey - play.getY() <= 113) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX(), play.getY() + 57, 55, 55);
                play.playSounds(man);
                return;
            }
            if (play.getY() >= 341 && ey - play.getY() >= 0 && ey - play.getY() <= 56 && ex - play.getX() >= 57 && ex - play.getX() <= 113) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
            if (play.getY() >= 341 && ey - play.getY() >= 0 && ey - play.getY() <= 56 && play.getX() - ex > 0 && play.getX() - ex <= 57) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
        }
        if (judge == 2) {
            if (ex - play.getX() >= 0 && ex - play.getX() < 57 && play.getY() - ey > 0 && play.getY() - ey <= 57) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX(), play.getY() - 57, 55, 55);
                play.playSounds(man);
                return;
            }
            if (play.getY() <= 284 && ey - play.getY() >= 0 && ey - play.getY() <= 56 && ex - play.getX() >= 57 && ex - play.getX() <= 113) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() + 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
            if (play.getY() <= 284 && ey - play.getY() >= 0 && ey - play.getY() <= 56 && play.getX() - ex > 0 && play.getX() - ex <= 57) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.setBounds(play.getX() - 57, play.getY(), 55, 55);
                play.playSounds(man);
                return;
            }
        }
    }

    public void carEat(ChessManBehavior play, ChessManBehavior playQ[], ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {
        int count = 0;
        if (play.getX() == enemy.getX()) {
            for (int i = 0; i < 32; i++) {
                if (play.getY() < enemy.getY()) {
                    for (int j = play.getY() + 57; j < enemy.getY(); j = j + 57) {
                        if (playQ[i].getX() == play.getX() && playQ[i].getY() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                } else {
                    for (int j = enemy.getY() + 57; j < play.getY(); j = j + 57) {
                        if (playQ[i].getX() == play.getX() && playQ[i].getY() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                }
            }
            if (count == 0) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died = true;
                play.playEatSounds(playQ);
                play.playEatSounds();
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getY() == enemy.getY()) {
            for (int i = 0; i < 32; i++) {
                if (play.getX() < enemy.getX()) {
                    for (int j = enemy.getX() + 57; j < play.getX() - 57; j = j + 57) {
                        if (playQ[i].getY() == play.getY() && playQ[i].getX() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                } else {
                    for (int j = play.getX() + 57; j < enemy.getX(); j += 57) {
                        if (playQ[i].getY() == play.getY() && playQ[i].getX() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                }
                if (count == 0) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
    }

    public void cannonEat(ChessManBehavior play, ChessManBehavior playQ[], ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {
        int count = 0;
        if (play.getX() == enemy.getX()) {
            for (int i = 0; i < 32; i++) {
                if (play.getY() < enemy.getY()) {
                    for (int j = play.getY() + 57; j < enemy.getY(); j = j + 57) {
                        if (playQ[i].getX() == play.getX() && playQ[i].getY() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                } else {
                    for (int j = enemy.getY() + 57; j < play.getY(); j = j + 57) {
                        if (playQ[i].getX() == play.getX() && playQ[i].getY() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                }
            }
            if (count == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died = true;
                play.playEatSounds(playQ);
                play.playEatSounds();
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getY() == enemy.getY()) {
            for (int i = 0; i < 32; i++) {
                if (play.getX() > enemy.getX()) {//******
                    for (int j = enemy.getX() + 57; j < play.getX(); j = j + 57) {
                        if (playQ[i].getY() == play.getY() && playQ[i].getX() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                } else {
                    for (int j = play.getX() + 57; j < enemy.getX(); j += 57) {
                        if (playQ[i].getY() == play.getY() && playQ[i].getX() == j && playQ[i].died == false) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
    }

    public void horsEat(ChessManBehavior play, ChessManBehavior playQ[], ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {
        int canGo = 1;
        if ((play.getX() - 57 == enemy.getX() || play.getX() + 57 == enemy.getX()) && (play.getY() - 114 == enemy.getY())) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].getX() == play.getX() && playQ[i].getY() == play.getY() - 57 && playQ[i].died == false) {
                    canGo = 0;
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                enemy.died = true;
                play.playEatSounds(playQ);
                play.playEatSounds();
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if ((play.getX() - 57 == enemy.getX() || play.getX() + 57 == enemy.getX()) && (play.getY() + 114 == enemy.getY())) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].getX() == play.getX() && playQ[i].getY() == play.getY() + 57 && playQ[i].died == false) {
                    canGo = 0;
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getX() - 114 == enemy.getX() && (play.getY() - 57 == enemy.getY() || play.getY() + 57 == enemy.getY())) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].getX() - 57 == play.getX() && playQ[i].getY() == play.getY() && playQ[i].died == false) {
                    canGo = 0;
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.setVisible(false);
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getX() + 114 == enemy.getX() && (play.getY() - 57 == enemy.getY() || play.getY() + 57 == enemy.getY())) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].getX() + 57 == play.getX() && playQ[i].getY() == play.getY() && playQ[i].died == false) {
                    canGo = 0;
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.setVisible(false);
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
    }

    public void elephantEat(ChessManBehavior play, ChessManBehavior playQ[],MouseEvent me, ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {
        int canGo = 1;
        int ey = me.getY();
        int judge = play.getName().charAt(1) - '0';
        if (play.getY() <= 284) {
            if (ey >= 341)
                return;
        }
        if (play.getY() >= 341) {
            if (ey < 341)
                return;
        }
        if (play.getX() - 114 == enemy.getX() && play.getY() - 114 == enemy.getY()) {
            if ((judge == 1 && enemy.getY() <= 284) || (judge == 2 && enemy.getY() >= 341)) {//判断黑红，控制移动范围
                for (int i = 0; i < 32; i++) {
                    if (playQ[i].getX() == play.getX() - 57 && playQ[i].getY() == play.getY() - 57 && playQ[i].died == false) {
                        canGo = 0;
                    }
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getX() + 114 == enemy.getX() && play.getY() - 114 == enemy.getY()) {
            if ((judge == 1 && enemy.getY() <= 284) || (judge == 2 && enemy.getY() >= 341)) {
                for (int i = 0; i < 32; i++) {
                    if (playQ[i].getX() == play.getX() + 57 && playQ[i].getY() == play.getY() - 57 && playQ[i].died == false) {
                        canGo = 0;
                    }
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getX() - 114 == enemy.getX() && play.getY() + 114 == enemy.getY()) {
            if ((judge == 1 && enemy.getY() <= 284) || (judge == 2 && enemy.getY() >= 341)) {
                for (int i = 0; i < 32; i++) {
                    if (playQ[i].getX() == play.getX() - 57 && playQ[i].getY() == play.getY() + 57 && playQ[i].died == false) {
                        canGo = 0;
                    }
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (play.getX() + 114 == enemy.getX() && play.getY() + 114 == enemy.getY()) {
            if ((judge == 1 && enemy.getY() <= 284) || (judge == 2 && enemy.getY() >= 341)) {
                for (int i = 0; i < 32; i++) {
                    if (playQ[i].getX() == play.getX() + 57 && playQ[i].getY() == play.getY() + 57 && playQ[i].died == false) {
                        canGo = 0;
                    }
                }
            }
            if (canGo == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                enemy.setVisible(false);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
    }

    public void chapEat(ChessManBehavior play, ChessManBehavior playQ[], ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {
        int canGo = 1;
        int judge = play.getName().charAt(1) - '0';
        if (enemy.getX() == play.getX() - 57 && enemy.getY() == play.getY() - 57) {
            if (judge == 1) {
                if ((enemy.getY() == 56 && enemy.getX() == 195) || (enemy.getY() == 133 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if (judge == 2) {
                if ((enemy.getY() == 455 && enemy.getX() == 195) || (enemy.getY() == 512 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
        if (enemy.getX() == play.getX() + 57 && enemy.getY() == play.getY() - 57) {
            if (judge == 1) {
                if ((enemy.getY() == 56 && enemy.getX() == 309) || (enemy.getY() == 133 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if (judge == 2) {
                if ((enemy.getY() == 455 && enemy.getX() == 309) || (enemy.getY() == 512 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
        if (enemy.getX() == play.getX() - 57 && enemy.getY() == play.getY() + 57) {
            if (judge == 1) {
                if ((enemy.getY() == 170 && enemy.getX() == 195) || (enemy.getY() == 133 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if (judge == 2) {
                if ((enemy.getY() == 569 && enemy.getX() == 195) || (enemy.getY() == 512 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
        if (enemy.getX() == play.getX() + 57 && enemy.getY() == play.getY() + 57) {
            if (judge == 1) {
                if ((enemy.getY() == 170 && enemy.getX() == 309) || (enemy.getY() == 133 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if (judge == 2) {
                if ((enemy.getY() == 569 && enemy.getX() == 309) || (enemy.getY() == 512 && enemy.getX() == 252)) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
    }

    public void masterEat(ChessManBehavior play, ChessManBehavior playQ[], ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {

        int judge = play.getName().charAt(1) - '0';
        if (enemy.getX() == play.getX() && enemy.getY() == play.getY() - 57) {
            if (judge == 1 || judge == 2) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                play.playEatSounds(playQ);
                play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
            }

        }
        if (enemy.getX() == play.getX() && enemy.getY() == play.getY() + 57) {
            if (judge == 1 || judge == 2) {
                ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                play.playEatSounds(playQ);
                play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
            }
        }
        if (enemy.getX() == play.getX() - 57 && enemy.getY() == play.getY()) {
            if (judge == 1 || judge == 2) {
                ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    enemy.died = true;
                play.playEatSounds(playQ);
                play.playEatSounds();
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
            }
        }
        if (enemy.getX() == play.getX() + 57 && enemy.getY() == play.getY()) {
            if (judge == 1 || judge == 2) {
               ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                play.playEatSounds(playQ);
                play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }

        }
    }

    public void soliderEat(ChessManBehavior play, ChessManBehavior playQ[], ChessManBehavior enemy, List<ChessRegret> chessRegretList, int man, int beEat) {
        int judge = play.getName().charAt(1) - '0';
        if (enemy.getX() == play.getX() && enemy.getY() == play.getY() - 57) {
            if (judge == 2) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.setVisible(false);
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (enemy.getX() == play.getX() && enemy.getY() == play.getY() + 57) {
            if (judge == 1) {
                ChessRegret chessRegret = new ChessRegret();
                chessRegret.eatMan = beEat;
                chessRegret.man = man;
                chessRegret.cx = play.getX();
                chessRegret.cy = play.getY();
                chessRegretList.add(chessRegret);
                play.playEatSounds(playQ);
                play.playEatSounds();
                enemy.setVisible(false);
                enemy.died = true;
                play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                return;
            }
        }
        if (enemy.getX() == play.getX() - 57 && enemy.getY() == play.getY()) {
            if (judge == 1) {
                if (enemy.getY() >= 341) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if (judge == 2) {
                if (enemy.getY() < 341) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
        if (enemy.getX() == play.getX() + 57 && enemy.getY() == play.getY()) {
            if (judge == 1) {
                if (enemy.getY() >= 341) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
            if (judge == 2) {
                if (enemy.getY() < 341) {
                    ChessRegret chessRegret = new ChessRegret();
                    chessRegret.eatMan = beEat;
                    chessRegret.man = man;
                    chessRegret.cx = play.getX();
                    chessRegret.cy = play.getY();
                    chessRegretList.add(chessRegret);
                    enemy.setVisible(false);
                    play.playEatSounds(playQ);
                    play.playEatSounds();
                    enemy.died = true;
                    play.setBounds(enemy.getX(), enemy.getY(), 55, 55);
                    return;
                }
            }
        }
    }

    public int masterMeet(ChessManBehavior playQ[])  {
        if (playQ[30].getX() != playQ[31].getX())
            return 0;
        int count = 0;
        int cx = playQ[30].getX();
        for (int j = playQ[30].getY() + 57; j < playQ[31].getY(); j = j + 57) {
            for (int i = 0; i < 32; i++) {
                if (playQ[i].getX() == cx && playQ[i].getY() == j && playQ[i].died == false) {
                    count++;
                }
            }
        }
        if (count > 0)
            return 0;
        return 1;
    }
    public void preview1(ChessManBehavior play, ChessManBehavior playQ[]){
        for (int i = 16; i <= 20; i++) {
            if (playQ[31].getX() == play.getX() && playQ[31].getY() == play.getY() + 57) {
                play.playImage(playQ);
            }
            if (playQ[31].getY() == play.getY() && (playQ[31].getX() == play.getX() - 57 || playQ[31].getX() == play.getX() + 57)) {
                play.playImage(playQ);
            }
        }
    }
    //黑兵
    public void preview2(ChessManBehavior play, ChessManBehavior[] playQ){
        int count = 0;
        for (int i = 0; i<=1; i++) {
            if (playQ[31].getX() == play.getX()){
                if (playQ[31].getY() < play.getY()){
                    for (int q = 0 ; q < 31 ; q++){
                        for (int j = play.getY() - 57 ; j > playQ[31].getY() ; j = j - 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false)
                                count=1;
                        }
                    }
                }
                if (playQ[31].getY() > play.getY()){ // 往下判断
                    for (int q = 0 ; q < 31 ; q++){
                        for (int j = play.getY() + 57 ; j < playQ[31].getY() ; j = j + 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false){
                                count=1;
                            }
                        }
                    }
                }
                if (count == 0){
                    play.playImage(playQ);
                }
            }
            if (playQ[31].getY() == play.getY()){
                if (playQ[31].getX() < play.getX()){
                    for (int q = 0; q < 31; q++){
                        for (int j = play.getX() - 57; j > playQ[31].getX(); j = j - 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = 1;
                            }
                        }
                    }
                }
                if (playQ[31].getX() > play.getX()){
                    for (int q = 0; q < 31; q++){
                        for (int j = play.getX() + 57; j < playQ[31].getX(); j = j + 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = 1;
                            }
                        }
                    }
                }
                if (count == 0) {
                    play.playImage(playQ);
                }
            }
        }
    }
    //黑车
    public void preview3(ChessManBehavior play, ChessManBehavior playQ[]){
        int count = 0;
        for (int i = 26;i <= 27;i++){
            if (playQ[31].getX() == play.getX()){
                if (playQ[31].getY() < play.getY()){
                    for (int q = 0; q < 31; q++){
                        for (int j = play.getY()-57; j > playQ[31].getY(); j = j - 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false)
                                count = count + 1;
                        }
                    }
                }
                if (playQ[31].getY() > play.getY()){
                    for (int q = 0; q < 31; q++){
                        for (int j = play.getY()+57; j < playQ[31].getY(); j = j + 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false)
                                count = count + 1;
                        }
                    }
                }
                if (count ==1){
                    play.playImage(playQ);
                    break;
                }
            }
            if (playQ[31].getY() == play.getY()){
                if (playQ[31].getX() < play.getX()){
                    for (int q = 0; q < 31; q++){
                        for (int j = play.getX()-57; j > playQ[31].getX(); j = j - 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = count + 1;
                            }
                        }
                    }
                }
                if (playQ[31].getX() > play.getX()){
                    for (int q = 0; q < 31; q++){
                        for (int j = play.getX() + 57; j < playQ[31].getX(); j = j + 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = count + 1;
                            }
                        }
                    }
                }
                if (count ==1){
                    play.playImage(playQ);
                }
            }
        }
    }
    //黑炮
    public void preview4(ChessManBehavior play, ChessManBehavior playQ[]){
        int move = 1;
        if ((play.getX() - playQ[31].getX() == 57 || playQ[31].getX() - play.getX() == 57) && play.getY() - playQ[31].getY() == 114) {
            move = 0;
            for (int q = 0; q < 31; q++) {
                if (playQ[q].died == false && playQ[q].getX() == play.getX() && playQ[q].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
        }
        if (play.getX() - playQ[31].getX() == 114 && (play.getY() - playQ[31].getY() == 57 || playQ[31].getY() - play.getY() == 57)){
            move = 0;
            for (int q = 0; q < 31; q++){
                if (playQ[q].died == false && playQ[q].getX() == play.getX() + 57 && playQ[q].getY() == play.getY()){
                    move = 1;
                    break;
                }
            }
        }
        if ((play.getX() - playQ[31].getX() == 57 || playQ[31].getX() - play.getX() == 57) && playQ[31].getY() - play.getY() == 114) {
            move = 0;
            for (int q = 0; q < 31; q++) {
                if (playQ[q].died == false && playQ[q].getX() == play.getX() && playQ[q].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
        }
        if (playQ[31].getX() - play.getX() == 114 && (play.getY() - playQ[31].getY() == 57 || playQ[31].getY() - play.getY() == 57)){
            move = 0;
            for (int q = 0; q < 31; q++){
                if (playQ[q].died == false && playQ[q].getX() == play.getX() + 57 && playQ[q].getY() == play.getY()){
                    move = 1;
                    break;
                }
            }
        }
        if (move == 0){
            play.playImage(playQ);
        }
    }
    //黑马
    public void preview11(ChessManBehavior play, ChessManBehavior playQ[]){
        for (int i = 21; i <= 25; i++) {
            if (playQ[30].getX() == play.getX() && playQ[30].getY() == play.getY() + 57) {
                play.playImage(playQ);
            }
            if (playQ[30].getY() == play.getY() && (playQ[30].getX() == play.getX() - 57 || playQ[30].getX() == play.getX() + 57)) {
                play.playImage(playQ);
            }
        }
    }
    //红兵
    public void preview12(ChessManBehavior play, ChessManBehavior[] playQ){
        int count = 1;
        for (int i = 2; i<=3; i++) {
            if (playQ[30].getX() == play.getX()){
                count = 0;
                if (playQ[30].getY() < play.getY()){
                    for (int q = 0 ; q < 30 ; q++){
                        for (int j = play.getY() - 57 ; j > playQ[30].getY() ; j = j - 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false)
                                count=1;
                        }
                    }
                }
                if (playQ[30].getY() > play.getY()){ // 往下判断
                    for (int q = 0 ; q < 30 ; q++){
                        for (int j = play.getY() + 57 ; j < playQ[30].getY() ; j = j + 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false){
                                count=1;
                            }
                        }
                    }
                }
                if (count == 0){
                    play.playImage(playQ);
                }
            }
            if (playQ[30].getY() == play.getY()){
                count = 0;
                if (playQ[30].getX() < play.getX()){
                    for (int q = 0; q < 30; q++){
                        for (int j = play.getX() - 57; j > playQ[30].getX(); j = j - 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = 1;
                            }
                        }
                    }
                }
                if (playQ[30].getX() > play.getX()){
                    for (int q = 0; q < 30; q++){
                        for (int j = play.getX() + 57; j < playQ[30].getX(); j = j + 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = 1;
                            }
                        }
                    }
                }
                if (count == 0) {
                    play.playImage(playQ);
                }
            }
        }
    }
    //红车
    public void preview13(ChessManBehavior play, ChessManBehavior playQ[]){
        int count = 0;
        for (int i = 28;i <= 29;i++){
            if (playQ[30].getX() == play.getX()){
                if (playQ[30].getY() < play.getY()){
                    for (int q = 0; q < 30; q++){
                        for (int j = play.getY()-57; j > playQ[30].getY(); j = j - 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false)
                                count = count + 1;
                        }
                    }
                }
                if (playQ[30].getY() > play.getY()){
                    for (int q = 0; q < 30; q++){
                        for (int j = play.getY()+57; j < playQ[30].getY(); j = j + 57){
                            if (playQ[q].getX() == play.getX() && playQ[q].getY() == j && playQ[q].died == false)
                                count = count + 1;
                        }
                    }
                }
                if (count ==1){
                    play.playImage(playQ);
                    break;
                }
            }
            if (playQ[30].getY() == play.getY()){
                if (playQ[30].getX() < play.getX()){
                    for (int q = 0; q < 30; q++){
                        for (int j = play.getX() - 57; j > playQ[30].getX(); j = j - 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = count + 1;
                            }
                        }
                    }
                }
                if (playQ[30].getX() > play.getX()){
                    for (int q = 0; q < 30; q++){
                        for (int j = play.getX() + 57; j < playQ[30].getX(); j = j + 57){
                            if (playQ[q].getY() == play.getY() && playQ[q].getX() == j && playQ[q].died == false){
                                count = count + 1;
                            }
                        }
                    }
                }
                if (count ==1){
                    play.playImage(playQ);
                }
            }
        }
    }
    //红炮
    public void preview14(ChessManBehavior play, ChessManBehavior playQ[]){
        int move = 1;
        if ((play.getX() - playQ[30].getX() == 57 || playQ[30].getX() - play.getX() == 57) && play.getY() - playQ[30].getY() == 114) {
            move = 0;
            for (int q = 0; q < 30; q++) {
                if (playQ[q].died == false && playQ[q].getX() == play.getX() && playQ[q].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
        }
        if (play.getX() - playQ[30].getX() == 114 && (play.getY() - playQ[30].getY() == 57 || playQ[30].getY() - play.getY() == 57)){
            move = 0;
            for (int q = 0; q < 30; q++){
                if (playQ[q].died == false && playQ[q].getX() == play.getX() + 57 && playQ[q].getY() == play.getY()){
                    move = 1;
                    break;
                }
            }
        }
        if ((play.getX() - playQ[30].getX() == 57 || playQ[30].getX() - play.getX() == 57) && playQ[30].getY() - play.getY() == 114) {
            move = 0;
            for (int q = 0; q < 30; q++) {
                if (playQ[q].died == false && playQ[q].getX() == play.getX() && playQ[q].getY() - play.getY() == -57) {
                    move = 1;
                    break;
                }
            }
        }
        if (playQ[30].getX() - play.getX() == 114 && (play.getY() - playQ[30].getY() == 57 || playQ[30].getY() - play.getY() == 57)){
            move = 0;
            for (int q = 0; q < 30; q++){
                if (playQ[q].died == false && playQ[q].getX() == play.getX() + 57 && playQ[q].getY() == play.getY()){
                    move = 1;
                    break;
                }
            }
        }
        if (move == 0){
            play.playImage(playQ);
        }
    }
    //红马



}
