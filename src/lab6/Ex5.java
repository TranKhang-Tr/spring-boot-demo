package lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex5 {
public static void main(String[] args) {
	Map<String, List<Integer>> p = new HashMap<>();
	
	List<Integer> l = new ArrayList<>();
	l.add(1);
	l.add(2);
	l.add(3);
	l.add(4);
	
	p.putIfAbsent("key", new ArrayList<>());
	p.get("key").addAll(l);
	p.put("Category", l);
	p.put("CATEGORY", l);
	System.out.println(p.containsKey("key"));
	
	
	System.out.println(p);
	
}
}
