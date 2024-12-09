package gradingTools.comp524f24.assignment5;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("11/12/2024 01:00:00", 1.05);
		addDueDate("11/16/2024 01:00:00", 1.0);
		addDueDate("11/23/2024 01:00:00", 0.9);
		addDueDate("12/05/2024 01:00:00", 0.7);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F24Assignment5Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
