$(function() {
	
	
	let user = JSON.parse(localStorage.getItem('loginUser'));
    let userName = user.userName;
    let userPoint = user.userPoint;
    let userBalance = user.userBalance;
    
	
    
    $('#left_first').append(
    		'<div>'+userName+'님의 예약현황</div>'
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
    				'<h3>' + shop.shopName + '</h3>'
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
    		
    		
    		
    	}
    })
    
    
    
    
    $.ajax({
    	type:'post',
    	url:'getReviews.do',
    	data:"userId="+user.userId,
    	
    	success:function(result){
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
    
    
    

})
