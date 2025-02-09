package ListenersTestNG;

import org.testng.Assert;
import org.testng.SkipException;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenersTestNG.Listeners.class)  //это что бы ссылаться на файл в котором все слушатели (папка.название со слушателями.class)
public class TestWithListenersTestNG {
	
	@Test(priority = 3)    //(priority = 3) для настргойки очерёдности выполнения тестов
	public void test() {
		System.out.println("test");
	}
	
	@Test(priority = 1)
	public void test1() {
		System.out.println("test1");
		Assert.assertTrue(false);          // тест будет проваленым
	}
	
	@Test(priority = 2)
	public void test2() {
		System.out.println("test2");
		throw new SkipException("Skipped test2");        // тест будет пропущен
	}

	
}
