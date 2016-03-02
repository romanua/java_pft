import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.Point;

/**
 * Created by roman on 02.03.2016.
 */
public class DistanceTest {

    @Test
    public void testDistance() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(5, 7);
        assert p1.distance(p1,p2) == 24;
    }
}
