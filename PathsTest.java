import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest{

	@Test
	public void paths_tell_that_their_is_direct_path_or_not(){
		String predicate = Paths.isDirectFlight("Bangalore","Singapore");
		assertEquals("true",predicate);
	}
	@Test
	public void paths_tell_that_their_is_direct_path_or_not_01(){
		String predicate = Paths.isDirectFlight("Bangalore","Tokyo");
		assertEquals("false",predicate);
	}
	
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base(){
		String predicate = Paths.isDirectFlight("Chennai","Tokyo");
		assertEquals("No city named 'Chennai' in database",predicate);
	}
	
	@Test
	public void paths_tell_if_the_city_no_present_in_data_base_01(){
		String predicate = Paths.isDirectFlight( "Bangalore","Stockholm");
		assertEquals("No city named 'Stockholm' in database",predicate);
	}
}