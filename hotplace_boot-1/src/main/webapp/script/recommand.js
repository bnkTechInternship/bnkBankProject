$(function() {
    let isLogined = localStorage.getItem('loginUser')
    let user = null;
    if(isLogined)
        user = JSON.parse(localStorage.getItem('loginUser'));    
    console.log(isLogined)
    console.log(user)

    // 로그인 되어있는 경우
    if(user) {
        let userId = user.userId;
        console.log(userId)


        //ajax로 요청 보내서 선택사항 데이터가 있는지
        let result = null;

        // 결과가 있으면
        if(result) {
            
            // ajax로 데이터 분석해서 맞는 데이터 받기
        } 
        else { //결과 없으면
            $("#select_1").addClass('appear')
            $("#select_1").css('z-index',10)
        }            
    } 
    
    
    $("#select_no").click(() => {
        $("#select_1").removeClass('appear')
        $("#select_1").css('z-index',-1)
    })

    $("#select_yes").click(() => {
        $("#select_1").removeClass('appear')
        $("#select_1").css('z-index',-1)
        $('#input_data').addClass('appear')
        $('#input_data').css('z-index',10)
    })

    $("#send_data").click(() => {
        //ajax써서 데이터 전송하기
        
        $('#input_data').removeClass('appear')
        $('#input_data').css('z-index',-1)
        Swal.fire(
            '데이터 입력',
            '성공적으로 입력되었습니다!',
            'success'
        )
        setTimeout(() => {location.reload()},1500)
    })
    
})

