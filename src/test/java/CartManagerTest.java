import static org.junit.Assert.assertEquals;

public class CartManagerTest {

    @org.junit.jupiter.api.Test
    void purchaseAddition() {
        CartManager manager = new CartManager();
        PurchaseItem element = new PurchaseItem();
        manager.add(element);
        int expected = 1;
        int actual = manager.getArrayLenght();
        assertEquals(expected, actual);
    }
}