$(function() {
    
    $('#fromspring').click(function(){
    	
	        $.ajax({
	        	type:'post',
	        	url:'test.do',
	    
	        	success:function(result){
	        		
	        		$('div').html(result)
	        			
        	}
        
        })//ajax
    })
    
    
    $('#tospring').click(function(){
    	
    	$.ajax({
    		type: 'post',
    		url: 'test2.do',
    		data:{
    			'hi':'hello'
    		},
    		
    		success:function(result){
    			
    			$('div').html(result)
    			
    		}
    			
    	})
    	
    })
    
})