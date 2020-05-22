function wordGame(ls) {
	var Arr = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
	function randomsort(a, b) {
    return Math.random()>.5 ? -1 : 1;
    //用Math.random()函数生成0~1之间的随机数与0.5比较，返回-1或1
    }
	var Arr_copy = Arr.sort(randomsort);
	var i = 0;
	var grade=0;
	var Arr_user=[];
	var input_user;
	//Arr_copy=["1","2"];
	$('.ruleTitle').text('单字母任务，键盘上敲击对应字母')

//	var interval=setInterval(function() {
//		if(Arr.length==i){
//				clearInterval(interval);
//				$('.ruleTitle').text('单词任务，输入框内输入屏幕上对应的单词按“提交”完成签到...')
//				$('.div_terms').css('display','block');
//				termsGame();
//
//			}
////			var n = Math.floor(Math.random() * Arr.length);
////			if (n == -1 && Arr.length > 0) {
////				n = Math.floor(Math.random() * Arr.length);
////			}
////			var randWord = Arr[n];
//			var context = $(".context").text(Arr[i]);
////			Arr.splice($.inArray(randWord, Arr), 1);
//			$('.tip').css('display','none');
//			i=i+1;
//
//	    },3000)
        
         $(".context").text(Arr[i]);
         $("html").bind('keypress',fn1=function(e) {
         	 var content=$('.context').text();
         	 var inputs = String.fromCharCode(e.keyCode)
       
         		if(content==inputs){
         	    i=i+1;
         	    setTimeout(function(){
         	    	$(".context").text(Arr[i]);
                    $('.tip').css('display','none');
                    if(5==i){
			            $('.ruleTitle').text('单词任务，文本框内输入')
			            $('.div_terms').css('display','block');
			            $('.tip').css('display','none');
						$('html').unbind('keypress',fn1);
			            termsGame(ls);



		            }
         	    },1000)
         	    
         	 }
         	 
         })	
}




function keyCodeEvent(){
		var grade=0;
		$("body").bind('keypress', fn2=function(e) {
		var context = $(".context").text()
		var inputs = String.fromCharCode(e.keyCode)
		var context_Arr = context.split("")
		$('.div_wordGame').text(inputs)
		
        if(context.length>1){
        	return;
        }
		if (inputs.length <= context.length) {
			for (i = 0; i < inputs.length; i++) {
				if (context.charAt(i) != inputs.charAt(i)) {
					/*			 			var reg = new RegExp(""+context.charAt(i)+"","g");
								 			var b = $('.context').html().replace(reg,"<span id=\'erron_color'\ style=\'color:red;\'>"+context.charAt(i)+"</span>");
								 			$('.context').html(b);*/
					context_Arr[i] = "<span id='erron_color' style='color:red;'>" + context.charAt(i) + "</span>"
					var context_string = context_Arr.join("")
					$('.context').html(context_string)
					$('.tip').css('display','none');
				} else {
					context_Arr[i] = context.charAt(i)
					var context_string = context_Arr.join("")
					$('.context').html(context_string)
					$('.tip').css('display','block');
					/*grade=grade+5;*/
					$('.runtest').text(grade);
				}
			}
		}
	})
	}


function funs(){
	
}


