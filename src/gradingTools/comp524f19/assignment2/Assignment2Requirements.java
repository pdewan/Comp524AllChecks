package gradingTools.comp524f19.assignment2;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;


public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		
		addDueDate("10/14/2019 01:00:00", 1.0);
		addDueDate("10/29/2019 01:00:00", 0.9);
		addDueDate("12/31/2019 01:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(Assignment2Suite.class);		

	}
}
