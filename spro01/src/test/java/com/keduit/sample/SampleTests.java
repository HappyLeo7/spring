package com.keduit.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
//메인 없이도 실행가능
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		System.out.println("test1---------");
		log.info(restaurant);
		log.info("-----------------------");
		log.info(restaurant.getChef());
	}
	
	@Setter(onMethod_ = {@Autowired})
	private Hotel hotel;
	
	@Test
	public void testEcistHotel() {
		assertNotNull(hotel);
		System.out.println("testhotel-------");
		log.info(hotel);
		log.info("---------");
		log.info(hotel.getChef());
	}
	
	
}
