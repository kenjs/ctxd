package com.cattsoft.tm.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.tm.component.domain.CtxdDOM;
import com.cattsoft.tm.vo.DTableDescSVO;


/**
 * 
 * Title: 服务开通系统<br>
 * Description: 外勘处理Delegate<br>
 * Date: 2007-6-25 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author wangyun
 */
public class CtxdDelegate {
	private static Log log = LogFactory.getLog(CtxdDelegate.class);

	private static CtxdDelegate delegate = null;

	private CtxdDelegate() {

	}

	public static CtxdDelegate getDelegate() {
		if (delegate == null) {
			delegate = new CtxdDelegate();
		}
		return delegate;
	}
	
	
	
	
	/**
	 * 获取查询结果集
	 */
	public PagView queryResult(String tableId,List conditionListFromPage,PagInfo pageInfo) throws AppException, SysException {
		Connection conn = null;
		PagView returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.queryResult(tableId,conditionListFromPage,pageInfo);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	
	public List getQueryConditionList(String tableId,List conditionListFromPage)throws AppException,SysException{
		Connection conn = null;
		List returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.getQueryConditionList(tableId,conditionListFromPage);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	/**
	 * 获取需要查询的列
	 * @param tableId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public  List getQueryColumnList(String tableId) throws AppException, SysException{
		Connection conn = null;
		List returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.getQueryColumnList(tableId);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	public List getFuncNodeListByUser(SysUserSVO user) throws AppException,SysException{
		Connection conn = null;
		List returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.getFuncNodeListByUser(user);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	public String login(SysUserSVO user) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.login(user);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	/**
	 * 获取当前数据库用户的表
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getDBTables()throws AppException, SysException{
		Connection conn = null;
		List returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.getDBTables();
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	public DTableDescSVO getConfigTableInfo(String tableId)throws AppException, SysException{
		Connection conn = null;
		DTableDescSVO returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.getConfigTableInfo(tableId);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 获取列的说明信息，如果没有，则取数据字典的说明
	 * @param svo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getColumnDescList(String tableName)throws AppException, SysException{
		Connection conn = null;
		List returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			returnValue =dom.getColumnDescList(tableName);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return returnValue;
	}
	
	
	/**
	 *
	 * @param svo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public void saveTableConfig(DTableDescSVO table,List columns,List queryConditionList)throws AppException, SysException{
		Connection conn = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			dom.saveTableConfig(table,columns,queryConditionList);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
	}
	
	public List getConfigTabList() throws AppException, SysException {
		Connection conn = null;
		List res=null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			CtxdDOM dom=new CtxdDOM();
			res=dom.getConfigTabList();
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
			}
		}
		return res;
	}
	
}
