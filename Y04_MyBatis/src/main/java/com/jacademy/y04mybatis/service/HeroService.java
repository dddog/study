package com.jacademy.y04mybatis.service;

import java.util.List;

import com.jacademy.y04mybatis.domain.Hero;
import com.jacademy.y04mybatis.domain.HeroInfo;

public interface HeroService {
	
	public boolean insert(Hero hero);
	public boolean delete(Hero hero);
	public boolean update(Hero hero);
	public Hero selectByKey(Hero hero);
	public List<Hero> select();
	public List<Hero> selectByLimit(HeroInfo heroInfo);
	public int count();
}
