package com.example;

public class Subtitle {
	private int key;
	private long begin;
	private long end;
	private String sub;

	public Subtitle(int key, long begin, long end, String sub) {
		this.key = key;
		this.begin = begin;
		this.end = end;
		this.sub = sub;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public long getBegin() {
		return begin;
	}
	public void setBegin(long begin) {
		this.begin = begin;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	

}
