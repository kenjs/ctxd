/**
 * 
 */
package com.cattsoft.sm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

/**
 * Title:ϵͳ����-Ա������-�ͻ����͹���<br>
 * Description:�ͻ����͹���MDAO�ӿ�<br>
 * Copyright:Copyright (C) 2009<br>
 * Company:cattsoft<br>
 * 
 * @author � 2009-4-28<br>
 * @version 1.0 <br>
 * 
 */
public interface ICustCatMDAO extends IDAO {
	/**
	 * ���vo�е���Ϣ��ȡ���������Ϣ<br>
	 * 
	 * @param vo����������Ϣ
	 * @return List �������������Ϣ
	 * @throws AppException
	 * @throws SysException
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException;
	
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException;
	
	/**
	 * ����ע���ͻ�����
	 * 
	 * @param voList
	 * @throws AppException
	 * @throws SysException
	 */
	public void unableBat(List voList) throws AppException, SysException;

}