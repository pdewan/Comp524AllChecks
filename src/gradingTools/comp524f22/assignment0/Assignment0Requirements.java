package gradingTools.comp524f22.assignment0;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f20.assignment0_1.F20Assignment0_1Suite;
import gradingTools.comp524f21.assignment0_1.F21Assignment0_1Suite;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment0Requirements extends AJUnitProjectRequirements {
	public Assignment0Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("08/20/2022 01:00:00", 1.05);
		addDueDate("08/23/2022 01:00:00", 1.0);
		addDueDate("08/30/2022 01:00:00", 0.9);
		addDueDate("09/06/2022 01:00:00", 0.7);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F22Assignment0Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
