package gradingTools;

import grader.basics.execution.BasicProjectExecution;

public class ForkHeadlessComp524F20 {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 1";
	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-1";

//	static final String STUDENT = "sdgeorge";
//	static final String STUDENT = "kakiryan";
	
	static final String COURSE = "Comp524F20";

	static final String[] students = {"^", "kyuyeon", "patelvap", "$"};

	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please enter the assignment folder as a main arg");
			System.exit(-1);;
		}
		String[] myArgs = {
				COURSE, args[0], students[0], students[1]
		};
		for (int i = 2; ; i++) {
//			BasicProjectExecution.runProject(RunHeadlessStudentRange.class, myArgs, false);
			BasicProjectExecution.runProcess(RunHeadlessStudentRange.class, myArgs, true);

			if (i == students.length) {
				break;
			}
			myArgs[2] = myArgs[3];
			myArgs[3] = students[i];
		}
		
	}

}
