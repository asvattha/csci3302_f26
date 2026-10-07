public class App {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("Kevin", 23);
        Student s2 = new Student("Tyler", 33);
        Student s3 = new Student("Sarah", 32);
        Student s4 = new Student("Peter", 20);
        Student s5 = new Student("Madison", 35);

        LinkedList<Student> studentList = new LinkedList<>();

        System.out.println("Initially empty? " + studentList.isEmpty()); // true
        System.out.println("Initial size: " + studentList.size()); // 0

        studentList.add(0, s1); //["Kevin"]
        studentList.add(s2); // ["Kevin", "Tyler"]
        studentList.add(s3); // ["Kevin", "Tyler", "Sarah"] 
        studentList.add(0, s4); // ["Peter", "Kevin", "Tyler", "Sarah"]

        System.out.println("\nAfter adding elements: ");
        System.out.println("List: " + studentList); // ["Peter", "Kevin", "Tyler", "Sarah"]
        System.out.println("Size: " + studentList.size()); // 4
        System.out.println("Is Empty? " + studentList.isEmpty()); // false

        System.out.println("\nChecking get()");
        System.out.println("Index 0: " + studentList.get(0)); // "Peter"

        System.out.println("\nChecking indexof()");
        System.out.println("Index of Tyler: " + studentList.indexOf(s2)); // 2
        System.out.println("Index of Madison: " + studentList.indexOf(s5)); // "-1"

        System.out.println("\nChecking contains");
        System.out.println("Contains Sarah? " + studentList.contains(s3)); // true
        System.out.println("Contains Justin: " + studentList.contains(s5)); // false

        System.out.println("\nChecking remove");
        studentList.remove(0); // ["Kevin", "Tyler", "Sarah"]
        studentList.remove(s4); // Peter is already removed; hence returns false
        studentList.remove(s3); // ["Kevin", "Tyler"]
        System.out.println("After removing elements: ");
        System.out.println("List: " + studentList); // ["Kevin", "Tyler"]

        System.out.println("\nChecking removeall");
        studentList.clear();
        System.out.println("Size: " + studentList.size()); // 0
        System.out.println("Is Empty? " + studentList.isEmpty()); // true

    }
}