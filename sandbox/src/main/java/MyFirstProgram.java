
public class MyFirstProgram {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(5, 7);

        System.out.println(distance(p1,p2));
        System.out.println(p1.distance(p1,p2));
    }
    //Function example
        public static double distance(Point p1, Point p2) {
            return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

}
