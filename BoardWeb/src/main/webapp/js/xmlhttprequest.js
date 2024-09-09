/**
 * xmlhttprequest
 * 비동기처리를하는 대표적인 객체 
 * 
 * 
 */
// /javascript.do 페이지에서 js/MOCK_DATA.json 요청.
const xhtp =  new XMLHttpRequest();//생성, 서버상의 페이지를 요청할떄 사용하느 ㄴ객체
xhtp.open('get','js/MOCK_DATA.json'); //서버 페이지 지정(요청). 매개변수 2개필요(요청방식,서버페이지?) 
xhtp.send(); //서버 요청.
xhtp.onload = function() {//on은 이벤트와 관련된것들임 on이벤트가 발생하면 ~ 이라는것, //로드가 되는 이벤트가 발생되면
	console.log(xhtp.responseText); //xhtp객체의 responseText 속성 = > 결과값.
	let result = JSON.parse(xhtp.responseText); //문자열 -> 객체 변경
	//보여줄 항목을 배열 담기
	let fields = ['id','first_name','last_name','gender','salary']	
	result.forEach(function(item,idx,ary){
		if(item.salary >= 8000 && item.gender == 'Female') {
			console.log(item);// item = {id,first_name,last_name...} => tr>td*5 생성
			let tr = document.createElement('tr');
			// 보여줄 필드 출력.
			fields.forEach(field =>{
				let td = document.createElement('td');
				td.innerHTML = item[field];
				tr.appendChild(td);
			})
			//요소생성.
			let btn = document.createElement('button');// <button>삭제</button>
			btn.innerHTML = '삭제';
			btn.addEventListener('click',()=>{tr.remove()});
			let td = document.createElement('td');			
			td.appendChild(btn);
			tr.appendChild(td);
			document.querySelector('.list').appendChild(tr);
			
		}
	})
} 
