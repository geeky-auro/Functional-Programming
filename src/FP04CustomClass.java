import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        // All Match, none match , anymatch
        // Checking whether the review of the course is greater than 90.
        System.out.println(list.stream().allMatch(course -> course.getReviewScore()>90));
        System.out.println(list.stream().allMatch(course -> course.getReviewScore()>95));
        System.out.println(list.stream().noneMatch(course -> course.getReviewScore()>90));

        Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore()>95;
        Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore()>90;

        Predicate<Course> reviewScoreLessThan90 = course -> course.getReviewScore()<90;

        System.out.println(list.stream().allMatch(reviewScoreGreaterThan95));
        System.out.println(list.stream().noneMatch(reviewScoreGreaterThan90));
        System.out.println(list.stream().noneMatch(reviewScoreLessThan90));
        System.out.println(list.stream().anyMatch(reviewScoreGreaterThan95));

    /*
        Few Utility Functions present in the class !
        allMatch() -> returns true if every element matches the predicate in the stream
        noneMatch() -> returns true if no element matches the condition specified in the predicate
        anyMatch() -> If atleast one element in the stream matches the specific condition.
     */

        /*
        * Sorting using Comparator
        * */
        Comparator<Course> comparatorByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(list.stream().sorted(comparatorByNoOfStudents).collect(Collectors.toList()));
        Comparator<Course> comparatorByNoOfStudentsDecreasing =Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(list.stream().sorted(comparatorByNoOfStudentsDecreasing).collect(Collectors.toList()));

        // Compare by No. of Students and No. of Reviews ;)
        // Note there are default primitive methods so use primitive methods
        // such as comparingInt so that less auto boxing will be required !
        Comparator<Course> compareByStudentsandReviews = Comparator
                .comparingInt(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore);

        // Skip ,limit, takeWhile and dropWhile

        // Task : Pick the Top 5 Courses
        System.out.println(list.stream().sorted(comparatorByNoOfStudentsDecreasing).limit(5).collect(Collectors.toList()));

        // Task : Skip the Top 3 Results
        System.out.println(list.stream().sorted(compareByStudentsandReviews).skip(3).collect(Collectors.toList()));

        // Task : Take all elements until we get an element  whose review score is less than 95 ;






    }
}
