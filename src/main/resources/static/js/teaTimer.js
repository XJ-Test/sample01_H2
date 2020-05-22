
var teaTimes;
var IP;
$(document).ready(function() {
			$(function() {
				 getTime();
				 // alert(teaTimes);
				if(teaTimes==null||teaTimes==""){
					teaTimes=100;
				}
	             Teatimer(teaTimes);
				 setIP(IP);
            });    
        })


function Teatimer(intDiff) {
		window.setInterval(function() {
			var day = 0,
				hour = 0,
				minute = 0,
				second = 0; //时间默认值
			if (intDiff > 0) {
				day = Math.floor(intDiff / (60 * 60 * 24));
				hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
				minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
				second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
			}
			if (intDiff == -1) {
				$(window).attr('location','/SelectAllGrade');
			}
			if (minute <= 9) minute = '0' + minute;
			if (second <= 9) second = '0' + second;
			$('#day_show').html(day + "天");
			$('#hour_show').html('<s id="h"></s>' + hour + '时');
			$('#minute_show').html('<s></s>' + minute + '分');
			$('#second_show').html('<s></s>' + second + '秒');
			intDiff--;
		}, 1000);
	}


function getTime() {
	$.ajax({
		async: false,
		type:"post",
		url: "/stuQues",
		contentType:"application/json",
		success:
			function(data){
			     teaTimes=data[1];
			     IP=data[2];
			},
		error:
			function(){

			}
	});
}

function setIP(IP) {
    $("#IP").html(""+IP);
}