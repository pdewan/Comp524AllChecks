package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.gradebook.DiaryManagement;
import gradingTools.gradebook.GradebookGradescopeConverter;
import gradingTools.gradebook.StaticDiaryManagement;
import gradingTools.gradebook.SummaryDiaryManagement;

public class Comp524DiarySummaryToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	static String[] onyensToEmail = new String[] {
//			"wisler95:bwisler@unc.edu",
//			"yulupan:ypan1@unc.edu",
//		"whglaser:whglaser@ad.unc.edu"
//		"harrywh:harrywang11@126.com",
//		"zackaxal:zackb@unc.edu"
	};
//	static final String DIARY_FILE_NAME = 
//			"D:\\UNCGoogleDrive\\401-f15\\grades\\f18\\401diaries_Direct.csv";
//	static final String DIARY_FILE_NAME = 
//			"401diaries_Direct.csv";
	static final String DIARY_FILE_NAME = 
//			"524diaries_11-29-2020_summary.csv";
//			"524diaries_12-6-2021_summary.csv";
			"diar_5-3-2024_summary.csv";
//			"f23_12-7-2023_summary.csv";
//			"f22_12-3-2022_summary.csv";
//			"533DiaryGrades_5-1-2022_summary.csv";
//	static final String DIARY_FILE_NAME = 
//			"524diaries_11-18-2020_detailed.csv";
//	static String[] dates = {"", "9/21", "10/5", "10/26", "11/9", "11/23", "12/6"};
	static String[] dates = {"", ""};
//	static Integer[] diaryLimits = {-1};
//	static Integer[] qALimits = {-1};
	static Boolean[] isDiary = {true, false};
	static Integer[] limits = {-1, -1};
//	static final String GRADES_DIR = "G:\\My Drive\\524\\f21\\grades\\";
//	static final String GRADES_DIR = "G:\\My Drive\\533\\s22\\grades\\";
//	static final String GRADES_DIR = "G:\\My Drive\\524\\f22\\grades\\";
//	static final String GRADES_DIR = "G:\\My Drive\\524\\f23\\grades\\";
	static final String GRADES_DIR = "G:\\My Drive\\533\\s24\\grades\\";




	static final String GRADEBOOK_TEMPLATE_FILE_NAME = GRADES_DIR
			+ "gradebook_export_template.csv";
	

	public static void main (String[] args) {
//		Map aMap = GradebookConverter.gradeBookToMap(new File("D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv"));
//		GradebookGradescopeConverter.gradescopeToGradebook(
//				"D:\\UNCGoogleDrive\\401-f15\\grades\\401diaries.csv", 
//				"D:\\UNCGoogleDrive\\401-f15\\grades\\Midterm_scores_F17_Sakai_2.csv",
//				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
//				onyensToEmail);
		new SummaryDiaryManagement().diarySummaryToGradebook(				
				dates, 
				GRADES_DIR +

//				Comp401GradeBookToGradesScopeFileGenerator.GRADES_DIR +
				DIARY_FILE_NAME, 
				isDiary,
//				aDate.isEmpty()?false:true,
//				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
				GRADEBOOK_TEMPLATE_FILE_NAME,				

				onyensToEmail,
				limits);	
//		for (String aDate:dates) {
//		DiaryManagement.diaryToGradebook(				
//				aDate, 
//				DIARY_FILE_NAME, 
//				aDate.isEmpty()?false:true,
//				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,				
//				onyensToEmail);	
//		}
//		// print all diary
//		DiaryManagement.diaryToGradebook(				
////				"", 
//				dates,
//				DIARY_FILE_NAME, 
//				true,
//				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,				
//				onyensToEmail,
//				qALimits);	
		
	}

}
