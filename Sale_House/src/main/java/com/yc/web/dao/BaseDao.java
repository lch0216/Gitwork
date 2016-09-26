package com.yc.web.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao <T>{
	/**
	 * 
	 * @param t 要保存的对象
	 * @param sqlId
	 */
	public void save(T t,String sqlId);
	public void update(T t,String sqlId);
	public void del(Class<T> clazz,int id ,String sqlId);
	public void del(Class<T> clazz,List<Integer> ids ,String sqlId);// 删除多条数据
	// 查找一条
	public T find(T t,String sqlId);
	/**
	 * 根据条件进行分页查询
	 * @param clazz 查找的对象
	 * @param map ： 键为 字段名 值 为参数值
	 * @param sqlId mapper的方法名
	 * @param offset   ： 查询的开始记录的id
	 * @param sizePage ：每页记录数
	 * @return
	 */
	public List<T> findList(Class<T> clazz ,Map<String,Object> map ,String sqlId,int offset,int sizePage);
	public List<T> findAll(Class<T> clazz ,String sqlId);
	/**
	 * 聚合查询
	 * @return
	 */
	public int getCount(Class<T> clazz,String sqlId);

	public int getCount(Class<T> clazz ,Map<String,Object> map ,String sqlId);

}
