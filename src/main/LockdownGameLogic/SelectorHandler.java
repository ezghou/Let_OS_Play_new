package main.LockdownGameLogic;
import static main.LockdownGameLogic.Constants.*;

public class SelectorHandler {
    private int columnIndex;
    private int Xcenter, Ycenter;
    private int rx, ry;
    private boolean isClicked = false;
    public int cost;

    public SelectorHandler(int columnIndex){
        this.columnIndex = columnIndex;
        switch (columnIndex){
            case 0 -> cost = 50;
            case 1 -> cost = 100;
            case 2 -> cost = 75;
            default -> cost = 0;
        }
        setVariables();
    }

    public void setVariables(){
        Xcenter = selectorPaddingLeft + gridWidth/2;
        Ycenter = paddingTop + ((columnIndex * gridHeight) - (gridHeight/2));
        rx = selectorPaddingLeft;
        ry = paddingTop + (columnIndex * gridHeight);
    }


    public void setCollision(int px, int py){
        // above the bottom
        isClicked = px >= rx &&         // right of the left edge AND
                px <= rx + gridWidth &&    // left of the right edge AND
                py >= ry &&         // below the top AND
                py <= ry + gridHeight;
    }


    public void setCollision(boolean isClicked){
        this.isClicked = isClicked;
    }


    public int getXcenter() {
        return Xcenter;
    }

    public int getYcenter() {
        return Ycenter;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public boolean isClicked(){
        return isClicked;
    }

}
