import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Kevin", 23);
        Student s2 = new Student("Tyler", 33);
        Student s3 = new Student("Sarah", 32);
        Student s4 = new Student("Peter", 20);
        Student s5 = new Student("Madison", 35);

        RefQueue<Student> studentStack = new RefQueue<>();
        System.out.println(studentStack.isEmpty()); // true
        System.out.println(studentStack.size());// 0

        studentStack.enqueue(s1); // Kevin
        studentStack.enqueue(s2); // Kevin, Tyler
        studentStack.enqueue(s3); // Kevin, Tyler, Sarah

        System.out.println("After elements are added onto queue");
        System.out.println(studentStack);

        try {
            studentStack.dequeue(); // Tyler, Sarah (Kevin is removed)
            studentStack.dequeue(); // Sarah (Tyler is removed)
        } catch(MyEmptyQueueException ex) {
            ex.getMessage();
        }

        studentStack.enqueue(s4); // Sarah, Peter
        studentStack.enqueue(s5); // Sarah, Peter, Madison

        System.out.println(studentStack.size());
        System.out.println(studentStack.isEmpty());

        System.out.println(studentStack);

        studentStack.removeAll();
        System.out.println(studentStack.size());
        System.out.println(studentStack.isEmpty());

    }
}
