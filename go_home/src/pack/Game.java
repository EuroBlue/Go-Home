package pack;

public class Game {
    private Field GameField;
    private Player[] players=new Player[2];
    private byte cur_player;
    private int[] cur_figure_1=new int[2];
    private int[] cur_figure_2=new int[2];
    private Figure[] currentFigures=new Figure[2];
    private boolean int_double;
    public Game(byte start)
    {
        GameField=new Field(this);
        int_double=false;
        players[0]=new Player(this,"Blue",GameField);
        players[1]=new Player(this,"Red",GameField);
        if (start==-1) 
        {
            if(MainClass.genRanInt(0,1)==0)
            {
                cur_player=0;
            }
            else
            {
                cur_player=1;
            }
        }
        else 
        {
            cur_player=start;
        }
        this.throwCubes();
    }
    public Field getField()
    {
        return GameField;
    }
    public Player[] getPlayers()
    {
        return players;
    }
    public int getCurrentPlayer()
    {
        return cur_player;
    }
    public void throwCubes()
    {
        for (int i = 0; i < 2; i++) {
            cur_figure_1[i]=MainClass.genRanInt(0,1);
        }
        for (int i = 0; i < 2; i++) {
            cur_figure_2[i]=MainClass.genRanInt(0,1);
        }
        currentFigures[0]=this.getPlayers()[cur_figure_1[0]].getFigures()[cur_figure_1[1]];
        currentFigures[1]=this.getPlayers()[cur_figure_2[0]].getFigures()[cur_figure_2[1]];
        if (cur_figure_1.equals(cur_figure_2))
        {
            int_double=true;
        }
        else
        {
            int_double=false;
        }
        if(cur_player==0)
        {
            cur_player=1;
        }
        else
        {
            cur_player=0;
        }
    }
    public boolean getDouble()
    {
        return int_double;
    }
    public Figure[] getCurFig()
    {
        return currentFigures;
    }
}