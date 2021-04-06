package com.zsh.util;

public class ContentMap {
   int contentCount;
   boolean contentFlage;
   
public ContentMap(int contentCount, boolean contentFlage) {
	super();
	this.contentCount = contentCount;
	this.contentFlage = contentFlage;
}

public int getContentCount() {
	return contentCount;
}
public void setContentCount(int contentCount) {
	this.contentCount = contentCount;
}
public boolean isContentFlage() {
	return contentFlage;
}
public void setContentFlage(boolean contentFlage) {
	this.contentFlage = contentFlage;
}
}
