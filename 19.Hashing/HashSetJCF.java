
import java.util.HashSet;
import java.util.Iterator;

public class HashSetJCF {
    public static void main(String[] args) {
        HashSet<String> cities=new HashSet<>();
        cities.add("Mumbai");
        cities.add("surat");
        cities.add("nagpur");
        cities.add("delhi");

        Iterator it=cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(var city:cities){
            System.out.print(city+" ");
        }

    }
}
