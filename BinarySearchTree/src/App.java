public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Kevin", 23);
        Student s2 = new Student("Tyler", 33);
        Student s3 = new Student("Sarah", 32);
        Student s4 = new Student("Peter", 20);
        Student s5 = new Student("Maddie", 35);
        Student s6 = new Student("Alice", 29);

        BST<Student> myStudentTree = new BST<>();
        myStudentTree.isEmpty();

        myStudentTree.add(s1);
        myStudentTree.add(s2);
        myStudentTree.add(s3);
        myStudentTree.add(s4);
        myStudentTree.add(s5);
        myStudentTree.add(s6);

        System.out.println("BST Tree\n");

        System.out.println(myStudentTree);

        myStudentTree.remove(s1);
        myStudentTree.remove(s3);

        System.out.println("Tree after deletion\n");

        System.out.println(myStudentTree);
    }
}
