public class Student implements Comparable<Student> {
    
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override 
    public int compareTo(Student o) {
        if(this.name.compareTo(o.name) > 0)
            return 1;
        else if(this.name.compareTo(o.name) < 0)
            return -1;
        else
            return 0;
    }

    @Override 
    public boolean equals(Object o) {
        return this.compareTo((Student)o) == 0;
    }

    @Override 
    public String toString() {
        return this.name;
    }
}
