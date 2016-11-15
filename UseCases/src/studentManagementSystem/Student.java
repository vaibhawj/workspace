package studentManagementSystem;

public class Student {

	private PersonalInfo personalInfo;

	private EducationalInfo eduInfo;

	private Student mentor;

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public EducationalInfo getEduInfo() {
		return eduInfo;
	}

	public void setEduInfo(EducationalInfo eduInfo) {
		this.eduInfo = eduInfo;
	}

	public Student getMentor() {
		return mentor;
	}

	public void setMentor(Student mentor) {
		this.mentor = mentor;
	}

}
