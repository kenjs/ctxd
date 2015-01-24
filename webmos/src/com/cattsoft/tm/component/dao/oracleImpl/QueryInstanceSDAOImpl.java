package com.cattsoft.tm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.tm.component.dao.IQueryInstanceSDAO;import com.cattsoft.tm.vo.QueryInstanceSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法QueryInstanceSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class QueryInstanceSDAOImpl implements IQueryInstanceSDAO{    private static Logger log = Logger.getLogger(QueryInstanceSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     QueryInstanceSVO queryInstance=(QueryInstanceSVO) vo;    if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO QUERY_INSTANCE(CREATE_TIME,INSTANCE_NAME,INSTANCE_TYPE,QUERY_INSTANCE_ID,STS,TABLE_NAME)");sql.append(" VALUES (:createTime,:instanceName,:instanceType,:queryInstanceId,:sts,:tableName)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());   if (queryInstance.getCreateTime() == null) {      sql.setNullDate("createTime");     } else {    sql.setTimestamp("createTime", queryInstance.getCreateTime());    }       if (StringUtil.isBlank(queryInstance.getInstanceName())) {      sql.setNullString("instanceName");     } else {    sql.setString("instanceName", queryInstance.getInstanceName());    }       if (StringUtil.isBlank(queryInstance.getInstanceType())) {      sql.setNullString("instanceType");     } else {    sql.setString("instanceType", queryInstance.getInstanceType());    }       if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {      sql.setNullLong("queryInstanceId");     } else {    sql.setLong("queryInstanceId", queryInstance.getQueryInstanceId());    }       if (StringUtil.isBlank(queryInstance.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", queryInstance.getSts());    }       if (StringUtil.isBlank(queryInstance.getTableName())) {      sql.setNullString("tableName");     } else {    sql.setString("tableName", queryInstance.getTableName());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     QueryInstanceSVO queryInstance=(QueryInstanceSVO) vo;    if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT CREATE_TIME,INSTANCE_NAME,INSTANCE_TYPE,QUERY_INSTANCE_ID,STS,TABLE_NAME FROM QUERY_INSTANCE WHERE 1=1  ");sql.append(" and QUERY_INSTANCE_ID=:queryInstanceId");sql.setLong("queryInstanceId", queryInstance.getQueryInstanceId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      queryInstance =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           queryInstance = new QueryInstanceSVO();           queryInstance.setCreateTime(rs.getTimestamp("CREATE_TIME"));           queryInstance.setInstanceName(rs.getString("INSTANCE_NAME"));           queryInstance.setInstanceType(rs.getString("INSTANCE_TYPE"));           queryInstance.setQueryInstanceId(rs.getString("QUERY_INSTANCE_ID"));           queryInstance.setSts(rs.getString("STS"));           queryInstance.setTableName(rs.getString("TABLE_NAME"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return queryInstance;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       QueryInstanceSVO queryInstance=(QueryInstanceSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT CREATE_TIME,INSTANCE_NAME,INSTANCE_TYPE,QUERY_INSTANCE_ID,STS,TABLE_NAME FROM QUERY_INSTANCE WHERE 1=1 ");     try {if (queryInstance.getFlagCreateTime() == 1) {      if (queryInstance.getCreateTime() == null) {             sql.append(" and CREATE_TIME is null ");          }      else{             sql.append(" and CREATE_TIME=:createTime");             sql.setTimestamp("createTime", queryInstance.getCreateTime());          }   } if (queryInstance.getFlagInstanceName() == 1) {      if (StringUtil.isBlank(queryInstance.getInstanceName())) {             sql.append(" and INSTANCE_NAME is null ");          }      else{             sql.append(" and INSTANCE_NAME=:instanceName");             sql.setString("instanceName", queryInstance.getInstanceName());          }   } if (queryInstance.getFlagInstanceType() == 1) {      if (StringUtil.isBlank(queryInstance.getInstanceType())) {             sql.append(" and INSTANCE_TYPE is null ");          }      else{             sql.append(" and INSTANCE_TYPE=:instanceType");             sql.setString("instanceType", queryInstance.getInstanceType());          }   } if (queryInstance.getFlagQueryInstanceId() == 1) {      if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {             sql.append(" and QUERY_INSTANCE_ID is null ");          }      else{             sql.append(" and QUERY_INSTANCE_ID=:queryInstanceId");             sql.setLong("queryInstanceId", queryInstance.getQueryInstanceId());          }   } if (queryInstance.getFlagSts() == 1) {      if (StringUtil.isBlank(queryInstance.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", queryInstance.getSts());          }   } if (queryInstance.getFlagTableName() == 1) {      if (StringUtil.isBlank(queryInstance.getTableName())) {             sql.append(" and TABLE_NAME is null ");          }      else{             sql.append(" and TABLE_NAME=:tableName");             sql.setString("tableName", queryInstance.getTableName());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           queryInstance = new QueryInstanceSVO();           queryInstance.setCreateTime(rs.getTimestamp("CREATE_TIME"));           queryInstance.setInstanceName(rs.getString("INSTANCE_NAME"));           queryInstance.setInstanceType(rs.getString("INSTANCE_TYPE"));           queryInstance.setQueryInstanceId(rs.getString("QUERY_INSTANCE_ID"));           queryInstance.setSts(rs.getString("STS"));           queryInstance.setTableName(rs.getString("TABLE_NAME"));               res.add(queryInstance);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       QueryInstanceSVO queryInstance=(QueryInstanceSVO) vo;    if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE QUERY_INSTANCE SET ");     try {if (queryInstance.getFlagCreateTime() == 1) {sql.append("CREATE_TIME=:createTime,"); sql.setTimestamp("createTime", queryInstance.getCreateTime()); } if (queryInstance.getFlagInstanceName() == 1) {sql.append("INSTANCE_NAME=:instanceName,"); sql.setString("instanceName", queryInstance.getInstanceName()); } if (queryInstance.getFlagInstanceType() == 1) {sql.append("INSTANCE_TYPE=:instanceType,"); sql.setString("instanceType", queryInstance.getInstanceType()); } if (queryInstance.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", queryInstance.getSts()); } if (queryInstance.getFlagTableName() == 1) {sql.append("TABLE_NAME=:tableName,"); sql.setString("tableName", queryInstance.getTableName()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and QUERY_INSTANCE_ID=:queryInstanceId");sql.setLong("queryInstanceId", queryInstance.getQueryInstanceId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO QUERY_INSTANCE(CREATE_TIME,INSTANCE_NAME,INSTANCE_TYPE,QUERY_INSTANCE_ID,STS,TABLE_NAME)");sql.append(" VALUES (:createTime,:instanceName,:instanceType,:queryInstanceId,:sts,:tableName)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       QueryInstanceSVO queryInstance=(QueryInstanceSVO) list.get(i);         if (queryInstance== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {       throw new AppException("100002", "缺少对象的主键！");      }   if (queryInstance.getCreateTime() == null) {      sql.setNullDate("createTime");     } else {    sql.setTimestamp("createTime", queryInstance.getCreateTime());    }       if (StringUtil.isBlank(queryInstance.getInstanceName())) {      sql.setNullString("instanceName");     } else {    sql.setString("instanceName", queryInstance.getInstanceName());    }       if (StringUtil.isBlank(queryInstance.getInstanceType())) {      sql.setNullString("instanceType");     } else {    sql.setString("instanceType", queryInstance.getInstanceType());    }       if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {      sql.setNullLong("queryInstanceId");     } else {    sql.setLong("queryInstanceId", queryInstance.getQueryInstanceId());    }       if (StringUtil.isBlank(queryInstance.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", queryInstance.getSts());    }       if (StringUtil.isBlank(queryInstance.getTableName())) {      sql.setNullString("tableName");     } else {    sql.setString("tableName", queryInstance.getTableName());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     QueryInstanceSVO queryInstance=(QueryInstanceSVO) vo;    if (StringUtil.isBlank(queryInstance.getQueryInstanceId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM QUERY_INSTANCE WHERE 1=1  ");sql.append(" and QUERY_INSTANCE_ID=:queryInstanceId");sql.setLong("queryInstanceId", queryInstance.getQueryInstanceId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     QueryInstanceSVO queryInstance=(QueryInstanceSVO) vo;       }}
