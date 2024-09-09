/**
 * ajax.js
 * 
 *  ajax란 처리박식의 의미ㅇ다.
 * Asynchronous Jacascript And Xml
 * 비동기 방식이란 의미 
 * 
 * 동기방식이란 (첫번쨰 방식하면 두번쨰 방식, 두번쨰하면 세번째 ...) 이런거디다 
 * 
 * 비동기
 * setTimeout(function) {
 * 	console('a');
 * 
 * },1000) ->밑에거 abc먼저 출려갛고 1초있다 이거 출력함(스택공간에 코드 던져놓고 그 1초 기다리는 사이 1초동안 abc가 출력됨)
 * 
 * 동기
 * concole.log('a');
 * concole.log('b');
 * concole.log('c');
 * 
 * setTimeout(function) {
 * 	console('a');
 * 
 * },1000) * 
 * setTimeout(function) {
 * 	console('a');
 * 
 * },1000) * 
 * setTimeout(function) {
 * 	console('a');
 * 
 * },1000) -> 세개 동시에 1초 기다림
 */

  concole.log('a');
  concole.log('b');
  concole.log('c');