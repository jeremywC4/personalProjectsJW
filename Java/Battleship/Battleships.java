import java.util.ArrayList;

public class Battleships {

  //variables for class battleship
  private String name;
  private int size;
  private int hitCount;
  private int row;
  private int column;
  private boolean horizontal;
  private ArrayList<String> coordinates = new ArrayList<String>();

  //constructor for class Battleship
  public Battleships(String name, int size, boolean horiz, int hitCount, int row, int column, ArrayList<String> coords){
    this.name = name;
    this.size = size;
    this.hitCount = hitCount;
    this.row = row;
    this.column = column;
    horizontal = horiz;
    coordinates = coords;
  }

  //accessors and mutators for class Battleship 
  public String getName(){
    return name;
  }
  
  public int getSize(){
    return size;
  }
  
  public int getRow(){
    return row;
  }

  public int getCol(){
    return column;
  }

  public void setRow(int row){
    this.row = row;
  }

  public void setCol(int col){
    column = col;
  }
  
  public boolean isHorizontal(){
    return horizontal;
  }

  public void setHorizontal(boolean h){
    horizontal = h;
  }

  public int getHitCount(){
    return hitCount;
  }

  public ArrayList<String> getCoords(){
    return coordinates;
  }

  //remove coordinates from ship's array
  public ArrayList<String> removeCoords(String s){
    coordinates.remove(s);
    return coordinates;
  }

  //adds coordinates to ship's array
  public void addCoords(String phloop){
    coordinates.add(phloop);
  }
}