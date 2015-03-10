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
    private  int count;
    private List<String> path = new ArrayList<String>();
    private List<String> visited = new ArrayList<String>();
    Map<String,ArrayList<String>> db ;
    Map<Integer,ArrayList<String>> allPaths = new HashMap<Integer, ArrayList<String>>();
    Map<String,ArrayList<String>> cities ;
    private boolean hasPath(String src, String dest){
        visited.add(src);
        ArrayList<String> list = db.get(src);
        if(list != null ){
            if (list.contains(dest)){
                allPaths.put(++count, (ArrayList<String>) ((ArrayList<String>)path).clone());
                visited.clear();
                path.remove(dest);
                return true;
            }
            for (String city:db.get(src)) {
                if(!visited.contains(city))
                    path.add(city);
                hasPath(city,dest);
                path.remove(city);
            }
            return true;
        }
        return false;
    }

//    public boolean hasAnyPath(String src, String dest){
//        return (hasPath(src,dest))?true:hasPath(dest,src);
//    }

    public static <T> List<T> reverseList(List<T> list){
        List<T> reversedList=new ArrayList<T>();
        for (T item : list) {
            reversedList.add(0,item);
        }
        return reversedList;
    }

    public List<String> addInfo(List<String> cities ,Map<String,ArrayList<String>> countryInfo){
        List<String> result =new ArrayList<String>();
        String country = "";
        for (String city:cities){
            if(countryInfo.containsKey(city)){
                country =  countryInfo.get(city).get(0);
            }
            result.add(city+"["+country+"]");
        }
        return result;
    }
    public String getPath(String src,String dest) {
        List<String> result = null;
        List<String> cityWithCountry;
        String routes="";
        result = hasPath(src, dest) ? allPaths.get(1):hasPath(dest, src) ? reverseList(allPaths.get(1)):result;
        for (int i=1;i<allPaths.size()+1;i++){
            if(result != null){
                result = allPaths.get(i);
                result.add(0,src);
                result.add(dest);
                cityWithCountry = (cities != null)?addInfo(result,cities):result;
                routes = routes+"\n"+i+". "+String.join("==>",cityWithCountry);
            }else  return "No route find";
        };
        return routes;
    }
    public static void main(String args[]){
        String result="";
        try{
            result =  Result.getResult(args);
        }catch (Exception e){
//            result=e;
            System.out.println(e);
        }
        System.out.println(result);
    }

}
