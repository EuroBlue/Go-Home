package pack;

public class Field {
    private Cell[] x;
    private Cell[] y;
    private Cell[][] xy=new Cell[5][5];;
    private Game game;
    public Field(Game _game) 
    {
        game=_game;
        for (byte y = 0; y < 5; y++) {
            for (byte x = 0; x < 5; x++) {
                xy[y][x]= new Cell(this, 51+(80*x),52+(80*y),x,y);
            }
        }
    }
    public Cell[][] getCells()
    {
        return xy;
    }
    
}
