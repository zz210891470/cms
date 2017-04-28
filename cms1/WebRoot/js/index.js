// JavaScript Document
function change_news(id){
	if(id==1){
		document.getElementById("index_n").className="index_newslist1";
		document.getElementById("index_new").className="index_new";
		document.getElementById("index_notice").className="index_notice";
		document.getElementById("index_new_list").style.display="";
		document.getElementById("index_notice_list").style.display="none";
		document.getElementById("index_new_more").style.display="";
		document.getElementById("index_notice_more").style.display="none";
		}
	else{
		document.getElementById("index_n").className="index_newslist1_1";
		document.getElementById("index_new").className="index_new1";
		document.getElementById("index_notice").className="index_notice1";
		document.getElementById("index_new_list").style.display="none";
		document.getElementById("index_notice_list").style.display="";
		document.getElementById("index_new_more").style.display="none";
		document.getElementById("index_notice_more").style.display="";
		}
	}
function change(str1,str2,str3,str4,str5,str6){
	document.getElementById(str1).className=str2;
	document.getElementById(str3).style.display="";
	document.getElementById(str4).style.display="none";
	document.getElementById(str5).className="xxgk_bt1";
	document.getElementById(str6).className="xxgk_bt2";
}
function change1(str1,str2,str3,str4,str5,str6,str7,str8){
	document.getElementById(str1).className=str2;
	document.getElementById(str3).style.display="";
	document.getElementById(str4).style.display="none";
	document.getElementById(str5).style.display="none";
	document.getElementById(str6).className="xxgk_bt1";
	document.getElementById(str7).className="xxgk_bt2";
	document.getElementById(str8).className="xxgk_bt2";
}

function change2(str1){
	if(str1=='tzhj'){
		$("#tzhj").addClass("li_lmbt");
		$("#yhzc").removeClass("li_lmbt");
		$("#zsxm").removeClass("li_lmbt");
		$("#xmjs_list9").css("display","block");
		$("#xmjs_list8").css("display","none");
		$("#xmjs_list10").css("display","none");
	}else if(str1=='zsxm'){
		$("#tzhj").removeClass("li_lmbt");
		$("#yhzc").removeClass("li_lmbt");
		$("#zsxm").addClass("li_lmbt");
		$("#xmjs_list9").css("display","none");
		$("#xmjs_list8").css("display","block");
		$("#xmjs_list10").css("display","none");

	}else{
		$("#tzhj").removeClass("li_lmbt");
		$("#yhzc").addClass("li_lmbt");
		$("#zsxm").removeClass("li_lmbt");
		$("#xmjs_list9").css("display","none");
		$("#xmjs_list8").css("display","none");
		$("#xmjs_list10").css("display","block");
		
		
		
	}
	
	
}


function change3(str){
	if(str=='wjtz'){
		$("#wjtz").addClass("li_lmbt");
		$("#zcfg").removeClass("li_lmbt");
		$("#jgdj").removeClass("li_lmbt");
		$("#xnjs").removeClass("li_lmbt");
		$("#xxgk_list1").css("display","block");
		$("#xxgk_list2").css("display","none");
		$("#xxgk_list3").css("display","none");
		$("#xxgk_list4").css("display","none");
	
	}else if(str=='zcfg'){
		$("#wjtz").removeClass("li_lmbt");
		$("#zcfg").addClass("li_lmbt");
		$("#jgdj").removeClass("li_lmbt");
		$("#xnjs").removeClass("li_lmbt");
		$("#xxgk_list1").css("display","none");
		$("#xxgk_list2").css("display","block");
		$("#xxgk_list3").css("display","none");
		$("#xxgk_list4").css("display","none");
		
	}else if(str=='jgdj'){
		$("#wjtz").removeClass("li_lmbt");
		$("#zcfg").removeClass("li_lmbt");
		$("#jgdj").addClass("li_lmbt");
		$("#xnjs").removeClass("li_lmbt");
		$("#xxgk_list1").css("display","none");
		$("#xxgk_list2").css("display","none");
		$("#xxgk_list3").css("display","block");
		$("#xxgk_list4").css("display","none");
		
	}else{
		$("#wjtz").removeClass("li_lmbt");
		$("#zcfg").removeClass("li_lmbt");
		$("#jgdj").removeClass("li_lmbt");
		$("#xnjs").addClass("li_lmbt");
		$("#xxgk_list1").css("display","none");
		$("#xxgk_list2").css("display","none");
		$("#xxgk_list3").css("display","none");
		$("#xxgk_list4").css("display","block");
		
	}

}

function change4(str){
	     if(str=='xmcb'){
	    $("#xmcb").addClass("li_lmbt");
		$("#xmsh").removeClass("li_lmbt");
		$("#cbxm").removeClass("li_lmbt");
		$("#xmcb_list1").css("display","block");
		$("#xmcb_list2").css("display","none");
		$("#xmcb_list3").css("display","none");
		
	    	 
	     }else if(str=='xmsh'){
	    	 
	    $("#xmcb").removeClass("li_lmbt");
		$("#xmsh").addClass("li_lmbt");
		$("#cbxm").removeClass("li_lmbt");
		$("#xmcb_list1").css("display","none");
		$("#xmcb_list2").css("display","block");
		$("#xmcb_list3").css("display","none");
	    	 	 
	     }else{
	    $("#xmcb").removeClass("li_lmbt");
		$("#xmsh").removeClass("li_lmbt");
		$("#cbxm").addClass("li_lmbt");
		$("#xmcb_list1").css("display","none");
		$("#xmcb_list2").css("display","none");
		$("#xmcb_list3").css("display","block");
	    	 
	     }
		

}

function change5(str){
	     if(str=='xmzj'){
	    $("#xmzj").addClass("li_lmbt");
		$("#xmsb").removeClass("li_lmbt");
		$("#xmcs").removeClass("li_lmbt");
		$("#zjps").removeClass("li_lmbt"); 
	    $("#xmzj_list1").css("display","block");
		$("#xmzj_list2").css("display","none");
		$("#xmzj_list3").css("display","none");
		$("#xmzj_list4").css("display","none");

	     }else if(str=='xmsb'){
	    $("#xmzj").removeClass("li_lmbt");
		$("#xmsb").addClass("li_lmbt");
		$("#xmcs").removeClass("li_lmbt");
		$("#zjps").removeClass("li_lmbt"); 
		$("#xmzj_list1").css("display","none");
		$("#xmzj_list2").css("display","block");
		$("#xmzj_list3").css("display","none");
		$("#xmzj_list4").css("display","none");
		
	    }else if(str=='xmcs'){
	    $("#xmzj").removeClass("li_lmbt");
		$("#xmsb").removeClass("li_lmbt");
		$("#xmcs").addClass("li_lmbt");
		$("#zjps").removeClass("li_lmbt"); 
		$("#xmzj_list1").css("display","none");
		$("#xmzj_list2").css("display","none");
		$("#xmzj_list3").css("display","block");
		$("#xmzj_list4").css("display","none");
	    	 
	     }else{
	    $("#xmzj").removeClass("li_lmbt");
		$("#xmsb").removeClass("li_lmbt");
		$("#xmcs").removeClass("li_lmbt");
		$("#zjps").addClass("li_lmbt"); 
		$("#xmzj_list1").css("display","none");
		$("#xmzj_list4").css("display","block");
		$("#xmzj_list3").css("display","none");
		$("#xmzj_list2").css("display","none");
	     }
		

}

function change6(str){
	
	if(str=='xmkg'){
		$("#xmkg").addClass("li_lmbt");
		$("#xmjs").removeClass("li_lmbt"); 
		$("#xmjs_list1").css("display","block");
		$("#xmjs_list2").css("display","none");
	    	 
	     }else{
		$("#xmkg").removeClass("li_lmbt");
		$("#xmjs").addClass("li_lmbt"); 
		$("#xmjs_list1").css("display","none");
		$("#xmjs_list2").css("display","block");
	     }
	
}


function change_gzcy(str1,str2,str3,str4){
	document.getElementById(str1).className="gzcy_bt1";
	document.getElementById(str2).className="gzcy_bt2";
	document.getElementById(str3).style.display="";
	document.getElementById(str4).style.display="none";
}
function change_ph(str1,str2,str3,str4){
	document.getElementById(str1).className="ph_bt1";
	document.getElementById(str2).className="ph_bt2";
	document.getElementById(str3).style.display="";
	document.getElementById(str4).style.display="none";
}