package com.resolvit.placester.sources;

public class TextFileSource implements ISource {
	private String content;

	/**
	 * Class to manage a Text file source as input.
	 * 
	 * @author miriarte
	 * 
	 */	public TextFileSource(String path) {
		//TODO Implement code to read a file as input
	}

	@Override
	public String getContent() {
		return this.content;
	}
}
