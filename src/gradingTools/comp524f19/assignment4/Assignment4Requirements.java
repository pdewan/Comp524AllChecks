package gradingTools.comp524f19.assignment4;

import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;


public class Assignment4Requirements extends AJUnitProjectRequirements {
	public Assignment4Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		
		addDueDate("12/4/2019 02:00:00", 1.0);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(Assignment4Suite.class);		

	}
}
