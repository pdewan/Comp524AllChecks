package gradingTools.comp524f20.assignment5;

import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
//		addDueDate("10/9/2020 02:00:00", 1.05);
//		addDueDate("10/14/2020 02:00:00", 1.0);
//		addDueDate("10/21/2020 02:00:00", 0.9);
//		addDueDate("10/18/2020 02:00:00", 0.75);
		addDueDate("11/09/2020 02:00:00", 1.05);
		addDueDate("11/11/2020 02:00:00", 1.0);
		addDueDate("11/18/2020 02:00:00", 0.9);
//		addDueDate("11/18/2020 02:00:00", 0.75);
//		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F20Assignment5Suite.class);	
        addFeature("Screenshots enclosed", 5, new DocumentEnclosedTestCase());
//        BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A1.xml");


	}
}
