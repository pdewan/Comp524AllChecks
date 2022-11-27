package gradingTools.comp524f22.assignment6;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("11/29/2022 01:00:00", 1.05);
		addDueDate("12/01/2022 01:00:00", 1.0);
		addDueDate("12/08/2022 01:00:00", 0.9);
//		addDueDate("12/29/2022 01:00:00", 0.70);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment6Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
