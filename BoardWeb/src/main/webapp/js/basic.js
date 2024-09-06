/**
 * DOM 연습 
 */

console.log("basic.js");
let myName = 'Hong';
let myAge = 20;

const member = {
	id: 'user01',
	pw: '1111',
	email: 'user01@email.com',
	hobbies: ['sleeping','eating'],
	friends: [
		{name: 'kim', phone:'1234-1234'},
		{name: 'Lee', phone:'3456-2456'},
		{name: 'choi', phone:'8945-8619'}
	],
	showHobby: function() {
		let result = '';
		this.hobbies.forEach(item => {
			result += item + ' ';
		})
		return result;
	},
	showFriend: function() {
		let result ='aa';
		for (let i=0; i<member.friends.length; i++) {
			result += '<li>'+member.friends[i].name+', '+member.friends[i].phone+'</li>';
		}
		return result;
	}
}


member.phone = '010-1111-2222';
member.name = 'king';


console.log(member.id);
console.log(member['pw']);
let mailAddress = 'email';
console.log(member[mailAddress]);

console.log(member.hobbies[1]);
console.log(member['friends'][0]['name']);

console.log(member);

let tag = document.createElement('p');
tag.innerText = '이름 : ' + member.name;
document.querySelector('#show').appendChild(tag);

tag = document.createElement('p');
tag.innerHTML = '<b>' +'취미 : ' + member.showHobby()+'</b>';
document.querySelector('#show').appendChild(tag);

tag = document.createElement('p');
tag.innerHTML = '<ul>' + member.showFriend()+'</ul>';
document.querySelector('#show').appendChild(tag);


tag = document.createElement('ul');
member.friends.forEach(friend => {
	let li = document.createElement('li');
	li.innerHTML = '이름' + friend.name + ', 연락처 ' + friend.phone;
	
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click', function() {li.remove();});
	
	li.appendChild(btn);
	
	tag.appendChild(li);
})

document.querySelector('#show').appendChild(tag);
