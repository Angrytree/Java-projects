package com.palamarchuk.aop;

public class ExaminationJava implements IExamination {

	public void passExam() {
		System.out.println(" + I'm passing Java Exam!!!");

	}

	public void failExam(){
		System.out.println(" + I'm failing Java Exam!!!");
		throw new RuntimeException("failing");

	}

}
