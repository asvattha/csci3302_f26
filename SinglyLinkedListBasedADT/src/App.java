public class App {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("Kevin", 23);
        Student s2 = new Student("Tyler", 33);
        Student s3 = new Student("Sarah", 32);
        Student s4 = new Student("Peter", 20);
        Student s5 = new Student("Maddie", 35);

        SinglyList<Student> studentList = new SinglyList<>();

        System.out.println("Initially empty? " + studentList.isEmpty());
        System.out.println("Initial size: " + studentList.size());

        studentList.add(0, s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(0, s4);

        System.out.println("\nAfter adding elements: ");
        System.out.println("List: " + studentList);
        System.out.println("Size: " + studentList.size());
        System.out.println("Is Empty? " + studentList.isEmpty());

        System.out.println("\nChecking get()");
        System.out.println("Index 0: " + studentList.get(0));

        System.out.println("\nChecking indexof()");
        System.out.println("Index of Tyler: " + studentList.indexOf(s2));
        System.out.println("Index of Maddie: " + studentList.indexOf(s5));

        System.out.println("\nChecking contains");
        System.out.println("Contains Sarah? " + studentList.contains(s3));
        System.out.println("Contains Maddie: " + studentList.contains(s5));

        System.out.println("\nChecking remove");
        studentList.remove(0);
        studentList.remove(s4); // Peter is already removed; hence returns false
        studentList.remove(s3);
        System.out.println("After removing elements: ");
        System.out.println("List: " + studentList);

        System.out.println("\nChecking removeall");
        studentList.clear();
        System.out.println("Size: " + studentList.size());
        System.out.println("Is Empty? " + studentList.isEmpty());

    }
}
