import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTests {
    private final String name;
    private final float price;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Обычная", 8f },
                { "Ржаная", 10f },
                { "Сырная", 30.5f }
        };
    }

    @Test
    public void checkName() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void checkPrice() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        Assert.assertEquals(price, actual, 0);
    }
}