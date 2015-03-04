public class Main{
	public static void main(String[] args) {
		if(args.length<2){
			System.out.println("please provide two arguments 1.source and 2.destination");
			System.exit(1);
		}
		try{
			String result = Paths.getPath(args[0].toString(),args[1].toString());
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}