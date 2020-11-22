package gradingTools.comp524f20.assignment2;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f20.assignment0_1.F20Assignment0_1Suite;
import gradingTools.comp524f20.assignment0_3.F20Assignment0_3Suite;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
//		addDueDate("10/26/2020 02:00:00", 1.05);
//		addDueDate("10/28/2020 02:00:00", 1.0);
//		addDueDate("11/04/2020 02:00:00", 0.9);
//		addDueDate("11/11/2020 02:00:00", 0.75);
		addDueDate("10/9/2020 02:00:00", 1.05);
		addDueDate("10/14/2020 02:00:00", 1.0);
		addDueDate("10/21/2020 02:00:00", 0.9);
		addDueDate("10/28/2020 02:00:00", 0.75);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);
		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F20Assignment2Suite.class);	
        addFeature("Screenshots enclosed", 5, new DocumentEnclosedTestCase());
//        BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A1.xml");


	}
}
