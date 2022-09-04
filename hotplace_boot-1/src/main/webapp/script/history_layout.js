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
		data:"userId="+userId,

        success:function(list){
            console.log(list);
            
            for (let i=0; i<list.length;i++){
            	let src = list[i][0].shop.webAddress
            	let date = list[i][0].waitingDate
            	let shopName = list[i][0].shop.shopName
            	var menuList = [];
     
            	for(let j=0; j< list[i].length; j++){
            		menuList.push(list[i][j].menu.menuName)
            	}
            	
            	let addContent= 
            		`
                    <div class="history">
                		<div class="first">
                     
                			<img src="./" + "${src}">
                			<div class="first_text"> 
                				<div class = "date">${date} - 식사 완료</div><br><br>
                				<span id="name">${shopName}</span><br><br><br>
                				<span id="menu">보쌈집합 장수왕족발 고메부산밀면 밀면밀면 <br>39000원</span>
                            </div>
                        </div>
                        <div class="review man">
                            <blockquote>
                                <p id="reivew_before">별을 클릭해서 리뷰를 작성하세요!</p>
                            </blockquote>
                        </div><!--리뷰-->
                        <div class="nameNstar_right"> <!-- 별점 확정 안됐을 때 리뷰 -->
                            <fieldset class="rating">
                                <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                                <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                                <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                                <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                                <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                                <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                            </fieldset>
                        </div>
                    </div><!-- history-->
            	
            	
            	`
            		$('.left_second').append(addContent);
            	

            	
            	
            	
            }
        }

    });
    
    

   /* $('input[type="radio"]').click(
    		async() => {

    		    Swal.fire({
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

    		    }
    );

*/
    
    

})