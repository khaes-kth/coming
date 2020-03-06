package fr.inria.coming.spoon.repairability.repairtools;


import java.io.File;

import org.junit.Test;

import fr.inria.coming.changeminer.entity.FinalResult;
import fr.inria.coming.main.ComingMain;
import fr.inria.coming.spoon.repairability.RepairabilityTestUtils;

public class NPEfixTest {
	
	@Test
	public void testGroundTruthCreatedPatches() throws Exception {
    	RepairabilityTestUtils.checkGroundTruthPatches(getClass(), "NPEfix", 83, 0);
	}

	@Test
	public void testFilePairs() throws Exception {
		File left = getFile("repairability_test_files/NPEfix/NPEfix/s.java");
		File right = getFile("repairability_test_files/NPEfix/NPEfix/t.java");

		ComingMain cm = new ComingMain();

		FinalResult result = cm
				.run(new String[] { "-location", left.getAbsolutePath() + File.pathSeparator + right.getAbsolutePath(),
						"-input", "filespair", "-mode", "repairability", "-repairtool", "NPEfix", "-parameters", 
						"include_all_instances_for_each_tool:true:exclude_repair_patterns_not_covering_the_whole_diff:true:max_nb_commit_analyze:300:max_time_for_a_git_repo:-1"});

	}
	
	public File getFile(String name) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(name).getFile());
		return file;
	}
}
