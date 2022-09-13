package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data: Type: {0}; Name: {1}; Price: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.FILLING, "Обычная", 8f},
                {IngredientType.SAUCE, "Ржаная", 10f},
                {IngredientType.SAUCE, "Сырная", 30.5f}
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        Assert.assertEquals(price, actual, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(type, actual);
    }
}