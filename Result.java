import java.util.*;
import java.io.File;

public class Result{
	public static String getResult(String[] args)throws Exception{
        int fileIndex = Arrays.asList(args).indexOf("-f")+1;
        String fileName  = args[fileIndex];
        int destIndex = Arrays.asList(args).size()-1;
        String src = args[destIndex-1];
        String dest = args[destIndex];
        Paths paths = new Paths();
        if(!new File(fileName).exists()) throw new Exception("No dataBase"+fileName+" is found");
        paths.db = (fileIndex > 0)?DataBase.getDBFromFile(fileName):MyDataBase.defaultDataBase();
        if(!isPresent.city(paths.db,src)) return  " No city named +\""+src+"\" in database";
        if(!isPresent.city(paths.db,dest)) return   " No city named +\""+dest+"\" in database";
        return paths.getPath(src,dest);
	}
}