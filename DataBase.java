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

    public static Map<String,ArrayList<String>> getDBFromFile(String fileName){
        String file = null;
        try{
            file = MyReader.readFile(fileName);
        }catch (Exception e){};
        String[] lines = file.trim().split("\n");
        for(String from : lines){
          String src = from.split(",")[0];
          String dest = from.split(",")[1];
          insert(src.trim(), dest.trim());
        }
        return data;
    }
	public String toString(){
		return data.toString();
	}
}
