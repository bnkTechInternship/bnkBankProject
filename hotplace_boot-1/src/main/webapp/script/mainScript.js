// 은행, 가게 불러올 데이터 번호
var bankIdx = 1;
var shopIdx = 1;

// 은행 대기번호, 가게 좋아요 자료구조
var shopWaiting = new Map();
var likeList = [];

let tempWaiting = 1;

$(function() {
	// test code
	// localStorage.setItem('loginUser','user01');
	const user = localStorage.getItem('loginUser');
	console.log('user',user);

	// 페이지 로딩시 잠시 출력되는 내용
	let loadContent = 
	`
	<div class="container_item loading">
		<div class="photo_loading"></div>
		<div class="content_loading">
			<h2></h2>
			<p></p>
		</div>
	</div>
	`;

	$(".decoration").fadeIn(5000)

	// 처음 시작시 필요한 데이터 받아오는 함수
	initFunction();

	console.log(location.href)

	let url = location.href.split('?')[1].split('=');
	console.log(url)

	// 시작시 기본 로딩 데이터는 은행으로
	if(url[1] === 'bank'){
		$("#choose_bank").addClass('selected')
		getPartData(bankIdx,"bank");
		getPartData(bankIdx,"bank");
	}
	else {
		$("#choose_food").addClass('selected')
		getPartData(shopIdx,"shop");	
		getPartData(shopIdx,"shop");	
	} 
		
	
	setTimeout(() => {
		$("#logo_slow").addClass('active')
	},2000)

		

	// 스크롤 이벤트
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
        if (scrollTop + innerHeight >= scrollHeight - 10) {    
			if($('.selected').text() === '은행')
				getPartData(bankIdx,"bank")
			else getPartData(shopIdx,"shop")

        }
    })

	$('.menu').click(function() {

		//즉 선택한게 아니다 은행 -> 맛집 or 맛집 -> 은행
		$("#container").empty();

		if($(this).text() === '은행') {
			bankIdx = 1;
			getPartData(bankIdx,"bank");
			getPartData(bankIdx,"bank");
		}
		else {
			shopIdx = 1;
			getPartData(shopIdx,"shop");
			getPartData(shopIdx,"shop");
		}

		$('.menu').removeClass('selected');
		$(this).addClass('selected');
	})
    
    $(".search").click(function() {
        $("#mainNavbar").toggleClass('navbar_toggle')
        $("#searchNavbar").toggleClass('searchNavbar_toggle')

        $("#mainNavbar").toggleClass('bottom-shadow')
        $("#searchNavbar").toggleClass('bottom-shadow')
        
    })

   
    $("#container").on('click',".like",function() {
		// flag : true -> 찜하기, flag : false -> 찜 삭제
		let flag = true;		
		let shopId = $(this).attr('id').substr(8);
		let userId = $(this).attr('data-user')

		console.log(userId);

		if($(this).text() === '♥') 
			flag = !flag;
		

		showSwal(shopId,flag,userId,$(this))

    })//click
    
    
    

    $("#mode").click(function() {
        $("#container").toggleClass('dark_mode_container')
        $(".container_item").toggleClass('dark_mode_container_item')
		$('.shopName').toggleClass('dark_mode_container')
        $(".star").toggleClass('dark_mode_star')
        let data = $(this).attr('src');

        if(data === 'img2/moon.png') 
            $(this).attr('src','img2/sun.png')
        else 
            $(this).attr('src','img2/moon.png')
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

    $(".decoration").each((idx,item) => $(item).css('top',pos[idx].top).css('left',pos[idx].left))

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

	$('#getSearch').click(function(){
    	let shopName = $('#searchShop').val();
    	
    	$.ajax({
    		type:'post',
    		url:'searchShopName.do',
    		data: "shopName="+ shopName,
    		success: (list)=> {
    			$("#container").empty()
				for(let item of list){
					if(user == null) 
						$("#container").append(getShop_NoLogin(item));
					else $("#container").append(getShop_Login(item));

				}
				$(window).off('scroll')
				// $("#logo_slow").css('display','none');
				$('.decoration').css('display','none');
				$("#logo_slow").text('검색한 결과를 확인하세요!');
				$("#find_info").css('z-index',2);
				$("#logo_slow").css('z-index',-1);
				
    		},
			beforeSend : () => beforeSendWork(),
			complete : () => completeWork()
    	})
    });


	// --- function 정리 구간 --- //

    function loadPage(time) {
        $('.loader').css('z-index',12);
        $("#loadback").css('z-index',11);
        setTimeout(() => {
            $('.loader').css('z-index',-1);
            $("#loadback").css('z-index',-1);
        },time)
    }
         
    function getPartData(idx,category) {
		let url_ = `/${category}/init/data`

		// 은행 데이터 요청
		if(category === 'bank') {
			$.ajax({
				url : url_,
				type : 'get',
				data : {"number" : idx},

				success : (result) => {
					for(let item of result) 						
						$("#container").append(getBankContent(item));
				},
				beforeSend : () => beforeSendWork(),
				complete : () => completeWork()
			})
			bankIdx += 3;
		} // 가게 데이터 요청
		else if(category === 'shop') {
			$.ajax({
				url : url_,
				type : 'get',
				data : {"number" : idx},
				success : (result) => {
					for(let item of result) {
						if(user == null)
							$("#container").append(getShop_NoLogin(item));
						else $("#container").append(getShop_Login(item));
					}
				},
				beforeSend : () => beforeSendWork(),
				complete : () => completeWork()
			})
			shopIdx += 3;
		}
	}

    
  

    function beforeSendWork() {
		$('.loader').css('z-index',12);
		$("#loadback").css('z-index',11);										
		for(let i = 0 ; i < 3; i++)
			$("#container").append(loadContent);
	}

	function completeWork() {
		setTimeout(() => {
			$('.loader').css('z-index',-1);
			$("#loadback").css('z-index',-1);
			$('.loading').remove()
		},2000)
	}

	function showSwal(shopId,flag,userId,tag) {
		//flag : false => 찜 삭제
		let title_ = "찜 등록";
		let text_ = "이 가게를 찜 리스트에 추가할까요?";
		let desc_ = "정상적으로 추가되었습니다!";
		let url = "likeShop.do";

		if(!flag) {
			title_ = "찜 삭제";
			text_ = "이 가게를 찜 리스트에서 제거할까요?";
			desc_ = "정상적으로 제거되었어요";
			url = "unlikeShop.do"
		}

		Swal.fire({
			title: title_,
			text: text_,
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'OK',
		  }).then((result) => {
			if (result.isConfirmed) {
			  Swal.fire(
				title_,
				desc_,
				'success'
			  )
			  likeFunction(url,shopId,userId,tag)
			}
		  })
	}

	function likeFunction(url_,shopId,userId,tag) {
		$.ajax({
			url  : url_,
			type : 'get',
			data : "shopIdx="+shopId+"&userId="+userId,

			success : (result) => {
				if(tag.text() === '♥')
					tag.text('♡').css('color','white')
				else tag.text('♥').css('color','red')
			}
		})
	}

	// 은행 정보 받아오기
	function getBankContent(info) {
		return 	`
		<div class ="container_item">
			<div class="photo">
				<img src = "img2/BNK.jpg">
			</div>
			<div class ="shopName">${info.bankName}</div>
			<div class ="shopOper">영업시간 : ${info.bankOper}</div>
			<div id= bankWaiting${info.bankIdx}></div>
		</div>
		`;
	}

	// 비회원 로그인시 가게 정보
	function getShop_NoLogin(info) {
		let data = shopWaiting.get(info.shopIdx);		
		if(data === undefined) data = ++tempWaiting;

		return `
		<div class ="container_item">
			<div class="photo">
				<div class = "star" id = "shopStar${info.shopIdx}">★4.5</div>
				<img src = "${info.webAddress}">
			</div>
			<div class ="shopName">${info.shopName}</div>
			<div class ="shopOper">영업시간 : ${info.shopOper}</div>
			<div class ="shopWaiting">실시간 웨이팅 : ${data}</div>
		</div>`
	}


	// 수정해야함
	// 수정해야함
	// 수정해야함
	// 얘 모든 별점 다 받아와서 가게 아이디 맞게 별점 뿌려줘야함
	function getShop_Login(info) {
		let data = shopWaiting.get(info.shopIdx);		
		if(data === undefined) data = ++tempWaiting;

		let like = '♡';

		// 시작할때 유저 전체 like받아와서 여기서 검사하고 맞추기

		// 만약 찜한 가게일 경우
		for(let i = 0 ; i < likeList.length; i++) {
			if(likeList[i] == info.shopIdx) {
				like = '♥'
				break;
			}
		}

		return `
		<div class ="container_item">
			<div class="photo">
				<div class = "star" id = "shopStar${info.shopIdx}">
					★4.5
					<div class = "like" id = "shopLike${info.shopIdx}" data-user = ${user}>${like}</div>
				</div>
				<img src = "${info.webAddress}">
			</div>
			<div class ="shopName">${info.shopName}</div>
			<div class ="shopOper">영업시간 : ${info.shopOper}</div>
			<div class ="shopWaiting">실시간 웨이팅 : ${data}</div>
		</div>`
	}

	//가게 웨이팅 전부 받아오기
	async function getAllShopWaiting() {
		$.ajax({
			url : '/shop/allWaiting',
			type : 'get',

			success : (result) => {
				for(let item of result)
					shopWaiting.set(item.shopIdx,item.waitingNum)
			},
			beforeSend : () => beforeSendWork(),
			complete : () => completeWork()
		})
	}

	// 가게 좋아요 모두 받아오기
	async function getAllShopLike() {
		$.ajax({
			url : '/shop/allLike',
			type : 'get',

			success : (result) => {
				for(let i = 0 ; i < result.length; i++)
					if(user === result[i].userId)
						likeList.push(result[i].shopIdx)
				console.log("성공한 후 LikeList : ",likeList)						
			},
			beforeSend : () => beforeSendWork(),
			complete : () => completeWork()
		})
	}


	// 페이지 첫 로딩시 데이터 받아오기
	// 은행 웨이팅, 가게 좋아요 및 웨이팅 받아오는 시작 함수
	async function initFunction() {
		// 모든 가게 웨이팅
		await getAllShopWaiting();

		// 가게 좋아요 가져오기
		await getAllShopLike();

		// 은행 웨이팅 데이터가 없어서 아직 안만듬..		
		
	}
})
