package com.cattsoft.tm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.ISDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.tm.vo.DTableDescSVO;

public interface ICtxdMDAO extends ISDAO{
	
	PagView queryResult(String tableId,List conditionListFromPage,PagInfo pg) throws AppException,SysException;
	
	/**
	 * ��ȡ��ѯ�����б�
	 * @param tableId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getQueryCondition(String tableId) throws AppException, SysException;
	
	/**
	 * ��ȡ��Ҫ��ѯ����
	 * @param tableId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public  List getQueryColumnList(String tableId) throws AppException, SysException;
	
	/**
	 * ��ȡ��ѯ�����б�,������ѯ����ֵ
	 * @param tableId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getQueryCondition(String tableId,List conditionListFromPage) throws AppException, SysException;
	
	public List getFuncNodeListByUser(SysUserSVO vo) throws AppException,
	SysException ;
	
	/**
	 * ��ȡ��ǰ���ݿ��û��ı�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getDBTables()throws AppException, SysException;
	
	public DTableDescSVO getConfigTableInfo(String tableId)throws AppException, SysException;
	
	/**
	 * ��ȡ�е�˵����Ϣ�����û�У���ȡ�����ֵ��˵��
	 * @param svo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getColumnDescList(String tableName)throws AppException, SysException;

}
