public class Main{
	public static void main(String[] args) {
		System.out.println(args[0]+" "+args[1]);

		try{
			boolean result = Paths.isDirectFlight(args[0].toString(),args[1].toString());
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}