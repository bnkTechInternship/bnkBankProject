$(function(){
	

  document.getElementById("floatingName").focus();
 
    const counter = ($counter, max, endword) => {
        let now = max;
      
        const handle = setInterval(() => {
    
          $counter.innerHTML = Math.ceil(max - now).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+endword;
        
          // 목표수치에 도달하면 정지
          if (now < 1) {
            clearInterval(handle);
          }
          
          // 증가되는 값이 계속하여 작아짐
          const step = now / 30;
          
          // 값을 적용시키면서 다음 차례에 영향을 끼침
          now -= step;
        }, 20);
      }      
     
   const user = JSON.parse(localStorage.getItem('loginUser'));
   console.log(user);
    $('#id').html('<p>' + user.userId+'</p>');
    $('#floatingName').attr('value',user.userName);
    $('#floatingAddress').attr('value',user.userAddress.substring(0,5));
    $('#floatingAddress2').attr('value',user.userAddress.substring(5));
    $('#floatingPhone').attr('value',user.userNumber);
    $('#floatingEmail').attr('value',user.userEmail);
    $('#p1').html(user.userName);
    console.log(user.userPoint);
    console.log(user.userBalance);
    
    $('#conn').click(function(){
    	
    	const swalWithBootstrapButtons = Swal.mixin({
    		  customClass: {
    		    confirmButton: 'btn btn-success',
    		    cancelButton: 'btn btn-danger',
    		    confirmButtonColor: '#3085d6',
    		    cancelButtonColor: '#d33',
    		  },
    		  buttonsStyling: true
    		})
    		swalWithBootstrapButtons.fire({
    		  title: '동백전을 연동할까요?',
    		  text: "핫플 웨이팅을 위해선 동백전 정보가 꼭 필요해요",
    		  icon: 'warning',
    		  showCancelButton: true,
    		  confirmButtonText: '네, 할래요!',
    		  cancelButtonText: '아니요, 안할래요',
    		  reverseButtons: false
    		}).then((result) => {
    		  if (result.isConfirmed) {
    		    swalWithBootstrapButtons.fire(
    		    	'\n동백전 카드가 연동됩니다.'
    		    )
    		    const $counter = document.querySelector(".count"); // 카운터로 증가시킬 영역 선택
    	        const $counter2 = document.querySelector(".count2");

    	        max = 58000;
    	        console.log(parseInt(user.point));
    	        
    	        setTimeout(() => counter($counter, parseInt(user.userPoint), 'p'), 100); // max 값이 최종적으로 증가시킬 값
    	        setTimeout(() => counter($counter2, parseInt(user.userBalance), '원'), 100);
    		    
    		    
    		  } else if (
    		    /* Read more about handling dismissals below */
    		    result.dismiss === Swal.DismissReason.cancel
    		  ) {
    		    swalWithBootstrapButtons.fire(
    		      'Cancelled',
    		      '동백전 연동을 하지 않으면 BNK핫플 이용이 제한됩니다.'
    		    )
    		  }
    		})

       
      })
    
    
    $('#btn1').click(function(){
    	
    	if(
    			$('#floatingPassword').val()==''|| // password 변경은 다른데서 따로
    			$('#floatingName').val()==''||
    			$('#floatingAddress').val()==''||
    			$('#floatingPhone').val()==''||
    			$('#floatingEmail').val()==''
    			
    		)
    	{
    		Swal.fire({
	  			  icon: 'error',
	  			  title: '회원정보 수정 오류',
	  			  text: '입력하지 않은 정보가 있습니다.'
			})
    	}else{
    		
    	
	        $.ajax({
	            
	        	type:'post',
	        	url:'updateInfo.do',
	        	data:'userPw='+$('#floatingPassword').val()+
	        			'&userName='+$('#floatingName').val()+
	        			'&userAddress='+$('#floatingAddress').val()+$('#floatingAddress2').val()+
	        			'&userNumber='+$('#floatingPhone').val()+
	        			'&userEmail='+$('#floatingEmail').val()+
	        			'&userId=' + user.userId,
	        			
	        			success:function(user){	        				
	        				localStorage.setItem("loginUser",JSON.stringify(user));
	        				
	        			    $('#id').html('<p>' + user.userId+'</p>');
	        			    $('#name').attr('value',user.userName);
	        			    $('#floatingAddress').attr('value',user.userAddress.substring(0,5));
	        			    $('#floatingAddress2').attr('value',user.userAddress.substring(5));
	        			    $('#floatingPhone').attr('value',user.userNumber);
	        			    $('#floatingEmail').attr('value',user.userEmail);
	        		
	        			    
	        			    Swal.fire({
	        		  			  icon: 'success',
	        		  			  title: '회원정보 수정 성공!',
	        		  			  })
	        		
	        		
	        			}
        	
        	}); // ajax
    	}// else
    	

    
    
    });

    
    
    

    
    
    

})





  





//  this.target_frame.innerHTML = this.count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

/*
function numberCounter(target_frame, target_number) {
    this.count = 0; this.diff = 0;
    this.target_count = parseInt(target_number);
    this.target_frame = document.getElementById(target_frame);
    this.timer = null;
    this.counter();
};
    numberCounter.prototype.counter = function() {
        var self = this;
        this.diff = this.target_count - this.count;
    
        if(this.diff > 0) {
            self.count += Math.ceil(this.diff / 5);
        }
    
       
    
        if(this.count < this.target_count) {
            this.timer = setTimeout(function() { self.counter(); }, 20);
        } else {
            clearTimeout(this.timer);
        }
    };

new numberCounter(document.getElementById('counter2'), 99999);
new numberCounter("counter2", 1123456);
new numberCounter("counter1", 15);*/





  /*
  
  window.onload = () => {
    // 카운트를 적용시킬 요소
    const $counter = document.querySelector(".count");
    
    // 목표 수치
    const max = 17249;
    
    setTimeout(() => counter($counter, max), 2000);
  }

*/