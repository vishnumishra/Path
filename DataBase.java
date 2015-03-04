import java.util.*;
public class DataBase{
	static Map<String,ArrayList<String>> data = new  HashMap<String,ArrayList<String>>();
	public static void insert(String src,String dest){
		ArrayList<String> list = new ArrayList<String>();
		if(data.containsKey(src)){
			data.get(src).add(dest);
		}
		else{
			list.add(dest);
			data.put(src,list);
		}
	}
	public String toString(){
		return data.toString();
	}
}
