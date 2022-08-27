package gradingTools.comp524f21.assignment5;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f20.assignment0_1.F20Assignment0_1Suite;
import gradingTools.comp524f21.assignment0_1.F21Assignment0_1Suite;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("11/10/2021 01:00:00", 1.05);
		addDueDate("11/13/2021 01:00:00", 1.0);
		addDueDate("11/20/2021 01:00:00", 0.9);
//		addDueDate("11/27/2021 01:00:00", 0.75);
		addDueDate("12/02/2021 01:00:00", 0.75);		

//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);
//		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F21Assignment5Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
