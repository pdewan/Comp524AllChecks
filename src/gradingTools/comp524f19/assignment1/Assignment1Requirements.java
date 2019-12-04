package gradingTools.comp524f19.assignment1;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f19.assignment1.Assignment1Suite;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		
		addDueDate("09/25/2019 01:00:00", 1.0);
		addDueDate("10/02/2019 01:00:00", 0.9);
		addDueDate("10/09/2019 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(Assignment1Suite.class);		

	}
}
