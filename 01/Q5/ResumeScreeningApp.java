import java.util.*;

abstract class JobRole{
    private String candidateName;
    public JobRole(String candidateName){
        this.candidateName = candidateName;
    }
    public String getCandidateName(){
        return candidateName;
    }
    public abstract String getRoleDetails();
}

class SoftwareEngineer extends JobRole{
    public SoftwareEngineer(String candidateName){
        super(candidateName);
    }
    public String getRoleDetails(){
        return "Software Engineer Resume - "+getCandidateName();
    }
}

class DataScientist extends JobRole{
    public DataScientist(String candidateName){
        super((candidateName));
    }

    @Override
    public String getRoleDetails() {
        return "Data Scientist Resume - "+ getCandidateName();
    }
}

class ProductManager extends JobRole{
    public ProductManager(String candidatename){
        super(candidatename);
    }

    @Override
    public String getRoleDetails() {
        return "Product Manager Resume - "+getCandidateName();
    }
}

class Resume<T extends JobRole>{
    private T jobRole;
    public Resume(T jobRole){
        this.jobRole = jobRole;
    }
    public T getJobRole(){
        return jobRole;
    }
}

class ResumeScreeningSystem{
    public static void processResume(List<? extends JobRole> resumes){
        for(JobRole resume : resumes){
            System.out.println("Processing: "+resume.getRoleDetails());
        }
    }
}

public class ResumeScreeningApp {
    public static void main(String[] args){
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(new SoftwareEngineer("Anthony"));
        allResumes.add(new DataScientist("Nathaniel"));
        allResumes.add(new ProductManager("Jenna"));

        System.out.println("AI Screening System:");
        ResumeScreeningSystem.processResume(allResumes);
    }
}
