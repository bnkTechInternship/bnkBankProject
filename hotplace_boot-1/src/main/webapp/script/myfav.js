$(function() {

	const user = JSON.parse(localStorage.getItem("loginUser"));
	console.log(user)
	let userName = user.userName;
	let userId = user.userId;

	$('.left_first').append('<h3>' + userName + '님의 찜목록</h3>');
	
	$.ajax({
		type:'post',
		url:'getLikeList.do',
		data: 'userId='+userId,
		
		success:function(list){
			console.log(list[1]);
			for(let i=0; i< list.length ; i++){
				let shopIdx = 'shop_idx'+i;
				let likeid= 'like'+i
				let addContent = `
					
					<div id="content">
					<div id="wrapper_img">
					<img id="img1" src="${list[i].shop.webAddress}">
					</div>
						<span id="shop_idx">${list[i].shop.shopIdx}</span>
						<span id="text1">${list[i].shop.shopName}</span>
						<span class="like">♥찜취소</span>
					</div>
					`
					$('.left_second').append(addContent);
				}



		},
	});

	$(".left_second").on('click',".like",function() {
    	let data = $(this).text()
    	const user = JSON.parse(localStorage.getItem('loginUser'));
    	const userId = user.userId;
    	console.log(userId);
    	const shopIdx = $(this).prev().prev().text();
    	console.log($(this).prev().prev().text());
    		$.ajax({
				type : "get",	
    			url : "unlikeShop.do",
    			data : "shopIdx="+shopIdx+"&userId="+userId,
    			success : function(result){
    				
    				Swal.fire({
  					  title: '찜 취소',
  					  text: "이 가게를 찜 리스트에서 제거할까요?",
  					  icon: 'warning',
  					  showCancelButton: true,
  					  confirmButtonColor: '#3085d6',
  					  cancelButtonColor: '#d33',
  					  confirmButtonText: 'OK',
  					}).then((result) => {
  					  if (result.isConfirmed) {
  					    Swal.fire(
  					      '찜 취소',
  					      '정상적으로 제거되었어요',
  					      'success'
  					    )
						setTimeout("window.location.reload()", 2000);
  					  }
  					})
  					
    			}//success
	    	})//ajax
    		
    	
		
    })//click







})