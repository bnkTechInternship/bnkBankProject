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
    			Swal.fire({
  				  title: "회원님의 비밀번호는  " + result + " 입니다.",
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
    			
    			
    			
    		}//success
    	
    	}); //ajax    

    	
    }); //click
    
})