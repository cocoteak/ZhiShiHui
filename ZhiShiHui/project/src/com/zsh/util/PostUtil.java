package com.zsh.util;

public class PostUtil {
	String str;
	String post_changUserId;
	
	@Override
	public String toString() {
		return "PostUtil [post_changUserId=" + post_changUserId + ", str="
				+ str + "]";
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getPost_changUserId() {
		return post_changUserId;
	}

	public void setPost_changUserId(String postChangUserId) {
		post_changUserId = postChangUserId;
	}
	
	public PostUtil(String str, String postChangUserId) {
		super();
		this.str = str;
		post_changUserId = postChangUserId;
	}

	public String change(){
		String	str1="";
		int collect=0;
		
		if ("".equals(getStr()) || getStr().length() == 0) {
			str1 += post_changUserId + ",";
			System.out.println("getStr():"+getStr());
		} else {
			String[] splitstr = getStr().split(",");
			for (int i = 0; i < splitstr.length; i++) {
				System.out.println("splitstr[i]:"+splitstr[i]);
				// 查询是否收藏
				if (splitstr[i].equals(getPost_changUserId())) {
					collect += 1;
					System.out.println("取消收藏者:" + splitstr[i]);
				} else {// 未被收藏
					System.out.println("现收藏者:" + splitstr[i]);
					str1 += splitstr[i] + ",";
					
					System.out.println(collect);
					
					if (i == splitstr.length - 1 && collect == 0)
						str1 += getPost_changUserId() + ",";

				}
			}
		}
		return str1;
	}
	
}
