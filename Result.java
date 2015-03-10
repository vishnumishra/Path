import java.util.*;
import java.io.File;

public class Result{
	public static String getResult(String[] args)throws Exception{
        int fileIndex = Arrays.asList(args).indexOf("-f")+1;
        int citiesFileIndex = Arrays.asList(args).indexOf("-c")+1;
        String pathFile = args[fileIndex];
        String citiesFile = args[citiesFileIndex];
        int destIndex = Arrays.asList(args).size()-1;
        String src = args[destIndex-1];
        String dest = args[destIndex];
        Paths paths = new Paths();
        System.out.println("pathFile: "+pathFile+" citiesFile: "+citiesFile);
        if(fileIndex > 0 && !new File(pathFile).exists()) throw new Exception("No dataBase"+pathFile+" is found");
        if(citiesFileIndex > 0 && !new File(citiesFile).exists()) throw new Exception("No dataBase"+citiesFile+" is found");
        paths.db = (fileIndex > 0)?DataBase.getDBFromFile(pathFile):MyDataBase.defaultDataBase();
        paths.cities = (citiesFileIndex > 0)?DataBase.getDBFromFile(citiesFile):null;
        if(!isPresent.city(paths.db,src)) return  " No city named +\""+src+"\" in database";
        if(!isPresent.city(paths.db,dest)) return   " No city named +\""+dest+"\" in database";
        return paths.getPath(src,dest);
	}
}