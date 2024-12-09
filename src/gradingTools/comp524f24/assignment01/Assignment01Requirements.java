package gradingTools.comp524f24.assignment01;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment01Requirements extends AJUnitProjectRequirements {
	public Assignment01Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
//		addDueDate("09/26/2023 14:00:00", 1.05);
//		addDueDate("09/28/2023 12:30:00", 1.0);
//		addDueDate("10/03/2023 12:30:00", 0.9);
//		addDueDate("10/05/2023 12:30:00", 0.75);
		addDueDate("11/26/2024 14:00:00", 1.0);
		addDueDate("12/05/2024 01:00:00", 0.7);
		
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F24Assignment0_1Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
