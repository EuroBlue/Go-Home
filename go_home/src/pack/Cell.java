package pack;
public class Cell {
    private int x;
    private int y;
    private int arr_x;
    private int arr_y;
    private Field field;
    private Figure[] figures=new Figure[4];
    public Cell(Field f, int cord_x, int cord_y, int arrX,int arrY)
    {
        x=cord_x;
        y=cord_y;
        field=f;
        arr_x=arrX;
        arr_y=arrY;
    }
    public void setFigure (Figure fig)
    {
        for (int i = 0; i < 4; i++) {
            if(figures[i]!=null)
            {
                figures[i]=fig;
                break;
            }
        }
    }
    public void removeFigure(Figure fig)
    {
        Figure[] ff=new Figure[4];
        byte c=0;
        for (Figure f : figures) {
            if(f!=null)
            {
                if(!f.equals(fig))
                {
                    ff[c]=f;
                    c++;
                }
            }
        figures=ff.clone();
        }

    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getArrX()
    {
        System.out.println(arr_x);
        return arr_x;
    }
    public int getArrY()
    {
        return arr_y;
    }
    public Figure[] getFigures()
    {
        return figures;
    }
}