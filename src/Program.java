import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] str){
        String st = "Ура_товарищи!";
        Function2(st);
    }
    public static void Function1(String str){
        char[] arr = str.toCharArray();
        Map<Character, Integer> duplicate = new HashMap<>();
        for(Character ch:arr)
            duplicate.compute(ch, (k,v) -> v == null ? 1 : ++v);
        Stream<Map.Entry<Character, Integer>> result = duplicate.entrySet().stream().filter(e-> e.getValue() > 1);
        result.forEach( e-> System.out.println(e.getKey() + " " + e.getValue()) );
    }
    public static void Function2(String str){
        var result = str.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e, Collectors.counting()))
                                                       .entrySet().stream().filter(e->e.getValue() > 1).collect(Collectors.toList());
        result.forEach( e-> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
