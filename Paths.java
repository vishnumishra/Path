import java.util.*;

class MyDataBase{
	public static Map<String,ArrayList<String>> initDataBase(){
		DataBase db = new DataBase(); 
		db.insert("Bangalore","Singapore");
		db.insert("Singapore","Dubai");
		db.insert("Singapore","Seoul");
		db.insert("Seoul","Beijing");
		db.insert("Beijing","Tokyo");
		db.insert("Dubai","Finland");
		return db.data;
	}
}

class isPresent{
	public static boolean city(Map<String,ArrayList<String>> db,String src ){
		if(db.containsKey(src)) return true;
		for (String s :db.keySet()) {
			if(db.get(s).contains(src)) return true;
		}
		return false;
	}
}

public  class Paths{
	static  Map<String,ArrayList<String>> db = MyDataBase.initDataBase();
    private static Set<String> intermediateCitys = new HashSet<String>();
    private static boolean hasPath(String src, String dest){
        ArrayList<String> list = db.get(src);
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