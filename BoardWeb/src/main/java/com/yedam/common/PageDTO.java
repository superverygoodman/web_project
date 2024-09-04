package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//현재페이지정보. 1..3..10
	//이전, 아후 정보.
	int page;
	int startPage, endPage;
	boolean prev, next;
	
	public PageDTO (int page, int totalCnt) {//page:3 totalCnt:76
		this.page = page;
		this.endPage = (int) Math.ceil(page/10.0)*10;//20
		this.startPage = this.endPage-9;//11
		
		int realEnd = (int)Math.ceil(totalCnt/5.0);
		this.endPage = this.endPage > realEnd ? realEnd: this.endPage;
		
		//이전, 이후 여부
		prev = this.startPage>1;
		next = this.endPage < realEnd ? true:false;
		
		
		
	}
	
	
	
}
