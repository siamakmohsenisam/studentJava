package studpackage;

import java.io.Serializable;

public class Lesson implements Serializable{
	
	private double[] percent;
	private String lessonName;
	private double mintermExam;
	private double finalExam;
	private double project;
	
	
	public Lesson() {		
		this(new double[3],"",Double.NaN,Double.NaN,Double.NaN);
		percent[0]=0.4;
		percent[1]=0.3;
		percent[2]=0.3;
	}	
	
	public Lesson(String coursename, double mintermExam, double finalExam, double project) {
		this(new double[3],coursename,mintermExam,finalExam,project);
		percent[0]=0.4;
		percent[1]=0.3;
		percent[2]=0.3;
	}

	public Lesson(double[] percent, String coursename, double mintermExam, double finalExam, double project) {
		super();
		this.percent = percent;
		this.lessonName = coursename;
		this.mintermExam = mintermExam;
		this.finalExam = finalExam;
		this.project = project;
	}
	public double[] getPercent() {
		return percent;
	}
	public void setPercent(double[] percent) {
		this.percent = percent;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String coursename) {
		this.lessonName = coursename;
	}
	public double getMintermExam() {
		return mintermExam;
	}
	public void setMintermExam(double mintermExam) {
		this.mintermExam = mintermExam;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	public double getProject() {
		return project;
	}
	public void setProject(double project) {
		this.project = project;
	}
	public double finalgrade()
	{
		return finalExam*percent[0]+mintermExam*percent[1]+project*percent[2];
	}

	@Override
	public String toString() {
		return  lessonName ;
	}
	public String toString2() {
		return "Evaluation [coursename=" + lessonName + ", mintermExam=" + mintermExam + ", finalExam=" + finalExam
				+ ", project=" + project + "]";
	}
	

}
