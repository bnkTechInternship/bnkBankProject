$(function() {
    
    $('#login_button').click(function(){
        if($('#userId').val()=='')  {
              alert('Please enter user ID');
              $('#userId').focus();
        }
        else {
              $('form').submit();
        }
    })
    
    
    $('#notuserstartbtn').click(function(){
    	location.replace('main.html');
    });
})