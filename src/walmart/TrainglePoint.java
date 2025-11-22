package walmart;

public class TrainglePoint {

    static class Point{
        double x;
        double y;

        Point(double x, double y){
            this.x=x;
            this.y=y;
        }

    }

    public static double area(Point a,Point b,Point c){
        return Math.abs((a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y))/2.0);
    }

    public static boolean isInside(Point a, Point b, Point c, Point p){

        double areaABC=area(a,b,c);

        double areaPAB=area(p,a,b);

        double areaPBC=area(p,b,c);

        double areaPCA=area(p,c,a);

        return Math.abs(areaABC-(areaPBC+areaPAB+areaPCA))<1e-9;
    }

    public static void main(String[] args) {
        Point A = new Point(0, 0);
        Point B = new Point(5, 0);
        Point C = new Point(0, 5);

        Point P = new Point(2, 2); // Try changing this to test other points

        if (isInside(A, B, C, P)) {
            System.out.println("Point P is inside the triangle.");
        } else {
            System.out.println("Point P is outside the triangle.");
        }
    }
}
