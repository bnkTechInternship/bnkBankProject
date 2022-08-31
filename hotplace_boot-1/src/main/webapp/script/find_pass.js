$(function() {
    
	console.log("제이쿼리")
    $('#findPw_button').click(function(){
    	//$('form').submit();
    	var email = $('#floatingEmail').val();
    	var id = $('#floatingId').val();
    	console.log(email);
    	console.log(id);
    	
    	
    	$.ajax({
    		type:'post',
    		url:"findPw.do",
    		data:{"userEmail":email,"userId":id},
    		//data:"userEmail="+email+"&userId="+id,
    		
    		success:function(result){
    			console.log(result);
    			var re = confirm("회원님의 PW는  " + result + " 입니다.");
    			if(re){
    				 location.replace('login.html');
    			}
    			
    			
    		}//success
    	
    	}); //ajax    

    	
    }); //click
    
})