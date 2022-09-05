$(function() {
    $(window).resize(function() {
        
    })
    //
    const money = Math.floor(Math.random()*1001) * 1000;
    const point = Math.floor(Math.random()*1001) * 100;

    
    $('#money').val(money);
    $('#point').val(point);

    const moneystr = money.toString()
                .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
    const pointstr = point.toString()
                .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

    $('#modalmoney').html(moneystr+'&#8361;');
    $('#modalpoint').html(pointstr+'&#8361;');
    
    $('#register_button').click(function(){
    	
    	if( $('#floatingId').val()=="" ||
    			$('#floatingPassword').val()=="" ||
    			$('#floatingPasswordcheck').val()==""|| 
    			$('#floatingName').val()==""|| 
    			$('#floatingEmail').val()==""|| 
    			$('#floatingAddress').val()=="" || 
    			$('#floatingPhone').val()==""){
    		
    		Swal.fire({
	  			  icon: 'error',
	  			  title: '회원가입 오류',
	  			  text: '입력하지 않은 정보가 있습니다.'
			}).then()
				
    	}else{
    		
    	Swal.fire({
  			  icon: 'success',
  			  title: '회원가입 성공!',
  			  }).then((result)=>{
  				  if(result.isConfirmed)
	  					  $('form').submit();
  			  	}
  			  )
    	}
    });
    
   
  
    
    
    $('#floatingId').keyup(function(){
		//1.아이디 요건 충족하는지의 여부를 가늠..
		var id=$(this).val();
		if(id.length<4 || id.length>8){
			$('#check').html('4자 이상, 8자이하로 작성').css('color','red').css('font-size', 'x-small');
			$('#register_button').attr('disabled',true); //비활성화되어짐
		}else{ //2.아이디 요건을 충족하면 디비가서 존재유무를 따진다.
			
			$.ajax({
				//요청부분
				type:'post',
				url:'idExist.do',
				data:"id="+id,
				
				//응답부분
				success:function(result){
						var jsonData = JSON.parse(result); //객체 받음
						if(jsonData.check==true){
							$('#check').html('이미사용중인아이디').css('color','red');
							$('#register_button').attr('disabled',true);
						}else{
							$('#check').html('사용가능아이디').css('color','blue');
							$('#register_button').attr('disabled',false);
						}
				}//success
				,error:function(result){
					$('#check').html('이미사용중인아이디').css('color','red');
					$('#register_button').attr('disabled',true);
				}
				
			});//ajax
		}//else
	});	//keyup
    
    
    $('#floatingPasswordcheck').keyup(function(){
		//1.아이디 요건 충족하는지의 여부를 가늠..
		var pw_chk=$(this).val();
		if(pw_chk !=$('#floatingPassword').val()){
			
			$('#pwCheck').html('비밀번호가 다릅니다').css('color','red').css('font-size', 'x-small');
			$('#register_button').attr('disabled',true); //비활성화되어짐
		}else{ //2.아이디 요건을 충족하면 디비가서 존재유무를 따진다.
			$('#pwCheck').html('비밀번호가 동일합니다').css('color','blue').css('font-size', 'x-small');
			$('#register_button').attr('disabled',false);
		}//else
	});	//keyup
    
    
    $(document).ready(function() {
    	  
        $("#floatingPhone").focus(focused); //input에 focus일 때
        $("#floatingPhone").blur(blured);   //focus out일 때
      })

    function focused(){
      var input = $("#floatingPhone").val();
      
      //input안에서 하이픈(-) 제거
      var phone = input.replace( /-/gi, '');
      //number 타입으로 변경(숫자만 입력)
      $("#floatingPhone").prop('type', 'number');
      
      $("#floatingPhone").val(phone);
    }

    function blured(){
      var input = $("#floatingPhone").val();
      
      //숫자에 하이픈(-) 추가
      var phone = chkItemPhone(input);
      //text 타입으로 변경
      $("#floatingPhone").prop('type', 'text');
      
      $("#floatingPhone").val(phone);
    }


    //전화번호 문자(-)
    function chkItemPhone(temp) {
      var number = temp.replace(/[^0-9]/g, "");
      var phone = "";

      if (number.length < 9) {
        return number;
      } else if (number.length < 10) {
        phone += number.substr(0, 2);
            phone += "-";
            phone += number.substr(2, 3);
        phone += "-";
        phone += number.substr(5);
      } else if (number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
      } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
      }

      return phone;
    }
    
    
    
    
    
})