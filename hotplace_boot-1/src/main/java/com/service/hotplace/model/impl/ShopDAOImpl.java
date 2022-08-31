package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.model.ShopDAO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	static final String NS="sql.hotplace.mapper.";
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<Shop> getShopList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getShopList");
	}

	@Override
	public Shop getShop(int ShopIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getShop",ShopIdx);
	}

	@Override
	public int registerShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"registerShop",shop);
	}

	@Override
	public int deleteShop(int shopIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(NS+"deleteShop",shopIdx);
	}

	@Override
	public int updateShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(NS+"updateShop",shop);
	}

	@Override
	public List<Shop> getShopListByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getShopListByName",name);
	}

	@Override
	public int updateShopEnternum(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(NS+"updateShopEnternum",shop);
	}

	@Override
	public List<Shop> getPartData(int idx) throws Exception {
		return sqlsession.selectList(NS + "getShopPart",idx);
	}

}
