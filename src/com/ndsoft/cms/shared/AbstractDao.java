package com.ndsoft.cms.shared;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.google.visualization.datasource.base.TypeMismatchException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.ndsoft.cms.api.DbParameter;
import com.ndsoft.cms.api.Page;

public abstract class AbstractDao<T> extends HibernateDaoSupport {
	
	/**
	 * 新增一个实体对象
	 * @param entity 目标实体
	 * @return 新增后实体主键 
	 */
	public Serializable add(T entity) {
		Serializable result = super.getHibernateTemplate().save(entity.getClass().getName(), entity);
		return (BigDecimal) result;
	}
	
	/**
	 * 新增多个实体对象
	 * @param entitys 目标实体集合
	 * @return 新增后实体主键集合
	 */
	public Collection<Serializable> add(Collection<T> entitys) {
		List<Serializable> result = new LinkedList<Serializable>();
		for (T entity : entitys) {
			Serializable addResult = super.getHibernateTemplate().save(entity.getClass().getName(), entity);
			result.add(addResult);
		}
		return result;
	}
	
	/**
	 * 根据对象主键删除一个对象
	 * @param pk 对象主键
	 */
	public void delete(Serializable pk) {
		super.getHibernateTemplate().delete(find(pk));
	}
	
	/**
	 * 删除一个实体对象
	 * @param entity 目标实体
	 */
	public void delete(T entity) {
		super.getHibernateTemplate().delete(entity);
	}
	
	/**
	 * 删除多个实体对象
	 * @param entitys 目标实体集合
	 */
	public void delete(Collection<T> entitys) {
		for (T entity : entitys) {
			super.getHibernateTemplate().delete(entity);
		}
	}
	
	/**
	 * 更新一个实体对象
	 * @param entity 目标实体
	 * @param isClear 是否清除缓存数据
	 */
	public void update(T entity,boolean isClear){
		if(isClear)this.getCurrentSession().clear();
		super.getHibernateTemplate().update(entity);
	}
	
	/**
	 * 更新多个实体对象
	 * @param entitys 目标实体集合
	 * @param isClear 是否清除缓存数据
	 */
	public void update(Collection<T> entitys,boolean isClear){
		if(isClear)this.getCurrentSession().clear();
		for (T entity : entitys) {
			super.getHibernateTemplate().update(entity);
		}
	}
	
	/**
	 * 查找一个实体对象
	 * @param tClass 实体类型
	 * @param pk 实体主键
	 * @return 实体对象
	 */
	public T find(Serializable pk){
		return (T) super.getHibernateTemplate().get(this.getChildClass(),pk);
	}
	
	/**
	 * 查找多个实体对象
	 * @param tClass 实体类型
	 * @param pks 实体主键集合
	 * @return 实体对象集合
	 */
	public Collection<T> find(Collection<Serializable> pks){
		List<T> result = new LinkedList<T>();
		for (Serializable pk : pks) {
			T entity =  (T) super.getHibernateTemplate().get(this.getChildClass(),pk);
			result.add(entity);
		}
		return result;
	}
	
	/**
	 * 查找所有实体对象
	 * @param tClass 实体类型
	 * @param pks 实体主键集合
	 * @return 实体对象集合
	 */
	public Collection<T> findAll(){
		return getHibernateTemplate().loadAll(this.getChildClass());
	}
	
	/**
	 * 按HQL语句进行更新操作
	 * @param hql 更新HQL语句
	 * @param params 参数集合
	 * @return 受影响行数
	 */
	public int updateHQL(String hql,DbParameter... params) {
		Query query = this.getCurrentSession().createQuery(hql);
		for (DbParameter param : params) {
			dynamicSetParameter(query,param);
		}
		return query.executeUpdate();
	}
	
	/**
	 * HQL分页查询，不带条件
	 * @param page 分页对象
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public Collection<T> query(Page page){
		Query query = this.getCurrentSession().createQuery("from "+getChildClass().getName());
		Integer startRow = (page.getIndex() - 1) * page.getSize();
		query.setFirstResult(startRow);
		query.setMaxResults(page.getSize());
		List<T> result = new LinkedList<T>(query.list());
		page.setTotal(result.size());
		Integer pageCount = (result.size() % page.getSize()) > 0 ? (result.size() % page.getSize()) + 1 : (result.size() % page.getSize());
		page.setCount(pageCount);
		return result;
	}
	
	/**
	 * HQL查询，带条件
	 * @param hql HQL查询语句
	 * @param params 参数集合
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public Collection<T> query(String hql, DbParameter... params) {
		Query query = this.getCurrentSession().createQuery(hql);
		for (DbParameter param : params) {
			dynamicSetParameter(query,param);
		}
		List<T> result = new LinkedList<T>(query.list());
		return result;
	}
	
	/**
	 * HQL分页查询，带条件
	 * @param page 分页对象
	 * @param hql HQL查询语句
	 * @param params 参数集合
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public Collection<T> query(Page page, String hql, DbParameter... params) {
		Query query = this.getCurrentSession().createQuery(hql);
		Integer startRow = (page.getIndex() - 1) * page.getSize();
		query.setFirstResult(startRow);
		query.setMaxResults(page.getSize());
		for (DbParameter param : params) {
			dynamicSetParameter(query,param);
		}
		List<T> result = new LinkedList<T>(query.list());
		page.setTotal(result.size());
		Integer pageCount = (result.size() % page.getSize()) > 0 ? (result.size() % page.getSize()) + 1 : (result.size() % page.getSize());
		page.setCount(pageCount);
		return result;
	}
	
	/**
	 * 将SQL查询结果填充至DataTable
	 * @param sql 查询SQL语句 
	 * @param params 参数集合
	 * @return DataTable 结果集
	 */
	@SuppressWarnings("unchecked")
	public DataTable queryDataTable(String sql,DbParameter ...params) {
		Pattern p = Pattern.compile("(?<=[).*?(?=])");
		Matcher m = p.matcher(sql);
		
		sql = replaceSqlParameter(sql,params);
		
		Query query = this.getCurrentSession().createSQLQuery(sql);
		for (int i = 0,count = params.length; i < count; i++) {
			DbParameter param  = params[i];
			if(!m.find()) throw new IllegalArgumentException(param.getName() + "参数异常!");
			dynamicSetParameter(i,query,param);
		}
		List<Map<String,Object>> rows = query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
		Map<String,Object> columns = rows.size() > 0 ? rows.get(0) : null;
		if(columns == null) return null;
		
		Set<String> cols = columns.keySet();
		DataTable result = new DataTable();
		for (String colName : cols) {
			result.addColumn(new ColumnDescription(colName, ValueType.TEXT, colName));
		}
		try {
			for (int i = 0,rowCount = rows.size(); i < rowCount; i++) {
				Map<String,Object> row = rows.get(i);
				TableRow tr = new TableRow();
				for (String colName : cols) {
					Object value = row.get(colName);
					tr.addCell(value == null ? "" : value.toString());
				}
				result.addRow(tr);
			}
		} catch (TypeMismatchException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 将SQL查询结果填充至DataTable
	 * @param sql 查询SQL语句 
	 * @param params 参数集合
	 * @return DataTable 结果集
	 */
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> queryMap(String sql,DbParameter ...params) {
		Pattern p = Pattern.compile("(?<=[).*?(?=])");
		Matcher m = p.matcher(sql);
		
		sql = replaceSqlParameter(sql,params);
		
		Query query = this.getCurrentSession().createSQLQuery(sql);
		for (int i = 0,count = params.length; i < count; i++) {
			DbParameter param  = params[i];
			if(!m.find()) throw new IllegalArgumentException(param.getName() + "参数异常!");
			dynamicSetParameter(i,query,param);
		}
		List<Map<String,Object>> rows = query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
		Map<String,Object> columns = rows.size() > 0 ? rows.get(0) : null;
		if(columns == null) return null;
		
		Set<String> cols = columns.keySet();
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		for (String colName : cols) {
			result.put(colName, new LinkedList<String>());
		}
		for (int i = 0,rowCount = rows.size(); i < rowCount; i++) {
			Map<String,Object> row = rows.get(i);
			for (String colName : cols) {
				List<String> valueList = (LinkedList<String>)result.get(colName);
				String value = row.get(colName) == null ? "" : row.get(colName).toString();
				valueList.add(value);
			}
		}
		return result;
	}
	
	/**
	 * 按SQL语句进行更新操作
	 * @param sql 更新SQL语句 
	 * @param params 参数集合
	 * @return 受影响行数 
	 */
	public int updateSQL(String sql,DbParameter ...params) {
		Pattern p = Pattern.compile("(?<=[).*?(?=])");
		Matcher m = p.matcher(sql);
		sql = replaceSqlParameter(sql,params);
		Query query = this.getCurrentSession().createSQLQuery(sql);
		for (int i = 0; i < params.length; i++) {
			DbParameter param  = params[i];
			if(!m.find()) throw new IllegalArgumentException(param.getName() + "参数异常!");
			dynamicSetParameter(i,query,param);
		}
		return query.executeUpdate();
	}
	
	/**
	 * SQL语句查询操作
	 * @param sql 查询SQL语句 
	 * @param params 参数集合
	 * @return 结果集 
	 */
	@SuppressWarnings("unchecked")
	public Collection<T>  querySQL(Class<T> entityClass,String sql,DbParameter ...params) {
		Pattern p = Pattern.compile("(?<=[).*?(?=])");
		Matcher m = p.matcher(sql);
		sql = replaceSqlParameter(sql,params);
		Query query = this.getCurrentSession().createSQLQuery(sql).addEntity(entityClass);
		for (int i = 0; i < params.length; i++) {
			DbParameter param  = params[i];
			if(!m.find()) throw new IllegalArgumentException(param.getName() + "参数异常!");
			dynamicSetParameter(i,query,param);
		}
		return query.list();
	}
	
	@Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    } 
	
	private String replaceSqlParameter(String sql,DbParameter ...params){
		for (int i = 0; i < params.length; i++) {
			DbParameter param  = params[i];
			sql = sql.replace("["+param.getName()+"]", "?");
		}
		return sql;
	}
	
	private void dynamicSetParameter(int position,Query query,DbParameter param){
		if(param.getType() == StandardBasicTypes.BIG_DECIMAL)
			query.setBigDecimal(position, (BigDecimal) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BIG_INTEGER)
			query.setBigInteger(position, (BigInteger) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BINARY)
			query.setBinary(position, (byte[]) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BOOLEAN)
			query.setBoolean(position, (boolean) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BYTE)
			query.setByte(position, (byte) param.getValue());
		
		if(param.getType() == StandardBasicTypes.CALENDAR)
			query.setCalendar(position, (Calendar) param.getValue());
		
		if(param.getType() == StandardBasicTypes.CALENDAR_DATE)
			query.setCalendarDate(position, (Calendar) param.getValue());
		
		if(param.getType() == StandardBasicTypes.CHARACTER)
			query.setCharacter(position, (char) param.getValue());
		
		if(param.getType() == StandardBasicTypes.DATE)
			query.setDate(position, (Date) param.getValue());
		
		if(param.getType() == StandardBasicTypes.DOUBLE)
			query.setDouble(position, (Double) param.getValue());
		
		if(param.getType() == StandardBasicTypes.FLOAT)
			query.setFloat(position, (Float) param.getValue());
		
		if(param.getType() == StandardBasicTypes.INTEGER)
			query.setInteger(position, (Integer) param.getValue());
		
		if(param.getType() == StandardBasicTypes.LOCALE)
			query.setLocale(position, (Locale) param.getValue());
		
		if(param.getType() == StandardBasicTypes.LONG)
			query.setLong(position, (Long) param.getValue());
		
		if(param.getType() == StandardBasicTypes.SHORT)
			query.setShort(position, (Short) param.getValue());
		
		if(param.getType() == StandardBasicTypes.STRING)
			query.setString(position, (String) param.getValue());
		
		if(param.getType() == StandardBasicTypes.TEXT)
			query.setText(position, (String) param.getValue());
		
		if(param.getType() == StandardBasicTypes.TIME)
			query.setTime(position, (Date) param.getValue());
		
		if(param.getType() == StandardBasicTypes.TIMESTAMP)
			query.setTimestamp(position, (Date) param.getValue());
	}
	
	private void dynamicSetParameter(Query query,DbParameter param){
		if(param.getType() == StandardBasicTypes.BIG_DECIMAL)
			query.setBigDecimal(param.getName(), (BigDecimal) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BIG_INTEGER)
			query.setBigInteger(param.getName(), (BigInteger) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BINARY)
			query.setBinary(param.getName(), (byte[]) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BOOLEAN)
			query.setBoolean(param.getName(), (boolean) param.getValue());
		
		if(param.getType() == StandardBasicTypes.BYTE)
			query.setByte(param.getName(), (byte) param.getValue());
		
		if(param.getType() == StandardBasicTypes.CALENDAR)
			query.setCalendar(param.getName(), (Calendar) param.getValue());
		
		if(param.getType() == StandardBasicTypes.CALENDAR_DATE)
			query.setCalendarDate(param.getName(), (Calendar) param.getValue());
		
		if(param.getType() == StandardBasicTypes.CHARACTER)
			query.setCharacter(param.getName(), (char) param.getValue());
		
		if(param.getType() == StandardBasicTypes.DATE)
			query.setDate(param.getName(), (Date) param.getValue());
		
		if(param.getType() == StandardBasicTypes.DOUBLE)
			query.setDouble(param.getName(), (Double) param.getValue());
		
		if(param.getType() == StandardBasicTypes.FLOAT)
			query.setFloat(param.getName(), (Float) param.getValue());
		
		if(param.getType() == StandardBasicTypes.INTEGER)
			query.setInteger(param.getName(), (Integer) param.getValue());
		
		if(param.getType() == StandardBasicTypes.LOCALE)
			query.setLocale(param.getName(), (Locale) param.getValue());
		
		if(param.getType() == StandardBasicTypes.LONG)
			query.setLong(param.getName(), (Long) param.getValue());
		
		if(param.getType() == StandardBasicTypes.SHORT)
			query.setShort(param.getName(), (Short) param.getValue());
		
		if(param.getType() == StandardBasicTypes.STRING)
			query.setString(param.getName(), (String) param.getValue());
		
		if(param.getType() == StandardBasicTypes.TEXT)
			query.setText(param.getName(), (String) param.getValue());
		
		if(param.getType() == StandardBasicTypes.TIME)
			query.setTime(param.getName(), (Date) param.getValue());
		
		if(param.getType() == StandardBasicTypes.TIMESTAMP)
			query.setTimestamp(param.getName(), (Date) param.getValue());
	}
	
	private Session getCurrentSession(){
		return  super.getSessionFactory().getCurrentSession();
	}
	
	public abstract Class<T> getChildClass();
}
