// 478 - Points in Figures: Rectangles, Circles, Triangles
// Points coinciding with a figure border are not considered inside.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    List<Figure> figs = new ArrayList<>();
    outer:
    while (true) {
      String s = sc.next();
      char c = s.charAt(0);
      switch (c) {
        case 'r':
          figs.add(Rectangle.create(sc));
          break;
        case 't':
          figs.add(Triangle.create(sc));
          break;
        case 'c':
          figs.add(Circle.create(sc));
          break;
        default:
          break outer;
      }
    }

    List<Point> points = new ArrayList<>();
    while (true) {
      double x = sc.nextDouble();
      double y = sc.nextDouble();
      if (x == 9999.9 && y == 9999.9) {
        break;
      }
      points.add(new Point(x, y));
    }

    for (int p = 0; p < points.size(); p++) {
      int count = 0;
      for (int f = 0; f < figs.size(); f++) {
        if (figs.get(f).contains(points.get(p))) {
          System.out.printf("Point %d is contained in figure %d%n", p + 1, f + 1);
          count++;
        }
      }
      if (count == 0) {
        System.out.printf("Point %d is not contained in any figure%n", p + 1);
      }
    }
  }
}

class Point {

  double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }

}

abstract class Figure {

  abstract boolean contains(Point p);
}

class Rectangle extends Figure {

  Point ul, lr;

  static Rectangle create(Scanner sc) {
    Rectangle rect = new Rectangle();
    rect.ul = new Point(sc.nextDouble(), sc.nextDouble());
    rect.lr = new Point(sc.nextDouble(), sc.nextDouble());
    return rect;
  }

  @Override
  boolean contains(Point p) {
//    return ul.x <= p.x && p.x <= lr.x && lr.y <= p.y && p.y <= ul.y;
    return ul.x < p.x && p.x < lr.x && lr.y < p.y && p.y < ul.y;
  }
}

class Triangle extends Figure {

  Point a, b, c;

  static Triangle create(Scanner sc) {
    Triangle tri = new Triangle();
    tri.a = new Point(sc.nextDouble(), sc.nextDouble());
    tri.b = new Point(sc.nextDouble(), sc.nextDouble());
    tri.c = new Point(sc.nextDouble(), sc.nextDouble());
    return tri;
  }

  private double sign(Point p1, Point p2, Point p3) {
    return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
  }

  @Override
  boolean contains(Point p) {
    boolean b1, b2, b3;

    double d1 = sign(p, a, b);
    double d2 = sign(p, b, c);
    double d3 = sign(p, c, a);

    // check not on the boundary
    final double epsilon = 0.00005;
    double crossproduct;
    crossproduct = (p.y - a.y) * (b.x - a.x) - (p.x - a.x) * (b.y - a.y);
    if (Math.abs(crossproduct) < epsilon) {
      return false;
    }
    crossproduct = (p.y - b.y) * (c.x - b.x) - (p.x - b.x) * (c.y - b.y);
    if (Math.abs(crossproduct) < epsilon) {
      return false;
    }
    crossproduct = (p.y - c.y) * (a.x - c.x) - (p.x - c.x) * (a.y - c.y);
    if (Math.abs(crossproduct) < epsilon) {
      return false;
    }

    b1 = d1 < 0.0;
    b2 = d2 < 0.0;
    b3 = d3 < 0.0;

    return (b1 == b2) && (b2 == b3);
  }
}

class Circle extends Figure {

  Point c;
  double r;

  static Circle create(Scanner sc) {
    Circle circle = new Circle();
    circle.c = new Point(sc.nextDouble(), sc.nextDouble());
    circle.r = sc.nextDouble();
    return circle;
  }

  @Override
  boolean contains(Point p) {
    double dist = (c.x - p.x) * (c.x - p.x) + (c.y - p.y) * (c.y - p.y);
//    return dist <= r * r;
    return dist < r * r;
  }
}
