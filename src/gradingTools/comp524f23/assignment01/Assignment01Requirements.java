package gradingTools.comp524f23.assignment01;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp524f23.assignment0_1.F23Assignment0_1Suite;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;

public class Assignment01Requirements extends AJUnitProjectRequirements {
	public Assignment01Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/26/2023 14:00:00", 1.05);
		addDueDate("09/28/2023 12:30:00", 1.0);
		addDueDate("10/03/2023 12:30:00", 0.9);
		addDueDate("10/05/2023 12:30:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F23Assignment0_1Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
