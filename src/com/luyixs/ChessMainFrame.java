package com.luyixs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
public class ChessMainFrame extends JFrame implements ActionListener, MouseListener, Runnable {
    ChessManBehavior play[] = new ChessManBehavior[34];
    JLabel image;
    Container con;
    JToolBar jmain;
    JButton anew, repent, exit;
    JLabel text;
    int chessplayClick = 2;
    boolean chessManClick;
    Thread tmain;
    static int Man;
    ChessRule chessRule;
    List<ChessRegret> regretList;
    ChessManBehavior ye;
    ChessManBehavior jiang;

    public ChessMainFrame(String title) {
        con = this.getContentPane();
        con.setLayout(null);
        this.setTitle(title);
        jmain = new JToolBar();
        text = new JLabel("欢迎游玩 ○( ＾皿＾)っ");
        text.setToolTipText("亲爱的玩家");
        anew = new JButton("新游戏");
        anew.setToolTipText("再来一局吧相信自己o(*^＠^*)o");
        exit = new JButton("退出");
        exit.setToolTipText("下次见了喔( ﾟдﾟ)つBye");
        repent = new JButton("悔棋");
        repent.setToolTipText("走错了(￣ ‘i ￣;)");
        jmain.setLayout(new GridLayout(0, 4));
        jmain.add(anew);
        jmain.add(repent);
        jmain.add(exit);
        jmain.add(text);
        jmain.setBounds(0, 0, 558, 30);
        con.add(jmain);
        drawChessMain();
        for (int i = 0; i < 32; i++) {
            con.add(play[i]);
            play[i].addMouseListener(this);

        }
        Icon in = new ImageIcon("image/ye.jpg");
        ye = new ChessManBehavior(in);
        ye.setBounds(252,252,100,114);
        ye.setName("ye");
        con.add(ye);
        ye.setVisible(false);
        play[32] = ye;

        Icon pan = new ImageIcon("image/jiang.gif");
        jiang = new ChessManBehavior(pan);
        jiang.setBounds(212,100,140,100);
        jiang.setName("jiang");
        con.add(jiang);
        jiang.setVisible(false);
        play[33] = jiang;

        con.add(image = new JLabel(new ImageIcon("image/main.gif")));
        image.setBounds(0, 30, 558, 620);
        image.addMouseListener(this);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - 280, screenSize.height / 2 - 350);
        this.setIconImage(new ImageIcon("image/红将.gif").getImage());
        this.setResizable(false);
        this.setSize(568, 676);
        this.setVisible(true);
        regretList = new ArrayList<ChessRegret>();
        chessRule = new ChessRule();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        anew.addActionListener(this);
        repent.addActionListener(this);
        exit.addActionListener(this);


    }
    public void chessReset() {
        int i, k;
        for (i = 0, k = 24; i < 2; i++, k += 456) {
            play[i].setBounds(k, 56, 55, 55);
        }
        for (i = 4, k = 81; i < 6; i++, k += 342) {
            play[i].setBounds(k, 56, 55, 55);
        }
        for (i = 8, k = 138; i < 10; i++, k += 228) {
            play[i].setBounds(k, 56, 55, 55);
        }
        for (i = 12, k = 195; i < 14; i++, k += 114) {
            play[i].setBounds(k, 56, 55, 55);
        }
        for (i = 16, k = 24; i < 21; i++, k += 114) {
            play[i].setBounds(k, 227, 55, 55);
        }
        for (i = 26, k = 81; i < 28; i++, k += 342) {
            play[i].setBounds(k, 170, 55, 55);
        }
        play[30].setBounds(252, 56, 55, 55);
        for (i = 2, k = 24; i < 4; i++, k += 456) {
            play[i].setBounds(k, 569, 55, 55);
        }
        for (i = 6, k = 81; i < 8; i++, k += 342) {
            play[i].setBounds(k, 569, 55, 55);
        }
        for (i = 10, k = 138; i < 12; i++, k += 228) {
            play[i].setBounds(k, 569, 55, 55);
        }
        for (i = 14, k = 195; i < 16; i++, k += 114) {
            play[i].setBounds(k, 569, 55, 55);
        }
        for (i = 21, k = 24; i < 26; i++, k += 114) {
            play[i].setBounds(k, 398, 55, 55);
        }
        for (i = 28, k = 81; i < 30; i++, k += 342) {
            play[i].setBounds(k, 455, 55, 55);
        }
        play[31].setBounds(252, 569, 55, 55);
        for (i = 0; i < 32; i++) {
            System.out.println(i + " " + play[i].getName());
        }
        for (i = 0; i < 32; i++) {
            play[i].setVisible(true);
            play[i].died = false;
            Man = -1;
        }
        text.setText("     红棋走棋");
        chessplayClick=2;
        regretList.clear();
    }

    public void drawChessMain() {
        int i, k;
        Icon in = null;
        in = new ImageIcon("image/黑车.gif");
        for (i = 0, k = 24; i < 2; i++, k += 456) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 56, 55, 55);
            play[i].setName("车1");
        }
        in = new ImageIcon("image/黑马.gif");
        for (i = 4, k = 81; i < 6; i++, k += 342) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 56, 55, 55);
            play[i].setName("马1");
        }
        in = new ImageIcon("image/黑象.gif");
        for (i = 8, k = 138; i < 10; i++, k += 228) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 56, 55, 55);
            play[i].setName("象1");
        }
        in = new ImageIcon("image/黑士.gif");
        for (i = 12, k = 195; i < 14; i++, k += 114) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 56, 55, 55);
            play[i].setName("士1");
        }
        in = new ImageIcon("image/黑卒.gif");
        for (i = 16, k = 24; i < 21; i++, k += 114) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 227, 55, 55);
            play[i].setName("卒1" + i);
        }
        in = new ImageIcon("image/黑炮.gif");
        for (i = 26, k = 81; i < 28; i++, k += 342) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 170, 55, 55);
            play[i].setName("炮1" + i);
        }
        in = new ImageIcon("image/黑将.gif");
        play[30] = new ChessManBehavior(in);
        play[30].setBounds(252, 56, 55, 55);
        play[30].setName("将1");

        in = new ImageIcon("image/红车.gif");
        for (i = 2, k = 24; i < 4; i++, k += 456) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 569, 55, 55);
            play[i].setName("车2");
        }
        in = new ImageIcon("image/红马.gif");
        for (i = 6, k = 81; i < 8; i++, k += 342) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 569, 55, 55);
            play[i].setName("马2");
        }
        in = new ImageIcon("image/红象.gif");
        for (i = 10, k = 138; i < 12; i++, k += 228) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 569, 55, 55);//定位位置
            play[i].setName("象2");
        }
        in = new ImageIcon("image/红士.gif");
        for (i = 14, k = 195; i < 16; i++, k += 114) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 569, 55, 55);
            play[i].setName("士2");
        }
        in = new ImageIcon("image/红卒.gif");
        for (i = 21, k = 24; i < 26; i++, k += 114) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 398, 55, 55);
            play[i].setName("卒2" + i);
        }
        in = new ImageIcon("image/红炮.gif");
        for (i = 28, k = 81; i < 30; i++, k += 342) {
            play[i] = new ChessManBehavior(in);
            play[i].setBounds(k, 455, 55, 55);
            play[i].setName("炮2" + i);
        }
        in = new ImageIcon("image/红将.gif");
        play[31] = new ChessManBehavior(in);
        play[31].setBounds(252, 569, 55, 55);
        play[31].setName("将2");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(anew)) {
            System.out.println("新游戏");
            chessReset();
        }
        if (e.getSource().equals(repent)) {
            if (regretList.isEmpty() == false) {
                System.out.println("悔棋");
                ChessRegret chessRegret = regretList.get(regretList.size() - 1);
                Man = chessRegret.man;
                play[Man].setBounds(chessRegret.cx, chessRegret.cy, 55, 55);
                if (chessRegret.eatMan != -1) {
                    play[chessRegret.eatMan].setVisible(true);
                }
                if (play[Man].getName().charAt(1) == '2') {
                    chessplayClick = 2;
                    text.setText("    红棋走棋");
                } else {
                    chessplayClick = 1;
                    text.setText("    黑棋走棋");
                }
                regretList.clear();
            }else {
                System.out.println("只能悔棋一次哦");
            }
        }
        if (e.getSource().equals(exit)) {
            int j = JOptionPane.showConfirmDialog(this, "下次一定再来哟？", "退出", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (j == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int ex = 0;
        int ey = 0;
        if (tmain == null) {
            tmain = new Thread(this);
            tmain.start();
        }
        out:if (e.getSource().equals(image)) {
            if (chessplayClick == 2 && play[Man].getName().charAt(1) == '2') {
                ex = play[Man].getX();
                ey = play[Man].getY();
                if (Man >= 0 && Man < 4) {
                    System.out.println("移动红车");
                    chessRule.carRule(play[Man], play, e, regretList, Man);
                    chessRule.preview12(play[Man],play);
                }
                if (Man >= 4 && Man < 8) {
                    System.out.println("移动红马");
                    chessRule.horseRule(play[Man], play, e, regretList, Man);
                    chessRule.preview14(play[Man],play);
                }
                if (Man >= 8 && Man < 12) {
                    System.out.println("移动红象");
                    chessRule.elephantRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 12 && Man < 16) {
                    System.out.println("移动红士");
                    chessRule.chapRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 16 && Man < 26) {
                    System.out.println("移动红兵");
                    chessRule.soliderRule(play[Man], play, e, regretList, Man);
                    chessRule.preview11(play[Man],play);
                }
                if (Man >= 26 && Man < 30) {
                    System.out.println("移动红炮");
                    chessRule.cannonRule(play[Man], play, e, regretList, Man);
                    chessRule.preview13(play[Man],play);
                }
                if (Man == 30 || Man == 31) {
                    System.out.println("移动红帅");
                    chessRule.masterRule(play[Man], play, e, regretList, Man);
                }
                if (ex == play[Man].getX() && ey == play[Man].getY()) {
                    text.setText("     红棋走棋");
                    chessplayClick = 2;
                } else{
                    if (chessRule.masterMeet(play) == 1 ) {
                        text.setText("游戏结束,黑棋胜利！");
                        Object[] options = {"重新开始","退出"};
                        int op = JOptionPane.showOptionDialog(this, "游戏结束，黑棋胜利！","1",JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, null, options, options[0]);
                        if(op == JOptionPane.YES_OPTION){
                            System.out.println("新游戏");
                            chessReset();
                            repent.setEnabled(true);
                            chessManClick = false;
                            break out;
                        }
                        else if(op == JOptionPane.NO_OPTION){
                            System.exit(0);
                        }
                    }
                    text.setText("     黑棋走棋");
                    chessplayClick = 1;
                    chessManClick = false;
                }
            }
            else if (chessplayClick == 1 && play[Man].getName().charAt(1) == '1') {
                ex = play[Man].getX();
                ey = play[Man].getY();
                if (Man >= 0 && Man < 4) {
                    System.out.println("移动黑车");
                    chessRule.carRule(play[Man], play, e, regretList, Man);
                    chessRule.preview2(play[Man],play);
                }
                if (Man >= 4 && Man < 8) {
                    System.out.println("移动黑马");
                    chessRule.horseRule(play[Man], play, e, regretList, Man);
                    chessRule.preview4(play[Man],play);
                }
                if (Man >= 8 && Man < 12) {
                    System.out.println("移动黑象");
                    chessRule.elephantRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 12 && Man <= 15) {
                    System.out.println("移动黑士");
                    chessRule.chapRule(play[Man], play, e, regretList, Man);
                }
                if (Man >= 16 && Man < 26) {
                    System.out.println("移动黑兵");
                    chessRule.soliderRule(play[Man], play, e, regretList, Man);
                    chessRule.preview1(play[Man],play);
                }
                if (Man >= 26 && Man < 30) {
                    System.out.println("移动黑炮");
                    chessRule.cannonRule(play[Man], play, e, regretList, Man);
                    chessRule.preview3(play[Man],play);
                }
                if (Man == 30 || Man == 31) {
                    System.out.println("移动黑将");
                    chessRule.masterRule(play[Man], play, e, regretList, Man);
                }
                if (ex == play[Man].getX() && ey == play[Man].getY()) {
                    text.setText("     黑棋走棋");
                    chessplayClick = 1;
                } else{
                    if (chessRule.masterMeet(play) == 1) {
                        text.setText("游戏结束，红棋胜利！");
                        Object[] options = {"重新开始","退出"};
                        int op = JOptionPane.showOptionDialog(this, "游戏结束，红棋胜利！","1",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        if(op == JOptionPane.YES_OPTION){
                            System.out.println("新游戏");
                            chessReset();
                            repent.setEnabled(true);
                            chessManClick = false;
                            break out;
                        }
                        else if(op == JOptionPane.NO_OPTION){
                            System.exit(0);
                        }
                    }
                    text.setText("     红棋走棋");
                    chessplayClick = 2;
                    chessManClick = false;
                }
            }

        }
        else {
            int iClick = -1;
            for (int i = 0; i < 32; ++i) {
                if (e.getSource().equals(play[i])) {
                    iClick = i;
                    break;
                }
            }
            if (chessplayClick == 2) {
                int preX=1;
                int preY=-1;
                if (play[iClick].getName().charAt(1) == '2') {
                    Man = iClick;
                    preX=play[Man].getX();
                    preY=play[Man].getY();
                    chessManClick = true;
                    return;
                }
                int judge = play[Man].getName().charAt(1) - '0';
                if (play[iClick].getName().charAt(1) == '1' && judge == 2) {
                    if (Man >= 0 && Man < 4) {
                        System.out.println("车吃子判断");
                        chessRule.carEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview12(play[Man],play);
                    }
                    if (Man >= 4 && Man < 8) {
                        System.out.println("马吃子判断");
                        chessRule.horsEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview14(play[Man],play);
                    }
                    if (Man >= 8 && Man < 12) {
                        System.out.println("象吃子判断");
                        chessRule.elephantEat(play[Man], play, e,play[iClick], regretList, Man, iClick);

                    }
                    if (Man >= 12 && Man < 16) {
                        System.out.println("士吃子判断");
                        chessRule.chapEat(play[Man], play, play[iClick], regretList, Man, iClick);
                    }
                    if (Man >= 16 && Man < 26) {
                        System.out.println("兵吃子判断");
                        chessRule.soliderEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview11(play[Man],play);
                    }
                    if (Man >= 25 && Man < 30) {
                        System.out.println("炮吃子判断");
                        chessRule.cannonEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview13(play[Man],play);
                    }
                    if (Man == 30 || Man == 31) {
                        System.out.println("帅将吃子判断");
                        chessRule.masterEat(play[Man], play, play[iClick], regretList, Man, iClick);
                    }
                    if (play[iClick].getX() == play[Man].getX() && play[iClick].getY() == play[Man].getY()) {
                        if (chessRule.masterMeet(play) == 1) {
                            text.setText("游戏结束，黑棋胜利！");
                            Object[] options = {"重新开始","退出"};
                            int op = JOptionPane.showOptionDialog(this, "游戏结束，黑棋胜利！","1",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if(op == JOptionPane.YES_OPTION){
                                System.out.println("新游戏");
                                chessReset();
                                repent.setEnabled(true);
                                chessManClick = false;
                                break out;
                            }
                            else if(op == JOptionPane.NO_OPTION){
                                System.exit(0);
                            }
                        }
                        if (play[30].isVisible() == false) {
                            text.setText("游戏结束，红棋胜利！");
                            Object[] options = {"重新开始","退出"};
                            int op = JOptionPane.showOptionDialog(this, "游戏结束，红棋胜利！","1",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if(op == JOptionPane.YES_OPTION){
                                System.out.println("新游戏");
                                chessReset();
                                repent.setEnabled(true);
                                chessManClick = false;
                                break out;
                            }
                            else if(op == JOptionPane.NO_OPTION){
                                System.exit(0);
                            }
                        }
                        chessplayClick = 1;
                        text.setText("     黑棋走棋");
                        chessManClick = false;
                    }
                }
            }
            else if (chessplayClick == 1) {
                if (play[iClick].getName().charAt(1) == '1') {
                    Man = iClick;
                    chessManClick = true;
                    return;
                }
                int judge = play[Man].getName().charAt(1) - '0';
                if (play[iClick].getName().charAt(1) == '2' && judge == 1) {
                    if (Man >= 0 && Man < 4) {
                        System.out.println("车吃子判断");
                        chessRule.carEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview2(play[Man],play);
                    }
                    if (Man >= 4 && Man < 8) {
                        System.out.println("马吃子判断");
                        chessRule.horsEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview4(play[Man],play);
                    }
                    if (Man >= 8 && Man < 12) {
                        System.out.println("象吃子判断");
                        chessRule.elephantEat(play[Man], play, e, play[iClick], regretList, Man, iClick);
                    }
                    if (Man >= 12 && Man < 16) {
                        System.out.println("士吃子判断");
                        chessRule.chapEat(play[Man], play, play[iClick], regretList, Man, iClick);
                    }
                    if (Man >= 16 && Man < 26) {
                        System.out.println("兵吃子判断");
                        chessRule.soliderEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview1(play[Man],play);
                    }
                    if (Man >= 25 && Man < 30) {
                        System.out.println("炮吃子判断");
                        chessRule.cannonEat(play[Man], play, play[iClick], regretList, Man, iClick);
                        chessRule.preview3(play[Man],play);

                    }
                    if (Man == 30 || Man == 31) {
                        System.out.println("帅将吃子判断");
                        chessRule.masterEat(play[Man], play, play[iClick], regretList, Man, iClick);
                    }
                    if (play[iClick].getX() == play[Man].getX() && play[iClick].getY() == play[Man].getY()) {
                        if (chessRule.masterMeet(play) == 1) {
                            text.setText("游戏结束，红棋胜利！");
                            Object[] options = {"重新开始","退出"};
                            int op = JOptionPane.showOptionDialog(this, "游戏结束，红棋胜利！","1",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if(op == JOptionPane.YES_OPTION){
                                System.out.println("新游戏");
                                chessReset();
                                repent.setEnabled(true);
                                chessManClick = false;
                                break out;
                            }
                            else if(op == JOptionPane.NO_OPTION){
                                System.exit(0);
                            }
                        }
                        if (play[31].isVisible() == false) {
                            text.setText("游戏结束，黑棋胜利！");
                            Object[] options = {"重新开始","退出"};
                            int op = JOptionPane.showOptionDialog(this, "游戏结束，黑棋胜利！","1",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if(op == JOptionPane.YES_OPTION){
                                System.out.println("新游戏");
                                chessReset();
                                repent.setEnabled(true);
                                chessManClick = false;
                                break out;
                            }
                            else if(op == JOptionPane.NO_OPTION){
                                System.exit(0);
                            }
                        }
                        chessplayClick = 2;
                        text.setText("     红棋走棋");
                        chessManClick = false;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            if (play[32].isVisible()){
                try {
                    tmain.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                play[32].setVisible(false);
            }
            if (play[33].isVisible()){
                try {
                    tmain.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                play[33].setVisible(false);
            }
            if (chessManClick) {
                play[Man].setVisible(false);
                try {
                    tmain.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                play[Man].setVisible(true);
                for (int i = 0; i < 32; i++) {
                    if (i != Man && play[i].died == false)
                        play[i].setVisible(true);
                }
            } else {
                text.setVisible(false);
                try {
                    tmain.sleep(250);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                text.setVisible(true);
            }
            try {
                tmain.sleep(350);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
