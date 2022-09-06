package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.model.MenuDAO;

@Repository
public class MenuDAOImpl implements MenuDAO {
	@Autowired
	private SqlSession sqlsession;
	static final String NS="sql.menu.mapper.";
	
	@Override
	public int addMenu(Menu menu) throws Exception {
		return sqlsession.insert(NS+"addMenu",menu);
	}

	@Override
	public int deleteMenu(int menuIdx) throws Exception {
		return sqlsession.delete(NS+"deleteMenu",menuIdx);
	}

	@Override
	public List<Menu> getMenuByName(String menuName) throws Exception {
		return sqlsession.selectList(NS+"getMenuByName",menuName);
	}

	@Override
	public Menu getMenuByIdx(int menuIdx) throws Exception {
		return sqlsession.selectOne(NS+"getMenuByIdx",menuIdx);
	}

	@Override
	public List<Menu> getMenuList(int shopIdx) throws Exception {
		return sqlsession.selectList(NS+"getMenuList",shopIdx);
	}

	@Override
	public int updateMenu(Menu menu) throws Exception {
		return sqlsession.update(NS+"updateMenu",menu);
	}
}
