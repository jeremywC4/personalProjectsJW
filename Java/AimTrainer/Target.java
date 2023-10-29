import javax.swing.*;
import java.awt.event.*;
class Target extends JLabel {
  double x = 100; 
  double y = 100;
  int length = 50;
  
  public Target(){
    this.x = (int)(Math.random()*550);
    this.y = (int)(Math.random()*550);
  }
  
  public Target(double x, double y, int length){
    this.length = length;
    this.x = x;
    this.y = y;
    System.out.println("New Target - Mid: " + x + ", " + y + " length: " + length);
  }
  
  public int getLength(){
    return length;
  }
  public void setLength(int i){
    length = i;
  }

  public void setXY(double x, double y){
    this.x = x;
    this.y = y;
  }
  public void setX(double x){
    this.x = x;
  }
  public void setY(double x){
    this.y = x;
  }
  public double getXPOS(){
    return x;
  }

  public double getYPOS(){
    return y;
  }
  
}

