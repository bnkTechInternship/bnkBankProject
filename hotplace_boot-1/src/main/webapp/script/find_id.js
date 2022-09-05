$(function() {
    //
    $('#findId_button').click(function(){
    	
    	if( $('#floatingEmail').val()=="" ||
    			$('#floatingName').val()==""){
    		
    		Swal.fire({
    			  icon: 'error',
    			  title: 'ID찾기 에러',
    			  text: '입력하지 않은 정보가 있습니다.'
    			})
    	}
    	else{
	    	$.ajax({
	    		type:'post',
	    		url:"findId.do",
	    		data:{	
		    			userEmail:$('#floatingEmail').val(),
		    			userName:$('#floatingName').val()
	    			},
	    		
	    		success:function(result){
	    			if(result=='error'){
	    				
	    				Swal.fire({
	    	    			  icon: 'error',
	    	    			  title: 'ID찾기 에러',
	    	    			  text: '입력된 정보에 해당하는 ID가 없습니다.'
	    	    			})
	    				
	    			}else{
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
	    			}

	    		},//success
	    		error:function(result){ // DB에서 에러남
	    			Swal.fire({
  	    			  icon: 'error',
  	    			  title: 'ID찾기 에러',
  	    			  text: '입력된 정보에 해당하는 ID가 없습니다.'
  	    			})
	    		}
	    	}); //ajax    
    	}
    	
    }); //click
    
    
})