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
		 	
	//ʵ�ֲ����ǩ����:
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
		a.textContent="��";
		a.addEventListener("click",aClickHandler);
		li.appendChild(a);
		ul.appendChild(li);
	}
//	document.getElementById("post_content").value=str;
	
	function hiddenInput(){
		input.style.display="none";
		submit.style.display="none";
	}
	
	
	//���������ִ����ӱ�ǩ
    function clickHandler(e) {
		if(arr.length<5){
			//���ж�����ֵ�Ƿ�Ϊ��
			if(input.value!=""){
				if(selected.length<1){//��δ����κα�ǩ
					insertLabel(input.value);
					arr.push(input.value);
				}else{
					var count=0;//�����ѡ��ǩ���Ƿ��к����������ȵı�ǩ
					for(var i=0;i<selected.length;i++){//ȡ���Ѿ���ӵı�ǩ���бȽ�
						var seletedName=selected[i].innerHTML;//���磺seletedName="��������<a>��</a>"
						var inputText=input.value+"<a>��</a>";//�õ��������ı���ӡ�<a>��</a>"����
						if(inputText==seletedName){
							count=count+1;
						}	
					}
					if(count<1){
						if(arr.length>5){
							hiddenInput();
						}
					}else{
						alert("��������ظ���ǩ");
					}
				}
			}
		}else{
			hiddenInput();
		}
    }
	
	
	
	//����ɾ����ѡ��ǩ��
    function aClickHandler() {
        this.parentElement.remove();
    }
	
	//������ǩ���б�ѡ�еı�ǩ������ӵ���ѡ��ǩ:
	for(var i=0;i<lis.length;i++){
        lis[i].index =i;
        lis[i].addEventListener("click",function(){
			if(arr.length<5){
				h1.style.display='none';
				if(selected.length<1){//��δ����κα�ǩʱ
				insertLabel(this.innerHTML);
				arr.push(this.innerHTML);
				}else{//ȡ���Ѿ���ӱ�ǩ���бȽ�
					var count=0;//�����ѡ��ǩ���Ƿ��к����������ȵı�ǩ
					for(var i=0;i<selected.length;i++){//ȡ���Ѿ���ӵı�ǩ���бȽ�
						var seletedName=selected[i].innerHTML;//���磺seletedName="��������<a>��</a>"
						var lisText=this.innerHTML+"<a>��</a>";
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
						alert("��������ظ���ǩ������������");
					}
				}
			}else{
			hiddenInput();
			}	
        });
    }
	

