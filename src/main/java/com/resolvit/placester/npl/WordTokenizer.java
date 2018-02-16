package com.resolvit.placester.npl;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

/**
 * Class to obtain an array of tokens based on the words of a given sentence.
 * 
 * @author miriarte
 * 
 */
public class WordTokenizer {
	/**
	 * Tokenizes a sentences into an array of words.
	 * @param sentence the sentence to tokenize
	 * @return an array of words
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String[] tokenizeWords(String sentence) throws InvalidFormatException, IOException {
		InputStream is = this.getClass().getResourceAsStream("/en-token.bin");
		TokenizerModel model = new TokenizerModel(is);
		Tokenizer tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize(sentence);
		is.close();
		return tokens;
	}
}
