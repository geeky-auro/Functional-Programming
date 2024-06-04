import java.util.ArrayList;
import java.util.List;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;


    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name + ":" + noOfStudents + ":" +reviewScore;
    }
}

public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> list=new ArrayList<>();
        list.add(new Course("Spring","Framework",98,20000));
        list.add(new Course("Micro Services","Micro Services",95,20000));
        list.add(new Course("API","Micro Services",97,18000));
        list.add(new Course("DOcker","Cloud",91,25000));
        list.add(new Course("Kubernetes","Cloud",96,50000));
        list.add(new Course("AWS","Cloud",92,30000));
        list.add(new Course("Azure","CLoud",92,20000));
        list.add(new Course("GCP","Cloud",93,40000));



    }
}
