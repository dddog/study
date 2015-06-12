package com.jacademy.y04mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacademy.y04mybatis.domain.Hero;
import com.jacademy.y04mybatis.domain.HeroInfo;
import com.jacademy.y04mybatis.repository.HeroDao;
import com.jacademy.y04mybatis.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService{

	@Autowired
	private HeroDao dao;
	
	@Transactional
	@Override
	public boolean insert(Hero hero) {
		int result = dao.insert(hero);
		System.out.println("insert(Hero hero) >> key: " + hero.getSno());
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Hero hero) {
		int result = dao.delete(hero);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Hero hero) {
		int result = dao.update(hero);
		System.out.println(result);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public Hero selectByKey(Hero hero) {
		return dao.selectByKey(hero);
	}

	@Override
	public List<Hero> select() {
		return dao.select();
	}

	@Override
	public List<Hero> selectByLimit(HeroInfo heroInfo) {
		return dao.selectByLimit(heroInfo);
	}

	@Override
	public int count() {
		return dao.count();
	}

}
