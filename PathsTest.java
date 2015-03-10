import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest{
	public Paths p;
	public void setUp(){
		p=new Paths();
        p.db = MyDataBase.defaultDataBase();
	}

	@Test
	public void paths_tell_that_are_any_path_btwn_Bangalore_to_Singapore(){
		setUp();
		boolean predicate = p.hasAnyPath("Bangalore","Singapore");
		assertEquals(true,predicate);
	}

	// @Test
	// public void hasAnyPath_tell_that_the_Gugrat_is_not_in_dataBase(){
	// 	setUp();
	// 	try{
	// 		boolean predicate = p.hasAnyPath("Gugrat","Singapore");
	// 	}catch(Exception e){
	// 		assertEquals(e.getMessage(),"No city named \"Gugrat\" in database");
	// 	}
	// }
	// @Test
	// public void hasAnyPath_tell_that_the_Japan_is_not_in_dataBase(){
	// 	setUp();
	// 	try{
	// 		boolean predicate = p.hasAnyPath("Bangalore","Japan");
	// 	}catch(Exception e){
	// 		assertEquals(e.getMessage(),"No city named \"Japan\" in database");
	// 	}
	// }



	@Test
	public void paths_tell_that_their_any_path_btwn_Bangalore_to_Tokyo(){
		setUp();
		boolean predicate = p.hasAnyPath("Bangalore","Tokyo");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_btwn_Tokyo_to__Bangalore(){
		setUp();
		boolean predicate = p.hasAnyPath("Tokyo","Bangalore");
		assertEquals(true,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Bangalore_to_Finland(){
		setUp();
		boolean predicate = p.hasAnyPath("Bangalore","Finland");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_From_Finland_to_Bangalore(){
		setUp();
		boolean predicate = p.hasAnyPath("Finland","Bangalore");
		assertTrue(predicate);
	}
    @Test
    public  void getPath_give_the_path_between_Finland_to_Singapore(){
		setUp();
        String path = p.getPath("Finland","Singapore");
        assertEquals("Finland==>Dubai==>Singapore",path);
    }
    @Test
    public  void getPath_give_the_path_between_Singapore_to_Finland(){
		setUp();
        String path = p.getPath("Singapore","Finland");
        assertEquals("Singapore==>Dubai==>Finland",path);
    }
    @Test
    public  void getPath_give_the_path_between_Bangalore_to_singapore(){
		setUp();
        String path = p.getPath("Bangalore","Singapore");
        assertEquals("Bangalore==>Singapore",path);
    }
    @Test
    public  void getPath_give_the_path_between_singapore_to_Bangalore(){
		setUp();
        String path = p.getPath("Singapore","Bangalore");
        assertEquals("Singapore==>Bangalore",path);
    }
    @Test
    public  void getPath_give_the_path_between_Tokyo_to_Bangalore(){
		setUp();
        String path = p.getPath("Tokyo","Bangalore");
        assertEquals("Tokyo==>Beijing==>Seoul==>Singapore==>Bangalore",path);
    }
   @Test
   public  void getPath_give_the_path_between_Bangalore_to_Tokyo(){
		setUp();
       String path = p.getPath("Bangalore","Tokyo");
       assertEquals("Bangalore==>Singapore==>Seoul==>Beijing==>Tokyo",path);
   }
    @Test
	public void reverseList_reverse_the_list_element(){
		setUp();
		List<String> list = Arrays.asList("Bangalore","Singapore","Tokyo","Beijing");
		List<String> reverseList = Paths.reverseList(list);
		assertEquals("[Beijing, Tokyo, Singapore, Bangalore]",reverseList.toString());
    }
    @Test
    public void getDBFromFile_create_data_base_from_file_01(){
        p=new Paths();
        p.db = DataBase.getDBFromFile("Paths.txt");
        assertEquals(p.db.containsKey("Finland"),false);
        assertEquals(p.db.containsKey("Beijing"),true);
        assertEquals(p.db.containsKey("Seoul"),true);
        assertEquals(p.db.containsKey("Singapore"),true);
    }
    @Test
    public void getDBFromFile_create_data_base_from_file_02(){
        p=new Paths();
        p.db = DataBase.getDBFromFile("Paths.txt");
        assertEquals(p.db.containsKey("Singapore"),true);
    }

    @Test
    public  void getPath_is_working_for_file_data_base(){
        p=new Paths();
        p.db = DataBase.getDBFromFile("Paths.txt");
        String path = p.getPath("Bangalore","Tokyo");
        assertEquals("Bangalore==>Singapore==>Seoul==>Beijing==>Tokyo",path);
    }
    @Test
    public  void getPath_is_working_for_file_data_base_02(){
        p=new Paths();
        p.db = DataBase.getDBFromFile("Paths.txt");
        String path = p.getPath("Bangalore","Singapore");
        assertEquals("Bangalore==>Singapore",path);
    }
    @Test
    public void addInfo_add_the_country_info_with_city(){
        setUp();
        List<String> city = new ArrayList<String>();
        List<String> result;
        List<String> actual = new ArrayList<String>();
        actual.add("delhi[India]");
        ArrayList<String> country = new ArrayList<String>();
        country.add("India");
        Map<String,ArrayList<String>> mappedCity = new HashMap<String,ArrayList<String>>();
        mappedCity.put("delhi",country);
        city.add("delhi");
        result = p.addInfo(city,mappedCity);
        assertArrayEquals(actual.toArray(),result.toArray());
    }
    @Test
    public void addInfo_add_the_country_info_with_multiple_city(){
        setUp();
        List<String> city = new ArrayList<String>();
        List<String> result;
        List<String> actual = new ArrayList<String>();
        actual.add("delhi[India]");
        actual.add("lahore[Pak]");
        ArrayList<String> country1 = new ArrayList<String>();
        ArrayList<String> country2 = new ArrayList<String>();
        country1.add("India");
        country2.add("Pak");
        Map<String,ArrayList<String>> mappedCity = new HashMap<String,ArrayList<String>>();
        mappedCity.put("delhi",country1);
        mappedCity.put("lahore",country2);
        city.add("delhi");
        city.add("lahore");
        result = p.addInfo(city,mappedCity);
        assertArrayEquals(actual.toArray(),result.toArray());
    }

}
