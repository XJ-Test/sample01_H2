function essayGame(ls){
	var contents='You are Absolutely UniqueEnjoy that uniquenesss1. You do not have to pretend in order to seem more like someone else. You do not have to lie to hide the parts of you that are not like what you see in anyone else.You were meant to be different. Nowhere, in all of history, will the same things be going on in anyone’s mind, soul and spirit as are going on in yours right now.'
	if(ls!=null&&ls!=""){
		contents=ls;
	}

		
		$('.context').text(contents);
		$('.context').css('font-size','20px');
//		$('.btn_submit').click(function(){
//			if (confirm("是否确认提交?") == true){
//				
//				alert("签到完毕!");
//			}
//		})
	}



function essayEvent(){
		$(".input").bind('input propertychange', function() {
		var context = $(".context").text()
		var inputs = $(this).val()
		var context_Arr = context.split("")

		if (inputs.length <= context.length) {
			for (i = 0; i < inputs.length; i++) {
				if (context.charAt(i) != inputs.charAt(i)) {
					/*			 			var reg = new RegExp(""+context.charAt(i)+"","g");
								 			var b = $('.context').html().replace(reg,"<span id=\'erron_color'\ style=\'color:red;\'>"+context.charAt(i)+"</span>");
								 			$('.context').html(b);*/
					context_Arr[i] = "<span id='erron_color' style='color:red;'>" + context.charAt(i) + "</span>"
					var context_string = context_Arr.join("")
					$('.context').html(context_string)
				} else {
					context_Arr[i] = context.charAt(i)
					var context_string = context_Arr.join("")
					$('.context').html(context_string)
				}
			}
		}
	})		
	}




