package gradingTools.comp524f22.assignment2;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/10/2022 01:00:00", 1.05);
		addDueDate("09/13/2022 01:00:00", 1.0);
		addDueDate("09/20/2022 01:00:00", 0.9);
		addDueDate("09/27/2022 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment2Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
