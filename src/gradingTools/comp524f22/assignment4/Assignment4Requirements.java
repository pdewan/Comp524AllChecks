package gradingTools.comp524f22.assignment4;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment4Requirements extends AJUnitProjectRequirements {
	public Assignment4Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("11/01/2022 01:00:00", 1.05);
		addDueDate("11/03/2022 01:00:00", 1.0);
		addDueDate("11/10/2022 01:00:00", 0.9);
		addDueDate("11/17/2022 01:00:00", 0.70);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment4Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
