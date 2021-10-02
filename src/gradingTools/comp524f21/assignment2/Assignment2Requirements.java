package gradingTools.comp524f21.assignment2;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f20.assignment0_1.F20Assignment0_1Suite;
import gradingTools.comp524f21.assignment0_1.F21Assignment0_1Suite;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("09/18/2021 01:00:00", 1.05);
		addDueDate("09/22/2021 01:00:00", 1.0);
		addDueDate("09/29/2021 01:00:00", 0.9);
		addDueDate("10/06/2021 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F21Assignment2Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
