package com.sdlx.sh.vector.multidb.xdb;

import com.sdlx.sh.vector.multidb.xdb.entity.Country;
import com.sdlx.sh.vector.multidb.xdb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XdbApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCluster(){
		Country country = new Country();
		country.setCountryCode("199");
		country.setCountryName("IR");
		try {
			userService.insert(country);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test
	public void testMaster(){
		Country country = new Country();
		country.setCountryCode("399");
		country.setCountryName("BR");
		try {
			userService.insertMaster(country);
		}catch (Exception e) {
			e.printStackTrace();
		}


	}


}
