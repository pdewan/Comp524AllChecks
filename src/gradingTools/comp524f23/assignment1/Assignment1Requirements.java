package gradingTools.comp524f23.assignment1;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/08/2023 01:00:00", 1.05);
		addDueDate("09/13/2023 01:00:00", 1.0);
		addDueDate("09/20/2023 01:00:00", 0.9);
		addDueDate("09/27/2023 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F23Assignment1Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
