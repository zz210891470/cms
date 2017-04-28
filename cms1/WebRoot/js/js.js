// JavaScript Document


//获取ID
function Y(al)
{
	    return eval('document.getElementById("'+al+'")');		
}
//改变样式
function ChangClass(uid,css,num)
{   
	for(i=0; i<8; i++)
	{
	  if (i==num )
	  { 
	  document.getElementById("subNav"+i+"").style.display="block";
	  }else{
		  document.getElementById("subNav"+i+"").style.display="none";
		  }
	} 

}

function openWin(links,flag)
{
if(flag==0){
window.location=""+links+"";
}
else{
window.open(""+links+"");
}
}


//改变div 
function ChangDiv(uid,css,num,div)
{  
var tabList = document.getElementById(uid).getElementsByTagName("li");
for(i=0; i<tabList.length; i++)
{
  if (i ==num )
  { 

  tabList[i].className =css;

 document.getElementById(""+div+""+i+"").style.display="block";
    
  }else{

  tabList[i].className = "none"; 
 document.getElementById(""+div+""+i+"").style.display="none";
    }
} 

}