package gradingTools.comp524f22.assignment3;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment3Requirements extends AJUnitProjectRequirements {
	public Assignment3Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/29/2022 01:00:00", 1.05);
		addDueDate("10/01/2022 01:00:00", 1.0);
		addDueDate("10/08/2022 01:00:00", 0.9);
		addDueDate("10/15/2022 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment3Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
