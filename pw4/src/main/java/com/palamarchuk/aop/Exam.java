package com.palamarchuk.aop;

public class Exam implements IExam {

	public void beReady() {// BEFORE
		System.out.println(" - You should be ready to exam!!!");
	}

	public void getPapers() {// BEFORE
		System.out.println(" - You must get the empty piece paper!!! ");
	}

	public void signPapers() {// BEFORE
		System.out.println(" - You must sign your papers!!!");
	}

	public void reviewWork() {// AFTER
		System.out
				.println(" - You should review your work and be sure that all right");
	}

	public void pass() {// AFTER
		System.out.println(" - You successfuly passed your exam!!!");
	}

	public void fail() {
		System.out.println(" - You failed your exam!!!");
		
	}

}
