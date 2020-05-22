function termsGame(ls){
	var Arr=['collection','fire','system','public','static'];

	if(ls!=null&&ls!=""){
		Arr=ls;
	}
	var cont = Arr.length;
		function randomsort(a, b) {
            return Math.random()>.5 ? -1 : 1;
            //用Math.random()函数生成0~1之间的随机数与0.5比较，返回-1或1
        }
	    Arr.sort(randomsort);
		var Arr_user=[];
		var i=0;
		var user_input;
		var grade_before=$('.runtest').text();
		var grade=parseInt(grade_before);
		$('.context').text(Arr[i]);

	$(document).keyup(function(event){
		if(event.keyCode ==13){
			user_input=$('.terms_input').val();
			Arr_user.push(user_input);
			if(user_input==Arr[i]){
				/*grade=grade+5;*/
				if(Arr[i].length>12){
					grade += 100/cont *compare1(Arr[i],user_input);
					alert(compare1(Arr[i],user_input))
					alert(100/cont)
				}else
					grade+=100/cont;
				$('.runtest').text(grade);
			}
			i=i+1;
			if(Arr.length>i){
				$('.context').text(Arr[i]);
				$('.terms_input').val("");

			}else{

				func_submit();
			}
		}
	});

		$('.nextButton').click(function(){
			user_input=$('.terms_input').val();
			Arr_user.push(user_input);
			if(user_input==Arr[i]){
					/*grade=grade+5;*/
					if(Arr[i].length>12){
						grade += 100/cont *compare1(Arr[i],user_input);
						alert(compare1(Arr[i],user_input))
						alert(100/cont)
					}else
						grade+=100/cont;
					$('.runtest').text(grade);
			}
			i=i+1;
			if(Arr.length>i){
				$('.context').text(Arr[i]);
				$('.terms_input').val("");

			}else{

				func_submit();
			}
		})
	}



function inputOperation(){
		$(".terms_input").bind('input propertychange', function() {
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


