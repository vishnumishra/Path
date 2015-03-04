import java.util.*;

class DataBase{
	static Map<String,List<String>> db = new  HashMap<String,List<String>>();
	public static Map<String,List<String>> initDataBase(){
		List<String> bangalore = new ArrayList<String>();
		List<String> singapore = new ArrayList<String>();
		List<String> seoul = new ArrayList<String>();
		List<String> beijing = new ArrayList<String>();
		List<String> dubai = new ArrayList<String>();
	
		bangalore.add("Singapore");
		singapore.add("Dubai");
		singapore.add("Seoul");
		seoul.add("Beijing");
		beijing.add("Tokyo");
		dubai.add("Finland");

		db.put("Bangalore",bangalore);
		db.put("Singapore",singapore);
		db.put("Seoul",seoul);
		db.put("Beijing",beijing);
		db.put("Dubai",dubai);
		return db;
	}
}

class isPresent{
	public static boolean city(Map<String,List<String>> db,String src ){
		if(db.containsKey(src)) return true;
		for (String s :db.keySet()) {
			if(db.get(s).contains(src)) return true;
		}
		return false;
	}
}

public  class Paths{
	static  Map<String,List<String>> db = DataBase.initDataBase();
    private static Set<String> intermediateCitys = new HashSet<String>();
    private static boolean hasPath(String src, String dest){
        List<String> list = db.get(src);
        intermediateCitys.add(src);
        if(list == null) return false;
        if (list.contains(dest) || src == dest){
            intermediateCitys.add(dest);
            return true;
        }
        for (String city:list) {
            intermediateCitys.add(city);
            if (hasPath(city, dest)) return true;   
        }
    	return false;
    }

    public  static boolean hasAnyPath(String src, String dest)throws Exception{
        if(!isPresent.city(db,src))
            throw new Exception("No city named \""+src+"\" in database");
        if(!isPresent.city(db,dest))
            throw new Exception("No city named \""+dest+"\" in database");
        return (hasPath(src,dest))?true:hasPath(dest,src);
    }

    public static String getPath(String src,String dest)throws Exception{
    	if(hasAnyPath(src,dest))
    		return intermediateCitys.toString();
    	return "Sorry no path";
    }
}