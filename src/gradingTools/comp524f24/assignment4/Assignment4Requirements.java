package gradingTools.comp524f24.assignment4;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment4Requirements extends AJUnitProjectRequirements {
	public Assignment4Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("10/31/2024 01:00:00", 1.05);
		addDueDate("11/02/2024 01:00:00", 1.0);
		addDueDate("11/09/2024 01:00:00", 0.9);
		addDueDate("11/16/2024 01:00:00", 0.70);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F24Assignment4Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
