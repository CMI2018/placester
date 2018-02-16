package com.resolvit.placester.sources;

/**
 * Class to manage a String source as input.
 * 
 * @author miriarte
 * 
 */
public class StringSource implements ISource {
	private String content;

	/**
	 * Constructor.
	 * @param text the text to be used as input.
	 */
	public StringSource(String text) {
		this.content = text;
	}

	/**
	 * Returns the content.
	 *	@return the content 
	 */
	@Override
	public String getContent() {
		return this.content;
	}
}
