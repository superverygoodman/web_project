/**
 * 
 */
console.log(json); //문자열
let data = JSON.parse(json); // 문자열 => 객체변경
console.log(data);
console.clear();
/*
data.forEach(function(item, idx,ary) {
	
	if (idx<10) {
	console.log(item);
	}
	
})
*/
/*
data.forEach(function(item, idx,ary) {
	if (item.salary>8000 && item.gender ==  'Female') {
	console.log(item);
	}
	
})
*/
let result =data.filter(function(item, idx,ary) {
	if (item.salary>8000 && item.gender ==  'Female') {
		return true;
	}
	
})
let btn = document.querySelector("searchBtn");
btn.addEventListener('click', function () {
	let salary = 
	let gender
	
})
console.log(result);
