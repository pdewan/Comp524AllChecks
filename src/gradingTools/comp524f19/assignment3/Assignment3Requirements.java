package gradingTools.comp524f19.assignment3;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;


public class Assignment3Requirements extends AJUnitProjectRequirements {
	public Assignment3Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		
		addDueDate("11/8/2019 02:00:00", 1.0);
		addDueDate("11/22/2019 02:00:00", 0.9);
		addDueDate("12/30/2019 02:00:00", 0.75);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(Assignment3Suite.class);		

	}
}
