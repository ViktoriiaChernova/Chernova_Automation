import org.junit.Test;
import org.junit.Assert;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        Assert.assertTrue("getLocalNumber do not return 14",a == 14);
    }

    @Test
    public void testGetClassNumber()
    {
      int b = this.getClassNumber();
      Assert.assertTrue("getClassNumber do not return number>45",b > 45);
    }

    @Test
    public void testGetClassString()
    {
        String c = this.getClassString();
        if (c.contains("Hello") || c.contains("hello")) {
            System.out.println("test succeed");
        } else {
            Assert.fail( c + " does not contains Hello word");
        }
    }
}
