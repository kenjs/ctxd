package com.cattsoft.tm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.tm.component.dao.IQueryConditionSDAO;import com.cattsoft.tm.vo.QueryConditionSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法QueryConditionSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class QueryConditionSDAOImpl implements IQueryConditionSDAO{    private static Logger log = Logger.getLogger(QueryConditionSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     QueryConditionSVO queryCondition=(QueryConditionSVO) vo;    if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO QUERY_CONDITION(COLUMN_NAME,CONDITION_TYPE,CREATE_TIME,QUERY_CONDITION_ID,STS,INSTANCE_ID)");sql.append(" VALUES (:columnName,:conditionType,:createTime,:queryConditionId,:sts,:instanceId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(queryCondition.getColumnName())) {      sql.setNullString("columnName");     } else {    sql.setString("columnName", queryCondition.getColumnName());    }       if (StringUtil.isBlank(queryCondition.getConditionType())) {      sql.setNullString("conditionType");     } else {    sql.setString("conditionType", queryCondition.getConditionType());    }    if (queryCondition.getCreateTime() == null) {      sql.setNullDate("createTime");     } else {    sql.setTimestamp("createTime", queryCondition.getCreateTime());    }       if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {      sql.setNullString("queryConditionId");     } else {    sql.setString("queryConditionId", queryCondition.getQueryConditionId());    }       if (StringUtil.isBlank(queryCondition.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", queryCondition.getSts());    }      sql.setString("instanceId", queryCondition.getInstanceId());            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     QueryConditionSVO queryCondition=(QueryConditionSVO) vo;    if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT COLUMN_NAME,CONDITION_TYPE,CREATE_TIME,QUERY_CONDITION_ID,STS,TABLE_NAME FROM QUERY_CONDITION WHERE 1=1  ");sql.append(" and QUERY_CONDITION_ID=:queryConditionId");sql.setString("queryConditionId", queryCondition.getQueryConditionId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      queryCondition =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           queryCondition = new QueryConditionSVO();           queryCondition.setColumnName(rs.getString("COLUMN_NAME"));           queryCondition.setConditionType(rs.getString("CONDITION_TYPE"));           queryCondition.setCreateTime(rs.getTimestamp("CREATE_TIME"));           queryCondition.setQueryConditionId(rs.getString("QUERY_CONDITION_ID"));           queryCondition.setSts(rs.getString("STS"));           queryCondition.setTableName(rs.getString("TABLE_NAME"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return queryCondition;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       QueryConditionSVO queryCondition=(QueryConditionSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT COLUMN_NAME,CONDITION_TYPE,CREATE_TIME,QUERY_CONDITION_ID,STS,INSTANCE_ID FROM QUERY_CONDITION WHERE 1=1 ");     try {if (queryCondition.getFlagColumnName() == 1) {      if (StringUtil.isBlank(queryCondition.getColumnName())) {             sql.append(" and COLUMN_NAME is null ");          }      else{             sql.append(" and COLUMN_NAME=:columnName");             sql.setString("columnName", queryCondition.getColumnName());          }   } if (queryCondition.getFlagConditionType() == 1) {      if (StringUtil.isBlank(queryCondition.getConditionType())) {             sql.append(" and CONDITION_TYPE is null ");          }      else{             sql.append(" and CONDITION_TYPE=:conditionType");             sql.setString("conditionType", queryCondition.getConditionType());          }   } if (queryCondition.getFlagCreateTime() == 1) {      if (queryCondition.getCreateTime() == null) {             sql.append(" and CREATE_TIME is null ");          }      else{             sql.append(" and CREATE_TIME=:createTime");             sql.setTimestamp("createTime", queryCondition.getCreateTime());          }   } if (queryCondition.getFlagQueryConditionId() == 1) {      if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {             sql.append(" and QUERY_CONDITION_ID is null ");          }      else{             sql.append(" and QUERY_CONDITION_ID=:queryConditionId");             sql.setString("queryConditionId", queryCondition.getQueryConditionId());          }   } if (queryCondition.getFlagSts() == 1) {      if (StringUtil.isBlank(queryCondition.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", queryCondition.getSts());          }   } //if (queryCondition.getFlagTableName() == 1) {//      if (StringUtil.isBlank(queryCondition.getTableName())) {//             sql.append(" and TABLE_NAME is null ");//          }//      else{//             sql.append(" and TABLE_NAME=:tableName");//             sql.setString("tableName", queryCondition.getTableName());//          }//   } if(!StringUtil.isBlank(queryCondition.getInstanceId())) {	 sql.append(" and INSTANCE_ID=:instanceId");	 sql.setString("instanceId", queryCondition.getInstanceId()); }           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           queryCondition = new QueryConditionSVO();           queryCondition.setColumnName(rs.getString("COLUMN_NAME"));           queryCondition.setConditionType(rs.getString("CONDITION_TYPE"));           queryCondition.setCreateTime(rs.getTimestamp("CREATE_TIME"));           queryCondition.setQueryConditionId(rs.getString("QUERY_CONDITION_ID"));           queryCondition.setSts(rs.getString("STS"));          // queryCondition.setTableName(rs.getString("TABLE_NAME"));           queryCondition.setInstanceId(rs.getString("INSTANCE_ID"));               res.add(queryCondition);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       QueryConditionSVO queryCondition=(QueryConditionSVO) vo;    if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE QUERY_CONDITION SET ");     try {if (queryCondition.getFlagColumnName() == 1) {sql.append("COLUMN_NAME=:columnName,"); sql.setString("columnName", queryCondition.getColumnName()); } if (queryCondition.getFlagConditionType() == 1) {sql.append("CONDITION_TYPE=:conditionType,"); sql.setString("conditionType", queryCondition.getConditionType()); } if (queryCondition.getFlagCreateTime() == 1) {sql.append("CREATE_TIME=:createTime,"); sql.setTimestamp("createTime", queryCondition.getCreateTime()); } if (queryCondition.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", queryCondition.getSts()); } if (queryCondition.getFlagTableName() == 1) {sql.append("TABLE_NAME=:tableName,"); sql.setString("tableName", queryCondition.getTableName()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and QUERY_CONDITION_ID=:queryConditionId");sql.setString("queryConditionId", queryCondition.getQueryConditionId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO QUERY_CONDITION(COLUMN_NAME,CONDITION_TYPE,CREATE_TIME,QUERY_CONDITION_ID,STS,TABLE_NAME)");sql.append(" VALUES (:columnName,:conditionType,:createTime,:queryConditionId,:sts,:tableName)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       QueryConditionSVO queryCondition=(QueryConditionSVO) list.get(i);         if (queryCondition== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(queryCondition.getColumnName())) {      sql.setNullString("columnName");     } else {    sql.setString("columnName", queryCondition.getColumnName());    }       if (StringUtil.isBlank(queryCondition.getConditionType())) {      sql.setNullString("conditionType");     } else {    sql.setString("conditionType", queryCondition.getConditionType());    }    if (queryCondition.getCreateTime() == null) {      sql.setNullDate("createTime");     } else {    sql.setTimestamp("createTime", queryCondition.getCreateTime());    }       if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {      sql.setNullString("queryConditionId");     } else {    sql.setString("queryConditionId", queryCondition.getQueryConditionId());    }       if (StringUtil.isBlank(queryCondition.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", queryCondition.getSts());    }       if (StringUtil.isBlank(queryCondition.getTableName())) {      sql.setNullString("tableName");     } else {    sql.setString("tableName", queryCondition.getTableName());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     QueryConditionSVO queryCondition=(QueryConditionSVO) vo;    if (StringUtil.isBlank(queryCondition.getQueryConditionId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM QUERY_CONDITION WHERE 1=1  ");sql.append(" and QUERY_CONDITION_ID=:queryConditionId");sql.setString("queryConditionId", queryCondition.getQueryConditionId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     QueryConditionSVO queryCondition=(QueryConditionSVO) vo;       }}
