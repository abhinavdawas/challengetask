package test;


import main.utils.CalculationLogic;
import static org.junit.Assert.*;
import org.junit.*;
import main.model.Item;
import java.math.*;

public class CalculationLogicTest {
    @Test
    public void testGetPrice(){
        Item item = new Item(1, "book",new BigDecimal(10), true, true);
        CalculationLogic calculationLogic = new CalculationLogic();
        assertEquals(new BigDecimal(10),calculationLogic.getPriceWithoutTax(item));
    }

    @Test
    public void getPriceWithTax(){
        Item item = new Item(1, "book",new BigDecimal(10), true, true);
        CalculationLogic calculationLogic = new CalculationLogic();
        assertEquals(new BigDecimal("10.50"),calculationLogic.getPriceWithTax(item));
    }


}
