/**
 * boardTable.js
 */

const table = new DataTable('#example', {
    ajax: 'replyTable.do?bno='+bno,
    columnDefs: [
        {
            // The `data` parameter refers to the data for the cell (defined by the
            // `data` option, which defaults to the column being worked with, in
            // this case `data: 0`.
            render: (data, type, row) => '<button onclick="deleteRow(event,'+row.replyNo+')">삭제</button>',
            targets: 4
        },
        { visible: true, targets: [3] }
    ],
    columns: [
        { data: 'replyNo' },
        { data: 'reply' },
        { data: 'replyer' },
        { data: 'replyDate' }
    ],
        lengthMenu: [
        [5, 25, 50, -1],
        [5, 25, 50, 'All']
    ],
    order: {
        idx: 0,
        dir: 'desc'
    }
    
    

});

function deleteRow(e,rno) {
	//console.log(e.target.parentElement.parentElement.children[0].innerHTML);//button상위상위첫번쨰자식요소.html
	//let rno = e.target.parentElement.parentElement.children[0].innerHTML;
	if (e.target.parentElement.parentElement.classList.contains('selected')) {
		e.stopPropagation();
	}
	//fetch('removeReply.do?rno='+rno)
	fetch('removeReply.do',{
		method:'post',
		headers:{'Content-Type':'application/x-www-form-urlencoded'},
		body:'rno='+rno
	})
	.then(resolve=>resolve.json())
	.then(result=> {
		if (result.retCode=='OK') {
			/*
			if (e.target.parentElement.parentElement.classList.contains('selected')) {
			table.row('.selected').remove().draw(false);
			} else {
			e.target.parentElement.parentElement.classList.add('selected');
			table.row('.selected').remove().draw(false);				
			}*/
			
			table.row('.selected').remove().draw(false);							
			//e.target.parentElement.parentElement.remove();
			
		} else {
			alert("NO!")
		}
	})
}


let delNum = '';
table.on('click', 'tbody tr', (e) => {
    let classList = e.currentTarget.classList;
	delNum =e.currentTarget.firstChild.innerHTML 
    if (classList.contains('selected')) {
        classList.remove('selected');
    }
    else {
		console.log(table.row('.selected'))
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
        
    }
});
 
document.querySelector('#delReply').addEventListener('click', function () {
    //fetch('removeReply.do?rno='+delNum)
    fetch('removeReply.do',{
    		method:'post',
    		headers:{'Content-Type':'application/x-www-form-urlencoded'},
    		body:'rno='+delNum})
    .then(resolve=>resolve.json())
    .then(result => {
		if (result.retCode == 'OK') {
	    table.row('.selected').remove().draw(false);
		} else {
			alert("NO!")
		}
	})
	.catch(err => console.log(err))
    
    
});






















function addNewRow() {
	let reply = document.querySelector('#reply').value;
	fetch('addReply.do', {
		method:'post',
		headers:{'Content-Type':'application/x-www-form-urlencoded'}, //키와밸류 형식으로 넘김
		body:'bno='+bno+'&reply='+reply+'&replyer='+writer
	}) //주소표시줄 addReply.do?bno=148&reply=test&replyer=user01	
	.then(resolve=>resolve.json())
	.then(result => {
		if (result.retCode == 'OK') {
		    table.row
		        .add({
		         replyNo:result.retVal.replyNo,
		         reply:result.retVal.reply ,
		         replyer:result.retVal.replyer,
		         replyDate:result.retVal.replyDate
		        })
		        .draw(false);
			
		}else {
			alert("no!")
		}
	})
	.catch(err=>{
		console.log(err);
	})
 	
}
 
let counter = 1;
 
document.querySelector('#addReply').addEventListener('click', addNewRow);
 
// Automatically add a first row of data
