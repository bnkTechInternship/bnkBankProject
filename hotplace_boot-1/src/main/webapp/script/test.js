function getPartData(idx) {
    $.ajax({
        url : '/shop/init/data',
        type : "get",
        data : {
            "number" : idx,
        },
        
        success : (result) => {
            const user = JSON.parse(localStorage.getItem('loginUser'));
            console.log(user);
            
            var like = '♡'
            for(let i = 0 ; i < result.length; i++) {
                const webAddress=result[i].webAddress
                const shopIdx = result[i].shopIdx
                const shopName = result[i].shopName
                const shopOper = result[i].shopOper
                const totalCnt = result[i].totalCnt
                
                if(user!=null){
                    let userId = user.userId;
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
                                    avgScore = result;
                                }
                            })
                            
                            var jsonData = JSON.parse(result);
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
                                    <div id="shopName">${shopName}</div>
                                    <div id="shopOper">영업시간 : ${shopOper}</div>
                                    <div id="shopWaiting">실시간 웨이팅 : ${totalCnt}</div>
                                </div>`
                                
                            console.log(like);  
                            $("#container").append(addContent);
                            
                        }//success끝
                    })//ajax
                }else{
                    var avgScore = 0.0;
                    $.ajax({
                        type:'post',
                        url:'getAvgScore.do',
                        async:false,
                        data: "shopIdx="+shopIdx,
                        
                        success : function(result){
                            avgScore = result;
                        }
                    })
                    let addContent=`
                    
                    <div class ="container_item">
                        <div class="photo">
                            <div class = "star">
                                ★ ${avgScore}
                            <div class = "like">♡</div>
                        </div>
                            <img src = "${webAddress}">
                        </div>
                        <input type=hidden value=${shopIdx}>
                        <div id="shopName">${shopName}</div>
                        <div id="shopOper">영업시간 : ${shopOper}</div>
                        <div id="shopWaiting">실시간 웨이팅 : ${totalCnt}</div>
                        </div>`
                            
                        $("#container").append(addContent);

                }

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


/*좋아요*/
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