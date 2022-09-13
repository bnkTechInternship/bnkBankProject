// 받은 url
let url = location.href.split('?')[1].split('&')

// shop or bank 구분
let category_ = url[0].split('=')

// shop or bank 고유 idx
let idx_ = url[1].split('=')

// 가게 리뷰
let shopReview = []

// test code
const user = localStorage.getItem('loginUser');
let loginUserId  = null;
    

$(function() {
    const reg = (/[\{\'\"}]/g);
    if(user != null) 
        loginUserId = user.replace(reg,'').split(',')[0].split(':')[1]

    // 찜하기 or 찜 취소하기 클릭
    $("#imgDiv").on('click','#jjim',function() {
        let condition = $(this).text();

        // 비로그인시
        if(loginUserId == null) {
            loginPopup()
            return;
        }

        // 가게 찜 취소하기
        if(condition == '찜 취소하기') 
            showSwal(idx_[1],1,loginUserId)
        // 가게 찜 하기
        else if (condition === '찜 하기') 
            showSwal(idx_[1],2,loginUserId)        
        // 은행 예약하기
        else showSwal(idx_[1],3,loginUserId)     

    })

    // 페이지 구성을 위한 함수
    initFunction();

    // 사진 교환을 위한 변수
    let idx = 0;
    let divNum = 3;

    if(category_[1] === 'bank')  {
        photo = [`../img2/bank3.jpg`,`../img2/BNK.jpg`];
        $("#imgDiv").css('background-image',`url(../img2/bank3.jpg)`)        
        divNum = 2;
    }
    else  photo = ['../img2/wallpaper10.jpg','../img2/wallpaper8.jpg','../img2/wallpaper1.jpg']        

    // 사진 변경
    setInterval(() => {
        $("#imgDiv").css('background-image',`url(${photo[parseInt((idx++)%divNum)]})`);
    },8000)    

    // 페이지 로딩시 애니메이션 세팅
    setTimeout(() => { $('.start').addClass('active') },1000)
})

// 페이지 구성을 위한 함수
async function initFunction() {

    // 은행 또는 가게 정보 받아오기
    let marketInfo = await getShopData()
    let marketReview = undefined;

    // 카테고리가 가게일 경우 리뷰 가져오기
    if(category_[1] === 'shop')
        marketReview = await getShopReview(marketInfo);    

    // 데이터 세팅
    await setData(marketInfo,marketReview);  
}

// 은행 또는 가게 정보 받아오기
let getShopData = async() => new Promise((resolve,reject) => {
    $.ajax({
        url  : '/getDetail',
        type : 'post',
        data : {
            category : category_[1],
            idx : idx_[1],
        },
        success : (result) => {
            resolve(result)            
        }
    })
})

// 가게 리뷰 받기
let getShopReview = async(marketInfo) => new Promise((resolve,reject) => {
    $.ajax({
        url : '/info/getShopReview',
        type : 'get',
        data : { shopIdx : idx_[1] },
        success : (result) => {
            let sum = 0;
            for(let i = 0 ; i < result.length; i++) {
                shopReview.push(result[i]);
                sum += result[i].score;            
            }
            resolve(sum/result.length);
        }
    })
})

// 데이터 세팅
async function setData(marketInfo,review) {
    let appendData; // 정보 설몀 태그로 가게 또는 은행에 따라 변경됨.

    // review != undefined는 리뷰가 있다는 말로 가게에 해당
    if(review != undefined) {
         // 가게 좋아요 세팅
        let jjimInfo = await getAllShopLike();

        // 가게에 맞는 데이터 받기
        appendData = await getShopInfoTag(jjimInfo,marketInfo,review) 
    
        // 메뉴 생성
        await addMenuList(marketInfo);
        
        // 리뷰 생성
        await addReviewList();

        // 그래프 생성
        await addGraph();
    }
    //은행일 경우 은행에 맞는 정보로 세팅
    else { 
        // 은행에 맞는 데이터 받기
        appendData = await getBankInfoTag(marketInfo);

        // 은행의 경우 지도, footer 추가
        await bankSetting(marketInfo);
    }
    $('#imgDiv').prepend(appendData)
}

// 가게 인포 제작 함수
async function getShopInfoTag(jjimInfo,marketInfo,review) {
    let star = ''
    let jjim = '찜 하기'
    
    if(jjimInfo === 1)
        jjim = '찜 취소하기'

    for(let i = 0 ; i < parseInt(review); i++)
        star += '★'
    
    return `
    <div id="restaurant_info" class="disappear init start">
        <div id="name" class="center">${marketInfo.shopName}</div>
        <div id="review" class="center"><span>${star}</span>${review.toFixed(1)}</div>
        <div class="center">${marketInfo.shopAddress}</div>
        <div class = "center small">전화번호 : ${marketInfo.shopNumber}</div>
        <div class = "center small">운영 시간 : ${marketInfo.shopOper}</div>
        <div id="info_menu">
            <div id="jjim" >${jjim}</div>
        </div>
    </div>
    `;
}

// 메뉴판, 메뉴아이템 모두 추가하는 함수
async function addMenuList(marketInfo) {
    let content_two = `
    <div id="content_two" class="up">
        <div id="content_two_menu">
            <div id="menu_title">- 메뉴판 -</div>
        </div>
    </div>
    `;

    $("#content_two").append(content_two)

    // 여기서 ajax로 menu받아와서 값 넣기
    let allMenu = await getMenu(marketInfo);
    await addMenu(allMenu);
}

// 비동기 통신으로 모든 메뉴 가져오기
let getMenu = async(marketInfo) => new Promise((resolve,reject) => {
    $.ajax({
        url  : "/info/getAllMenu",
        type : 'get',
        data : {
            shopIdx : marketInfo.shopIdx,
        },
        success : (result) => {
            resolve(result);
        }
    })
})

// 메뉴판에 메뉴 추가하기
async function addMenu(allMenu) {
    let menu = '';
    for(let i = 0 ; i < allMenu.length; i++) {
        menu += `
        <div class="menu_item">
            <div class="menu_item_tape"></div>
            <div class="menu_info">
                <div class="menu_name" value = "${allMenu[i].menuIdx}">${allMenu[i].menuName}</div>
                <div class = "menu_size" data-price = ${allMenu[i].menuPrice}> ₩ : ${allMenu[i].menuPrice}</div>                
                <div class = "menu_desc">부드러운 감자 샐러드와 베이컨의 환상조합</div>
                <div class = "menu_ingredient">국내산 : 감자, 풀때기</div>
                <div class = "menu_ingredient">호주산 : 베이컨, 새우</div>
            </div>
            <div class="menu_item_img">
                <img src="img2/wallpaper${i+1}.jpg" id = "bgPhoto">
            </div>
        </div>
        `
    }
    $("#content_two_menu").append(menu)
}

// 리뷰 리스트 추가
async function addReviewList() {
    let content_one = `
    <div id="content_one" class = "up">
        <div id="review_title">
            <img src = "img2/reviews.png">
        </div>
        <div id="review_list">
            <div class="review_list_container" id = "review_list_container1">
            </div>
            <div class="review_list_container" id = "review_list_container2">
            </div>
        </div>
    </div>
    `
    // 리뷰 리스트 content에 붙이기
    await $("#content").append(content_one);
    // 리뷰 내용 붙이기
    await addReviewItem();
}

// 리뷰 내용 추가 함수
async function addReviewItem() {
    let gender = ['img2/man.png','img2/woman.png']

    for(let i = 0 ; i < shopReview.length; i++) {
        let reviewItem = `
        <div class="review man" >
            <p class="bubble speech2" >${shopReview[i].comm}</p>
            <div class="userInfo info_right">
                <div class="nameNstar_left">
                    <div>${shopReview[i].userId}</div>
                    <div>리뷰 평점 : ${shopReview[i].score}</div>
                </div>
                <img src = "${gender[i%2]}" style="width: 50px; height: 50px;">
            </div>
        </div>                
        `
        $(`#review_list_container${parseInt(i/2) + 1}`).append(reviewItem);
    }
}

// 그래프 추가 함수
async function addGraph() {
    let graphTag = `
    <div id = "graph" class = "up">
        <canvas id="myChart1" style="min-width: 200px; max-height : 500px; max-width: 100%;"></canvas>
    </div>
    `;
    $("#content").append(graphTag);
    makeChart1();
}

// 가게 좋아요 모두 받아오기
let getAllShopLike = async() => new Promise((resolve,reject) => {
    $.ajax({
        url : '/shop/allLike',
        type : 'get',
        success : (result) => {    
            // 비로그인시 -1
            if(loginUserId == null)
                resolve(-1);
            for(let i = 0 ; i < result.length; i++) {   
                // 찜을 한 가게일 경우
                if(result[i].userId === loginUserId && result[i].shopIdx == idx_[1]) 
                    resolve(1);
            }
            // 찜 안한 가게일 경우
            resolve(0);
        },        
    })
})


// 찜 설정
function showSwal(shopId,flag,userId) {
    //flag : 1 => 찜 삭제
    let title_ = "찜 등록";
    let text_ = "이 가게를 찜 리스트에 추가할까요?";
    let desc_ = "정상적으로 추가되었습니다!";
    let url = "likeShop.do";

    if(flag == 1) {
        title_ = "찜 삭제";
        text_ = "이 가게를 찜 리스트에서 제거할까요?";
        desc_ = "찜이 삭제되었습니다!";
        url = "unlikeShop.do"
    } else if(flag == 3) {
        title_ = "대기표 예약"
        text_ = "은행 대기표를 예약하시겠습니까?";
        desc_ = "대기표가 예약되었습니다.";
        url = "bankReserve.do"
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
          setJjim(url,shopId,userId,flag)
        }
      })
}

// 찜하기 함수
function setJjim(url_,shopId,userId,flag) {
    // 가게일 경우
    let data_ = `shopIdx=${shopId}&userId=${userId}`

    // 은행일 경우 전송하는 데이터 변경
    if(flag == 3)
        data_ = `bankIdx=${shopId}&userId=${userId}`

    $.ajax({
        url  : url_,
        type : 'get',
        data : data_,

        success : (result) => {
            if($("#jjim").text() === '찜 하기') {
                $("#jjim").text('찜 취소하기')
                $("#heart_beat").css('z-index','5');
                $("#heart_beat").css('opacity','1');
    
                setTimeout(() => {
                    $("#heart_beat").css('z-index','-1');
                    $("#heart_beat").css('opacity','0');
                },2000)
            }
            else if($("#jjim").text() === '찜 취소하기')
                $("#jjim").text('찜 하기');    
                  
            if(flag == 3)
                setTimeout(() => { location.href = `/reserve.html`; },2000)          
        }
    })
}

// 은행에 맞는 info태그 생성
async function getBankInfoTag(marketInfo) {
    return `
    <div id="restaurant_info" class="disappear init start">
        <div id="name" class="center">${marketInfo.bankName}</div>
        <div class="center">은행 주소 : ${marketInfo.bankAddress}</div>
        <div class = "center small">전화번호 : ${marketInfo.bankNumber}</div>
        <div class = "center small">운영 시간 : ${marketInfo.bankOper}</div>
        <div id="info_menu">
            <div id="jjim" >대기표 예약하기</div>
        </div>
    </div>
    `;
}

// 은행에 맞게 페이지 세팅
async function bankSetting(marketInfo) {
    $("#note").remove();
    addMap(marketInfo);
}

// 지도 추가, footer추가
function addMap(marketInfo) {
    let mapTag = `
        <div id = "mapContainer" class = "up">
            <div id = "mapInfo">은행 위치</div>
            <div id = "map">
            </div>
        </div>
    `
    $('body').append(mapTag);
    createMap(marketInfo);
    addFooter();
}

// 지도 추가 함수
function createMap(marketInfo) {
    var mapContainer = document.getElementById('map'),
    mapOption = { 
        center: new kakao.maps.LatLng(marketInfo.bankLat, marketInfo.bankLong), 
        level: 3 // 지도의 확대 레벨
    };

    var map = new kakao.maps.Map(mapContainer, mapOption); 
    var markerPosition  = new kakao.maps.LatLng(marketInfo.bankLat, marketInfo.bankLong); 
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    marker.setMap(map);
}

// footer추가
function addFooter() {
    let data =  `
    <footer class="footer-07">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12 text-center">
                    <h2 class="footer-heading"><a href="#" class="logo">BNK_HOT_PLACE</a></h2>
                    <p class="menu">
                        <a href="#">Home</a>
                        <a href="#">Agent</a>
                        <a href="#">About</a>
                        <a href="#">Listing</a>
                        <a href="#">My</a>
                        <a href="#">Contact</a>
                    </p>
                    <ul class="ftco-footer-social p-0">
                        <li class="ftco-animate"><a href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><span class="ion-logo-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><span class="ion-logo-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#" data-toggle="tooltip" data-placement="top" title="Instagram"><span class="ion-logo-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-md-12 text-center">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>
            </div>
        </div>
    </footer>        
    `
    $('body').append(data);
}

// 비로그인 팝업
function loginPopup() {
    Swal.fire({
        icon: 'error',
        title: '회원전용 기능입니다.',
        text: '로그인을 해주세요',
        footer: '<a href="login.html">로그인 하러가기</a>'
    })
}