$(function() {
	
	
	const user = JSON.parse(localStorage.getItem('loginUser'));
    let userName = user.userName;
    let userPoint = user.userPoint;
    let userBalance = user.userBalance;
    
	
    
    $('#left_first').append(
    		'<div>'+userName+'님의 실시간 웨이팅 정보</div>'
    );
    
    $('.card_text').append(
            '<p id="p1">' +userName + '</p><h5>' + userPoint + 'p</h5><h2>'+
            userBalance+'원</h2>'
    );
    
   


})
