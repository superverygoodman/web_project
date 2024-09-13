<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});//구글에 패키지 로드
      google.charts.setOnLoadCallback(drawChart);//로드할때 일어날 콜백함수 drawchart 함수를 던져줌

      function drawChart() {
		var dataAry = [['작성자','작성글 숫자']];
    	 fetch ('chart.do')
    	 .then(resolve => resolve.json())
    	 .then(result => {
    		result.forEach(member => {
    			console.log('gd'+dataAry)
    			dataAry.push([member.memberName,member.cnt]);
    			console.log(dataAry)
    		})
    		
    		var data = google.visualization.arrayToDataTable(dataAry);
	        var options = {
	          title: '게시글 작성자별 작성글 수 '
	        };
	        var chart = new google.visualization.PieChart(document.getElementById('piechart'));//그려줄차트와 그것의 위치지정?
	        chart.draw(data, options);//차트그려줌

    		 
    	 })
    	 .catch(err => console.log(err))
    	  
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
