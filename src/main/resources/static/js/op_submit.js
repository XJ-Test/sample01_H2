        	function func_submit(){

                $(document).keyup(function(event){
                    if(event.keyCode ==13){
                        if (confirm("是否确认提交?") == true){
                            func_endBt();
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
                    }
                });

        		$('.nextButton').click(function () {

            	if (confirm("是否确认提交?") == true){
            		func_endBt();
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

              });
        	}
        	

function func_endBt(){
	var grade=$('.runtest').text();
	grade=parseInt(grade);
	var content=$('.context').text();
	var inputs=$('.input').val();
	var grade_essay=compare1(content,inputs);
	grade_essay=parseInt(grade_essay);
    grade=grade+grade_essay
    
    $('.runtest').text(grade);
	$('.testGrade').css('display', 'block');
	$('.input').attr("readonly", "true");
	$('.hidden').css('display', 'block');
	$('.li_tip').text('系统已提交内容...');
	$('.li_rateTrue').text('正确率：');
	$('.li_rateBat').text('平均速度：');
	$('.li_grade').text('最终成绩：'+grade);
}




function compare1(x, y) {

        var z = 0;

        console.log(typeof x);

        //判断是否为字符串

        if(typeof x == "string"){

        x=x.split("");

        y=y.split("");

        }

        var s = x.length + y.length;;

        x.sort();

        y.sort();

        var a = x.shift();

        var b = y.shift();

        while(a !== undefined && b !== undefined) {

            if (a === b) {

                z++;

                a = x.shift();

                b = y.shift();

            } else if (a < b) {

                a = x.shift();

            } else if (a > b) {

                b = y.shift();

            }

        }

        return z/s *2;

    }


