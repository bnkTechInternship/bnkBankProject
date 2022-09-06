
$(function(){
	
	
	$('#choose_logout').click(function(){
		
		Swal.fire({
			  title: '로그아웃 하시겠습니까?',
			  text: "로그아웃하면 동백전 시스템을 이용할 수 없습니다.",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#d33',
			  cancelButtonColor: '#3085d6',
			  confirmButtonText: '그만 이용할래요',
			  cancelButtonText: '게속 이용할래요.',
			}).then((result) => {
			  if (result.isConfirmed) {
				  window.localStorage.removeItem('loginUser');
				  
			    Swal.fire(
			      '이용해주셔서 감사합니다.',
			      '성공적으로 로그아웃 되었습니다.',
			      'success'
			    ).then((result)=>{
			    	location.href = `login.html`
			    })
			  }
			})
	})
		
	
})

