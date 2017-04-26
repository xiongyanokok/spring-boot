package com.xy.controller;

import java.util.Date;

public class ArticleInfo {
	private long _id;
	private String title;
	private String userName;

	private int postType;
	private Date postTime;
	private long userId;
	private String source;
	private String sourceUrl;
	private String brief;
	private int state;
	private int isEssential;
	private long blogId;
	private int articleType;
	private int wordCount;
	private int clickCount;
	private int commentCount;
	private int collectCount;
	private int recommendCount;
	private int trackbackCount;
	private Date lastUpdateTime;
	private int acceptComment;
	private String content;
	private int classId;
	private int essencial;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getIsEssential() {
		return isEssential;
	}

	public void setIsEssential(int isEssential) {
		this.isEssential = isEssential;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public int getArticleType() {
		return articleType;
	}

	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}

	public int getTrackbackCount() {
		return trackbackCount;
	}

	public void setTrackbackCount(int trackbackCount) {
		this.trackbackCount = trackbackCount;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getAcceptComment() {
		return acceptComment;
	}

	public void setAcceptComment(int acceptComment) {
		this.acceptComment = acceptComment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getEssencial() {
		return essencial;
	}

	public void setEssencial(int essencial) {
		this.essencial = essencial;
	}

}
