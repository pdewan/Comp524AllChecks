package gradingTools;

import java.util.Arrays;

public class TestHeadlessStudentRange {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 1";
	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-1";

//	static final String STUDENT = "sdgeorge";
//	static final String STUDENT1 = "kakiryan";
//	static final String STUDENT2 = "kila";
	static final String STUDENT1 = "^";
	static final String STUDENT2 = "kyuyeon";

	static final String COURSE = "Comp524F20";
	
	public static void main(String[] args) {
		String[] myArgs = {
				COURSE, ASSIGNMENT, STUDENT1, STUDENT2
		};
//		System.out.println ("Test headless student range\n" + Arrays.toString(myArgs));
		RunHeadlessStudentRange.main(myArgs);
	}

}
