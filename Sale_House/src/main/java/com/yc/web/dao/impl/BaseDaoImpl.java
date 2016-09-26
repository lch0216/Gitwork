package com.yc.web.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.web.dao.BaseDao;
@Repository
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

	private static final String MAPPERPATH = "com.yc.web.mapper.";
	// com.yc.web.mapper.类名Mapper.方法名
	public void save(T t, String sqlId) {
		super.getSqlSession().insert(MAPPERPATH + t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	public void update(T t, String sqlId) {
		super.getSqlSession().update(MAPPERPATH + t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	public void del(Class<T> t, int id, String sqlId) {
		super.getSqlSession().delete(MAPPERPATH + t.getSimpleName()+"Mapper."+sqlId,id);
	}

	public void del(Class<T> t, List<Integer> ids, String sqlId) {
		super.getSqlSession().delete(MAPPERPATH + t.getSimpleName()+"Mapper."+sqlId,ids);

	}

	public List<T> findAll(Class<T> t,String sqlId) {
		List<T> ls = null;
		ls = super.getSqlSession().selectList(MAPPERPATH + t.getSimpleName()+"Mapper."+sqlId,t);
		return ls;
	}

	public int getCount(Class<T> t, String sqlId) {
		int count = 0;
		count =  super.getSqlSession().selectOne(MAPPERPATH + t.getSimpleName()+"Mapper."+sqlId);
		return count;
	}

	public int getCount(Class<T> t, Map<String, Object> map,
			String sqlId) {
		int count = 0;
		count = super.getSqlSession().selectOne(MAPPERPATH + t.getSimpleName()+"Mapper."+sqlId,map);
		return count;
	}
	public T find(T t, String sqlId) {
		t = super.getSqlSession().selectOne(MAPPERPATH + t.getClass().getSimpleName()+"Mapper."+sqlId,t);
		return t;
	}

	@Resource(name ="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	public List<T> findList(Class<T> t, Map<String, Object> map,
			String sqlId, int offset, int sizePage) {
		List<T> ls = null;
		ls = super.getSqlSession().selectList(MAPPERPATH + t.getSimpleName() + "Mapper." + sqlId,map,new RowBounds(offset, sizePage));
		return ls;
	}

}
