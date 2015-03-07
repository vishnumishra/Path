import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest{
	@Test
	public void paths_tell_that_are_any_path_btwn_Bangalore_to_Singapore()throws Exception{
		Paths p= new Paths();
		boolean predicate = p.hasAnyPath("Bangalore","Singapore");
		assertEquals(true,predicate);
	}
	@Test
	public void hasAnyPath_tell_that_the_Gugrat_is_not_in_dataBase()throws Exception{
		Paths p= new Paths();
		try{
			boolean predicate = p.hasAnyPath("Gugrat","Singapore");
		}catch(Exception e){
			assertEquals(e.getMessage(),"No city named \""+"Gugrat"+"\" in database");
		}
	}
	@Test
	public void hasAnyPath_tell_that_the_Japan_is_not_in_dataBase()throws Exception{
		Paths p= new Paths();
		try{
			boolean predicate = p.hasAnyPath("Bangalore","Japan");
		}catch(Exception e){
			assertEquals(e.getMessage(),"No city named \""+"Japan"+"\" in database");
		}
	}

	@Test
	public void paths_tell_that_their_any_path_btwn_Bangalore_to_Tokyo()throws Exception{
		Paths p= new Paths();
		boolean predicate = p.hasAnyPath("Bangalore","Tokyo");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_btwn_Tokyo_to__Bangalore()throws Exception{
		Paths p= new Paths();
		boolean predicate = p.hasAnyPath("Tokyo","Bangalore");
		assertEquals(true,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Bangalore_to_Finland()throws Exception{
		Paths p= new Paths();
		boolean predicate = p.hasAnyPath("Bangalore","Finland");
		assertEquals(true,predicate);
	}
	@Test
		public void paths_tell_that_their_any_path_From_Finland_to_Bangalore()throws Exception{
		Paths p= new Paths();
		boolean predicate = p.hasAnyPath("Finland","Bangalore");
		assertTrue(predicate);
	}
    @Test
        public  void getPath_give_the_path_between_Finland_to_Singapore()throws Exception{
		Paths p= new Paths();
        String path = p.getPath("Finland","Singapore");
        assertEquals("Finland==>Dubai==>Singapore",path);
    }
    @Test
        public  void getPath_give_the_path_between_Singapore_to_Finland()throws Exception{
		Paths p= new Paths();
        String path = p.getPath("Singapore","Finland");
        assertEquals("Singapore==>Dubai==>Finland",path);
    }
    @Test
        public  void getPath_give_the_path_between_Bangalore_to_singapore()throws Exception{
		Paths p= new Paths();
        String path = p.getPath("Bangalore","Singapore");
        assertEquals("Bangalore==>Singapore",path);
    }
    @Test
        public  void getPath_give_the_path_between_singapore_to_Bangalore()throws Exception{
		Paths p= new Paths();
        String path = p.getPath("Singapore","Bangalore");
        assertEquals("Singapore==>Bangalore",path);
    }
    @Test
        public  void getPath_give_the_path_between_Tokyo_to_Bangalore()throws Exception{
		Paths p= new Paths();
        String path = p.getPath("Tokyo","Bangalore");
        assertEquals("Tokyo==>Beijing==>Seoul==>Singapore==>Bangalore",path);
    }
    @Test
        public  void getPath_give_the_path_between_Bangalore_to_Tokyo()throws Exception{
		Paths p= new Paths();
        String path = p.getPath("Bangalore","Tokyo");
        assertEquals("Bangalore==>Singapore==>Seoul==>Beijing==>Tokyo",path);
    }
    
}
