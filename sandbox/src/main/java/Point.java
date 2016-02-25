/**
 * Created by roman on 23.02.2016.
 */
public class Point {
    public double x,y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    //object method to calculate distance between two points
    public double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }
}
