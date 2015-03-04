import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest{

	@Test
	public void paths_tell_that_are_any_path_btwn_Bangalore_to_Singapore()throws Exception{
		boolean predicate = Paths.hasAnyPath("Bangalore","Singapore");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_btwn_Bangalore_to_Tokyo()throws Exception{
		boolean predicate = Paths.hasAnyPath("Bangalore","Tokyo");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_btwn_Tokyo_to__Bangalore()throws Exception{
		boolean predicate = Paths.hasAnyPath("Tokyo","Bangalore");
		assertEquals(true,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Bangalore_to_Finland()throws Exception{
		boolean predicate = Paths.hasAnyPath("Bangalore","Finland");
		assertEquals(true,predicate);
	}
	@Test
		public void paths_tell_that_their_any_path_From_Finland_to_Bangalore()throws Exception{
		boolean predicate = Paths.hasAnyPath("Finland","Bangalore");
		assertTrue(predicate);
	}

	@Test
	public void paths_tell_if_the_city_no_present_in_data_base(){
	 	Map<String,List<String>> db = DataBase.initDataBase();
		assertEquals(isPresent.city(db,"Singapore"),true);
	}
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base_01(){
	 	Map<String,List<String>> db = DataBase.initDataBase();
		assertEquals(isPresent.city(db,"Stockholm"),false);
	}
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base_02(){
	 	Map<String,List<String>> db = DataBase.initDataBase();
		assertEquals(isPresent.city(db,"Chennai"),false);
	}
}