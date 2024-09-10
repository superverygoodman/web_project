/**
 * replyBoard.js
 * replyService에 정의된 메소드를 통해서 기능 실행
 */
/******************** 
  이벤트(댓글등록)
************************/

document.querySelector('#addReply').addEventListener('click',addReplyFnc)




/******************** 
 * 댓글목록 그리기/
 */ 

console.log(bno,writer);

svc.replyList(bno, function(result){ 
	console.log(result)
	result.forEach(reply=>{
		document.querySelector('div.content ul').appendChild(makeLi(reply));
	});}, //성공처리 했을 때 실햏마수
	function(err){
		console.log(err);
	}
);

makeLi();
/*-----------------------
   댓글정보 -> li 생성하는 함ㅅ.
   -------------------*/
function makeLi(reply={}) {
	let cloned = document.querySelector('#template').cloneNode(true);
	cloned.style.display = 'block';
	cloned.setAttribute('data-rno',reply.replyNo);
	cloned.querySelector('span').innerHTML = reply.replyNo;
	cloned.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	cloned.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	cloned.querySelector('button').addEventListener('click',deleteLiFnc);
	return cloned;
} 
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
				e.target.parentElement.parentElement.remove();
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
	svc.addReply(param,
	function(result){
		if (result.retCode=='OK'){
			Swal.fire({
			  title: "댓",
			  text: "글등록",
			  icon: "success"
			});
			document.querySelector('div.content ul').appendChild(makeLi(result.retVal));
		} else {
			alert('댓글시류ㅐ')
		}
	},
		function(err){
		console.log(err)
	}
	)

	
}