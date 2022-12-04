package org.example;

import java.util.List;

// 일급 컬렉션 : List 형태로 된 객체(Course) 정보만 인스턴스 변수로 가지는 클래스
public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiPlyCreditAndCourseGrade() {

        return courses.stream()
                .mapToDouble(Course::multiplayCreditAndCourseGrade)
                .sum();

        /*
        double multipliedCreditAndCourseGrade = 0;

        for(Course course : courses) {
            //multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            multipliedCreditAndCourseGrade += course.multiplayCreditAndCourseGrade();
        }
        return multipliedCreditAndCourseGrade;
         */
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit) // course -> course.getCredit() 이란 뜻
                .sum();
    }
}
