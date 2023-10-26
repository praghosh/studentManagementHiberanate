package com.example.mypackage;

import java.util.Date;

 

import com.example.studentManagement.entity.Course;
import com.example.studentManagement.entity.Feedback;
import com.example.studentManagement.entity.Gender;
import com.example.studentManagement.entity.Instructor;
import com.example.studentManagement.entity.Student;
import com.example.studentMgmt.crudUtil.ExampleCRUD;
import com.example.util.DateUtil;
 


public class Main {
	public static void main(String[] args) {
		createStudent ();
		createInstructor ();
		createCourse();
		createFeedbacks();
		getStudnetInfo(1);

	}



	public static void createStudent () {


		String []  email = {"jim.doe@india.com", "sandy.smith@india.com", 

				"jonny_parker@india.com", "tonny.davison@india.com", "pete.jonson@india.com"};
		String []  firstNames = {"Jim", "Sandy", 

				"Jonny", "Tonny", "Pete"};

		String []  lastNames =   {"Doe", "Smith", 

				"Parker", "Davison", "Pete"};

		for (int i = 0; i < firstNames.length; i++) {
			Student student = new Student(firstNames [i], lastNames [i], 
					email[i]);
			student.setGender(Gender.MALE);
			student.setDateOfBirth(DateUtil.getDateIndianFormat("25-02-2001"));
			ExampleCRUD.crateStudent(student);
		}

	}


	public static void createInstructor () {

		String []  email = {"hary.jonathon@usa.com", "mathew.anderson@usa.com", 

		"stanley_williams@usa.com"};
		String []  firstNames = {"Hary", "Mathew", 

		"Stanley" };

		String []  lastNames =   {"jonathon", "Anderson", 

		"Williams" };

		for (int i = 0; i < firstNames.length; i++) {
			Instructor instr = new Instructor(firstNames [i], lastNames [i], 
					email[i]);
			ExampleCRUD.crateInstructor(instr);
		}

	}

	public static void createCourse () {

		String []  courseTitle = {"Angular", "Spring", 

		"React"};
		int []  courseCredit = {4,3,2};	 

		for (int i = 0; i < courseTitle.length; i++) {
			Course crs = new Course(courseTitle [i], courseCredit [i]);	 
			ExampleCRUD.crateCourset(crs);
		}

	}

	// Create   entries in FeedBack table

	public static void addFeedback (int StudentId, String instructorName, String Feeback, Date feedBackDate) {
		Student s = ExampleCRUD.findStudent(StudentId);
		Feedback feed = new Feedback(StudentId, s, feedBackDate, instructorName, Feeback);
		ExampleCRUD.saveFeedBack(feed);

	}

	public static void createFeedbacks () {

		Date feedBackDate = DateUtil.getDateIndianFormat("25-02-2023");
		addFeedback(2, "Hary", "Session was excellent", feedBackDate);
		addFeedback(2, "Stanley", "Session was not so good", feedBackDate);
		addFeedback(1, "Hary", "Everything is clear", feedBackDate);

	}
	public static void getStudnetInfo (int StudentID) {

		Student s = ExampleCRUD.findStudent(2);
		System.out.println(s);
		s.setFirstName("Dinanath");
		ExampleCRUD.updateStudent(s);
		System.out.println(s);
	}
}

