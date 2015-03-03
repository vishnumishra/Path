import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest{

	@Test
	public void paths_tell_that_their_is_direct_path_or_not()throws Exception{
		boolean predicate = Paths.isDirectFlight("Bangalore","Singapore");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_is_direct_path_or_not_01()throws Exception{
		boolean predicate = Paths.isDirectFlight("Bangalore","Tokyo");
		assertEquals(false,predicate);
	}
	
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base(){
	 	Map<String,List<String>> db = DataBase.initDataBase();
		assertEquals(isPresent.src(db,"Singapore"),true);
	}
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base_01(){
	 	Map<String,List<String>> db = DataBase.initDataBase();
		assertEquals(isPresent.src(db,"Stockholm"),false);
	}
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base_02(){
	 	Map<String,List<String>> db = DataBase.initDataBase();
		assertEquals(isPresent.src(db,"Chennai"),false);
	}

}