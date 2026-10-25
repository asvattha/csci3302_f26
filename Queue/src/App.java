import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Kevin", 23);
        Student s2 = new Student("Tyler", 33);
        Student s3 = new Student("Sarah", 32);
        Student s4 = new Student("Peter", 20);
        Student s5 = new Student("Madison", 35);

        //RefQueue<Student> studentQueue = new RefQueue<>();

        CircularQueue<Student> studentQueue = new CircularQueue<>();
        System.out.println(studentQueue.isEmpty()); // true
        System.out.println(studentQueue.size());// 0

        studentQueue.enqueue(s1); // Kevin
        studentQueue.enqueue(s2); // Kevin, Tyler
        studentQueue.enqueue(s3); // Kevin, Tyler, Sarah

        System.out.println("After elements are added onto queue");
        System.out.println(studentQueue);

        try {
            studentQueue.dequeue(); // Tyler, Sarah (Kevin is removed)
            studentQueue.dequeue(); // Sarah (Tyler is removed)
        } catch(MyEmptyQueueException ex) {
            ex.getMessage();
        }

        studentQueue.enqueue(s4); // Sarah, Peter
        studentQueue.enqueue(s5); // Sarah, Peter, Madison

        System.out.println(studentQueue.size());
        System.out.println(studentQueue.isEmpty());

        System.out.println(studentQueue);

        studentQueue.removeAll();
        System.out.println(studentQueue.size());
        System.out.println(studentQueue.isEmpty());

    }
}
