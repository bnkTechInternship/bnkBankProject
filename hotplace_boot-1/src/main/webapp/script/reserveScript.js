$(function() {
	
	
	const user = JSON.parse(localStorage.getItem('loginUser'));
    let userName = user.userName;
    let userId = user.userId;
    let userPoint = user.userPoint;
    let userBalance = user.userBalance;	
    
    console.log(user);
    
    
    $('button').click(function(){

    	$.ajax({
    		type: 'post',
    		url: 'deleteWaitingInfo.do',
    		data: {
    			userId: userId,
    			shopIdx: $(this).parents('.contents').children().children('.left_second').children('.details').children(0).children(1).children(1).attr('name'),
    			},
    		
    		success:function(data){
    			
    		}
    	})
    	
    	
    })
    
    
    $('#left_first').append(
    		'<div>'+userName+'님의 실시간 웨이팅 정보</div>'
    );
    
    $('.card_text').append(
            '<p id="p1">' +userName + '</p><h5>' + userPoint + 'p</h5><h2>'+
            userBalance+'원</h2>'
    );
    
    $.ajax({
    	type:'post',
    	url:'getShopInfo.do',
    	data:"userId="+user.userId,
    	
    	
    	success:function(shop){
    		
    		
    		$('#shop_name').append(
    				'<h3 name="'+shop.shopIdx+'">' + shop.shopName + '</h3>'
    		);
    		
    		$('.details_text').html(
    				'<span>' + shop.shopNumber + '</span>'
    		);
    		
    		$('#phone').click(function(){
    			$('.details_text').html(
        				'<span>' + shop.shopNumber + '</span>'
        		);
    			
    		});
    		
    		$('#oper').click(function(){
    			$('.details_text').html(
        				'<span>' + shop.shopOper + '</span>'
        		);
    			
    		});
    		
    		$('#addr').click(function(){
    			$('.details_text').html(
        				'<span>' + shop.shopAddress + '</span>'
        		);
    			
    		});
    		
    		
    		
    	},
    	error:function(){
    		
        }
    
    })
    
    
    
    
    $.ajax({
    	type:'post',
    	url:'getReviews.do',
    	data:"userId="+user.userId,
    	
    	success:function(result){
    		console.log(result);
    	    $('.review_first').append(
    	    	`
                <div class="review_head">
                    <!--<div class="review_img"><img src="img/bank.png"></div> -->
                    <div class="review_writer"><span>${result[0].userId}</span></div>
                    <div class="review_star"><p>★  ${result[0].score}</p></div>
                </div>
                <div class="review_text">
                    <p>${result[0].comm}
                    </p>
                </div>
                `
    	    );
    	    
    	    $('.review_second').append(
        	    	`
                    <div class="review_head">
                        <!--<div class="review_img"><img src="img/bank.png"></div> -->
                        <div class="review_writer"><span>${result[1].userId}</span></div>
                        <div class="review_star"><p>★  ${result[1].score}</p></div>
                    </div>
                    <div class="review_text">
                        <p>${result[1].comm}
                        </p>
                    </div>
                    `
        	    );
    	}
    });
    
    $.ajax({
    	type:'post',
    	url:'getOrder.do',
    	data:"userId="+userId,
    	
    	success:function(waitingshops){
    		let totalPrice = 0;
    		waitingshops.forEach((el, i) => {
    			totalPrice += el.waitingCnt;
    			$('.menu_list').append(
        				`
                        <div class="menu_text">
                            <div class="menu_name"><span>${waitingshops[i].waitingDate} </span></div>
                            <div class="menu_amount"><span>${waitingshops[i].quantity}개</span></div>
                            <div class="menu_price"><span>${waitingshops[i].waitingCnt}원</span></div>
                        </div>
                        `
                          
        		);

    		});
    		$('.menu_list').append(
    				
                    '<br><hr><br><div class="menu_text"><div class="menu_name"><span>총 금액'
                         +
                        '</span></div><div class="menu_amount"><span>:</span></div><div class="menu_price"><span>'+ totalPrice +'원</span></div></div>'

    		);
    	},
    	error:function(){
    		/*
    		$().html(`<div class="wrap_img">
                        <div id="main_text">현재 웨이팅 중인 가게가 없어요</div>
                        <div id="sub_text">고메부산에 소개된 핫플들을 웨이팅하고 동백전 캐시백도 받아보세요!</div>
                        <a href="main.html" id="waiting_text">웨이팅하러가기</a>
                    </div>`);*/
    	}
    });
    
    $.ajax({
    	type:'post',
    	url:'getRealWaiting.do',
    	data:"userId="+user.userId,
    	success:function(untilCnt){
    		
    		$('#untilCnt').append(
    				'내 차례까지 '+ untilCnt+ '팀'		
    		)
    		
    		$('#untilTime').append(
    				'예상 대기시간 '+ parseInt(untilCnt)*10 +'분'
    		)
    		
    	},
    	error:function(untilCnt){
    		
    		//$('.waiting_info').html(``);
    	}
    	
    });

})
