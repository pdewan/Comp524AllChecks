package gradingTools;

import grader.config.ExecutionSpecificationSelector;

public class Comp524Driver {
	public static void main (String[] args) {
		ExecutionSpecificationSelector.getExecutionSpecification().setGraderModule("Comp524f19");
		ExecutionSpecificationSelector.getExecutionSpecification().setGraderProblemDownloadPath("foo");
		ExecutionSpecificationSelector.getExecutionSpecification().setUseProjectConfiguration(true); // duplicating what is in the ASuite

		Driver.main(args);
		for(String s : args) {
			if (s.matches("-.*?[hH][eE][aA][dD][lL][eE][sS]{2}.*")) { // any variety of -.*headless.* with any capitalization
				System.exit(0);
			}
		}
	}
}
