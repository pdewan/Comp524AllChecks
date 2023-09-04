package gradingTools;

import gradingTools.RunHeadlessOneStudent;

public class RunHeadlessOneStudentDriver {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-1";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-2";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-3";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 3";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 2";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-4";

//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524Assingments\\Assignment6";

	static final String ASSIGNMENT_FOLDER = "C:\\Users\\dewan\\Downloads\\Assignment 1 524f23\\Assignment 1";

//	static final String STUDENT = "kakiryan";
//	static final String STUDENT = "justin2";
//	static final String STUDENT = "sdgeorge";
//	static final String STUDENT = "codyq";
//	static final String STUDENT = "nalin";
	static final String STUDENT = "yulupan";

	static final String COURSE = "Comp524F23";
	static final String ASSIGNMENT = "Assignment1";


	static final String[] MY_ARGS = { ASSIGNMENT_FOLDER, STUDENT };

	public static void main(String[] args) {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 1";

//	static final String STUDENT = "sdgeorge";
//	static final String STUDENT = "kakiryan";

//		TestForkHeadlessOneStudent.main(MY_ARGS);
//		HeadlessOneStudentComp524F20.main(MY_ARGS);
		RunHeadlessOneStudent.runHeadlessOneStudent(COURSE, ASSIGNMENT, ASSIGNMENT_FOLDER, STUDENT);
//		Tracer.setMaxTraces(maxPrints);

//	TestHeadlessOneStudent.main(MY_ARGS);
	}
}
