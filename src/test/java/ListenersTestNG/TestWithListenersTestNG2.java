package ListenersTestNG;

import org.testng.Assert;
import org.testng.SkipException;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenersTestNG.Listeners.class)  //это что бы ссылаться на файл в котором все слушатели (папка.название со слушателями.class)
public class TestWithListenersTestNG2 {
	
	@Test(priority = 3)   //(priority = 3) для настргойки очерёдности выполнения тестов
	public void test4() {
		System.out.println("test4");
	}
	
	@Test(priority = 2)
	public void test5() {
		System.out.println("test5");
		throw new SkipException("Skipped test6");        // тест будет пропущен
		
	}
	
	@Test(priority = 1)
	public void test6() {
		System.out.println("test6");
		Assert.assertTrue(false);          // тест будет проваленым
	}

}
