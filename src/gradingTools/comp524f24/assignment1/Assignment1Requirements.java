package gradingTools.comp524f24.assignment1;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/07/2024 01:00:00", 1.05);
		addDueDate("09/11/2024 01:00:00", 1.0);
		addDueDate("09/18/2024 01:00:00", 0.9);
		addDueDate("09/25/2024 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F24Assignment1Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());
	}
}
