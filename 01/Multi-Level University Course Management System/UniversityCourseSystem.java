import java.util.*;

abstract class CourseType{
    private String title;
    public CourseType(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType{
    public ExamCourse(String title){
        super(title);
    }
    public String getEvaluationMethod(){
        return "Assignment-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }

    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType{
    public ResearchCourse(String title){
        super(title);
    }
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }
}

class CourseDisplay{
    public static void showCourses(List<? extends CourseType> courses){
        for(CourseType c : courses){
            System.out.println(c.getTitle()+" - "+c.getEvaluationMethod());
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args){
        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse("Mathematics"));
        examDept.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentDept = new Course<>();
        assignmentDept.addCourse(new AssignmentCourse("Literature"));
        assignmentDept.addCourse(new AssignmentCourse("Sociology"));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse("Thesis Writing"));
        researchDept.addCourse(new ResearchCourse("Quantum Research"));

        System.out.println("Exam-Based Courses:");
        CourseDisplay.showCourses(examDept.getCourses());

        System.out.println("\nAssignment-Based Courses:");
        CourseDisplay.showCourses(assignmentDept.getCourses());

        System.out.println("\nResearch-Based Courses:");
        CourseDisplay.showCourses(researchDept.getCourses());
    }
}
