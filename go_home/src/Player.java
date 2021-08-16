import java.awt.Color;
public class Player extends MainClass{
    private Game game;
    private String colour;
    private Field field;
    private Color colour_int;
    private Figure[] figures=new Figure[2];
    public Player(Game _game,String _colour, Field f)
    {
        game=_game;
        field=f;
        colour=_colour;
        if (colour.equals("Blue"))
        {
            System.out.println("BLUE");
            colour_int=Color.BLUE;
            figures[0]=new Figure(this, colour, game.getField().getCells()[0][0],field,1);
            figures[1]=new Figure(this, colour, game.getField().getCells()[4][4],field,2);
        }
        else
        {
            System.out.println("RED");
            colour_int=Color.RED;
            figures[0]=new Figure(this, colour, game.getField().getCells()[4][0],field,3);
            figures[1]=new Figure(this, colour, game.getField().getCells()[0][4],field,4);
        }
    }
    
    /** 
     * @return Figure[]
     */
    public Figure[] getFigures()
    {
        return figures;
    }
    
    /** 
     * @return Color
     */
    public Color getColor()
    {
        return colour_int;
    }
}