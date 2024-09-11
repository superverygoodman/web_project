/**
 *  replySercice.js
 */

/*-------------------------------------------------------
날짜포맷 : yyyy-MM-dd HH:mm:ss 반환하는 메소드를 Date객체 추가.
--------------------------------------------------------*/
Date.prototype.dateFormat = function () {
	let yyyy = this.getFullYear();
	let MM = ('0' + (this.getMonth() + 1)).slice(-2); //  08 09  
	let dd = ('0'+this.getDay()).slice(-2);
	
	let HH = ('0'+this.getHours()).slice(-2);
	let mm = ('0'+this.getMinutes()).slice(-2);
	let ss = ('0'+this.getSeconds()).slice(-2);
	
	return yyyy+'-'+MM+'-'+dd+' '+HH+':'+mm+':'+ss;
}




/*-----------------------------------------------------
replyVO를 생성하는 함수
------------------------------------------------------*/
 let field = ['replyNo','reply','replyer','replyDate'];
//댓글정보 -> tr>td>*4 생성반환
function makeRow( reply = {}){
	let tr = document.createElement('tr');
	tr.setAttribute('data-rno',reply.replyNo);
	let td = document.createElement('td');
	let check = document.createElement('input')
	check.setAttribute('type','checkbox');
	td.appendChild(check);
	tr.appendChild(td);
	field.forEach(field => {
		let td = document.createElement('td');
		if (field == 'replyDate') {
			let today = new Date(reply[field]); //날짜문자 -> 날짜객체.dataFormat() 출력.
			td.innerHTML = today.dateFormat();
		}else {
			td.innerHTML = reply[field];
			
		}
			tr.appendChild(td);
	})
	//삭제버튼
	let btn = document.createElement('button');// <button>삭제</button>
	btn.innerHTML = '삭제';
	btn.addEventListener('click',deleteRowFnc); //이벤트 사용할때는 ()호츌문 넣지말고 함수이름만 쓸것 안넣으면 걍 바로실행함 키자마자
	
	td = document.createElement('td');			
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}
// 서비스 메소드를 통해서 ajax 기능을 실행.
// 1.목록 , 2.삭제, 3.추가 4....





const svc = {
	replyList: function (param={bno:1,page:1}, successCallback, errorCallback) {
		fetch('replyList.do?bno='+param.bno+'&page='+param.page)
		.then(resolve => resolve.json())
		.then(successCallback)
		.catch(errorCallback)
	},
	removeReply(rno=1, successCallback, errorCallback) { //바로 메소드 형태로 해도 상관없음
		fetch('removeReply.do?rno='+rno)
		.then(resolve => resolve.json())
		.then(successCallback)
		.catch(errorCallback)
		
	},
	addReply(param={bno,reply,replyer}, successCallback, errorCallback) {
		fetch('addReply.do',{
			method:'post',
			headers:{'Content-Type':'application/x-www-form-urlencoded'},
			body: 'bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer
		})
		.then(resolve => resolve.json())
		.then(successCallback)
		.catch(errorCallback)
	},
	replyPagingCount(bno=1,successCallback,errorCallback) {
		fetch('replyCount.do?bno='+bno)
		.then(resolve => resolve.json())
		.then(successCallback)
		.catch(errorCallback)
	}
}
