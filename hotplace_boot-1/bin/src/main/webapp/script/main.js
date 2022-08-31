$(function() {    
    let width = $(window).innerWidth();
    
    if(width < 800) {
        $("#topNavbar2").removeClass('top');
        $("#topNavbar2").addClass('bottom');
    } else {
        $("#topNavbar2").addClass('top');
        $("#topNavbar2").removeClass('bottom');
    }

    $("#itemContainer a").hover(function() {
        let id = $(this).attr('id');

        if(id == 1) {
            $(this).children('img').attr('src','img/bank2.png');
            $(this).children('span').css('color','rgb(251,159,182)');
        } else if(id == 2) {
            $(this).children('img').attr('src','img/restaurant2.png');
            $(this).children('span').css('color','rgb(251,159,182)');
        } else if(id == 3) {
            $(this).children('img').attr('src','img/eiffel-tower2.png');
            $(this).children('span').css('color','rgb(251,159,182)');
        }else if(id == 4) {
            $(this).children('img').attr('src','img/information2.png');
            $(this).children('span').css('color','rgb(251,159,182)');
        }
    },function() {
        let id = $(this).attr('id');

        if(id == 1) {
            $(this).children('img').attr('src','img/bank.png');
            $(this).children('span').css('color','black');
        } else if(id == 2) {
            $(this).children('img').attr('src','img/restaurant.png');
            $(this).children('span').css('color','black');
        } else if(id == 3) {
            $(this).children('img').attr('src','img/eiffel-tower.png');
            $(this).children('span').css('color','black');
        }else if(id == 4) {
            $(this).children('img').attr('src','img/information.png');
            $(this).children('span').css('color','black');
        }
    })

    $("#itemContainer a").click(function() {
        $("#itemContainer a").css('border-bottom','none');        
        $(this).css('border-bottom','2px solid black');
    })

    $("#switch").click(function() {
        let text =  $(this).text();
        if(text === '지도로 보기') {
            $(this).text('내용으로 보기')
            $("#map").css('z-index',2);
            $("#content").css('z-index',1);

            //test
            $("#map").css('top',"0")
            $("#content").css('top',"-100%")
        }else {
            $(this).text('지도로 보기')
            $("#map").css('z-index',1);
            $("#content").css('z-index',2);

            // test
            $("#map").css('top',"-100%")
            $("#content").css('top',"0")
        }
    })



    $(window).resize(function() {
        let width = $(window).innerWidth();
        
        if(width < 800) {
            $("#topNavbar2").removeClass('top');
            $("#topNavbar2").addClass('bottom');
        } else {
            $("#topNavbar2").addClass('top');
            $("#topNavbar2").removeClass('bottom');
        }
    })
})


