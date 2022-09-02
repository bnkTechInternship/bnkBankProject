$(function() {
	let partData = 1;
	getPartData(partData);		
	getPartData(partData);
	//getPartWaitingCnt(partData);
	
	
	
    $(window).scroll(function() {
        let scrollTop = $(this).scrollTop();


        if(scrollTop > 280)
            $("#logo_slow > div:nth-child(3)").css('opacity',0)
        else $("#logo_slow > div:nth-child(3)").css('opacity',1)
        if(scrollTop > 350)
            $("#logo_slow > div:nth-child(2)").css('opacity',0)
        else $("#logo_slow > div:nth-child(2)").css('opacity',1)
        if(scrollTop > 450)
            $("#logo_slow > div:nth-child(1)").css('opacity',0)
        else $("#logo_slow > div:nth-child(1)").css('opacity',1)

        if(scrollTop > 430) {
            $("#searchNavbar, #mainNavbar")
                    .css('background-color','rgba(255,255,255,0.7)')
            $("#searchNavbar * , #mainNavbar *").css('color','black')
            $(".search").attr('src','img2/search.png')
            $("#getSearch").attr('src','img2/search.png')
            $("#userInfo").attr('src','img2/user.png')
        } else {
            $("#searchNavbar, #mainNavbar")
                    .css('background-color','rgba(34,34,49,1)')
            $("#searchNavbar * , #mainNavbar *").css('color','white')
            $(".search").attr('src','img2/search2.png')
            $("#getSearch").attr('src','img2/search2.png')
            $("#userInfo").attr('src','img2/user2.png')
        }

        let calcScroll = scrollTop * 0.005;
        let calcScroll2 = scrollTop * 0.008;

        $('.decoration').css('opacity',1-calcScroll);
        $('#navi').css('opacity',1-calcScroll2);

        let logoHeight = - scrollTop / 5;
        $("#logo_slow").css('transform', `translateY(${logoHeight}px)`);

        var innerHeight = $(window).innerHeight();
        var scrollHeight = $('body').prop('scrollHeight');
        if (scrollTop + innerHeight >= scrollHeight - 20) {
            
            let loadContent = 
            `
            <div class="container_item loading">
                <div class="photo_loading"></div>
                <div class="content_loading">
                    <h2></h2>
                    <p></p>
                </div>
            </div>
            `

            let addContent = `
            
            <div class ="container_item">
                <div class="photo">
                    <div class = "star">
                        ★ 4.5
                        <div class = "like">♡</div>
                    </div>	
                    <img src = "img2/wallpaper1.jpg">
                </div>
                <div>가게 이름</div>
                <div>평균 가격 : ₩35,000</div>
                <div>웨이팅 사람수 : 5</div>
            </div>
            
            `           
            getPartData(partData);
           // getPartWaitingCnt(partData);
            
            
        } else {
            console.log("아님")
        }

    })
    
    $('#logo').click(function(){
    	location.replace('main.html');
    })

    $(".search").click(function() {
        $("#mainNavbar").toggleClass('navbar_toggle')
        $("#searchNavbar").toggleClass('searchNavbar_toggle')

        $("#mainNavbar").toggleClass('bottom-shadow')
        $("#searchNavbar").toggleClass('bottom-shadow')
        
    })

/*    $("#container").on('click',".like",function() {
        let data = $(this).text()
        // 로그인 되었는지 확인하고
        // 찜하는 기능도 들어가야함
        if(data === '♡')
            $(this).html('♥').css('color','red')   
        else $(this).html('♡').css('color','white')
    })*/
    
    $("#container").on('click',".like",function() {
    	
    	
    	let data = $(this).text()
    	const user = JSON.parse(localStorage.getItem('loginUser'));
    	const userId = user.userId;
    	console.log(userId);
    	const shopIdx = $(this).parent().parent().next().val();
    	console.log(data);
    	if(data == '♡'){
    		if(localStorage.getItem("loginUser")==null){
    					location.replace('login.html')}
    		$(this).html('♥').css('color','red');
    		$.ajax({
				type : "get",	
    			url : "likeShop.do",
    			data : "shopIdx="+shopIdx+"&userId="+userId,
    			success : function(result){
    				Swal.fire({
    					  title: '찜 등록',
    					  text: "이 가게를 찜 리스트에 추가할까요?",
    					  icon: 'warning',
    					  showCancelButton: true,
    					  confirmButtonColor: '#3085d6',
    					  cancelButtonColor: '#d33',
    					  confirmButtonText: 'OK',
    					}).then((result) => {
    					  if (result.isConfirmed) {
    					    Swal.fire(
    					      '찜 등록',
    					      '정상적으로 추가되었어요',
    					      'success'
    					    )
    					  }
    					})
    				
    			}//success
	    	})//ajax
    		
    		
    		
    	}else{
    		$(this).html('♡').css('color','white');
    		$.ajax({
				type : "get",	
    			url : "unlikeShop.do",
    			data : "shopIdx="+shopIdx+"&userId="+userId,
    			success : function(result){
    				
    				Swal.fire({
  					  title: '찜 취소',
  					  text: "이 가게를 찜 리스트에서 제거할까요?",
  					  icon: 'warning',
  					  showCancelButton: true,
  					  confirmButtonColor: '#3085d6',
  					  cancelButtonColor: '#d33',
  					  confirmButtonText: 'OK',
  					}).then((result) => {
  					  if (result.isConfirmed) {
  					    Swal.fire(
  					      '찜 취소',
  					      '정상적으로 제거되었어요',
  					      'success'
  					    )
  					  }
  					})
  					
    			}//success
	    	})//ajax
    		
    	
    	
    	}
    	console.log($(this).parent().parent().next().val());
    	
		
    })//click
    
    
    

    $("#mode").click(function() {
        $("#container").toggleClass('dark_mode_container')
        $(".container_item").toggleClass('dark_mode_container_item')
        $(".star").toggleClass('dark_mode_star')
        let data = $(this).attr('src');

        if(data === 'img2/moon.png') {
            $(this).attr('src','img2/sun.png')
        }else {
            $(this).attr('src','img2/moon.png')
            
        }
    })

    $( '#up' ).click( function() {
        if($(this).attr('src') === 'img2/up-arrow.png') {
            $( 'html, body' ).animate( { scrollTop : 0 }, 1000 );
            return false;
        }

        
    });

    let pos = [ {top : "70px", left : "250px"},
                {top : "300px", left : "100px"}, 
                {top : "220px", left : "390px"},
                {top : "70px", left : "1200px"},
                {top : "300px", left : "1350px"},
                {top : "220px", left : "1050px"}]

    $(".decoration").each((idx,item) => {
        $(item).css('top',pos[idx].top).css('left',pos[idx].left)
        
    })

    $("#changeToMap").click(function() {
        $('.right-layer').toggleClass('active')
        setTimeout(() => {
            if($(this).attr('src') === 'img2/writer.png')
                $(this).attr('src','img2/map.png');
            else $(this).attr('src','img2/writer.png');

            $("#map").toggleClass('map_zidx');
            $("#content").toggleClass('content_small');
            $("container_item").toggleClass('content_small');
            $("#up").toggleClass('content_small')
            $("#toggleBtn").toggleClass('zidx_up')
            $("#toggleBtn *").toggleClass('zidx_up')
        },880)
    })

    $("#toggleBtn img").click(function() {
        loadPage(1500);
    })

    function loadPage(time) {

        $('.loader').css('z-index',12);
        $("#loadback").css('z-index',11);
        setTimeout(() => {
            $('.loader').css('z-index',-1);
            $("#loadback").css('z-index',-1);
        },time)
    }
    
    function getPartWaitingCnt(idx){
    	$.ajax({
    		
    		url: '/shop/init/waitingCnt',
    		type : "get",
    		data : {
    			"number" : idx,
    		},
    		
    			success : (result) => {
				
				
				for(let i = 0 ; i < result.length; i++) {
					let addContent = 
						`
			                <div>실시간 웨이팅 : ${result[i]}</div>
			                </div>
			            
			            `
						$("#container").append(addContent);
				}
				
			} // success 끝
    	}
    	
    	)
    	
    	
    }
    
 
    
    function getPartData(idx) {
    	const user = JSON.parse(localStorage.getItem('loginUser'));
    	let userId = user.userId;

    	
    	$.ajax({
    		url : '/shop/init/data',
			type : "get",
			data : {
				"number" : idx,
			},
			
			success : (result) => {
				
				var like = '♡'
				for(let i = 0 ; i < result.length; i++) {
					const webAddress=result[i].webAddress;
					const shopIdx = result[i].shopIdx;
					const shopName = result[i].shopName;
					const shopOper = result[i].shopOper;
					const totalCnt = result[i].totalCnt;
					
/*					$.ajax({
						type:'post',
			    		url:'getAvgScore.do',
			    		async:false,
			    		data: "shopIdx="+shopIdx,
			    		
			    		success : function(result){
			    			console.log(result);
			    			let avgScore = result;
			    		}
					})*/
					
					$.ajax({
			    		type:'post',
			    		url:'checkLike.do',
			    		data: "userId="+userId+"&shopIdx="+shopIdx,
			    		
			    		
			    		success : function(result){
			    			var avgScore = 0.0;
							$.ajax({
								type:'post',
					    		url:'getAvgScore.do',
					    		async:false,
					    		data: "shopIdx="+shopIdx,
					    		
					    		success : function(result){
					    			console.log(result);
					    			avgScore = result;
					    		}
							})
							
			    			console.log(userId+"아작스호출"+shopIdx);
			    			var jsonData = JSON.parse(result);
			    			console.log(jsonData);
			    			if(jsonData ==true){
			    				like = '♥'
			    			}else{
			    				like = '♡'
			    			}
			    			
			    		    	//$('.like').html('♡').css('color','white');
	    					let addContent = `
	    			            
	    			            <div class ="container_item">
	    			                <div class="photo">
	    			                    <div class = "star">
	    									★ ${avgScore}
	    		                        <div class = "like">` + like + `</div>
	    		                    </div>
	    		                    	<img src = "${webAddress}">
	    			                </div>
	    			                <input type=hidden value=${shopIdx}>
	    			                <div>${shopName}</div>
	    			                <div>영업시간 : ${shopOper}</div>
	    			                <div>실시간 웨이팅 : ${totalCnt}</div>
	    			                </div>`
	    			            
	    			        console.log(like);  
	    					$("#container").append(addContent);
			    		}
			    	})

				}
			}, // success 끝
			beforeSend : () => {
				$('.loader').css('z-index',12);
		        $("#loadback").css('z-index',11);
		        
		        let loadContent = 
		            `
		            <div class="container_item loading">
		                <div class="photo_loading"></div>
		                <div class="content_loading">
		                    <h2></h2>
		                    <p></p>
		                </div>
		            </div>
		            `
		        
		        for(let i = 0 ; i < 3; i++)
	                $("#container").append(loadContent);
			},
			complete : () => {
				setTimeout(() => {
					$('.loader').css('z-index',-1);
		            $("#loadback").css('z-index',-1);
		            $('.loading').remove()
				},2000)
			}
    	})
    	
    	partData += 3;
    }
    

})