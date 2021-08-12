package pack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Player extends MainClass{
    private Game game;
    private String colour;
    private Field field;
    private Figure[] figures=new Figure[2];
    public Player(Game _game,String _colour, Field f)
    {
        game=_game;
        field=f;
        colour=_colour;
        if (colour.equals("Blue"))
        {
            System.out.println("BLUE");
            figures[0]=new Figure(this, colour, game.getField().getCells()[0][0],field,1);
            figures[1]=new Figure(this, colour, game.getField().getCells()[4][4],field,2);
        }
        else
        {
            System.out.println("RED");
            figures[0]=new Figure(this, colour, game.getField().getCells()[4][0],field,3);
            figures[1]=new Figure(this, colour, game.getField().getCells()[0][4],field,4);
        }
    }
    public Figure[] getFigures()
    {
        return figures;
    }
}