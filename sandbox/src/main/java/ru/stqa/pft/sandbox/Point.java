package ru.stqa.pft.sandbox;

public class Point {
  private double x;
  private double y;

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance(Point p1){
    double x1 = p1.getX();
    double y1 = p1.getY();
    double x2 = x;
    double y2 = y;
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

}
