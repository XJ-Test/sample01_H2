function login_submit(){
    $('.form_login').attr('method','post');
    $('.form_login').attr('action','/stuLogin');

}

$(document).ready(function() {
	$('.btn_login').click(function () {
			$(function() {
	            login_submit();     
            });
	})

})

    