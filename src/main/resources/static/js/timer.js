function timer(intDiff) {
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
				func_endBt();
				func_endTo();
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

function func_end(){
	$('.testGrade').css('display', 'block');
	$('.input').attr("readonly", "true");
	$('.hidden').css('display', 'block');
	$('.li_tip').text('时间到了！系统已提交内容...');
	$('.li_rateTrue').text('正确率：');
	$('.li_rateBat').text('平均速度：');
	$('.li_grade').text('最终成绩：');
}

function func_endTo() {
	var stuID=$('.stuID_info').text();
	var stuName=$('.stuName_info').text();
	var grade_final=$('.runtest').text();
	var grades=parseInt(grade_final);
	var adata={
		"stuName":stuName,
		"stuID":stuID,
		"grade":grades
	}
	var data=JSON.stringify(adata);
	$.ajax({
		type:"post",
		url: "stu",
		contentType:"application/json",
		data: data,
		success:
			function(){

			},
		error:
			function(){

			}
	});
}
