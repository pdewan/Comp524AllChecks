package gradingTools.comp524f22.assignment5;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("11/12/2022 01:00:00", 1.05);
		addDueDate("11/15/2022 01:00:00", 1.0);
		addDueDate("11/22/2022 01:00:00", 0.9);
		addDueDate("11/29/2022 01:00:00", 0.70);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment5Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
