package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.gradebook.GradebookGradescopeConverter;

public class Comp524GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
//	public static final String GRADES_FOLDER = "G:\\My Drive\\533\\grades\\";
//	public static final String GRADES_FOLDER = Comp524GradeBookToGradesScopeFileGenerator.GRADES_DIR;
	public static final String GRADES_FOLDER =  "G:\\My Drive\\524\\f20\\grades\\";

//	public static final String GRADES_FOLDER = Comp524GradeBookToGradesScopeFileGenerator.GRADES_DIR;

//
//	public static final String GRADESCOPE_FILE_NAME = "Comp524_F19_Midterm_scores.csv";
//	public static final String SAKAI_FILE_NAME = "Midterm_scores_F19_Sakai.csv";
//	public static final String GRADE_COLUMN_NAME = "Midterm";
	
	public static final String GRADESCOPE_FILE_NAME = "G_Assignnent_0_1_scores.csv";
	public static final String SAKAI_FILE_NAME = "G_Assignnent_0_1_scores_sakai.csv";
	public static final String GRADE_COLUMN_NAME = "G_Assignment_0_1_Sakai";
	public static final String GRADE_TEMPLATE_FILE_NAME  = "gradebook_export_template.csv";
	public static final String[] assignmentNames = {
			"G_Assignnent_0_1",
			"G_Assignnent_0_2",
			"G_Assignnent_0_3",
			"G_Assignnent_0_4",
			"G_Assignment_1",
			"G_Assignment_2",
			"G_Assignment_3",
			"G_Assignment_4",
			"G_Assignment_5",
			"G_Assignment_6",
	};

	
	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu"
	};
	

	public static void main (String[] args) {
//		Map aMap = GradebookConverter.gradeBookToMap(new File("D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv"));
//		GradebookGradescopeConverter.gradescopeToGradebook(
//				GRADES_FOLDER + GRADESCOPE_FILE_NAME, 
//				GRADES_FOLDER + SAKAI_FILE_NAME,
////				Comp524GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
//				GRADES_FOLDER + GRADE_TEMPLATE_FILE_NAME,
//				onyensToEmail,
//				GRADE_COLUMN_NAME);
//		
//	 
//	}
	GradebookGradescopeConverter.gradescopeToGradebook(GRADES_FOLDER, assignmentNames, GRADE_TEMPLATE_FILE_NAME, onyensToEmail);
	
//	gradescopeToGradebook(
//			GRADES_FOLDER + GRADESCOPE_FILE_NAME, 
//			GRADES_FOLDER + SAKAI_FILE_NAME,
////			Comp524GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
//			GRADES_FOLDER + GRADE_TEMPLATE_FILE_NAME,
//			onyensToEmail,
//			GRADE_COLUMN_NAME);
//	
// 
}

}
