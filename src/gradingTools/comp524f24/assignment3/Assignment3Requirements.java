package gradingTools.comp524f24.assignment3;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment3Requirements extends AJUnitProjectRequirements {
	public Assignment3Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/28/2024 01:00:00", 1.05);
		addDueDate("10/02/2024 01:00:00", 1.0);
		addDueDate("10/09/2024 01:00:00", 0.9);
		addDueDate("10/16/2024 01:00:00", 0.7);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F24Assignment3Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
