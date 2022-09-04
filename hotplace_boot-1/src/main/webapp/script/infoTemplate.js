let url = location.href.split('?')[1].split('&')
let category_ = url[0].split('=')
let idx_ = url[1].split('=')
let shopReview = []
const user = localStorage.getItem('loginUser');


$(function() {
    // test code
	// localStorage.setItem('loginUser','user01');

    $("#imgDiv").on('click','#jjim',function() {
        let condition = $(this).text();


        if(condition == '찜 취소하기') {
            showSwal(idx_[1],false,user)
        } else showSwal(idx_[1],true,user)        
    })


    initFunction();

    if(category_[1] === 'bank')  {
        $("#imgDiv").css('background-image',`url(../img2/BNK.jpg)`)
        $("#bgPhoto").attr('src','img2/BNK.jpg')        
        console.log($("#imgDiv").css('background-image'))
    }
        
    else {
        photo = ['../img2/wallpaper9.jpg','../img2/wallpaper1.jpg','../img2/wallpaper2.jpg']
        let idx = 0;
        setInterval(() => {
            $("#imgDiv").css('background-image',`url(${photo[parseInt((++idx)%3)]})`);
        },5000)    
    }

    // 페이지 로딩시 애니메이션 세팅
    setTimeout(() => {
        $('.start').addClass('active')
    },1000)

})

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
            console.log(result)
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
    let appendData;

    // review != undefined는 리뷰가 있다는 말로 가게에 해당
    if(review != undefined) {
        let jjimInfo = await getAllShopLike();
        appendData = await getInfoTag(jjimInfo,marketInfo,review)

    
        // 메뉴 생성
        await addMenuList(marketInfo);
        
        // 리뷰 생성
        await addReviewList();

        // 그래프 생성
        await addGraph();
    }
    else { //은행일 경우 은행에 맞는 정보로 세팅

    }
    

    $('#imgDiv').prepend(appendData)
}

// 가게 인포 제작 함수
async function getInfoTag(jjimInfo,marketInfo,review) {
    console.log(marketInfo)
    let star = ''
    let jjim = '찜 하기'
    
    console.log("찜 상태 값 : ",jjimInfo)
    if(jjimInfo === 1) {
        jjim = '찜 취소하기'
        console.log("해당 유저는 찜한 상태입니다.")
    } else if(jjimInfo === 0) {
        console.log("찜 안한 상태")
    } else {
        console.log("비로그인 상태")
    }
        
    

    for(let i = 0 ; i < parseInt(review); i++)
        star += '★'
    
    return `
    <div id="restaurant_info" class="disappear init start">
        <div id="name" class="center">${marketInfo.shopName}</div>
        <div id="review" class="center"><span>${star}</span>${review}</div>
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
    console.log('allMenu : ',allMenu)
    for(let i = 0 ; i < allMenu.length; i++) {
        menu += `
        <div class="menu_item">
            <div class="menu_item_tape"></div>
            <div class="menu_info">
                <div class="menu_name" value = "${allMenu[i].menuIdx}">${allMenu[i].menuName}</div>
                <div class = "menu_size" data-price = ${allMenu[i].menuPrice}>- 소 : ${allMenu[i].menuPrice}</div>
                <div class = "menu_size" data-price = ${allMenu[i].menuPrice * 2}>- 대 : ${allMenu[i].menuPrice * 2}</div>
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

async function addReviewItem() {
    let cnt = 1;
    let gender = ['img2/man.png','img2/woman.png']
    console.log("addReview Item에서 사용하는 리뷰 : ",shopReview)

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
            if(user == null)
                resolve(-1);
            
            for(let i = 0 ; i < result.length; i++) {            
                // 찜을 한 가게일 경우
                if(result[i].userId === user && result[i].shopIdx == idx_[1]) 
                    resolve(1);
            }
            // 찜 안한 가게일 경우
            resolve(0);
        },        
    })
})


// 찜 설정
function showSwal(shopId,flag,userId) {
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
    console.log("오냐1")

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
          console.log("누렀따.")
          likeFunction(url,shopId,userId)
        }
      })
}

function likeFunction(url_,shopId,userId) {
    console.log(url_)
    console.log(shopId)
    console.log(userId)

    $.ajax({
        url  : url_,
        type : 'get',
        data : "shopIdx="+shopId+"&userId="+userId,

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
            else $("#jjim").text('찜 하기');
        }
    })
}