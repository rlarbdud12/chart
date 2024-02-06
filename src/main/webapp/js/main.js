$(function(){
	pageList(1);
})

function pageList(page) {

	$.ajax({	
		url : "/paging.do",
		type: "GET",
		data : {
			page : page
		},
		success : function(res) {
			$("#grid").empty();
			const grid = new tui.Grid({
			      el: document.getElementById('grid'),
			      data: [],
			      scrollX: false,
			      scrollY: false,
			      columns: [
			  		{header : '순번', name : 'id', align:'center'},
					{header : '제목', name : 'title', align:'center'},
					{header : '작가', name : 'writer', align:'center'},
					{header : '내용', name : 'contents', align:'center'},
					{header : '날짜', name : 'dt', align:'center'},
					{header : '조회수', name : 'cnt', align:'center'}
			      ]
			});
			grid.resetData(res.paging.list);
			console.log("성공");
			
			grid.on('click', (ev) => {
				  if (ev.columnName === 'title') {
					window.location.href='/detail.do?id=' + grid.getRow(ev.rowKey).id;
				  }
			});
			
			

			
			

			$("#pageNum").empty();
						
 			var listCnt = Math.ceil(res.paging.listCnt/10);		//전체 페이지수 
			var startBlock = res.paging.startBlock;	//블록 시작 번호
			var btsSu = res.paging.btnSu;	//전체 페이지 수
			//버튼 처음(<<), 버튼 이전(<)
			if (page != 1){
				var prev = '<button onclick="pageList(1)"><<</button>'+'<button onclick="pageList('+(page-1)+')"><</button>';
				$("#pageNum").append(prev);
			}
			
			//버튼 5개
				for(var i=0; i<5; i++){
 					if ((startBlock+i) == page){
						var btn = 
						'<button style="background:red" onclick="pageList('+(startBlock+i)+')">'+(startBlock+i)+'</button>';
					}else{
						var btn = 
						'<button onclick="pageList('+(startBlock+i)+')">'+(startBlock+i)+'</button>';
					}  
					
 					var btn = 
						'<button id="btn' +(startBlock+i)+ '" onclick="pageList('+(startBlock+i)+')">'+(startBlock+i)+'</button>';
						 
					$("#pageNum").append(btn);
					
 					if ((startBlock+i) == page){
						$("#btn" + (startBlock+i)).css("background", "red");
					} 
					
					if(startBlock+i == btsSu) break;
				}
				 	
			
			//버튼 이전(>), 버튼 마지막(>>)
			if (page != btsSu){
				var next = '<button onclick="pageList('+(page+1)+')">></button>'+'<button onclick="pageList('+btsSu+')">>></button>';
				$("#pageNum").append(next);
			}

			$("#chart").empty();
			
			var arr1 = [];
			var arr2 = [];
			for(var i=0; i<res.paging.list.length; i++){
				arr1[i] = res.paging.list[i].id;
				arr2[i] = res.paging.list[i].cnt;
				console.log(arr1[i]+","+arr2[i]);
			}
			
			const Chart = toastui.Chart;
			const el = document.getElementById('chart');
			const data = {
				categories: arr1,
				series: [
				    {
				      name: '조회수',
				      data: arr2
				    }
				]
			};
			const options = {
			  chart: { width: 1700, height: 400 },
			};
			const chart = Chart.columnChart({ el, data, options });
			

		}
	})

}



/*

$(function(){
	pageList(1);
})

function pageList(page) {
	
	$.ajax({	
		url : "/paging.do",
		type: "GET",
		data : {
 			search: $('#search').val(),		
			keyword: $('#keyword').val() 
			page : page
		},
		success : function(res) {
			console.log("성공");
			$("#tb").empty();	 //td 비워내기
			$("#pageNum").empty();
						
			for(var i=0; i<res.paging.list.length; i++){
				var tr = 
				'<tr>'+
	 				'<td>'+ '<a href="/detail.do?id='+res.paging.list[i].id+'">'+res.paging.list[i].id+'</a>'+'</td>'+
	 				'<td>'+res.paging.list[i].title+'</td>'+
	 				'<td>'+res.paging.list[i].writer+'</td>'+
	 				'<td>'+res.paging.list[i].contents+'</td>'+
	 				'<td>'+res.paging.list[i].cnt+'</td>'+
	 				'<td>'+res.paging.list[i].dt+'</td>'+
	 				'<td>'+res.paging.list[i].tm+'</td>'+
				'</tr>';				//리스트 표 생성
				$("#tb").append(tr);	//생성한 표를 티디에 추가
			}
			
 			var listCnt = Math.ceil(res.paging.listCnt/10);		//전체 페이지수 
			var startBlock = res.paging.startBlock;	//블록 시작 번호
			var btsSu = res.paging.btnSu;	//전체 페이지 수
			//버튼 처음(<<), 버튼 이전(<)
			if (page != 1){
				var prev = '<button onclick="pageList(1)"><<</button>'+'<button onclick="pageList('+(page-1)+')"><</button>';
				$("#pageNum").append(prev);
			}
			
			//버튼 5개
				for(var i=0; i<5; i++){
 					if ((startBlock+i) == page){
						var btn = 
						'<button style="background:red" onclick="pageList('+(startBlock+i)+')">'+(startBlock+i)+'</button>';
					}else{
						var btn = 
						'<button onclick="pageList('+(startBlock+i)+')">'+(startBlock+i)+'</button>';
					}  
					
 					var btn = 
						'<button id="btn' +(startBlock+i)+ '" onclick="pageList('+(startBlock+i)+')">'+(startBlock+i)+'</button>';
						 
					$("#pageNum").append(btn);
					
 					if ((startBlock+i) == page){
						$("#btn" + (startBlock+i)).css("background", "red");
					} 
					
					if(startBlock+i == btsSu) break;
				}
				 	
			
			//버튼 이전(>), 버튼 마지막(>>)
			if (page != btsSu){
				var next = '<button onclick="pageList('+(page+1)+')">></button>'+'<button onclick="pageList('+btsSu+')">>></button>';
				$("#pageNum").append(next);
			}
		}
	})
}
*/