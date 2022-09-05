$(function(){
    const user = JSON.parse(localStorage.getItem('loginUser'));
	let userName = user.userName;
	let userId = user.userId;

    $('.left_first').append(
        '<h3>' + userName+'님의 이용내역</h3>'
    );
    
    $(document).on('click','.last',
    		function(e){
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
				        if(result.isConfirmed){ // 확인버튼이면 ajax 처리하고 성공 실패에따라 모달
				        	
				        	
				        	$.ajax({
				        		type: 'post',
				        		url: 'addReview.do',
				        		data:{
				        			userId: userId,
				        			shopIdx: $(this).parent().attr('name'),
				        			score: $(this).val(),
				        			comment: text
				        			}
				        		,
				        		
				        		success:function(){
				        			Swal.fire(
							                '리뷰 등록',
							                '리뷰가 성공적으로 등록되었어요! ',
							                'success'
								        ).then((result)=>{
								        	location.reload(); // 버튼을 누르면 페이지 새로고침
								        })
								    
					        	},
				        		error:function(){
				        			alert("error!");
				        		}
				        	}) // success면 Swal.fire 사용, 실패면 에러페이지 연결
					        
				        	}//isConfirmed>
				        
					    })
    	
    	 
    })

  
    $.ajax({
        type:'post',
		url:'getWaitingList.do',
		data:"userId="+userId,

        success:function(list){
        	
        	/*for (let i=0; i<list.length; i++)
   					console.log(list[i][7]); //price, menu, score, comment, date, shopname, shopwebaddress, shopidx*/

        	
            for (let i=0; i<list.length;i++){
            		var starContent=`` // 별점이 있는것과 없는것을 구분하여 저장하는 변수
            		var score = `` // 별점이 몇점인지에 따라 별 갯수를 저장하는 변수
            		var text = list[i][3]; // starContent 안에 들어갈 코멘트를 저장하는 변수
            		var shopIdx = list[i][7]
            		if(list[i][2] == 0) // 별점이 아직 등록 안되었을 경우....
            		{
            			starContent = 
            				`
            					 <div class="review man">
		                            <blockquote>
		                                <p id="reivew_before">별을 클릭해서 리뷰를 작성하세요!</p>
		                            </blockquote>
		                        </div><!--리뷰-->
		                        
			                        <div class="nameNstar_right"> <!-- 별점 확정 안됐을 때 리뷰 -->
			                            <fieldset class="rating" name="${list[i][7]}">
			                                <input type="radio" class="last" id="star5" name="rating" value="5" /><label class = "full" for="star5"></label>
			                                <input type="radio" class="last" id="star4half" name="rating" value="4.5" /><label class="half" for="star4half"></label>
			                                <input type="radio" class="last"  id="star4" name="rating" value="4" /><label class = "full" for="star4"></label>
			                                <input type="radio" class="last" id="star3half" name="rating" value="3.5" /><label class="half" for="star3half"></label>
			                                <input type="radio" class="last" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
			                                <input type="radio" class="last" id="star2half" name="rating" value="2.5" /><label class="half" for="star2half"></label>
			                                <input type="radio" class="last" id="star2" name="rating" value="2" /><label class = "full" for="star2"></label>
			                                <input type="radio" class="last" id="star1half" name="rating" value="1.5" /><label class="half" for="star1half"></label>
			                                <input type="radio" class="last" id="star1" name="rating" value="1" /><label class = "full" for="star1"></label>
			                                <input type="radio" class="last" id="starhalf" name="rating" value="0.5" /><label class="half" for="starhalf"></label>
			                            </fieldset>
			                        </div>
            				`
            		}
            		else{ // 별점이 이미 등록되었을 경우...
            			
            			for(let j=0; j < 10-list[i][2]; j++) // 꽉찬 별 채우기
        				{
            				if(j%2==0) // 꽉찬 별에서는 마지막에 무조건 full이 나오므로 처음엔 full
            				score += 
                				`<input type="radio" id="starhalf" name="rating" value="half" /><label class="full" for="starhalf"></label>`	
            				else	// 짝수번째에는 무조건 half
            				score += 
                    			`<input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf"></label>`
            				
        					
        				}
            			
            			
            			for(let j=0; j < list[i][2]; j++) // 빈 별 채우기
            				{
            					if(list[i][2]%2==0){ // 최종 별점이 짝수면 full-half-full-half로 쌓아야하고,
	            					if(j%2==0)
	            					score += 
	            						`<input type="radio" id="starhalf" name="rating" value="half"  /><label id="fin" class="full" for="starhalf"></label>`
	            					else
	            					score += 
	                					`<input type="radio" id="starhalf" name="rating" value="half" /><label id="fin"  class="half" for="starhalf"></label>`
            					}
            					else{	// 최종 별점이 홀수면 half-full-half-full으로 쌓아야한다. css 적용때문에 쓰는 코드
            						if(j%2==0)
            						score += 
                    					`<input type="radio" id="starhalf" name="rating" value="half" /><label id="fin" class="half" for="starhalf"></label>`
            						else
            						score += 
                						`<input type="radio" id="starhalf" name="rating" value="half" /><label id="fin" class="full" for="starhalf"></label>`
            					}
            					
            				}
            			// 별점 div에 위에서 저장한 별 갯수와 comment를 더하여서 최종적으로 starContent를 만드는 코드
            			starContent =
            				`
            					<div class="review man">
		                            <blockquote>
		                                <p id="reivew_before">
		                    `
            								+text+
            				`
		                                </p>
		                            </blockquote>
		                        </div><!--리뷰-->
            					<div class="nameNstar_right">
		                            <fieldset class="rating">
		                    `
            							+score+
            				`
		                            </fieldset>
                        		</div>
            				`
            			
            		} // 별점이 이미 등록되었을 경우에 별점칸 생성 끝
            		
            		let addContent = 	
            		//최종적으로 addContent는 first안의 가게 정보와, starCotent로 쌓아올린 리뷰 정보인 history로 저장된다.
            		`
                    <div class="history">
                		<div class="first">
                			<img src="${list[i][6]}">
                			<div class="first_text"> 
                				<div class = "date">${list[i][4]} - 식사 완료</div><br><br>
                				<span id="name">${list[i][5]}</span><br><br><br>
                				<span id="menu">${list[i][1]}<br>${list[i][0]}</span>
                            </div>
                        </div>
		             `
            			+starContent+
		             `
			         </div><!-- history-->
            		 `
            		$('.left_second').append(addContent);

            }
        }

    }); // ajax
    


}) // fun