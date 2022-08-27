package gradingTools.comp524f22.assignment1;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("08/30/2022 01:00:00", 1.05);
		addDueDate("09/01/2022 01:00:00", 1.0);
		addDueDate("09/08/2022 01:00:00", 0.9);
		addDueDate("09/15/2022 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment1Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
