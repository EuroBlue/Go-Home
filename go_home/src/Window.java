import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
    private static ImageIcon darkIcon=new ImageIcon("go_home\\lib\\dark.png");
    private static ImageIcon returnIcon=new ImageIcon("go_home\\lib\\return.png");
    private static Image windowIcon=new ImageIcon("go_home\\lib\\ico.png").getImage();
    private static JLabel curFigLabel;
    private static JButton return_b;

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
        window.setIconImage(windowIcon);

        header=new JLabel();
        header.setForeground(new Color(0,0,0,50));
        header.setIcon(header_img);
		header.setBounds(0, 0, 800, 200);
		header.setVisible(true);
		windowPanel.add(header);
		header.setVisible(true);

        start=new JButton();
        start.setIcon(play);
        cleanButton(start);
		start.setBounds(185, 300, 370, 80);
		windowPanel.add(start);
		start.addActionListener(new Window());

        back=new JLabel();
        back.setIcon(backIcon);
		back.setBounds(0, 0, 740, 800);
		back.setVisible(true);
		windowPanel.add(back);
		back.setVisible(true);



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


        window.requestFocus();
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

        curFigLabel=new JLabel(cur_Figures[0].getIndex()+"   "+cur_Figures[1].getIndex());
        curFigLabel.setBounds(0,700, 740, 100);
        curFigLabel.setVerticalAlignment(JLabel.TOP);
        curFigLabel.setHorizontalAlignment(JLabel.CENTER);
        curFigLabel.setForeground(Color.WHITE);
        curFigLabel.setFont(new Font("Calibri", Font.PLAIN, 75));
        curFigLabel.setVisible(true);
        windowPanel.add(curFigLabel);
        curFigLabel.setVisible(true);

        back=new JLabel();
        back.setIcon(backIcon);
		back.setBounds(0, 0, 740, 800);
		back.setVisible(true);
		windowPanel.add(back);
		back.setVisible(true);

        window.requestFocus();
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
    public static void frame(Game g)
    {
        if(!win())
        {
            g.throwCubes();
        }
        game=g;
        cur_Figures=g.getCurFig();
        windowPanel.addKeyListener(new Window());

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                g.getPlayers()[i].getFigures()[j].getLabel().setBounds(g.getPlayers()[i].getFigures()[j].getCell().getX(), g.getPlayers()[i].getFigures()[j].getCell().getY(), 77, 78);
                g.getPlayers()[i].getFigures()[j].getLabel().setVisible(true);
                fieldLabel.add(g.getPlayers()[i].getFigures()[j].getLabel());
            }
        }

        if (g.getCurrentPlayer()==0) 
        {
            infoRed.setVisible(false);
            infoBlue.setVisible(true);
        } 
        else {
            infoBlue.setVisible(false);
            infoRed.setVisible(true);
        }
        
        curFig_1.setBounds(g.getCurFig()[0].getCell().getX(),g.getCurFig()[0].getCell().getY(), 77, 78);
        curFig_2.setBounds(g.getCurFig()[1].getCell().getX(),g.getCurFig()[1].getCell().getY(), 77, 78);

        curFigLabel.setText(cur_Figures[0].getIndex()+"   "+cur_Figures[1].getIndex());

        window.requestFocus();
        fieldLabel.repaint();
        window.repaint();
        
    }
    public static boolean win()
    {
        String win_text="";
        Color fg=Color.BLACK;
        if ((cur_Figures[0].getWin()&&cur_Figures[1].getWin())&&cur_Figures[0].getPlayer()!=cur_Figures[1].getPlayer()) {
            win_text="Draw!";
            System.out.println(win_text);
            fg=Color.WHITE;
        }
        else if (cur_Figures[0].getWin()) {
            win_text=cur_Figures[0].getColour()+" Won!";
            System.out.println(win_text);
            fg=cur_Figures[0].getPlayer().getColor();
        }
        else if (cur_Figures[1].getWin()) {
            win_text=cur_Figures[1].getColour()+" Won!";
            System.out.println(win_text);
            fg=cur_Figures[1].getPlayer().getColor();
        }
        if (cur_Figures[0].getWin()||cur_Figures[1].getWin()) {
            playing=false;
            JLabel dark=new JLabel();
            dark.setIcon(darkIcon);
            dark.setBounds(0, 0, 740, 800);
            dark.setVisible(true);
            windowPanel.add(dark);
            dark.setVisible(true);

            return_b=new JButton();
            return_b.setIcon(returnIcon);
            cleanButton(return_b);
            return_b.setBounds(185, 300, 370, 80);
            return_b.addActionListener(new Window());

            JLabel congrats=new JLabel(win_text, SwingConstants.CENTER);
            congrats.setFont(new Font("Calibri", Font.PLAIN, 70));
            congrats.setForeground(fg);
            congrats.setBounds(145, 200, 450, 80);
            congrats.setVisible(true);
            congrats.setVisible(true);

            windowPanel.add(congrats);
            windowPanel.add(return_b);
            windowPanel.add(dark);
            windowPanel.add(curFigLabel);
            windowPanel.add(infoBlue);
            windowPanel.add(infoRed);
            windowPanel.add(fieldLabel);
            windowPanel.add(back);
            window.repaint();
            return true;
        }
        else
        {
            return false;
        }
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
                first=1;
            }
            else
            {
                first=0;
            }
            startGame(new Game(first));
        }
        if(e.getSource()==return_b)
        {
            window.dispose();
            start();
        }
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {;
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        moving(keyEvent);
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public static void moving(KeyEvent ke){
        if(playing)
        {
            String direction;
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT||ke.getKeyCode() == KeyEvent.VK_D) {
                direction = "right";
                System.out.println(direction);
                for (Figure figure : cur_Figures) {
                    figure.moveFigure(figure.getCell().getArrX()+1, figure.getCell().getArrY());
                }
                frame(game);
            } else if (ke.getKeyCode() == KeyEvent.VK_LEFT||ke.getKeyCode() == KeyEvent.VK_A) {
                direction = "left";
                System.out.println(direction);
                for (Figure figure : cur_Figures) {
                    figure.moveFigure(figure.getCell().getArrX()-1, figure.getCell().getArrY());
                }
                frame(game);
            } else if (ke.getKeyCode() == KeyEvent.VK_UP||ke.getKeyCode() == KeyEvent.VK_W ) {
                direction = "up";
                System.out.println(direction);
                for (Figure figure : cur_Figures) {
                    figure.moveFigure(figure.getCell().getArrX(), figure.getCell().getArrY()-1);
                }
                frame(game);
            } else if (ke.getKeyCode() == KeyEvent.VK_DOWN||ke.getKeyCode() == KeyEvent.VK_S) {
                direction = "down";
                System.out.println(direction);
                for (Figure figure : cur_Figures) {
                    figure.moveFigure(figure.getCell().getArrX(), figure.getCell().getArrY()+1);
                }
                frame(game);
            }
        }
    }
}