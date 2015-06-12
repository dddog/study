package com.jacademy.y05mybatis.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jacademy.y05mybatis.domain.Hero;
import com.jacademy.y05mybatis.domain.HeroInfo;

@Repository
public interface HeroDao {

	public int insert(Hero hero);
	public int delete(Hero hero);
	public int update(Hero hero);
	public Hero selectByKey(Hero hero);
	public List<Hero> select();
	public List<Hero> selectByLimit(HeroInfo heroInfo);
	public int count();
	
	public List<Hero> search(Hero hero);
}
