import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DiningManagerTest {

	@Test
    public void testCalculateTotalCostWithoutDiscounts() {
        // Caso de prueba 1: Verificar el costo total sin descuentos
        Map<String, Integer> selectedMeals1 = new HashMap<>();
        selectedMeals1.put("Spaghetti", 2);
        selectedMeals1.put("Pizza", 1);
        double totalCost1 = DiningManager.calculateTotalCost(selectedMeals1);
        assertEquals(7.0, totalCost1, 0.001);
    }

    @Test
    public void testCalculateTotalCostDiscount10Percent() {
        // Caso de prueba 2: Verificar el descuento del 10% con más de 5 comidas
        Map<String, Integer> selectedMeals2 = new HashMap<>();
        selectedMeals2.put("Dumplings", 3);
        selectedMeals2.put("Spaghetti", 3);
        double totalCost2 = DiningManager.calculateTotalCost(selectedMeals2);
        assertEquals(8.1, totalCost2, 0.001);
    }

    @Test
    public void testCalculateTotalCostDiscount20Percent() {
        // Caso de prueba 3: Verificar el descuento del 20% con más de 10 comidas
        Map<String, Integer> selectedMeals3 = new HashMap<>();
        selectedMeals3.put("Sushi", 6);
        selectedMeals3.put("Cake", 5);
        double totalCost3 = DiningManager.calculateTotalCost(selectedMeals3);
        assertEquals(22.4, totalCost3, 0.001);
    }

    @Test
    public void testCalculateTotalCostSpecialOfferDiscount() {
        // Caso de prueba 4: Verificar el descuento especial de $25
        Map<String, Integer> selectedMeals4 = new HashMap<>();
        selectedMeals4.put("Dumplings", 4);
        selectedMeals4.put("Sushi", 3);
        double totalCost4 = DiningManager.calculateTotalCost(selectedMeals4);
        assertEquals(11.7, totalCost4, 0.001);
    }

    @Test
    public void testCalculateTotalCostSpecialMealCategorySurcharge() {
        // Caso de prueba 5: Verificar el recargo del 5% en comidas especiales
        Map<String, Integer> selectedMeals5 = new HashMap<>();
        selectedMeals5.put("Chef's Special", 2);
        double totalCost5 = DiningManager.calculateTotalCost(selectedMeals5);
        assertEquals(10.5, totalCost5, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTotalCostInvalidQuantity() {
        // Caso de prueba 6: Verificar el manejo de cantidades inválidas (negativas)
        Map<String, Integer> selectedMeals6 = new HashMap<>();
        selectedMeals6.put("Dumplings", -2);
        DiningManager.calculateTotalCost(selectedMeals6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTotalCostMealNotAvailable() {
        // Caso de prueba 7: Verificar el manejo de selección de comidas no disponibles
        Map<String, Integer> selectedMeals7 = new HashMap<>();
        selectedMeals7.put("Sushi", 2);
        DiningManager.calculateTotalCost(selectedMeals7);
    }

    @Test
    public void testCalculateTotalCostMaxOrderQuantity() {
        // Caso de prueba 8: Verificar el manejo del máximo de 100 comidas
        Map<String, Integer> selectedMeals8 = new HashMap<>();
        selectedMeals8.put("Spaghetti", 50);
        selectedMeals8.put("Pizza", 51);
        double totalCost8 = DiningManager.calculateTotalCost(selectedMeals8);
        assertEquals(177.4, totalCost8, 0.001);
    }
}