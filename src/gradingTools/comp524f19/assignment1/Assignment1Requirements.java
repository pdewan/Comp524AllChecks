package gradingTools.comp524f19.assignment1;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f19.assignment1.Assignment1Suite;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		
		addDueDate("02/4/2014 23:55:59", 1.0);
		addDueDate("02/5/2014 23:55:59", 0.5);		
		addJUnitTestSuite(Assignment1Suite.class);		

	}
}
