import java.util.HashMap;

public class Journey {

    public static String getStart(HashMap<String,String> tickets){
        // step1 - create a reverese map [ To->From ]
        HashMap<String,String> revMap=new HashMap<>();
        for (String ticket : tickets.keySet()) {
            revMap.put(tickets.get(ticket),ticket);
        }

        // step1 - check for those ticket which exist in {From} but not in {To}
        for (String ticket : tickets.keySet()) {
            if(!revMap.containsKey(ticket)){
                return ticket;
            }
        }

        return null;
    }
    public static void main(String[] args) {

        HashMap<String,String> tickets=new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // step1 - get the starting point of the journey
        String start=getStart(tickets);
        System.out.print(start);

        for(String key:tickets.keySet()){
            System.out.print(" -> "+tickets.get(start));
            start=tickets.get(start);
        }

    }
}
