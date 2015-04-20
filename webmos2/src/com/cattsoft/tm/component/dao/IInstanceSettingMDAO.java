package com.cattsoft.tm.component.dao;

import java.util.List;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.tm.vo.QueryInstanceSVO;

public interface IInstanceSettingMDAO extends IDColumnDescSDAO {

	public List getTableColumns(String tableName) throws AppException,
			SysException;

	/**
	 * ��ȡĳһʵ�����е���Ϣ
	 * 
	 * @param instacneId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getQueryConfigColumnList(String instanceId)
			throws AppException, SysException;
	
	public QueryInstanceSVO getTableByInstanceId(String instanceId)
			throws AppException, SysException ;

}
