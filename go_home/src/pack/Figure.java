package pack;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Figure extends MainClass{
    private static ImageIcon _1= new ImageIcon("go_home\\lib\\blue_1.png");
    private static ImageIcon _2= new ImageIcon("go_home\\lib\\blue_2.png");
    private static ImageIcon _3= new ImageIcon("go_home\\lib\\red_1.png");
    private static ImageIcon _4= new ImageIcon("go_home\\lib\\red_2.png");
    private Player player;
    private String colour;
    private Cell cell;
    private Field field;
    private JLabel label;
    public Figure(Player p,String col, Cell c,Field f, int i)
    {
        player=p;
        colour=col;
        cell=c;
        field=f;
        if (i==1) 
        {
            System.out.println("seted for 1");
            label=new JLabel();
            label.setIcon(_1);
        }
        else if (i==2)
        {
            System.out.println("seted for 2");
            label=new JLabel();
            label.setIcon(_2);
        }
        else if (i==3)
        {
            System.out.println("seted for 3");
            label=new JLabel();
            label.setIcon(_3);
        }
        else
        {
            System.out.println("seted for 4");
            label=new JLabel();
            label.setIcon(_4);
        }
        cell.setFigure(this);
    }
    public void moveFigure(int x,int y)
    {
        cell.removeFigure(this);
        field.getCells()[y][x].setFigure(this);
        cell=field.getCells()[y][x];
    }
    public JLabel getLabel()
    {
        return label;
    }
    public Cell getCell()
    {
        return cell;
    }
    public String getColour()
    {
        return colour;
    }
}