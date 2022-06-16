package com.exam.exspring.bbs;

import java.sql.Date;

//다음주까지 만들어오자
// 게시판목록(글번호,글제목,작성자,작성일)/bbs/list.do
// 게시판글추가(글제목,내용,작성자)/bbs/add.do
// 게시판글변경(글제목,내용)/bbs/edit.do
// 게시판글삭제(변경화면에서 삭제버튼 클릭시) bbs/del.do
// BbsController,BbsService,BbsServiceImpl,BbsDao,
// BbsMapper.xml
// bbsList.jsp,bbsAdd.jsp,bbsEdiet.jsp


public class BbsVo {
	
	private int bbsNo; 
	private String bbsTitle; 
	private String bbsContent; 
	private String bbsWriter; 
	private Date bbsRegData; 
	private int bbsCount;
	
	
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsWriter() {
		return bbsWriter;
	}
	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}
	public Date getBbsRegData() {
		return bbsRegData;
	}
	public void setBbsRegData(Date bbsRegData) {
		this.bbsRegData = bbsRegData;
	}
	public int getBbsCount() {
		return bbsCount;
	}
	public void setBbsCount(int bbsCount) {
		this.bbsCount = bbsCount;
	} 
	
	

}
