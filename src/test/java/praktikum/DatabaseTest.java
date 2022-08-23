package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

    Database database;

    @Before
    public void init() {
        database = new Database();
    }

    @Test
    public void availableBuns() {
        Assert.assertNotNull(database.availableBuns());
    }

    @Test
    public void availableIngredients() {
        Assert.assertNotNull(database.availableIngredients());
    }
}