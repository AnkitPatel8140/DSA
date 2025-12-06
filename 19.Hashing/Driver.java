public class Driver {
    public static void main(String[] args) {
        HashMapImplementation<String, Integer> hm=new HashMapImplementation<>();
        hm.put("abc", 12);
        hm.put("abcuu", 13);
        hm.put("abeec", 15);

        System.out.println(hm.containsKey("abc"));
        hm.remove("abc");
        System.out.println(hm.containsKey("abc"));
        System.out.print(hm);

        System.out.println(hm.getKeys());
    }
}
