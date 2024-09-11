/**
 * replyBoard.js
 * replyService에 정의된 메소드를 통해서 기능 실행
 */
// DOM 요소를 다 읽어드린 다음에 코드실행.
let pagination 

document.addEventListener('DOMContentLoaded',function(e){
	/******************** 
	  이벤트(댓글등록)
	************************/
	//댓글등록
	document.querySelector('#addReply').addEventListener('click',addReplyFnc)
	//페이지링크 클릭
	document.querySelectorAll('ul.pagination a').forEach(aTag => {
		aTag.addEventListener('click',showReplyListFnc);
	pagination = document.querySelector('ul.pagination');
	})
	
showPagingListFnc()
/*-----------------------
   댓글정보 -> li 생성하는 함ㅅ.
   -------------------*/

makeLi();

svc.replyList({bno:bno,page:page}, 
	function(result){ 
	console.log(result)
	result.forEach(reply=>{
		document.querySelector('div.content ul').appendChild(makeLi(reply));
	});}, //성공처리 했을 때 실햏마수
	function(err){
		console.log(err);
	}
);

		
})//end of DOMContentLoaded
function makeLi(reply={}) {
	let cloned = document.querySelector('#template').cloneNode(true);
	cloned.style.display = 'block';
	cloned.setAttribute('data-rno',reply.replyNo);
	cloned.querySelector('span').innerHTML = reply.replyNo;
	cloned.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	cloned.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	cloned.querySelector('button').addEventListener('click',deleteLiFnc);
	cloned.querySelector('button').setAttribute('data-page',page);
	return cloned;
} 


/******************** 
 * 댓글목록 그리기/
 */ 
let page = 1; // 페이지가변경될떄마다 사용해야함.





/*-----------------------------
	함수 : deleteLiFnc
	기능 : 버튼이 포함된 row 삭제. (ajax포홤)
--------------------------------*/
function deleteLiFnc(e){
		Swal.fire({
	  title: "경고",
	  text: "정말 삭제하시겠습니까?",
	  icon: "warning",
	  showCancelButton: true,
	  confirmButtonColor: "#3085d6",
	  cancelButtonColor: "#d33",
	  confirmButtonText: "삭제",
	  cancelButtonText:"취소"
	}).then((result) => {
	  if (result.isConfirmed) {
		let rno = e.target.parentElement.parentElement.dataset.rno;
		svc.removeReply(rno,//삭제글번호
		function(result) {
			if (result.retCode == 'OK') {
				Swal.fire({
			      title: "성공!",
			      text: "댓글이 삭제 완료되었습니다!",
			      icon: "success"
			    });
				//showReplyListFnc(e);
				showReplyAndPagingListFnc();
			} else {
				Swal.fire({
	      			title: "불가",
	      			text: "알수없는 이유로 삭제가 실패했습니다.",
	      			icon: "success"
	    		});				
			}
		},
		function(err) {
			console.log(err);
		}
		);

	    Swal.fire({
	      title: "Deleted!",
	      text: "Your file has been deleted.",
	      icon: "success"
	    });
	  }
	});
}
/*---------------------------------------
       댓글 등록 이벤트 핸들러.
----------------------------------------*/

function addReplyFnc(e) {
	
	//bno, replyer, reply
	let reply = document.querySelector('#reply').value;
	let param = {bno:bno,reply:reply,replyer:writer};
	console.log(writer);
	svc.addReply(param,
	function(result){
		if (result.retCode=='OK'){
			Swal.fire({
			  title: "댓",
			  text: "글등록",
			  icon: "success"
			});
			page =1;
			showReplyAndPagingListFnc()
			//showReplyListFnc(e);
		} else {
			alert('댓글시류ㅐ')
		}
	},
		function(err){
		console.log(err)
	}
	)

	
}

/*-------------------------------------
		링크클릭시 댓글목록 새로출력.
		함수: showReplyListFnc
---------------------------------------*/

function showReplyListFnc(e) {
	// 기존에 출력 리스트 지워주고.(나서 다시그리기)
	console.log("gd")
	document.querySelectorAll('div.content li').forEach((li,idx) => {
		
		if(idx > 2 ) {
			li.remove();
		}

	})
	page = e.target.dataset.page;
	svc.replyList({bno:bno,page:page},
	function(result){ 
	result.forEach(reply=>{
		document.querySelector('div.content ul').appendChild(makeLi(reply));
	})
	showPagingListFnc();
	}, //성공처리 했을 때 실햏마수
	function(err){
		console.log(err);
	}
);
	
}

/*-------------------------------------
		댓글개수를 활용해서 페이지 리스트 생성.
		함수 : showPagingListFnc
-------------------------------------*/
	function showPagingListFnc() {
	
		
		svc.replyPagingCount(bno,
			makePagingList, //성공했을때 실행할 콜뱍함수.
			function(err) {
				console.log(err);
			})
	}


// 정상처리 실행할 콜백함수. 
function makePagingList(result){
	document.querySelectorAll('ul.pagination li').forEach((li,idx) => {
	if (idx < 8) {
		li.remove();
		}
	})
	let totalCnt = result.totalCount;
	// 페이지 목록 만들기.
	let startPage, endPage, realEnd; //첫페이지 ~ 마지막페이지
	let prev, next;//이전페이지, 이후페이지
	endPage = Math.ceil(page/5)*5;
	startPage = endPage-4;
	realEnd = Math.ceil(totalCnt/5);
	endPage = endPage>realEnd ? realEnd : endPage;
	prev = startPage > 1;
	next = endPage < realEnd;
	//이전 페이지
	let li = document.createElement('li');
	li.className = 'page-item';
	let aTag = document.createElement('a');
	aTag.className = 'page-link';
	aTag.setAttribute('data-page',startPage-1);
	aTag.innerHTML = 'Previous';
	li.appendChild(aTag);
	if (prev) {
	aTag.setAttribute('href','#');
	} else {
		li.classList.add('disabled')
	}
	pagination.appendChild(li);		
		
	//li 생성. 페이지 범위에 들어갈
	for (let p = startPage; p<=endPage; p++) {
		let li = document.createElement('li');
		li.className = 'page-item';
		let aTag = document.createElement('a');
		aTag.className = 'page-link';
		aTag.setAttribute('href','#');
		aTag.setAttribute('data-page',p);
		aTag.innerHTML = p;
		li.appendChild(aTag);
		if (p == page) {
		li.classList.add('active')
		li.setAttribute('aria-current','page');
		}
		pagination.appendChild(li);		
	}
	
	//이후페이지
	 li = document.createElement('li');
	li.className = 'page-item';
	aTag = document.createElement('a');
	aTag.className = 'page-link';
	aTag.setAttribute('data-page',endPage+1);
	aTag.innerHTML = 'Next';
	li.appendChild(aTag);
	if (next) {
			aTag.setAttribute('href','#');
	} else {
			li.classList.add('disabled')
	}
	
	pagination.appendChild(li);
	document.querySelectorAll('ul.pagination a').forEach(aTag => {
	aTag.addEventListener('click',showReplyListFnc);
})		
			
}

function showReplyAndPagingListFnc() {
	// 기존에 출력 리스트 지워주고.(나서 다시그리기)
	console.log("gd")
	document.querySelectorAll('div.content li').forEach((li,idx) => {
		
		if(idx > 2 ) {
			li.remove();
		}

	})
	svc.replyList({bno:bno,page:page},
	function(result){ 
	result.forEach(reply=>{
		document.querySelector('div.content ul').appendChild(makeLi(reply));
	})
	showPagingListFnc();
	}, //성공처리 했을 때 실햏마수
	function(err){
		console.log(err);
	}
);
	
}
