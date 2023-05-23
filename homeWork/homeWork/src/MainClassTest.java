import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        Assert.assertTrue("getLocalNumber do not return 14",a == 14);
    }
}
