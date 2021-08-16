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
    
    /** 
     * @return Cell[][]
     */
    public Cell[][] getCells()
    {
        return xy;
    }
    
    /** 
     * @return Cell[]
     */
    public Cell[] getCellX()
    {
        return x;
    }
    
    /** 
     * @return Cell[]
     */
    public Cell[] getCellY()
    {
        return y;
    }
    
    /** 
     * @return Game
     */
    public Game getGame()
    {
        return game;
    }
    
}
