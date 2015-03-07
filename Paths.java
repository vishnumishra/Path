import java.util.*;

class MyDataBase{
	public static Map<String,ArrayList<String>> initDataBase(){
		DataBase db = new DataBase();
        db.insert("Bangalore", "Singapore");
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
    private Deque<String> path = new ArrayDeque<String>();
    Map<String,ArrayList<String>> db = MyDataBase.initDataBase();
    private boolean hasPath(String src, String dest){
        ArrayList<String> list = db.get(src);
        if(list != null){
            if (list.contains(dest)){
                return true;
            }
            for (String city:list) {
                if (hasPath(city, dest)){   
                    path.add(city);
                    return true;   
                } 
            }
        } 
        return false;
    }

    public boolean hasAnyPath(String src, String dest)throws Exception{
        if(!isPresent.city(db,src))
            throw new Exception("No city named \""+src+"\" in database");
        if(!isPresent.city(db,dest))
            throw new Exception("No city named \""+dest+"\" in database");
        return (hasPath(src,dest))?true:hasPath(dest,src);
    }

    public String getPath(String src,String dest)throws Exception{
        path.clear();
        String result =src;
        if(hasPath(src,dest)){
            for(Iterator descItr = path.descendingIterator();descItr.hasNext();) {
                result += "==>"+descItr.next();
             }
            return result+"==>"+dest;
        }
        if(hasPath(dest,src)){
            for(Iterator itr = path.iterator();itr.hasNext();) {
                result += "==>"+itr.next();
             }
            return result+"==>"+dest;
        }
    	return "Sorry no path";
    }
}