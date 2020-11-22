package gradingTools.comp524f20.assignment03;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.project.BasicProjectIntrospection;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp524f20.assignment0_1.F20Assignment0_1Suite;
import gradingTools.comp524f20.assignment0_2.F20Assignment0_2Suite;
import gradingTools.comp524f20.assignment0_3.F20Assignment0_3Suite;
import gradingTools.sharedTestCase.DocumentEnclosedTestCase;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;

public class Assignment03Requirements extends AJUnitProjectRequirements {
	public Assignment03Requirements() {
//		Comp533TraceUtility.setTurnOn(true);
//		Comp533TraceUtility.setTracing();
//		GraderTraceUtility.setTurnOn(true);
//		GraderTraceUtility.setTracing();
		addDueDate("08/22/2020 01:00:00", 1.05);
		addDueDate("08/26/2020 01:00:00", 1.0);
		addDueDate("09/02/2020 01:00:00", 0.9);
		addDueDate("09/09/2020 01:00:00", 0.75);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);
//		F20Assignment0_3Suite.smlIsBatFile(false);
		F20Assignment0_3Suite.smlIsBatFile(BasicExecutionSpecificationSelector.getBasicExecutionSpecification().getSMLIsBat());

		BasicProjectIntrospection.setUseMainClass(true);
		addJUnitTestSuite(F20Assignment0_3Suite.class);	
        addFeature("Screenshots enclosed", 3, new DocumentEnclosedTestCase());


	}
}
