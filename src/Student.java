import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable, Comparable<Student> {
    String jmeno;

    int znamka;


    public Student(String jmeno, int znamka) {
        this.jmeno = jmeno;
        this.znamka = znamka;

    }

    @Override
    public String toString() {
        return "Student{" +
                "jmeno='" + jmeno + '\'' +
                ", znamka=" + znamka +
                '}';
    }

    @Override
    public int compareTo(Student st) {
        return jmeno.compareTo(st.jmeno);
    }
}
