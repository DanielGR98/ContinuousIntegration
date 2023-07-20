import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DiningManagerTest {

    @Test
    public void testCalculateTotalCost() {
        // Caso de prueba 1
        Map<String, Integer> selectedMeals1 = new HashMap<>();
        selectedMeals1.put("Dumplings", 3);
        selectedMeals1.put("Spaghetti", 3);
        double totalCost1 = DiningManager.calculateTotalCost(selectedMeals1);
        assertEquals(8.10, totalCost1, 0.001);

    }
}