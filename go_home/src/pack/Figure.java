
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Figure extends MainClass{
    // private static ImageIcon _1= new ImageIcon("go_home\\lib\\blue_1.png");
    private static ImageIcon _1= new ImageIcon("go_home\\lib\\transparent\\blue_1.png");
    private static ImageIcon _2= new ImageIcon("go_home\\lib\\transparent\\blue_2.png");
    private static ImageIcon _3= new ImageIcon("go_home\\lib\\transparent\\red_1.png");
    private static ImageIcon _4= new ImageIcon("go_home\\lib\\transparent\\red_2.png");
    private ImageIcon transparent;
    private Player player;
    private String colour;
    private Cell cell;
    private Field field;
    private JLabel label;
    private int index;
    public Figure(Player p,String col, Cell c,Field f, int i)
    {
        player=p;
        colour=col;
        cell=c;
        field=f;
        index=i;
        if (index==1) 
        {
            System.out.println("seted for 1");
            label=new JLabel();
            transparent=new ImageIcon("go_home\\lib\\transparent\\blue_1.png");
            label.setIcon(_1);
        }
        else if (index==2)
        {
            System.out.println("seted for 2");
            label=new JLabel();
            transparent=new ImageIcon("go_home\\lib\\transparent\\blue_2.png");
            label.setIcon(_2);
        }
        else if (index==3)
        {
            System.out.println("seted for 3");
            label=new JLabel();
            transparent=new ImageIcon("go_home\\lib\\transparent\\red_1.png");
            label.setIcon(_3);
        }
        else
        {
            System.out.println("seted for 4");
            label=new JLabel();
            transparent=new ImageIcon("go_home\\lib\\transparent\\red_2.png");
            label.setIcon(_4);
        }
        cell.setFigure(this);
    }
    public void moveFigure(int x,int y)
    {
        if(x>4)
        {
            x=0;
        }
        if(x<0)
        {
            x=4;
        }
        if(y<0)
        {
            y=4;
        }
        if(y>4)
        {
            y=0;
        }
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
    public ImageIcon getTransparent()
    {
        return transparent;
    }
    public boolean getWin()
    {
        if(this.cell.getArrX()==2&&this.cell.getArrY()==2)
        {
            return true;
        }
        return false;
    }
    public Player getPlayer()
    {
        return player;
    }
    public int getIndex()
    {
        return index;
    }
}