import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Kevin", 23);
        Student s2 = new Student("Tyler", 33);
        Student s3 = new Student("Sarah", 32);
        Student s4 = new Student("Peter", 20);
        Student s5 = new Student("Madison", 35);

        //RefStack<Student> studentStack = new RefStack<>();
        ArrStack<Student> studentStack = new ArrStack<>();
        System.out.println(studentStack.isEmpty()); // true
        System.out.println(studentStack.size());// 0

        studentStack.push(s1); // Kevin
        studentStack.push(s2); // Tyler, Kevin
        studentStack.push(s3); // Sarah, Tyler, Kevin

        System.out.println("After elements are pushed onto stack");
        System.out.println(studentStack);

        try {
            studentStack.pop(); // Tyler, Kevin  (Sarah is popped)
            studentStack.pop(); // Kevin (Tyler is popped)
        } catch(MyEmptyStackException ex) {
            ex.getMessage();
        }

        studentStack.push(s4); // Peter, Kevin
        studentStack.push(s5); // Madison, Peter, Kevin

        System.out.println(studentStack.size());
        System.out.println(studentStack.isEmpty());

        System.out.println(studentStack);

        studentStack.removeAll();
        System.out.println(studentStack.size());
        System.out.println(studentStack.isEmpty());

    }
}
