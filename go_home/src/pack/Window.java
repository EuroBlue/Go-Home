package pack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.xml.namespace.QName;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Window implements ActionListener,KeyListener {
    public static boolean playing=false;
    public static JFrame window;
    private static JPanel windowPanel;
	public static JLabel header;
    public static JLabel back;
    private static ImageIcon header_img=new ImageIcon("go_home\\lib\\header.png");
    private static ImageIcon play=new ImageIcon("go_home\\lib\\play.png");
    private static ImageIcon backIcon=new ImageIcon("go_home\\lib\\background.png");

    private static JButton start;

	private static JLabel question;
    private static JButton random;
    private static ImageIcon randIcon=new ImageIcon("go_home\\lib\\random.png");
    private static JButton blue;
    private static ImageIcon blueIcon=new ImageIcon("go_home\\lib\\blue.png");
    private static JButton red;
    private static ImageIcon redIcon=new ImageIcon("go_home\\lib\\red.png");

    private static JLabel fieldLabel;
    private static JLabel curFig_1;
    private static JLabel curFig_2;
    private static ImageIcon curFig=new ImageIcon("go_home\\lib\\current_figure.png");
    private static JLabel infoBlue;
    private static JLabel infoRed;
    private static ImageIcon fieldIcon=new ImageIcon("go_home\\lib\\field.png");
    private static Figure[] cur_Figures=new Figure[2];
    private static Game game;

    public static void start()
    {
        windowPanel=new JPanel();
		windowPanel.setLayout(null);
        windowPanel.setSize(740, 800);
        window=new JFrame("Go Home");

        window.addKeyListener(new Window());

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.add(windowPanel);
		window.setResizable(false);

        header=new JLabel();
        header.setForeground(new Color(0,0,0,50));
        header.setIcon(header_img);
		header.setBounds(0, 0, 800, 200);
		header.setVisible(true);
        windowPanel.addKeyListener(new Window());
		windowPanel.add(header);
		header.setVisible(true);

        start=new JButton();
        start.setIcon(play);
        cleanButton(start);
		start.setBounds(185, 300, 370, 80);
		windowPanel.add(start);
		start.addActionListener(new Window());
        start.addKeyListener(new Window());

        back=new JLabel();
        back.setIcon(backIcon);
		back.setBounds(0, 0, 740, 800);
		back.setVisible(true);
		windowPanel.add(back);
		back.setVisible(true);
        back.addKeyListener(new Window());



        window.setSize(740, 800);
		window.setLocationRelativeTo(null);
    }
    private static void gameOptions()
    {
        windowPanel.remove(start);
        windowPanel.remove(back);

        question=new JLabel("<html><font color='white'>Who will make the first move?</font></html>", SwingConstants.CENTER);
        question.setFont(new Font("Calibri", Font.PLAIN, 35));
		question.setBounds(145, 200, 450, 80);
		question.setVisible(true);
		windowPanel.add(question);
		question.setVisible(true);
        question.addKeyListener(new Window());

        random=new JButton();
        random.setIcon(randIcon);
        cleanButton(random);
		random.setBounds(185, 300, 370, 80);
		windowPanel.add(random);
		random.addActionListener(new Window());

        blue=new JButton();
        blue.setIcon(blueIcon);
        cleanButton(blue);
		blue.setBounds(185, 400, 370, 80);
		windowPanel.add(blue);
		blue.addActionListener(new Window());

        red=new JButton();
        red.setIcon(redIcon);
        cleanButton(red);
		red.setBounds(185, 500, 370, 80);
		windowPanel.add(red);
		red.addActionListener(new Window());

        back=new JLabel();
        back.setIcon(backIcon);
		back.setBounds(0, 0, 740, 800);
		back.setVisible(true);
		windowPanel.add(back);
		back.setVisible(true);
        back.addKeyListener(new Window());

        window.repaint();
    }
    private static void startGame(Game g)
    {
        game=g;
        playing=true;
        cur_Figures=g.getCurFig();
        windowPanel.remove(back);
        windowPanel.remove(question);
        windowPanel.remove(blue);
        windowPanel.remove(red);
        windowPanel.remove(random);
        windowPanel.addKeyListener(new Window());

        fieldLabel=new JLabel();
        fieldLabel.setIcon(fieldIcon);
		fieldLabel.setBounds(115, 200, 500, 500);
		fieldLabel.setVisible(true);
		windowPanel.add(fieldLabel);
		fieldLabel.setVisible(true);
        fieldLabel.addKeyListener(new Window());

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                g.getPlayers()[i].getFigures()[j].getLabel().setBounds(g.getPlayers()[i].getFigures()[j].getCell().getX(), g.getPlayers()[i].getFigures()[j].getCell().getY(), 77, 78);
                g.getPlayers()[i].getFigures()[j].getLabel().setVisible(true);
                fieldLabel.add(g.getPlayers()[i].getFigures()[j].getLabel());
            }
        }
        infoBlue=new JLabel("<html>B<br/>L<br/>U<br/>E</html>");
        infoBlue.setVerticalAlignment(JLabel.TOP);
        infoBlue.setHorizontalAlignment(JLabel.CENTER);
        infoBlue.setForeground(Color.WHITE);
        infoBlue.setFont(new Font("Calibri", Font.PLAIN, 75));
        infoBlue.setVisible(false);
        windowPanel.add(infoBlue);
        infoBlue.setBounds(10, 200, 100, 500);

        infoRed=new JLabel("<html>R<br/>E<br/>D</html>");
        infoRed.setVerticalAlignment(JLabel.TOP);
        infoRed.setHorizontalAlignment(JLabel.CENTER);
        infoRed.setForeground(Color.WHITE);
        infoRed.setFont(new Font("Calibri", Font.PLAIN, 100));
        infoRed.setVisible(false);
        windowPanel.add(infoRed);
        infoRed.setBounds(630, 200, 100, 500);


        if (g.getCurrentPlayer()==0) 
        {
            infoRed.setVisible(false);
            infoBlue.setVisible(true);
        } 
        else {
            infoBlue.setVisible(false);
            infoRed.setVisible(true);
        }
        
        curFig_1=new JLabel();
        curFig_1.setIcon(curFig);
        curFig_1.setBounds(g.getCurFig()[0].getCell().getX(),g.getCurFig()[0].getCell().getY(), 77, 78);
        curFig_1.setVisible(true);
        fieldLabel.add(curFig_1);
        curFig_1.setVisible(true);

        curFig_2=new JLabel();
        curFig_2.setIcon(curFig);
        curFig_2.setBounds(g.getCurFig()[1].getCell().getX(),g.getCurFig()[1].getCell().getY(), 77, 78);
        curFig_2.setVisible(true);
        fieldLabel.add(curFig_2);
        curFig_2.setVisible(true);

        back=new JLabel();
        back.setIcon(backIcon);
		back.setBounds(0, 0, 740, 800);
		back.setVisible(true);
		windowPanel.add(back);
		back.setVisible(true);

        fieldLabel.repaint();
        window.repaint();
    }
    public static void cleanButton(JButton play)
    {
        play.setBorderPainted(false); 
        play.setContentAreaFilled(false); 
        play.setFocusPainted(false); 
        play.setOpaque(false);
    }
    public void frame(Game g)
    {
        windowPanel.remove(back);
        windowPanel.remove(question);
        windowPanel.remove(blue);
        windowPanel.remove(red);
        windowPanel.remove(random);

        fieldLabel=new JLabel();
        fieldLabel.setIcon(fieldIcon);
		fieldLabel.setBounds(115, 200, 500, 500);
		fieldLabel.setVisible(true);
		windowPanel.add(fieldLabel);
		fieldLabel.setVisible(true);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                g.getPlayers()[i].getFigures()[j].getLabel().setBounds(g.getPlayers()[i].getFigures()[j].getCell().getX(), g.getPlayers()[i].getFigures()[j].getCell().getY(), 77, 78);
                g.getPlayers()[i].getFigures()[j].getLabel().setVisible(true);
                fieldLabel.add(g.getPlayers()[i].getFigures()[j].getLabel());
            }
        }
        infoBlue=new JLabel("<html>B<br/>L<br/>U<br/>E</html>");
        infoBlue.setVerticalAlignment(JLabel.TOP);
        infoBlue.setHorizontalAlignment(JLabel.CENTER);
        infoBlue.setForeground(Color.WHITE);
        infoBlue.setFont(new Font("Calibri", Font.PLAIN, 75));
        infoBlue.setVisible(false);
        windowPanel.add(infoBlue);
        infoBlue.setBounds(10, 200, 100, 500);

        infoRed=new JLabel("<html>R<br/>E<br/>D</html>");
        infoRed.setVerticalAlignment(JLabel.TOP);
        infoRed.setHorizontalAlignment(JLabel.CENTER);
        infoRed.setForeground(Color.WHITE);
        infoRed.setFont(new Font("Calibri", Font.PLAIN, 100));
        infoRed.setVisible(false);
        windowPanel.add(infoRed);
        infoRed.setBounds(630, 200, 100, 500);


        if (g.getCurrentPlayer()==0) 
        {
            infoRed.setVisible(false);
            infoBlue.setVisible(true);
        } 
        else {
            infoBlue.setVisible(false);
            infoRed.setVisible(true);
        }
        
        curFig_1=new JLabel();
        curFig_1.setIcon(curFig);
        curFig_1.setBounds(g.getCurFig()[0].getCell().getX(),g.getCurFig()[0].getCell().getY(), 77, 78);
        curFig_1.setVisible(true);
        fieldLabel.add(curFig_1);
        curFig_1.setVisible(true);

        curFig_2=new JLabel();
        curFig_2.setIcon(curFig);
        curFig_2.setBounds(g.getCurFig()[1].getCell().getX(),g.getCurFig()[1].getCell().getY(), 77, 78);
        curFig_2.setVisible(true);
        fieldLabel.add(curFig_2);
        curFig_2.setVisible(true);

        back=new JLabel();
        back.setIcon(backIcon);
		back.setBounds(0, 0, 740, 800);
		back.setVisible(true);
		windowPanel.add(back);
		back.setVisible(true);

        fieldLabel.repaint();
        window.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start)
        {
            gameOptions();
        }
        if(e.getSource()==random||e.getSource()==blue||e.getSource()==red)
        {
            byte first;
            if(e.getSource()==random)
            {
                first=-1;
            }
            else if(e.getSource()==blue)
            {
                first=0;
            }
            else
            {
                first=1;
            }
            startGame(new Game(first));
        }
    }
    //this takes care of key events like
    @Override
    //key was typed
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("1");
    }

    @Override
    //key was pressed
    public void keyPressed(KeyEvent keyEvent) {
        //moving(keyEvent);
        System.out.println("2");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("3");
    }

    public static void moving(KeyEvent ke){
        String direction;
        //this could probaly be optimzed with just getting the right cordinats but meh ima do it like this makes more sens
        //todo add WASD Support
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT ) {
            //Right arrow key code
            direction = "right";
            System.out.println(direction);
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT ) {
            //Left arrow key code
            direction = "left";
            System.out.println(direction);
        } else if (ke.getKeyCode() == KeyEvent.VK_UP ) {
            //Up arrow key code
            direction = "up";
            System.out.println(direction);
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN ) {
            //Down arrow key code
            direction = "down";
            System.out.println(direction);
        }
}
}