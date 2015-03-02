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

class isPresent{
	public static boolean element(Map<Source,Destination>db,String src){
		boolean result = false ;
		for(Source s :db.keySet())
			if(s.toString().equals(new Source(src).toString())) result = true;
		for(Source v :db.keySet()) 
			if(db.get(v).toString().equals(new Source(src).toString())) result = true;
		return result;
	}
}


class DataBase{
	static Map<Source,Destination> db = new  HashMap<Source,Destination>();
	public static Map<Source,Destination> initDataBase(){
		db.put(new Source("Bangalore"),new Destination("Singapore"));
		db.put(new Source("Singapore"),new Destination("Seoul"));
		db.put(new Source("Singapore"),new Destination("Dubai"));
		db.put(new Source("Seoul"),new Destination("Beijing"));
		db.put(new Source("Beijing"),new Destination("Tokyo"));
		return db;
	}
}

public  class Paths{
	static Map<Source,Destination> db = DataBase.initDataBase();
	public static String isDirectFlight(String src,String dest){

		if(!isPresent.element(db,src)) return "No city named '"+src+"' in database";
		if(!isPresent.element(db,dest)) return "No city named '"+dest+"' in database";
		for(Source s :db.keySet()) {
			if(s.toString() == src && db.get(s).toString() == dest)
				return "true";
		}
		return  "false";
	}
}