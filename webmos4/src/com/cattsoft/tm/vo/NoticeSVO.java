package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * NoticeSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class NoticeSVO extends GenericVO {private String content = null;private Date createTime = null;private String noticeId = null;private String releasePerson = null;private String sts = null;private String title = null;private int flagContent = 0;private int flagCreateTime = 0;private int flagNoticeId = 0;private int flagReleasePerson = 0;private int flagSts = 0;private int flagTitle = 0;public String getContent(){ return content;}public void setContent(String newValue){  this.content = newValue;  flagContent = 1;}public int getFlagContent(){  return flagContent;}public Date getCreateTime(){  return createTime;}public void setCreateTime(Date newValue){   this.createTime = newValue;  flagCreateTime = 1;}public int getFlagCreateTime(){  return flagCreateTime;}public String getNoticeId(){ return noticeId;}public void setNoticeId(String newValue){  this.noticeId = newValue;  flagNoticeId = 1;}public int getFlagNoticeId(){  return flagNoticeId;}public String getReleasePerson(){ return releasePerson;}public void setReleasePerson(String newValue){  this.releasePerson = newValue;  flagReleasePerson = 1;}public int getFlagReleasePerson(){  return flagReleasePerson;}public String getSts(){ return sts;}public void setSts(String newValue){  this.sts = newValue;  flagSts = 1;}public int getFlagSts(){  return flagSts;}public String getTitle(){ return title;}public void setTitle(String newValue){  this.title = newValue;  flagTitle = 1;}public int getFlagTitle(){  return flagTitle;}public void clearFlagContent(){ flagContent = 0 ;}public void clearFlagCreateTime(){ flagCreateTime = 0 ;}public void clearFlagNoticeId(){ flagNoticeId = 0 ;}public void clearFlagReleasePerson(){ flagReleasePerson = 0 ;}public void clearFlagSts(){ flagSts = 0 ;}public void clearFlagTitle(){ flagTitle = 0 ;}public void clearAll(){ flagContent = 0; flagCreateTime = 0; flagNoticeId = 0; flagReleasePerson = 0; flagSts = 0; flagTitle = 0;}}
