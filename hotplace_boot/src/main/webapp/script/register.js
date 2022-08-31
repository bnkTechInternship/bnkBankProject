$(function() {
    $(window).resize(function() {
        
    })

    const money = Math.floor(Math.random()*1001) * 1000;
    const point = Math.floor(Math.random()*1001) * 100;

    
    $('#money').val(money);
    $('#point').val(point);

    const moneystr = money.toString()
                .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
    const pointstr = point.toString()
                .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

    $('#modalmoney').html(moneystr+'&#8361;');
    $('#modalpoint').html(pointstr+'&#8361;');
    
    $('#register_button').click(function(){
    	 $('form').submit();
    });

    

})