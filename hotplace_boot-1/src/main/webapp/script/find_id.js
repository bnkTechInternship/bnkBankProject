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
    			
    			
    			Swal.fire({
    				  title: "회원님의 ID는  " + result + " 입니다.",
    				  showDenyButton: true,
    				  showCancelButton: false,
    				  confirmButtonText: '로그인하기',
    				  denyButtonText: 'PW찾기',
    				}).then((result) => {
    				  /* Read more about isConfirmed, isDenied below */
    				  if (result.isConfirmed) {
    					  location.replace('login.html');
    				  } else if (result.isDenied) {
    					  location.replace('find_pass.html');
    				  }
    				})
    			//var re = confirm("회원님의 ID는  " + result + " 입니다.");
//    			if(re){
//    				 location.replace('login.html');
//    			}
    			
    			
    		}//success
    	
    	}); //ajax    

    	
    }); //click
    
    
})