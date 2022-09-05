$(function() {
    //
    $('#login_button').click(function(){
        if($('#userId').val()=='')  {
	        	Swal.fire({
		  			  icon: 'error',
		  			  title: '로그인 오류',
		  			  text: 'ID를 입력해주세요.'
				})
              $('#userId').focus();
        }
        else if($('#userPw').val()==''){
	        	Swal.fire({
		  			  icon: 'error',
		  			  title: '로그인 오류',
		  			  text: '비밀번호를 입력해주세요.'
				})
        }
        else {
	        $.ajax({
	        	type:'post',
	        	url:'login.do',
	        	data:"userId="+$('#userId').val()+"&userPw="+$('#userPw').val(),
	      
	        	success:function(result){
	        		if(result.userId!=null){
	        			localStorage.setItem("loginUser",JSON.stringify(result));
	        			location.replace('main.html');
	        		}else{
	        			Swal.fire({
	      	  			  icon: 'error',
	      	  			  title: '로그인 오류',
	      	  			  text: 'ID 혹은 패스워드가 올바르지 않습니다.'
	      			})
	        		}
	        			
	        		
        	}
        
        
        })//ajax
        
        }
        
    })
    
    $('#notuserstartbtn').click(function(){
    	location.replace('main.html');
    });
})