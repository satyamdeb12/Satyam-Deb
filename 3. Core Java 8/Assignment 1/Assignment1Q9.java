package Assignment1;

class Student {
	private int subjectA, subjectB, subjectC;

	public Student() {

	}

	public Student(int subjectA, int subjectB, int subjectC) {
		this.subjectA = subjectA;
		this.subjectB = subjectB;
		this.subjectC = subjectC;
	}

	public int getSubjectA() {
		return subjectA;
	}

	public void setSubjectA(int subjectA) {
		this.subjectA = subjectA;
	}

	public int getSubjectB() {
		return subjectB;
	}

	public void setSubjectB(int subjectB) {
		this.subjectB = subjectB;
	}

	public int getSubjectC() {
		return subjectC;
	}

	public void setSubjectC(int subjectC) {
		this.subjectC = subjectC;
	}

	public int studentsTotalMarksInAllSubjects(Student[] students) {
		int s1 = students[0].subjectA + students[0].subjectB + students[0].subjectC;
		int s2 = students[1].subjectA + students[1].subjectB + students[1].subjectC;
		int s3 = students[2].subjectA + students[2].subjectB + students[2].subjectC;
		return s1 + s2 + s3;
	}

	public double studentsAverageMarksInAllSubjects(Student[] students) {
		int s1 = students[0].subjectA + students[0].subjectB + students[0].subjectC;
		int s2 = students[1].subjectA + students[1].subjectB + students[1].subjectC;
		int s3 = students[2].subjectA + students[2].subjectB + students[2].subjectC;
		return (s1 + s2 + s3) / 3;
	}

	public int subjectATotalByStudents(int[] marks) {
		int totalMarksInSubjectA = 0;
		for (int i = 0; i < marks.length; i++) {
			totalMarksInSubjectA = totalMarksInSubjectA + marks[i];
		}
		return totalMarksInSubjectA;
	}

	public double subjectAAverageByStudents(int[] marks) {
		int totalMarksInSubjectA = 0;
		for (int i = 0; i < marks.length; i++) {
			totalMarksInSubjectA = totalMarksInSubjectA + marks[i];
		}
		return totalMarksInSubjectA / marks.length;
	}

	public double subjectBAverageByStudents(int[] marks) {
		int totalMarksInSubjectB = 0;
		for (int i = 0; i < marks.length; i++) {
			totalMarksInSubjectB = totalMarksInSubjectB + marks[i];
		}
		return totalMarksInSubjectB / marks.length;
	}

	public double subjectCAverageByStudents(int[] marks) {
		int totalMarksInSubjectC = 0;
		for (int i = 0; i < marks.length; i++) {
			totalMarksInSubjectC = totalMarksInSubjectC + marks[i];
		}
		return totalMarksInSubjectC / marks.length;
	}
}

public class Assignment1Q9 {

	public static void main(String[] args) {
		Student[] students = new Student[3];

		students[0] = new Student(10, 20, 30);
		students[1] = new Student(10, 20, 30);
		students[2] = new Student(10, 20, 30);
		int[] marksInSubA = { students[0].getSubjectA(), students[1].getSubjectA(), students[2].getSubjectA() };
		int[] marksInSubB = { students[0].getSubjectB(), students[1].getSubjectB(), students[2].getSubjectB() };
		int[] marksInSubC = { students[0].getSubjectC(), students[1].getSubjectC(), students[2].getSubjectC() };

		Student student = new Student();
		System.out.println(student.studentsTotalMarksInAllSubjects(students));
		System.out.println(student.studentsAverageMarksInAllSubjects(students));
		System.out.println(student.subjectATotalByStudents(marksInSubA));
		System.out.println(student.subjectAAverageByStudents(marksInSubA));
		System.out.println(student.subjectATotalByStudents(marksInSubB));
		System.out.println(student.subjectBAverageByStudents(marksInSubB));
		System.out.println(student.subjectATotalByStudents(marksInSubC));
		System.out.println(student.subjectCAverageByStudents(marksInSubC));

	}
}