package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main implements ActionListener {

    JFrame frame;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    JPanel enemyMainPanel;
    JPanel enemyLeftPanel;
    JLabel enemyStatusLabel;
    JPanel enemyHpPanel;
    JPanel enemyHpRemainingPanel;
    JPanel enemyHpDamagedPanel;
    JLabel enemyRightLabel;

    JPanel playerMainPanel;
    JLabel playerLeftLabel;
    JPanel playerRightPanel;
    JPanel playerMarginPanel;
    JLabel playerStatusLabel;
    JPanel playerHpPanel;
    JPanel playerHpRemainingPanel;
    JPanel playerHpDamagedPanel;

    JPanel consolePanel;
    JPanel technicalPanel;
    JLabel messageLabel;

    int eventStatus = 0;
    int enemyDamagedCount = 0;
    int playerDamagedCount = 0;

    public static void main(String[] args) throws URISyntaxException {
        new Main();
    }

    public Main() throws URISyntaxException {
        frame = new JFrame("ポケモン");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        menuBar = new JMenuBar();
        menu = new JMenu("設定");
        menuItem = new JMenuItem("初期化");
        menuItem.addActionListener(this);
        menuItem.setActionCommand("初期化");
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        enemyMainPanel = new JPanel();
        enemyMainPanel.setLayout(new GridLayout(1, 2));
        enemyMainPanel.setBackground(Color.WHITE);

        enemyLeftPanel = new JPanel();
        enemyLeftPanel.setLayout(new GridLayout(4, 1));
        enemyLeftPanel.setOpaque(false);

        enemyStatusLabel = new JLabel("いぬ LV:100 やけど");
        enemyStatusLabel.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 40));
        enemyStatusLabel.setHorizontalAlignment(JLabel.CENTER);

        enemyHpPanel = new JPanel();
        enemyHpPanel.setOpaque(false);

        enemyHpRemainingPanel = new JPanel();
        enemyHpRemainingPanel.setBackground(Color.GREEN);
        enemyHpRemainingPanel.setPreferredSize(new Dimension(450, 50));

        enemyHpDamagedPanel = new JPanel();
        enemyHpDamagedPanel.setBackground(Color.RED);
        enemyHpDamagedPanel.setPreferredSize(new Dimension(0, 50));

        enemyRightLabel = new JLabel(new ImageIcon(getPngPath() + "enemy.png"));
        enemyRightLabel.setOpaque(false);

        enemyHpPanel.add(enemyHpRemainingPanel);
        enemyHpPanel.add(enemyHpDamagedPanel);
        enemyLeftPanel.add(enemyStatusLabel);
        enemyLeftPanel.add(enemyHpPanel);
        enemyMainPanel.add(enemyLeftPanel);
        enemyMainPanel.add(enemyRightLabel);
        frame.add(enemyMainPanel);

        playerMainPanel = new JPanel();
        playerMainPanel.setLayout(new GridLayout(1, 2));
        playerMainPanel.setBackground(Color.WHITE);

        playerLeftLabel = new JLabel(new ImageIcon(getPngPath() + "player.png"));
        playerLeftLabel.setOpaque(false);

        playerRightPanel = new JPanel();
        playerRightPanel.setLayout(new GridLayout(4, 1));
        playerRightPanel.setOpaque(false);

        playerStatusLabel = new JLabel("ねこ LV:100 やけど");
        playerStatusLabel.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 40));
        playerStatusLabel.setHorizontalAlignment(JLabel.CENTER);

        playerHpPanel = new JPanel();
        playerHpPanel.setOpaque(false);

        playerHpRemainingPanel = new JPanel();
        playerHpRemainingPanel.setBackground(Color.GREEN);
        playerHpRemainingPanel.setPreferredSize(new Dimension(450, 50));

        playerHpDamagedPanel = new JPanel();
        playerHpDamagedPanel.setBackground(Color.RED);
        playerHpDamagedPanel.setPreferredSize(new Dimension(0, 50));

        playerHpPanel.add(playerHpRemainingPanel);
        playerHpPanel.add(playerHpDamagedPanel);
        playerRightPanel.add(playerStatusLabel);
        playerRightPanel.add(playerHpPanel);
        playerMainPanel.add(playerLeftLabel);
        playerMainPanel.add(playerRightPanel);
        frame.add(playerMainPanel);

        consolePanel = new JPanel();
        consolePanel.setLayout(new GridLayout(1, 2));
        consolePanel.setBackground(Color.WHITE);
        technicalPanel = new JPanel();
        technicalPanel.setLayout(new GridLayout(2, 2));

        JButton technicalButton1 = new JButton("かえんほうしゃ");
        JButton technicalButton2 = new JButton("なみのり");
        JButton technicalButton3 = new JButton("10まんボルト");
        JButton technicalButton4 = new JButton("サイコキネシス");
        technicalButton1.setPreferredSize(new Dimension(200, 100));
        technicalButton2.setPreferredSize(new Dimension(200, 100));
        technicalButton3.setPreferredSize(new Dimension(200, 100));
        technicalButton4.setPreferredSize(new Dimension(200, 100));
        technicalButton1.addActionListener(this);
        technicalButton2.addActionListener(this);
        technicalButton3.addActionListener(this);
        technicalButton4.addActionListener(this);
        technicalButton1.setActionCommand("button1");
        technicalButton2.setActionCommand("button2");
        technicalButton3.setActionCommand("button3");
        technicalButton4.setActionCommand("button4");
        technicalButton1.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
        technicalButton2.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
        technicalButton3.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
        technicalButton4.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
        technicalButton1.setBackground(Color.WHITE);
        technicalButton2.setBackground(Color.WHITE);
        technicalButton3.setBackground(Color.WHITE);
        technicalButton4.setBackground(Color.WHITE);

        messageLabel = new JLabel("いぬがあらわれた！");
        messageLabel.setBorder(new LineBorder(Color.BLACK, 5, false));
        messageLabel.setHorizontalAlignment(JLabel.LEFT);
        messageLabel.setVerticalAlignment(JLabel.TOP);
        messageLabel.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 40));
        messageLabel.setOpaque(false);

        technicalPanel.add(technicalButton1);
        technicalPanel.add(technicalButton2);
        technicalPanel.add(technicalButton3);
        technicalPanel.add(technicalButton4);
        consolePanel.add(technicalPanel);
        consolePanel.add(messageLabel);
        frame.add(consolePanel);

        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        eventStatus++;

        int damage = 0;
        if (e.getActionCommand().equals("button1")) {
            damage = 200;
        } else if (e.getActionCommand().equals("button2")) {
            damage = 100;
        } else if (e.getActionCommand().equals("button3")) {
            damage = 50;
        } else if (e.getActionCommand().equals("button4")) {
            damage = 25;
        } else if (e.getActionCommand().equals("初期化")) {
            eventStatus = 0;
            enemyDamagedCount = 0;
            playerDamagedCount = 0;
            enemyHpPanel.remove(enemyHpRemainingPanel);
            enemyHpPanel.remove(enemyHpDamagedPanel);
            playerHpPanel.remove(playerHpRemainingPanel);
            playerHpPanel.remove(playerHpDamagedPanel);
            enemyHpRemainingPanel.setPreferredSize(new Dimension(450, 50));
            enemyHpDamagedPanel.setPreferredSize(new Dimension(0, 50));
            playerHpRemainingPanel.setPreferredSize(new Dimension(450, 50));
            playerHpDamagedPanel.setPreferredSize(new Dimension(0, 50));
            enemyHpPanel.add(enemyHpRemainingPanel);
            enemyHpPanel.add(enemyHpDamagedPanel);
            playerHpPanel.add(playerHpRemainingPanel);
            playerHpPanel.add(playerHpDamagedPanel);
            enemyRightLabel.setVisible(true);
            playerLeftLabel.setVisible(true);
            messageLabel.setText("いぬがあらわれた！");
        }

        if (eventStatus == 1) {
            messageLabel.setText("ねこはどうする？");
        } else if (eventStatus == 2) {
            messageLabel.setText("ねこのこうげき！");
            Toolkit.getDefaultToolkit().beep();
            if (enemyDamagedCount + damage < 450) {
                enemyDamagedCount += damage;
            } else {
                enemyDamagedCount = 450;
            }
            enemyHpPanel.remove(enemyHpRemainingPanel);
            enemyHpPanel.remove(enemyHpDamagedPanel);
            enemyHpRemainingPanel.setPreferredSize(new Dimension(450 - enemyDamagedCount, 50));
            enemyHpDamagedPanel.setPreferredSize(new Dimension(enemyDamagedCount, 50));
            enemyHpPanel.add(enemyHpRemainingPanel);
            enemyHpPanel.add(enemyHpDamagedPanel);
            if (enemyDamagedCount == 450) {
                messageLabel.setText("いぬをたおした！");
                enemyRightLabel.setVisible(false);
                eventStatus = 4;
            }
        } else if (eventStatus == 3) {
            messageLabel.setText("いぬのこうげき！");
            Toolkit.getDefaultToolkit().beep();
            if (playerDamagedCount + damage < 450) {
                playerDamagedCount += damage;
            } else {
                playerDamagedCount = 450;
            }
            playerHpPanel.remove(playerHpRemainingPanel);
            playerHpPanel.remove(playerHpDamagedPanel);
            playerHpRemainingPanel.setPreferredSize(new Dimension(450 - playerDamagedCount, 50));
            playerHpDamagedPanel.setPreferredSize(new Dimension(playerDamagedCount, 50));
            playerHpPanel.add(playerHpRemainingPanel);
            playerHpPanel.add(playerHpDamagedPanel);
            if (playerDamagedCount == 450) {
                messageLabel.setText("ねこはたおれた！");
                playerLeftLabel.setVisible(false);
                eventStatus = 4;
            } else {
                eventStatus = 0;
            }
        }
    }

    private String getPngPath() throws URISyntaxException {
        String a = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).toString();
        return a.substring(0, a.lastIndexOf("\\")) + "\\png\\" ;
    }

}
