import java.util.*;

class Source{
	String src;
	public Source(String src){
		this.src = src; 
	}
	public String toString(){
		return src;
	}
}

class Destination{
	String dest;
	public Destination(String dest){
		this.dest = dest; 
	}
	public String toString(){
		return dest;
	}
}

class DataBase{
	static Map<String,String> db = new  HashMap<String,String>();
	public static Map<String,String> initDataBase(){
		db.put(new String("Bangalore"),new String("Singapore"));
		db.put(new String("Singapore"),new String("Seoul"));
		db.put(new String("Singapore"),new String("Dubai"));
		db.put(new String("Seoul"),new String("Beijing"));
		db.put(new String("Beijing"),new String("Tokyo"));
		return db;
	}
}

public  class Paths{
	static Map<String,String> db = DataBase.initDataBase();
	public static String isDirectFlight(String src,String dest){
		if(!(db.containsKey(src) ||db.containsValue(src) )) return "No city named '"+src+"' in database";
		if(!(db.containsKey(dest)||db.containsValue(dest))) return "No city named '"+dest+"' in database";

		for (String s :db.keySet() ) {
			if(s.equals(src) && db.get(s).equals(dest))
				return "true";
		}
		return  "false";
	}
}