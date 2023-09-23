package gradingTools.comp524f23.assignment2;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/23/2023 01:00:00", 1.05);
		addDueDate("09/27/2023 01:00:00", 1.0);
		addDueDate("10/04/2023 01:00:00", 0.9);
		addDueDate("10/11/2023 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F23Assignment2Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
