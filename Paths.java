import java.util.*;

class MyDataBase{
	public static Map<String,ArrayList<String>> defaultDataBase(){
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

public class Paths{
    private List<String> path = new ArrayList<String>();
    private List<String> visited = new ArrayList<String>();
    Map<String,ArrayList<String>> db ;
    private boolean hasPath(String src, String dest){
        path.clear();
        ArrayList<String> list = db.get(src);
        if(list != null && !visited.contains(src)){
            visited.add(src);
            if (list.contains(dest)){
                return true;
            }
            for (String city:list) {
                if (hasPath(city,dest)){
                    path.add(city);
                    return true;
                }
            }
        } 
        return false;
    }

    public boolean hasAnyPath(String src, String dest){
        return (hasPath(src,dest))?true:hasPath(dest,src);
    }

    public static <T> List<T> reverseList(List<T> list){
        List<T> reversedList=new ArrayList<T>();
        for (T item : list) {
            reversedList.add(0,item);
        }
        return reversedList;
    }

    public String getPath(String src,String dest) {
        List<String> result;
        result = hasPath(src, dest) ? reverseList(path) : hasPath(dest, src) ? path : null;
        if(result != null){
            result.add(0,src);
            result.add(dest);
          return String.join("==>",result);
        }
        return "No route find";
    }
    public static void main(String args[]){
        String result;
        try{
            result =  Result.getResult(args);
        }catch (Exception e){
            result=e.getMessage();
        }
        System.out.println(result);
    }

}
