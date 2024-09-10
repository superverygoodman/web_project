/**
 * reply.js 
 */

let replyer ='user01';
let bno =148;

const xhtp =  new XMLHttpRequest();//생성, 서버상의 페이지를 요청할떄 사용하느 ㄴ객체
xhtp.open('get','replyList.do?bno=148'); //서버 페이지 지정(요청). 매개변수 2개필요(요청방식,서버페이지?) 
xhtp.send(); //서버 요청.
xhtp.onload = function () {
	console.log(xhtp.responseText);
	let result = JSON.parse(xhtp.responseText);
	console.log(result);
	result.forEach(reply => {
		document.querySelector('.list').appendChild(makeRow(reply));
		});
}
	let checkAll = document.querySelector('#allCheck');
	checkAll.addEventListener('change', checksel);
	
	let check = document.querySelector('#check');
	check.addEventListener('click',delCheckedFnc1);
/*
document.querySelector('#addReply').addEventListener('click', function() {
	let reply = document.querySelector('#reply').value;
  const addHtp = new XMLHttpRequest();
  addHtp.open('get', 'addReply.do?bno='+bno+'&reply='+reply +'&replyer='+replyer);
  addHtp.send();
  addHtp.onload = function(){
	  let  result = JSON.parse(addHtp.responseText);
	  console.log(result); // retCode, retVal=>{}
	  let tr = makeRow(result.retVal);
	  document.querySelector('.list').appendChild(tr);
	  
  }
})
*/	
//	let addbtn = document.querySelector('#addReply');
//	addbtn.addEventListener('click',addreply);
	
	document.querySelector('#addReply').addEventListener('click',function () {
		let reply = document.querySelector('#reply').value;
		const addHtp = new XMLHttpRequest();
		addHtp.open('get','addReply.do?bno='+bno+'&reply='+reply+'&replyer='+replyer)
		addHtp.send();
		addHtp.onload = function() {
		let result = JSON.parse(addHtp.responseText);
		console.log(result);
		let tr = makeRow(result.retVal);
		document.querySelector('.list').appendChild(tr);
		}
		
	})

function addreply () {
	let replyCt = document.querySelector('#reply').value;
	console.log(replyCt);
	const delHtp = new XMLHttpRequest();
	delHtp.open('get',"addReply.do?replyer="+replyer+'&bno='+bno+'&reply='+replyCt);
	delHtp.send();
	let result = JSON.parse(delHtp.responseText);
	if (result.retCode == 'OK') {
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		let check = document.createElement('input')
		check.setAttribute('type','checkbox');
		td.appendChild(check);
		tr.appendChild(td);
		field.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = reply[field];
			tr.appendChild(td);
		})
		//삭제버튼
		let btn = document.createElement('button');// <button>삭제</button>
		btn.innerHTML = '삭제';
		btn.addEventListener('click',deleteRowFnc); //이벤트 사용할때는 ()호츌문 넣지말고 함수이름만 쓸것 안넣으면 걍 바로실행함 키자마자
		
		td = document.createElement('td');			
		td.appendChild(btn);
		tr.appendChild(td);
		let list = document.querySelector('.list')
		list.appendChild(tr);
	} else {
		alter('인서트 실패!')
	}
	
}



//선택삭제함수
function delCheckedFnc1(e) {
	//?rno=21&rno=22&rno=23
	let params = "rno=";
	document.querySelectorAll('tbody input[type="checkbox"]:checked').forEach(item => {
		let rno = item.parentElement.nextElementSibling.innerHTML;
		params += rno + "&rno=";
	})
	const delHtp = new XMLHttpRequest();
	delHtp.open('get',"removeReplys.do?"+params);
	delHtp.send();
	delHtp.onload = function () {
		let result = JSON.parse(delHtp.responseText);
		if (result.retCode == 'OK') {
			alert('완료');
			document.querySelectorAll('.list input[type="checkbox"]:checked').forEach(item=> {
				item.parentElement.parentElement.remove();
			})
		} else {
			alter('처리중 예외');
		}
	}
}


//선택삭제함수 반복실행
function deleteset() {
	let allcheck = document.querySelectorAll('tbody input[type="checkbox"]:checked');
	allcheck.forEach(item => {
	let rno = item.parentElement.nextElementSibling.innerHTML;
	const delHtp = new XMLHttpRequest();
	delHtp.open('get','removeReply.do?rno='+rno)//컨트롤 지정
	delHtp.send();
	delHtp.onload = function() {
		let result = JSON.parse(delHtp.responseText);
		if (result.retCode == 'OK') {
			item.parentElement.parentElement.remove();
		} else if (result.retCode == 'NG') {
			alert('알수 없는 예외 발생');
		} else {
			alert('잘못된 반환 코드..');
		}
	}

	})
}




function checksel () {
	let allcheck = document.querySelectorAll('tbody input[type="checkbox"]');
		let checkAll = document.querySelector('#allCheck');
	allcheck.forEach(item => {
		item.checked = this.checked;
		})
	}



let field = ['replyNo','reply','replyer','replyDate'];
//댓글정보 -> tr>td>*4 생성반환
function makeRow( reply = {}){
	let tr = document.createElement('tr');
	let td = document.createElement('td');
	let check = document.createElement('input')
	check.setAttribute('type','checkbox');
	td.appendChild(check);
	tr.appendChild(td);
	field.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = reply[field];
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
//삭제처리할 함수
function deleteRowFnc(e) { //이벤트로는 삭제할 번호를 알수가 없음. 그래서 부모태그의 첫번째 자식같이 다른 태그에서 삭제할것을 찾아야함. 매개변수를 넣을수가 없으니까
	console.log(e.target.parentElement.parentElement.firstChild.innerHTML);
	let rno = e.target.parentElement.parentElement.firstChild.innerHTML;
	console.log(e.target.parentElement.parentElement.children[1].innerHTML);
	rno = e.target.parentElement.parentElement.children[1].innerHTML;
	const delHtp = new XMLHttpRequest();
	delHtp.open('get','removeReply.do?rno='+rno)//컨트롤 지정
	delHtp.send();
	delHtp.onload = function() {
		let result = JSON.parse(delHtp.responseText);
		if (result.retCode == 'OK') {
			e.target.parentElement.parentElement.remove();
		} else if (result.retCode == 'NG') {
			alert('알수 없는 예외 발생');
		} else {
			alert('잘못된 반환 코드..');
		}
	}
}//end of delCheckedFnc(e)


