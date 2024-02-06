$(function(){
	getChart();
})

function getChart(){
	$.ajax({
		url : "/getChart.do",
		type : "GET",
		data : {},
		success : function(res){
			var arr1 = [];
			var arr2 = [];
			for(var i=0; i<res.data.length; i++){
				arr1[i] = res.data[i].dt;
				arr2[i] = res.data[i].dtcnt;
				console.log(arr1[i]+","+arr2[i]);
			}
			
			const Chart = toastui.Chart;
			const el = document.getElementById('chart');
			const data = {
					categories: arr1,
				series: [
				    {
				      name: '전체조회수',
				      
				      data: arr2,
				    },				    
				],
			};
			const options = {
			  chart: { width: 1700, height: 400 },
			};
			const chart = Chart.lineChart({ el, data, options });
			
		}
	})
}