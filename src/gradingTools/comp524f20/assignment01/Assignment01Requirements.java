package gradingTools.comp524f20.assignment01;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f20.assignment0_1.F20Assignment0_1Suite;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment01Requirements extends AJUnitProjectRequirements {
	public Assignment01Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("08/22/2020 01:00:00", 1.05);
		addDueDate("08/26/2020 01:00:00", 1.0);
		addDueDate("09/02/2020 01:00:00", 0.9);
		addDueDate("09/09/2020 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F20Assignment0_1Suite.class);		

	}
}
