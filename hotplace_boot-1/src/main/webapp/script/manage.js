$(function() {

	const user = JSON.parse(localStorage.getItem('loginUser'));
	let userName = user.userName;
	let shop = "";

	$('#userName').append('<h2>' + userName + '</h2>');

	let url = location.href;
	let shopIdx = (url.slice(url.indexOf('=') + 1, url.length));
	$.ajax({
		type : 'get',
		url : 'shopName.do',
		data : "shopIdx=" + shopIdx,
		
		success : function(shop) {
			$('#shopName').append('<h2>' + shop.shopName + '</h2>');
			$('#enternum').append('<h1>현재 '+shop.shopEnternum+'번 입장</h1>');
			$('.shopImg').append('<img src='+shop.webAddress+'>');
			
		}// success
		
	})// ajax
	$('.entrance').click(function() {
		
		let url = location.href;
		let shopIdx = (url.slice(url.indexOf('=') + 1, url.length));
		console.log(shop);
		$.ajax({
			type : 'get',
			url : 'updateEnter.do',
			data : "shopIdx="+shopIdx,

			success : function(result) {
				location.href = url;
			}
		}) //ajax
	})

})