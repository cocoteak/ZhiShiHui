  var input=document.getElementById("input");
    
    var ul=document.getElementById("ul1");
    var lis=document.getElementsByClassName("none-li");
    
    window.onload=function(){    
    var submit=document.getElementById("input");
    submit.addEventListener("click",clickHandler);}
    
	var selected=document.getElementsByClassName('selected-lis');
	var arr=new Array();
	var str='';
	var h=document.getElementById("post_label");
	var h1=document.getElementById("post_labels");
		 	
	//实现插入标签函数:
	function insertLabel(value){
		var li=document.createElement("li");
		li.setAttribute("class","selected-lis");
		li.setAttribute("name","label");
		li.setAttribute("id","labels");
		li.setAttribute("value",value);
		li.textContent=value;
		str+=value+",";
		h.value=str;
		var a=document.createElement("a");
		a.textContent="×";
		a.addEventListener("click",aClickHandler);
		li.appendChild(a);
		ul.appendChild(li);
	}
//	document.getElementById("post_content").value=str;
	
	function hiddenInput(){
		input.style.display="none";
		submit.style.display="none";
	}
	
	
	//输入框输入执行添加标签
    function clickHandler(e) {
		if(arr.length<5){
			//先判断输入值是否为空
			if(input.value!=""){
				if(selected.length<1){//还未添加任何标签
					insertLabel(input.value);
					arr.push(input.value);
				}else{
					var count=0;//标记已选标签中是否有和输入框中相等的标签
					for(var i=0;i<selected.length;i++){//取出已经添加的标签进行比较
						var seletedName=selected[i].innerHTML;//例如：seletedName="技术博客<a>×</a>"
						var inputText=input.value+"<a>×</a>";//得到输入框的文本后加“<a>×</a>"符号
						if(inputText==seletedName){
							count=count+1;
						}	
					}
					if(count<1){
						if(arr.length>5){
							hiddenInput();
						}
					}else{
						alert("不能添加重复标签");
					}
				}
			}
		}else{
			hiddenInput();
		}
    }
	
	
	
	//监听删除已选标签：
    function aClickHandler() {
        this.parentElement.remove();
    }
	
	//监听标签库中被选中的标签，并添加到已选标签:
	for(var i=0;i<lis.length;i++){
        lis[i].index =i;
        lis[i].addEventListener("click",function(){
			if(arr.length<5){
				h1.style.display='none';
				if(selected.length<1){//还未添加任何标签时
				insertLabel(this.innerHTML);
				arr.push(this.innerHTML);
				}else{//取出已经添加标签进行比较
					var count=0;//标记已选标签中是否有和输入框中相等的标签
					for(var i=0;i<selected.length;i++){//取出已经添加的标签进行比较
						var seletedName=selected[i].innerHTML;//例如：seletedName="技术博客<a>×</a>"
						var lisText=this.innerHTML+"<a>×</a>";
						if(lisText==seletedName){
								count=count+1;
						}
					}
					if(count<1){
						if(arr.length<5){
							insertLabel(this.innerHTML);
							arr.push(this.innerHTML);
						}else{
							hiddenInput();
						}
					}else{
						alert("不能添加重复标签，请重新输入");
					}
				}
			}else{
			hiddenInput();
			}	
        });
    }
	

