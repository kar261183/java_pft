package ru.stqa.pft.sandbox;

public class Homework {

  public static void main(String[] args) {
    Point point1 = new Point(4, 10);
    Point point2 = new Point(8, 20);
    double val = distance(point1, point2);
    System.out.println("Расстояние между двумя точками: " + val);

    Point point3 = new Point(34, 10);
    Point point4 = new Point(3, 25);
    val = point3.distance(point4);
    System.out.println("Расстояние между двумя точками: " + val);
  }

  static double distance(Point p1, Point p2) {
    double x1 = p1.getX();
    double y1 = p1.getY();
    double x2 = p2.getX();
    double y2 = p2.getY();
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
