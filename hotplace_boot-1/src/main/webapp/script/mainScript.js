// 은행, 가게 불러올 데이터 번호
var bankIdx = 1;
var shopIdx = 1;

// 은행 대기번호, 가게 좋아요 자료구조
var shopWaiting = new Map();
var likeList = [];
let shopReview = []


let tempWaiting = 1;

$(function() {
	const user = localStorage.getItem('loginUser');
	const reg = (/[\{\'\"}]/g);
	let loginUserId  = null;
	

	if(user != null)
		loginUserId = user.replace(reg,'').split(',')[0].split(':')[1]

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

	// 처음 시작시 필요한 데이터 받아오는 함수
	initFunction();

	let url = location.href.split('?');

	// 시작시 기본 로딩 데이터는 가게로
	if(url.length == 1 || (url.length > 1 && url[1].split('=')[1] === 'shop')){
		$("#choose_food").addClass('selected')
		getPartData(shopIdx,"shop");
		getPartData(shopIdx,"shop");
	}
	else {
		$("#choose_bank").addClass('selected')
		getPartData(bankIdx,"bank");	
		getPartData(bankIdx,"bank");	
	} 
	
	setTimeout(() => {
		$("#logo_slow").addClass('active')

		$(".down_slow").addClass('active')
		setTimeout(() => {
			$(".down_slow2").addClass('active')
		},1000)
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
			$("#logo").css('background-image','url(../img2/changeColorLogo2.png)')
        } else {
            $("#searchNavbar, #mainNavbar")
                    .css('background-color','rgba(34,34,49,1)')
            $("#searchNavbar * , #mainNavbar *").css('color','white')
            $(".search").attr('src','img2/search2.png')
            $("#getSearch").attr('src','img2/search2.png')
            $("#userInfo").attr('src','img2/user2.png')
			$("#logo").css('background-image','url(../img2/changeColorLogo.png)')
        }

        let calcScroll = scrollTop * 0.005;
        let calcScroll2 = scrollTop * 0.008;

        $('.decoration').css('opacity',1-calcScroll);
        $('#navi').css('opacity',1-calcScroll2);

        let logoHeight = - scrollTop / 5;
        $("#logo_slow").css('transform', `translateY(${logoHeight}px)`);

        var innerHeight = $(window).innerHeight();
        var scrollHeight = $('body').prop('scrollHeight');
        if (scrollTop + innerHeight >= scrollHeight - 5) {    
			if($('.selected').text() === '은행')
				getPartData(bankIdx,"bank")
			else getPartData(shopIdx,"shop")
        }
    })

	// 내정보 이미지 클릭시
	$("#userInfo").click(function() {
		//비로그인시
		if(loginUserId == undefined) {
			Swal.fire({
				icon: 'error',
				title: '회원전용 기능입니다.',
				text: '로그인을 해주세요',
				footer: '<a href="login.html">로그인 하러가기</a>'
			})
		}
		else location.href = 'userinfo.html'	
	})
    
	// 검색 이미지 클릭시
    $(".search").click(function() {
        $("#mainNavbar").toggleClass('navbar_toggle')
        $("#searchNavbar").toggleClass('searchNavbar_toggle')

        $("#mainNavbar").toggleClass('bottom-shadow')
        $("#searchNavbar").toggleClass('bottom-shadow')
    })

   // 좋아요 클릭시
    $("#container").on('click',".like",function() {
		// flag : true -> 찜하기, flag : false -> 찜 삭제
		let flag = true;		
		let shopId = $(this).attr('id').substr(8);
		let userId = $(this).attr('data-user')

		if($(this).text() === '♥') 
			flag = !flag;

		showSwal(shopId,flag,userId,$(this))
    })
    
	// 다크모드
    $("#mode").click(function() {
        $("#container").toggleClass('dark_mode_container')
        $(".container_item").toggleClass('dark_mode_container_item')
		$('.shopName').toggleClass('dark_mode_container')
        $(".star").toggleClass('dark_mode_star')
        let data = $(this).attr('src');

        if(data === 'img2/moon.png')  
			$(this).attr('src','img2/sun.png')
        else $(this).attr('src','img2/moon.png')
    })

	// 위로가기 버튼 클릭시
    $( '#up' ).click( function() {
        if($(this).attr('src') === 'img2/up-arrow.png') {
            $( 'html, body' ).animate( { scrollTop : 0 }, 1000 );
            return false;
        }
    });

	// 프론트 기술이 부족해 js로 위치 설정..
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

	// 은행 or 가게 불러오는 이미지 클릭시 로딩 페이지 등장
    $("#toggleBtn img").click(function() {
        loadPage(1500);
    })

	// 검색하기 클릭시
	$('#getSearch').click(function(){
    	let shopName = $('#searchShop').val();    
    	$.ajax({
    		type:'post',
    		url:'searchShopName.do',
    		data: "shopName="+ shopName,
    		success: (list)=> {
    			$("#container").empty()
				for(let item of list){
					if(loginUserId == null) 
						$("#container").append(getShop_NoLogin(item));
					else $("#container").append(getShop_Login(item));

				}
				$(window).off('scroll')
				$('.decoration').css('display','none');
				$("#logo_slow").text('검색한 결과를 확인하세요!');
				$("#find_info").css('z-index',2);
				$("#logo_slow").css('z-index',-1);
    		},
			beforeSend : () => beforeSendWork(),
			complete : () => completeWork()
    	})
    });

	// 가게 로딩
	$("#container").on('click','.link',function() {
		location.href = `infoTemplate.html?category=shop&data=${$(this).attr('data-info')}`;
	})

	


	// --- function 정리 구간 --- //

	// 로딩 애니메이션 함수
    function loadPage(time) {
        $('.loader').css('z-index',12);
        $("#loadback").css('z-index',11);
        setTimeout(() => {
            $('.loader').css('z-index',-1);
            $("#loadback").css('z-index',-1);
        },time)
    }
         
	// 스크롤시 일부 데이터만 받아오는 함수
    function getPartData(idx,category) {
		let url_ = `/${category}/init/data`

		$.ajax({
			url  : url_,
			type : 'get',
			data : {"number" : idx},
			success : (result) => {
				for(let item of result) {
					if(category === 'bank')	// 은행일 경우
						$("#container").append(getBankContent(item));
					else if(loginUserId == null) // 가게 & 비로그인 경우
						$("#container").append(getShop_NoLogin(item));
					else $("#container").append(getShop_Login(item)); // 가게 & 로그인
				}
			},
			beforeSend : () => beforeSendWork(),
			complete : () => {
				completeWork()
				if(category === 'shop') // 가게일 경우 별점 추가
					setStarReview();
			}
		})
		// 카테고리에 맞는 아이템 idx 증가
		if(category === 'bank')
			bankIdx += 3;
		else shopIdx += 3;		
	}

	// ajax요청동안 실행되는 함수
    function beforeSendWork() {
		$('.loader').css('z-index',12);
		$("#loadback").css('z-index',11);										
		for(let i = 0 ; i < 3; i++)
			$("#container").append(loadContent);
	}

	// ajax요청 끝나면 실행되는 함수
	function completeWork() {
		setTimeout(() => {
			$('.loader').css('z-index',-1);
			$("#loadback").css('z-index',-1);
			$('.loading').remove()
		},2000)
	}

	// 모달 함수
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


	// 좋아요 처리 함수
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
		<div class ="container_item cursor" onclick = "location.href = '/infoTemplate.html?category=bank&data=${info.bankIdx}'">
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
		<div class ="container_item cursor">
			<div class="photo">
				<div class = "star" id = "shopStar${info.shopIdx}"></div>
				<img src = "${info.webAddress}">
			</div>
			<div class ="shopName link" data-info = "${info.shopIdx}">${info.shopName}</div>
			<div class ="shopOper">영업시간 : ${info.shopOper}</div>
			<div class ="shopWaiting">실시간 웨이팅 : ${data}</div>
		</div>`
	}

	// 로그인한 경우 가게 데이터 받기
	function getShop_Login(info) {
		let data = shopWaiting.get(info.shopIdx);		
		if(data === undefined) data = ++tempWaiting;

		let like = '♡';


		// 만약 찜한 가게일 경우
		for(let i = 0 ; i < likeList.length; i++) {
			if(likeList[i] == info.shopIdx) {
				like = '♥'
				break;
			}
		}

		return `
		<div class ="container_item cursor">
			<div class="photo">
				<div class = "star" id = "shopStar${info.shopIdx}">
					
					<div class = "like" id = "shopLike${info.shopIdx}" data-user = ${loginUserId}>${like}</div>
				</div>
				<img src = "${info.webAddress}">
			</div>
			<div class ="shopName link" data-info = "${info.shopIdx}">${info.shopName}</div>
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
					if(loginUserId === result[i].userId)
						likeList.push(result[i].shopIdx)
			},
			beforeSend : () => beforeSendWork(),
			complete : () => completeWork()
		})
	}

	// 가게 리뷰 받아오기
	async function getShopReview() {
		$.ajax({
			url  : '/shop/review',
			type : 'get',

			success : (result) => {
				for(let i = 0 ; i < result.length; i++)
					shopReview.push(result[i])
			}
		})
	}

	// 별점 세팅 함수
	async function setStarReview() {
		// 나중에 효율적으로 계산 알고리즘 짜기
		for(let i = 0 ; i < shopReview.length; i++) {
			let data = shopReview[i].shopIdx;
			let cnt = 1;
			let sum = shopReview[i].score;
			for(let j = i + 1; j < shopReview.length; j++) {
				if(data === shopReview[j].shopIdx) {
					sum += shopReview[j].score;
					cnt++;
				}
			}
			if(!$(`#shopStar${shopReview[i].shopIdx}`).hasClass('exist')) {
				$(`#shopStar${shopReview[i].shopIdx}`).prepend(`★${(sum / cnt).toFixed(1)}`)
				$(`#shopStar${shopReview[i].shopIdx}`).addClass('exist')
			}
		}
	}

	// 페이지 첫 로딩시 데이터 받아오기
	// 가게 좋아요, 웨이팅, 별점 받아오는 시작 함수
	async function initFunction() {
		// 가게 웨이팅
		await getAllShopWaiting();

		// 가게 좋아요 가져오기
		await getAllShopLike();

		// 음식점 리뷰 가져오기
		await getShopReview();
	}
})
