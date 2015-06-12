package com.jacademy.y04mybatis.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jacademy.y04mybatis.domain.Hero;
import com.jacademy.y04mybatis.domain.HeroInfo;
import com.jacademy.y04mybatis.service.HeroService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class HeroServiceImplTest {

	@Autowired
	private HeroService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		int count = service.count();

		Hero hero = new Hero();
		hero.setName("spiderman");
		hero.setAge(18);

		assertThat(service.insert(hero), is(true));
		assertThat(service.count(), is((count + 1)));
	}

	@Test
	public void testDelete() {
		int count = service.count();

		Hero hero = new Hero();
		hero.setName("spiderman");
		hero.setAge(18);

		assertThat(service.insert(hero), is(true));
		assertThat(service.count(), is((count + 1)));
		
		assertThat(service.delete(hero), is(true));
		assertThat(service.count(), is(count));
	}

	@Test
	public void testUpdate() {
		Hero hero = new Hero();
		hero.setName("spiderman");
		hero.setAge(18);
		
		assertThat(service.insert(hero), is(true));
		
		hero.setName("ironman");
		hero.setAge(33);
		
		assertThat(service.update(hero), is(true));
		assertThat(service.selectByKey(hero).getName(), is("ironman"));
		assertThat(service.selectByKey(hero).getAge(), is(33));
	}

	@Test
	public void testSelectByKey() {
		Hero hero = new Hero();
		hero.setSno(1);
		assertThat(service.selectByKey(hero), is(nullValue()));
	}

	@Test
	public void testSelect() {
		int count = service.count();
		assertThat(service.select().size(), is(count));
	}

	@Test
	public void testSelectByLimit() {
		HeroInfo heroInfo = new HeroInfo();
		heroInfo.setStart(1);
		heroInfo.setEnd(10);
		assertThat(service.selectByLimit(heroInfo).size(), is(10));
	}

	@Test
	public void testCount() {
		assertThat(service.select().size(), is(service.count()));
	}

}
