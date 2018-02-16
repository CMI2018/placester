package com.resolvit.placester;

import java.util.Set;
import java.util.TreeSet;

/**
 * Stores the occurrences of a specific word from the paragraph.
 * 
 * @author miriarte
 * 
 */
public class Occurrence implements Comparable<Occurrence> {
	private String word;
	private int totalOccurrences = 0;
	private Set<Integer> sentenceIndexes = new TreeSet<>();

	/**
	 * Constructor to build an ocurrence based on a word and the sentence it was
	 * found in.
	 * 
	 * @param wordStem
	 *            the stem of a processed word
	 * @param sentence
	 *            the index of the sentence the word was found in
	 */
	public Occurrence(String wordStem, int sentence) {
		this.word = wordStem;
		this.totalOccurrences = 1;
		this.sentenceIndexes.add(sentence);
	}

	public void add(int sentence){
		this.totalOccurrences++;
		this.sentenceIndexes.add(sentence);
	}
	/**
	 * Returns the stem of an occurrence.
	 * 
	 * @return the wordStem
	 */
	public String getWord() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Occurrence other = (Occurrence) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equalsIgnoreCase(other.word))
			return false;
		return true;
	}

	@Override
	public int compareTo(Occurrence o) {
		return this.word.compareTo(o.getWord());
	}
}
