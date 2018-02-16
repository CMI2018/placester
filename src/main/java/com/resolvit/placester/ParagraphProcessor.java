package com.resolvit.placester;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.resolvit.placester.npl.SentenceSplitter;
import com.resolvit.placester.npl.WordTokenizer;

import opennlp.tools.stemmer.PorterStemmer;
import opennlp.tools.util.InvalidFormatException;

/**
 * Processes a paragraph in order to obtain a list of unique words.
 * 
 * @author miriarte
 * 
 */
public class ParagraphProcessor {
	private String paragraph;
	private String[] exceptionsArray = { "", "a", "the", "and", "of", "in", "be", "also", "as" };
	private Map<String, Occurrence>  processedStems = new TreeMap<>();
	public ParagraphProcessor(String paragraph) {
		this.paragraph = paragraph;
	}

	/**
	 * Returns a Set of unique occurrences of words in a given paragraph.
	 * 
	 * @return a Set of unique occurrences of words in a given paragraph
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public SortedSet<Occurrence> getUniqueWordsByStem() throws InvalidFormatException, IOException {
		TreeSet<Occurrence> occurrences = new TreeSet<>();
		SentenceSplitter splitter = new SentenceSplitter();
		WordTokenizer tokenizer = new WordTokenizer();
		String[] sentences = splitter.splitParagraph(paragraph);
		PorterStemmer ps = new PorterStemmer();
		for (int sentenceIndex = 0; sentenceIndex < sentences.length; sentenceIndex++) {
			String[] words = tokenizer.tokenizeWords(sentences[sentenceIndex]);
			for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
				String word = words[wordIndex].replaceAll("[^0-9a-zA-Z]", "");
				if (!Arrays.asList(exceptionsArray).contains(word.toLowerCase())) {
					String wordStem = ps.stem(word.toLowerCase());
					if (this.processedStems.containsKey(wordStem)){
						this.processedStems.get(wordStem).add(sentenceIndex);
					}
					else {
						Occurrence occurrence = new Occurrence(word, sentenceIndex);
						occurrences.add(occurrence);
						this.processedStems.put(wordStem,occurrence);						
						
					}
					ps.reset();
				}
			}
		}
		return occurrences;
	}
}
