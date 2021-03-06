package com.moonlit.model;

public class Article {
	private int id;
	private String title;
	private String content;
	public Article() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return String.format("[%d, %s]:\n%sh", id, title, content);
	}
}
