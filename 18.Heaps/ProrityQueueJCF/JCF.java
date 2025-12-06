import java.util.PriorityQueue;

class Student implements Comparable<Student>{
    int rank;
    String name;

    public Student(String name, int rank){
        this.name=name;
        this.rank=rank;
    }

    @Override
    public int compareTo(Student s2){
        return this.rank-s2.rank;
    }
}

public class JCF {


    public static void main(String[] args) {
        PriorityQueue<Student> pq=new PriorityQueue<>();
        pq.add(new Student("A", 12));
        pq.add(new Student("B", 13));
        pq.add(new Student("N", 1));
        pq.add(new Student("K", 45));
        System.out.println(pq.peek().name);
        pq.remove();
        System.out.println(pq.peek().name);
        pq.remove();
        System.out.println(pq.peek().name);
        pq.remove();
        System.out.println(pq.peek().name);
    }
}
