var ques;
$(document).ready(function() {

			$(function() {
				var sr=0;
				var theTerms;
				var Queslist;
				getQues();
				if(ques!=null&&ques!=""){

					var str=ques[0].toString();
					var ls=str.split(',');
					var terms=[];
					for(i=1;i<ls.length;i++){
						terms.push(ls[i]);
					}
					theTerms=terms;
					// Queslist=ls[ls.length-1];
					if(ques[1]!=null&&ques[1]!=""){
						sr=ques[1];
					}
				}


				if (sr==0){
					alert("老师还没发布任务");
					$(window).attr('location','/');
				}

	             wordGame(theTerms);
	             keyCodeEvent();
                 inputOperation();
                 // essayEvent();
	             timer(sr);
	             sr = 0;
	             // func_submit();
            });
        })
function getQues() {
	$.ajax({
		async: false,
		type:"post",
		url: "/stuQues",
		contentType:"application/json",
		success:
			function(data){
			ques=data;
			},
		error:
			function(){

			}
	});
}