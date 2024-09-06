/**
 * 
 */

 let btn = document.querySelector("#addbtn");
 
 
 
 btn.addEventListener('click', function(){
 let id = document.querySelector('#id').value;
 let name = document.querySelector('#name').value;
 let point= document.querySelector('#point').value;
 let box =[id,name,point];
 let tr = document.createElement('tr')
 for (let i =0; i<3; i++) {
	 let td = document.createElement('td');
	 td.innerHTML = box[i];
	 tr.appendChild(td);
 }
 document.querySelector('#id').value = '';
 document.querySelector('#name').value= '';
 document.querySelector('#point').value= '';
 document.querySelector('#list').appendChild(tr);
 })