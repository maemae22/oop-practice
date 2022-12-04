package org.example;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;

    // private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }

    //• 평균학점 계산 방법 = (학점수×교과목 평점)의 합계 / 수강신청 총학점 수
    //• MVC패턴(Model-View-Controller) 기반으로 구현한다.
    //• 일급 컬렉션 사용

    // 핵심 뽀인트 !!
    // 5. 객체들을 포괄하는 타입에 적절한 책임을 할당
    // 이수한 과목을 전달하여 평균학점 계산을 요청 --> 학점 계산기 --> (학점수×교과목 평점)의 합계 --> 과목(코스) : 일급 컬렉션
    //                                                   --> 수강신청 총학점 수         --> 과목(코스) : 일급 컬렉션
    public double calculateGrade() {

        // (학점수×교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiPlyCreditAndCourseGrade();

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
