$(function(){
    var userName = '<%=(User)session.getAttribute("user").getName()%>';
    
    $('#left_first').append(
    		'<div>'+userName+'님의 예약현황</div>'
    );
    

})
