import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by roman on 14.03.2016.
 */
public class PrimeTests {

    @Test
    public void testPrimes() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrimes() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
}
