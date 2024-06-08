import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
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
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {
    public static void test(){
        System.out.println("Test FUnction!");
    }

    public static void main(String[] args) {
        test();
        List<Course> list = new ArrayList<>();
        list.add(new Course("Spring", "Framework", 98, 20000));
        list.add(new Course("Micro Services", "Micro Services", 95, 20000));
        list.add(new Course("API", "Micro Services", 97, 18000));
        list.add(new Course("DOcker", "Cloud", 91, 25000));
        list.add(new Course("Kubernetes", "Cloud", 96, 50000));
        list.add(new Course("AWS", "Cloud", 92, 30000));
        list.add(new Course("Azure", "CLoud", 92, 20000));
        list.add(new Course("GCP", "Cloud", 93, 40000));

        // All Match, none match , anymatch
        // Checking whether the review of the course is greater than 90.
        System.out.println(list.stream().allMatch(course -> course.getReviewScore() > 90));
        System.out.println(list.stream().allMatch(course -> course.getReviewScore() > 95));
        System.out.println(list.stream().noneMatch(course -> course.getReviewScore() > 90));

        Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;

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
        Comparator<Course> comparatorByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(list.stream().sorted(comparatorByNoOfStudentsDecreasing).collect(Collectors.toList()));

        // Compare by No. of Students and No. of Reviews ;)
        // Note there are default primitive methods so use primitive methods
        // such as comparingInt so that less auto boxing will be required !
        Comparator<Course> compareByStudentsandReviews = Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

        // Skip ,limit, takeWhile and dropWhile

        // Task : Pick the Top 5 Courses
        System.out.println(list.stream().sorted(comparatorByNoOfStudentsDecreasing).limit(5).collect(Collectors.toList()));

        // Task : Skip the Top 3 Results
        System.out.println(list.stream().sorted(compareByStudentsandReviews).skip(3).collect(Collectors.toList()));

        // Task : Take all elements until we get an element  whose review score is less than 95 ;


//    list.stream().dropWhile(c->true);

        System.out.println(list.stream().filter(reviewScoreLessThan90).min(comparatorByNoOfStudents));

        // Average No. of reviews having greater than 95 on courses!
        System.out.println(list.stream().filter(reviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).average());


        /*
            .mapToInt(Course::getNoOfStudents)
            is equivalent to
            map(course->course.getNoOfStudents())
         */

        System.out.println(LocalDate.now());
        System.out.println(list);

        System.out.println(list.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));


        // How to convert A
        // We Require a Stream of Characters
        // Ex: STream ["S","p","r","i","n","g"]
        // But we have a Stream of String Arrays which have individual Characters
        // Stream[["S","p","r","i","n","g"],["S","p","r","i","n","g"]]
        // We want to flatten it !
        System.out.println("+===========================+");
        System.out.println("+===========================+");
        String arr[]={"Spring Boot","Ansible","Kubernetes","JPA","Hibernate","ORM"};
        List<String> courses= Arrays.asList(arr);
        System.out.println(courses);
//        courses.stream().map(x->x.split(""));
        System.out.println(courses.stream().map(x->x.split("")).collect(Collectors.toList()));

        // All the Strings having same length, we want to create a tupple of them !

        System.out.println();
        System.out.println();
        // courses had List of String elements
        // our task is to represent all the characters as single element in the array
        // For ex: {"AURO","SASWAT","RAJ"}
        // Expected Output : {'A','U','R','O','S','A','S','W','A','T','R','A','J'}
        // .map(course1->course1.split("")) this will give the output as {'A','U','R','O'},{'S','A','S','W','A','T'},{'R','A','J'}
        // Now what the flatmap does is takes all the arrays of characters and  flats,combines them into single array of characters which finally gives the output as
//        {'A','U','R','O','S','A','S','W','A','T','R','A','J'}
        courses.stream().map(course1->course1.split("")).flatMap(Arrays::stream).toList().forEach(System.out::print);
        String name[]={"AURO","SASWAT","RAJ"};
         List<String> names=Arrays.asList(name);
        names.stream().map(x->x.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);


        List<String> arrr1=Arrays.asList(arr);
        // Appending each element of first list to all the element of second list typically an order on N^2 approach!
        System.out.println(courses.stream()
                .flatMap(c->arrr1.stream().map(c2->List.of(c,c2))).toList());












    }
}
