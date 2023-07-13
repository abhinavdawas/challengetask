package test;

import main.utils.CalculationLogic;
import static org.junit.Assert.*;
import org.junit.*;
import main.model.Item;
import java.math.*;

public class CalculationLogicTest {
    @Test
    public void testGetPrice(){
        Item item = new Item("book",new BigDecimal(10), true, true);
        Item[] items = new Item[1];
        items[0] = item;
        CalculationLogic calculationLogic = new CalculationLogic(items);
        assertEquals(new BigDecimal(10),calculationLogic.getPrice(item));
    }

    @Test
    public void getPriceWithTax(){
        Item item = new Item("book",new BigDecimal(10), true, true);
        Item[] items = new Item[1];
        items[0] = item;
        CalculationLogic calculationLogic = new CalculationLogic(items);
        assertEquals(new BigDecimal("10.50"),calculationLogic.getPriceWithTax(item));
    }


}
