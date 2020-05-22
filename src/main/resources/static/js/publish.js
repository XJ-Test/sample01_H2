var app=new Vue({
	el:"#publish",
	data:{
		defaultTerm:['collection','fire','system','public','static'],
		defaultEssay:"You are Absolutely UniqueEnjoy that uniquenesss 1. You do not have to pretend in order to seem more like someone else. You do not have to lie to hide the parts of you that are not like what you see in anyone else.You were meant to be different. Nowhere, in all of history, will the same things be going on in anyone’s mind, soul and spirit as are going on in yours right now.",
	},
	methods:{
	}
})

var app=new Vue({
	el:"#TeaTimeConfig",
	data:{
		minute:[0],
		second:[0],
	},
	methods:{
		mHover:function(){
			this.minute=[0];
			for(i=1;i<60;i++){
				this.minute.push(i);
			}
		},
	}
})

$(document).ready(function(){
	$("#btn_publish").click(function(){
		var vote=$('input[name="select_radio"]').filter(':checked').val();
		var H=$('.H').val();
		var M=$('.M').val();
		var S=$('.S').val();
		var timeList=[H,M,S];
		if(vote==null||vote==""){
			alert('请选择测试内容!');
		}else{
			if (confirm("是否确认设置完毕，开始签到测试?") == true){
				$('#toPublish').attr('href','/teaSelectQues?quesTip='+vote+'&timeList='+timeList);
			}
		}
	})
})