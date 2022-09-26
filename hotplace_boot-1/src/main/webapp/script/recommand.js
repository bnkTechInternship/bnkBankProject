$(document).ready(readyFnc)


function readyFnc() {
    let isLogined = localStorage.getItem('loginUser')
    let user = null;
    if(isLogined)
        user = JSON.parse(localStorage.getItem('loginUser'));    
    console.log(isLogined)
    console.log(user)
    console.log(user)

    
    // 로그인 되어있는 경우
    if(user) {
        let userId = user.userId;
        console.log('userId : 123',userId)
        $("#userId_hidden").attr('value',userId);
        
        isExist(userId)                    
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

    $("#marri_2").on('change',function() {
        let chooseData = $(this).val()
        console.log(chooseData)

        if(chooseData == 1)
            $("#MARITAL_STATUS").css('display','block')
        else $("#MARITAL_STATUS").css('display','none')
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
}

let isExist = async(userId2) => new Promise((resolve,reject) => {
    $.ajax({
        type : 'post',
        url  : 'recommand/confirm',
        data : {'userId' : userId2},

        success : (result) => {
            console.log("값 확인 결과 : ",result)
            if(result == false) { 
                $("#select_1").addClass('appear')
                $("#select_1").css('z-index',10)
            } else {// 머신러닝 분석 데이터 받기
                
            }
        }
    })
})