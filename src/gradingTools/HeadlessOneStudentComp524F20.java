package gradingTools;

public class HeadlessOneStudentComp524F20 {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 1";
	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-3";

//	static final String STUDENT = "sdgeorge";
	static final String STUDENT = "kakiryan";
	static final String COURSE = "Comp524F20";
	
	public static void main(String[] args) {
		String[] myArgs = {
				COURSE, args[0], args[1]
		};
		RunHeadlessOneStudent.main(myArgs);
	}

}
