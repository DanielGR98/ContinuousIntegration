import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DiningManagerTest {

    @Test
    public void testCalculateTotalCost() {
        // Caso de prueba 1
        Map<String, Integer> selectedMeals1 = new HashMap<>();
        selectedMeals1.put("Spaghetti", 2);
        selectedMeals1.put("Pizza", 3);
        double totalCost1 = DiningManager.calculateTotalCost(selectedMeals1);
        assertEquals(61.94, totalCost1, 0.001);

        // Caso de prueba 2
        Map<String, Integer> selectedMeals2 = new HashMap<>();
        selectedMeals2.put("Dumplings", 8);
        selectedMeals2.put("Sushi", 6);
        double totalCost2 = DiningManager.calculateTotalCost(selectedMeals2);
        assertEquals(135.36, totalCost2, 0.001);

        
    }
}