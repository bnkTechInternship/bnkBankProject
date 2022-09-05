$(function(){

    $('#userinfo').css('display','block');

    $('#hotplace').click(function(){
        $('.selected').css('display','none');
        $('#hotplaceinfo').css('display','block');
    });

    $('#menu').click(function(){
        $('.selected').css('display','none');
        $('#menuinfo').css('display','block');

    });

    $('#bank').click(function(){
        $('.selected').css('display','none');
        $('#bankinfo').css('display','block');
    });
	
    $('#user').click(function(){
        $('.selected').css('display','none');
        $('#userinfo').css('display','block');
    });
    
    $('#search').click(function(){
		console.log("요청 전송")
    	let id = $('#id').val();
    	$.ajax({
    		type:'post',
    		url:'searchUser.do',
			data : {
				"userId" : id
			},    	    		
    		success:function(user){
				console.log("받아온 데이터 : ",user)
//    			let money = user.userBalance;
//    			if(money == null) money="연동 안함";
//    			
//    			let point = user.userPoint;
//    			if(point == null) point="연동 안함";
    			
    			$('#id').text('value', id);
//    			$('#id').attr('value',id);
    			$('#name').attr('value',user.userName);
    			$('#address1').attr('value',user.userAddress);
    			$('#address2').attr('value',user.userAddress);
    			$('#phone').attr('value',user.userNumber);
    			$('#email').attr('value',user.userEmail);
    			$('#money').attr('value',user.userBalance);
    			$('#point').attr('value',user.userPoint);
    			
    		}
    		
    	})
    });
    
    $('#btn1').click(function(){
        $.ajax({
            
        	type:'post',
        	url:'updateInfoForAdmin.do',
        	data:'userId='+$('#id').val()+
        			'&userName='+$('#name').val()+
        			'&userAddress='+$('#address1').val()+$('#address2').val()+
        			'&userNumber='+$('#phone').val()+
        			'&userEmail='+$('#email').val()+
        			'&userBalance=' + $('#money').val()+
        			'&userPoint=' + $('#point').val(),
        			
        			success:function(user){
        				
        			    $('#id').html('<p>' + user.userId+'</p>');
        			    $('#name').attr('value',user.userName);
            			$('#address1').attr('value',user.userAddress.substr(0,7));
            			$('#address2').attr('value',user.userAddress.substr(7));
            			$('#phone').attr('value',user.userNumber);
            			$('#email').attr('value',user.userEmail);
            			$('#money').attr('value',user.userBalance);
            			$('#point').attr('value',user.userPoint);
            			
					    Swal.fire(
							      '회원 정보 수정',
							      '정상적으로 수정되었어요',
							      'success'
							    )
        	}
        	
        });
    });
    
    $('#btn2').click(function(){
    	
    	let id = $('#id').val();
		Swal.fire({
			  title: '회원 삭제',
			  text: "이 회원을 정말 삭제할까요?",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'OK',
			}).then((result) => {
			  if (result.isConfirmed) {
			    $.ajax({
			    		type:'post',
			    		url:'deleteUser.do',
			    		data:"userId="+id,
			    		
			    		success:function(user){
						    Swal.fire(
								      '회원 삭제',
								      '정상적으로 삭제되었어요',
								      'success'
								    )
						
			    		}
			    	
			    });
			    location.replace('dba.html');

			  }
			})
    	
    });
    
    
    $('#searchBank').click(function(){
    	let id = $('#bank_idx').val();
    	console.log(id);
    	$.ajax({
    		type:'post',
    		url:'searchBank.do',
    		data:"bankIdx="+id,
    		
    		success:function(bank){
    			$('#bank_idx').text('value', id);
    			$('#bname').attr('value',bank.bankName);
    			//var idx = user.bankAddress.indexOf('구');
    			//console.log(idx);
     			$('#baddress1').attr('value',bank.bankAddress.substr(0,7));
    			$('#baddress2').attr('value',bank.bankAddress.substr(7));
    			$('#bphone').attr('value',bank.bankNumber);
    			$('#boper').attr('value',bank.bankOper);
    			$('#bwaiting').attr('value',bank.bankEnternum);
    			$('#blatitude').attr('value',bank.bankLat);
    			$('#blongitude').attr('value',bank.bankLong);
    			
    		}
    	})
    });
    

    $('#updateBank').click(function(){
    	let id = $('#bank_idx').val();
    	$.ajax({
        	type:'post',
        	url:'updateBankInfoForAdmin.do',
        	data:'bankIdx='+id+
        			'&bankName='+$('#bname').val()+
        			'&bankAddress='+$('#baddress1').val()+$('#baddress2').val()+
        			'&bankNumber='+$('#bphone').val()+
        			'&bankOper='+$('#boper').val()+
        			'&bankEnternum='+$('#bwaiting').val()+
        			'&bankLat=' + $('#blatitude').val()+
        			'&bankLong=' + $('#blongitude').val(),
        			success:function(bank){
        				
        				$('#bank_idx').text('value', id);
            			$('#bname').attr('value',bank.bankName);
             			$('#baddress1').attr('value',bank.bankAddress.substr(0,7));
            			$('#baddress2').attr('value',bank.bankAddress.substr(7));
            			$('#bphone').attr('value',bank.bankNumber);
            			$('#boper').attr('value',bank.bankOper);
            			$('#bwaiting').attr('value',bank.bankEnternum);
            			$('#blatitude').attr('value',bank.bankLat);
            			$('#blongitude').attr('value',bank.bankLong);
            			
					    Swal.fire(
							      '은행 정보 수정',
							      '정상적으로 수정되었어요',
							      'success'
							    )
        	}
        	
        });
    });
    
    
    $('#deleteBank').click(function(){
    	let id = $('#bank_idx').val();
		Swal.fire({
			  title: '은행 삭제',
			  text: "이 은행을 정말 삭제할까요?",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'OK',
			}).then((result) => {
			  if (result.isConfirmed) {
			    $.ajax({
			    		type:'post',
			    		url:'deleteBank.do',
			    		data:"BankIdx="+id,
			    		
			    		success:function(user){
						    Swal.fire(
								      '은행 삭제',
								      '정상적으로 삭제되었어요',
								      'success'
								    )
			    		}
			    	
			    });
			    location.replace('dba.html');
			  }
			})
    	
    });
    
    
    $('#searchShop').click(function(){
    	let id = $('#shop_idx').val();
    	$.ajax({
    		type:'post',
    		url:'searchShop.do',
    		data:"shopIdx="+id,
    		
    		success:function(shop){
    			$('#shop_idx').text('value', id);
    			$('#sname').attr('value',shop.shopName);
    			//var idx = user.shopAddress.indexOf('구');
    			//console.log(idx);
     			$('#saddress1').attr('value',shop.shopAddress.substr(0,8));
    			$('#saddress2').attr('value',shop.shopAddress.substr(8));
    			$('#sphone').attr('value',shop.shopNumber);
    			$('#soper').attr('value',shop.shopOper);
    			$('#swaiting').attr('value',shop.shopEnternum);
    			$('#slatitude').attr('value',shop.shopLat);
    			$('#slongitude').attr('value',shop.shopLong);
    			$('#scustomer').attr('value',shop.totalCnt);
    			$('#webaddr').attr('value',shop.webAddress);
    			
    		}
    	})
    })
    
    
    $('#deleteShop').click(function(){
    	let id = $('#shop_idx').val();
		Swal.fire({
			  title: '가게 삭제',
			  text: "이 가게를 정말 삭제할까요?",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'OK',
			}).then((result) => {
			  if (result.isConfirmed) {
			    $.ajax({
			    		type:'post',
			    		url:'deleteShop.do',
			    		data:"shopIdx="+id,
			    		
			    		success:function(user){
						    Swal.fire(
								      '가게 삭제',
								      '정상적으로 삭제되었어요',
								      'success'
								    )
			    		}
			    	
			    });
    			$('#shop_idx').text('value', "");
    			$('#sname').attr('value',"");
    			//var idx = user.shopAddress.indexOf('구');
    			//console.log(idx);
     			$('#saddress1').attr('value',"");
    			$('#saddress2').attr('value',"");
    			$('#sphone').attr('value',"");
    			$('#soper').attr('value',"");
    			$('#swaiting').attr('value',"");
    			$('#slatitude').attr('value',"");
    			$('#slongitude').attr('value',"");
    			$('#scustomer').attr('value',"");
    			$('#webaddr').attr('value',"");
			  }
			})
    	
    });
    
    $('#updateShop').click(function(){
    	let id = $('#shop_idx').val();
    	$.ajax({
        	type:'post',
        	url:'updateShopInfoForAdmin.do',
        	data:'shopIdx='+id+
        			'&shopName='+$('#sname').val()+
        			'&shopAddress='+$('#saddress1').val()+$('#saddress2').val()+
        			'&shopNumber='+$('#sphone').val()+
        			'&shopOper='+$('#soper').val()+
        			'&shopEnternum='+$('#swaiting').val()+
        			'&webAddress='+$('#webaddr').val()+
        			'&totalCnt='+$('#scustomer').val()+
        			'&shopLat=' + $('#slatitude').val()+
        			'&shopLong=' + $('#slongitude').val(),
        			
        			success:function(shop){
        				
        				$('#shop_idx').text('value', id);
            			$('#sname').attr('value',shop.shopName);
            			//var idx = user.shopAddress.indexOf('구');
            			//console.log(idx);
             			$('#saddress1').attr('value',shop.shopAddress.substr(0,8));
            			$('#saddress2').attr('value',shop.shopAddress.substr(8));
            			$('#sphone').attr('value',shop.shopNumber);
            			$('#soper').attr('value',shop.shopOper);
            			$('#swaiting').attr('value',shop.shopEnternum);
            			$('#slatitude').attr('value',shop.shopLat);
            			$('#slongitude').attr('value',shop.shopLong);
            			$('#scustomer').attr('value',shop.totalCnt);
            			$('#webaddr').attr('value',shop.webAddress);
            			
					    Swal.fire(
							      '가게 정보 수정',
							      '정상적으로 수정되었어요',
							      'success'
							    )
        	}
        	
        });
    	
    	
    });
    
    
    
    
    $('#searchMenu').click(function(){
    	let id = $('#menu_idx').val();
    	$.ajax({
    		type:'post',
    		url:'searchMenu.do',
    		data:"menuIdx="+id,
/*    				"shopIdx="+ $('#shop_idx').val(),
    				"menuName="+ $('#menu_name').val(),
    				"menuPrice="+ $('#menu_price').val(),*/
    				
    		
    		success:function(menu){
    			$('#menu_idx').attr('value',menu.menuIdx);
    			$('#shop_idx2').attr('value',menu.shopIdx);
    			$('#menu_name').attr('value',menu.menuName);
    			$('#menu_price').attr('value',menu.menuPrice);
    		}

    });
    });
    
    
    
    
    $('#deleteMenu').click(function(){
    	let id = $('#menu_idx').val();
		Swal.fire({
			  title: '메뉴 삭제',
			  text: "이 메뉴를 정말 삭제할까요?",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'OK',
			}).then((result) => {
			  if (result.isConfirmed) {
			    $.ajax({
			    		type:'post',
			    		url:'deleteMenu.do',
			    		data:"menuIdx="+id,
			    		
			    		success:function(user){
						    Swal.fire(
								      '메뉴 삭제',
								      '정상적으로 삭제되었어요',
								      'success'
								    )
						    $('#menu_idx').attr('value',"");
			    			$('#shop_idx2').attr('value',"");
			    			$('#menu_name').attr('value',"");
			    			$('#menu_price').attr('value',"");
			    		}
			    });
			    
			  }
			})
    	
    });
    
    
    $('#updateMenu').click(function(){
    	let id = $('#menu_idx').val();
    	$.ajax({
        	type:'post',
        	url:'updateMenuInfoForAdmin.do',
        	data:"menuIdx="+id+
        		"&shopIdx="+ $('#shop_idx2').val()+
        		"&menuName="+ $('#menu_name').val()+
        		"&menuPrice="+$('#menu_price').val(),
        			
        	success:function(shop){
			    Swal.fire(
					      '가게 정보 수정',
					      '정상적으로 수정되었어요',
					      'success'
					    )
        	}
        	
        });
    	
    	
    });
    
    
    	

    
    

    
});