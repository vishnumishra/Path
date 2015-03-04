// import java.util.*;

// class Path{
// 	static  Map<String,List<String>> db = DataBase.initDataBase();
//     private static Set<String> intermediateCitys = new HashSet<String>();
//     private static boolean hasPath(String src, String dest){
//         List<String> list = db.get(src);
//         intermediateCitys.add(src);
//         if(list == null) return false;

//         if (list.contains(dest) || src == dest){
//             intermediateCitys.add(dest);
//             return true;
//         }
//         for (int i = 0; i < list.size(); i++) {
//             String city = list.get(i);
//             intermediateCitys.add(city);
//             if (hasPath(city, dest)) return true;   
//         }
//     	return false;
//     }

//     public  static boolean checkAndClear(String src, String dest)throws Exception{
//         if(!isPresent.city(db,src))
//             throw new Exception("No city named \""+src+"\" in database");
//         if(!isPresent.city(db,dest))
//             throw new Exception("No city named \""+dest+"\" in database");
//         boolean result = (hasPath(src,dest))?true:hasPath(dest,src);
//         System.out.println("-----------intermediateCitys ---------\n"+intermediateCitys);
//         return result;
//     }
// }
// // public class Spike1 {
// //     public static void main(String[] args){
// //         try{
// //     		boolean result = Path.checkAndClear("Bangalore","Bangalore");
// //         }catch(Exception e){
// //             System.out.println(e.getMessage());
// //         }
// // 	}
// // }