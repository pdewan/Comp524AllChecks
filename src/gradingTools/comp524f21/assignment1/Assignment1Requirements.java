package gradingTools.comp524f21.assignment1;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/04/2021 01:00:00", 1.05);
		addDueDate("09/08/2021 01:00:00", 1.0);
		addDueDate("09/15/2021 01:00:00", 0.9);
		addDueDate("09/22/2021 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F21Assignment1Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());

	}
	
	
}
