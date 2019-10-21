package fr.inria.coming.spoon.repairability.repairtools;


import fr.inria.coming.changeminer.entity.FinalResult;
import fr.inria.coming.spoon.repairability.RepairabilityTestUtils;
import org.junit.Test;

public class ElixirTest {
    @Test
    public void elixirTest() throws Exception {
        FinalResult result = RepairabilityTestUtils.runRepairability("Elixir", "/repairability_test_files/Elixir/");
        RepairabilityTestUtils.checkNumberOfInstances(result, 8, 8);
    }

    @Test
    public void elixirTestonDatasetReal() throws Exception {
        FinalResult result = RepairabilityTestUtils.runRepairability("Elixir", "/repairability_test_files/elixir_data/");
        RepairabilityTestUtils.checkNumberOfInstances(result, 3, 3);
    }

    @Test
    public void elixirTestonDatasetFalse1() throws Exception {
        FinalResult result = RepairabilityTestUtils.runRepairability("Elixir", "/repairability_test_files/JGenProgPostiveTest/");
        RepairabilityTestUtils.checkNumberOfInstances(result, 1, 0);
    }

    @Test
    public void elixirTestonDatasetFalse2() throws Exception {
        FinalResult result = RepairabilityTestUtils.runRepairability("Elixir", "/repairability_test_files/NopolTypes/");
        RepairabilityTestUtils.checkNumberOfInstances(result, 3, 0);
    }
}
