$(function(){
    const user = JSON.parse(localStorage.getItem('loginUser'));
	let userName = user.userName;
	let userId = user.userId;

    $('.left_first').append(
        '<h3>' + userName+'님의 이용내역</h3>'
    );
    
    
    $.ajax({
        type:'post',
		url:'getWaitingList.do',
		data:"userid="+userId,

        success:function(list){
            console.log(list);

        }

    })





    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
        })

    

    $('input[type="radio"]').click(
        
    async () => {

    const { value: text } = await Swal.fire({
    input: 'textarea',
    inputLabel: '리뷰를 작성하세요',
    inputPlaceholder: '리뷰를 작성하세요!',

    showCancelButton: true,
    confirmButtonText: '네, 작성할래요',
    cancelButtonText: '아니요, 취소할래요',
    
    reverseButtons: false
    }).then((result)=>{
        text = result.value
        // console.log(result.value);
        if(result.isConfirmed){
            Swal.fire(
                '리뷰 등록',
                '리뷰가 성공적으로 등록되었어요! ',
                'success'
              )
        }
    })

    })


    
    

})