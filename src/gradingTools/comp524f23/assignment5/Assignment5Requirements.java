package gradingTools.comp524f23.assignment5;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("11/18/2023 01:00:00", 1.05);
		addDueDate("11/22/2023 01:00:00", 1.0);
		addDueDate("12/07/2023 01:00:00", 0.9);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F23Assignment5Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
