$(function() {
    
    $('#findId_button').click(function(){
    	//$('form').submit();
    	var email = $('#floatingEmail').val();
    	console.log(email);
    	
    	
    	$.ajax({
    		type:'post',
    		url:"findId.do",
    		data:"userEmail="+email,
    		
    		success:function(result){
    			console.log(result);
    			var re = confirm("회원님의 ID는  " + result + " 입니다.");
    			if(re){
    				 location.replace('login.html');
    			}
    			
    			
    		}//success
    	
    	}); //ajax    

    	
    }); //click
    
    
})