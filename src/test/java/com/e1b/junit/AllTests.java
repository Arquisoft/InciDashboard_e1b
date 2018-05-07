package com.e1b.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestIncidence.class, 
	TestInciService.class, 
	TestOperario.class,
	TestOperariosService.class 
})
public class AllTests {

}
