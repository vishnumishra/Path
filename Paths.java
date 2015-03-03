import java.util.*;

class DataBase{
	static Map<String,List<String>> db = new  HashMap<String,List<String>>();
	public static Map<String,List<String>> initDataBase(){
		List<String> bangalore = new ArrayList<String>();
		bangalore.add("Singapore");
		List<String> singapore = new ArrayList<String>();
		singapore.add("Seoul");
		singapore.add("Dubai");
		List<String> seoul = new ArrayList<String>();
		seoul.add("Beijing");
		List<String> beijing = new ArrayList<String>();
		beijing.add("Tokyo");

		db.put("Bangalore",bangalore);
		db.put("Singapore",singapore);
		db.put("Seoul",seoul);
		db.put("Beijing",beijing);
		return db;
	}
}

class isPresent{
	public static boolean src(Map<String,List<String>> db,String src ){
		if(db.containsKey(src)) return true;
		for (String s :db.keySet()) {
			if(db.get(s).contains(src)) return true;
		}
		return false;
	}
}

public  class Paths{
	static Map<String,List<String>> db = DataBase.initDataBase();
	public static boolean isDirectFlight(String src,String dest)throws Exception{
		if(!isPresent.src(db,src)){
			throw new Exception("No city named '"+src+"' in database");
		}
		if(!isPresent.src(db,dest)){
			throw new Exception("No city named '"+dest+"' in database");
		}

		if(db.get(src).contains(dest))
			return true;
		return  false;
	}
}