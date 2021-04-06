function change(page){
     document.getElementById("pageNow").value=page;
     document.getElementById("form1").submit();
}

function select(post_id){
	window.location.href="selectContent?post_id="+post_id;
}

function displaySelect(){
	window.location.href="selectPost?allSelect=true";
   }