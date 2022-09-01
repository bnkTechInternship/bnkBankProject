$(function() {
    
    $('#login_button').click(function(){
        if($('#userId').val()=='')  {
              alert('Please enter user ID');
              $('#userId').focus();
        }
        else {
             /* $('form').submit();*/
        
        
       
        $.ajax({
        	type:'post',
        	url:'login.do',
        	data:"userId="+$('#userId').val()+"&userPw="+$('#userPw').val(),
      
        	success:function(result){
        		console.log(result);
        		localStorage.setItem("loginUser",JSON.stringify(result));
        		
        		location.replace('main.html');
        		
        	}
        
        
        })//ajax
        
        }
        
    })
    
    
    
    
    
    $('#notuserstartbtn').click(function(){
    	location.replace('main.html');
    });
})