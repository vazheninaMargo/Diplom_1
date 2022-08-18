package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void setBuns() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int indexOfIngredient = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(indexOfIngredient);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredientFirst = Mockito.mock(Ingredient.class);
        Ingredient ingredientSecond = Mockito.mock(Ingredient.class);
        Ingredient ingredientThird = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        int indexOfThirdIngredient = burger.ingredients.indexOf(ingredientThird);

        burger.moveIngredient(indexOfThirdIngredient, 0);
        Assert.assertEquals(0, burger.ingredients.indexOf(ingredientThird));
    }

    @Test
    public void getPrice() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredientFirst = Mockito.mock(Ingredient.class);
        Ingredient ingredientSecond = Mockito.mock(Ingredient.class);
        Ingredient ingredientThird = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);

        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(5f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(20.4f);
        Mockito.when(ingredientThird.getPrice()).thenReturn(7.5f);

        // 10 * 2 + 5 + 20.4 + 7.5 = 25 + 27.9 = 52.9
        float actual = burger.getPrice();
        Assert.assertEquals(52.9f, actual, 0);
    }

    @Test
    public void getReceipt() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredientFirst = Mockito.mock(Ingredient.class);
        Ingredient ingredientSecond = Mockito.mock(Ingredient.class);
        Ingredient ingredientThird = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);

        // 10 * 2 + 5 + 20.4 + 7.5 = 25 + 27.9 = 52.9
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(5f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(20.4f);
        Mockito.when(ingredientThird.getPrice()).thenReturn(7.5f);

        Mockito.when(bun.getName()).thenReturn("Ржаная");
        Mockito.when(ingredientFirst.getName()).thenReturn("BBQ");
        Mockito.when(ingredientSecond.getName()).thenReturn("Котлета мясная");
        Mockito.when(ingredientThird.getName()).thenReturn("Сыр");

        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientThird.getType()).thenReturn(IngredientType.FILLING);

        String expected = "(==== Ржаная ====)\n" +
                "= sauce BBQ =\n" +
                "= filling Котлета мясная =\n" +
                "= filling Сыр =\n" +
                "(==== Ржаная ====)\n\n" +
                "Price: 52,900002\n";

        String actual = burger.getReceipt();

        Assert.assertEquals(expected, actual);
    }
}