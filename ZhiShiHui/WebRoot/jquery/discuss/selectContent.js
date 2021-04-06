function change(page){
     document.getElementById("pageNow").value=page;
     document.getElementById("form1").submit();
}

function displayOrHidden(content_recordnum){
    var reply=document.getElementById("reply"+content_recordnum.toString());
    if(reply.style.display=='block'){
    	reply.style.display='none';
    }else{
    	reply.style.display='block';
    }
   }

function recordNum(content_id,user_id){
	window.location.href="selectContent?post_id="+post_id+"&pageNow="+pageNow+"&changeCollection=true";
}

function changeCollection(post_id,pageNow){
	window.location.href="selectContent?post_id="+post_id+"&pageNow="+pageNow+"&changeCollection=true";
}

function changeLike(post_id,pageNow){
	window.location.href="selectContent?post_id="+post_id+"&pageNow="+pageNow+"&changeLikeNum=true";
}

function changeDislike(post_id,pageNow){
	window.location.href="selectContent?post_id="+post_id+"&pageNow="+pageNow+"&changeDislikeNum=true"; 
}

function changeContentLike(post_id,content_id,pageNow){
	window.location.href="selectContent?content_id="+content_id+"&post_id="+post_id+"&pageNow="+pageNow+"&changeContentLikenum=true";
}

function changeContentDislike(post_id,content_id,pageNow){
	window.location.href="selectContent?content_id="+content_id+"&post_id="+post_id+"&pageNow="+pageNow+"&changeContentDisikenum=true";
}
 
function editorPost(post_id){
	window.location.href="updateHandlePost?post_id="+post_id;
}

function deletePost(post_id){
	window.location.href="deletePost?post_id="+post_id;
}

function changeIfrefined(post_id,pageNow,post_ifrefined){
	window.location.href="selectContent?post_id="+post_id+"&pageNow="+pageNow+"&post_ifrefined="+post_ifrefined+"&changeIfrefined=true";
}

    





