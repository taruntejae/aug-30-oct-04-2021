import java.util.*;


public class CollectionsInJava  {
	public static void main(String[] args) {
		List<String> langs = Arrays.asList("Hindi", "Tamil", "Kannada");
		langs.forEach(System.out::println);
		
// 		Iterator<String> itr = langs.iterator();
// 		while(itr.hasNext()) {
// 			String lang = itr.next();
// 			System.out.println(lang);
// 		}
	}
}