import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;
public class Program {
    public static void main(String[] str){
        String st = "asdadfsd";
        var result = Function2(st);
        result.forEach( (k,v) -> out.println( k + "  " + v));

    }
    public static Map<Character, Integer> Function1(String str){
        Map<Character, Integer> result = new HashMap<>();
        for(Character ch:str.toCharArray())
            result.compute(ch, (k,v)-> (v == null) ? 1 : ++v);

        return result;
    }
    public static Map<Character, Long> Function2(String str){
        Map<Character, Long> result = str.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(c->c, Collectors.counting()));
        return result;
    }
}
