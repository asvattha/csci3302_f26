public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override 
    public int compareTo(Student s) {
        if(this.name.compareTo(s.name) > 0)
            return 1;
        else if (this.name.compareTo(s.name) < 0)
            return -1;
        else
            return 0;
    }

    @Override 
    public String toString() {
        return "(" + this.name + ", " + this.age + ")";
    }
}
