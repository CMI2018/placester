package com.resolvit.placester.npl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * Class to Split a paragraph into a String array of sentences using OpenNPL.
 * 
 * @author miriarte
 * 
 */
public class SentenceSplitter {
	private static final Logger LOGGER = LogManager.getLogger(SentenceSplitter.class);

	/**
	 * Splits a paragraph into an array of sentences.
	 * 
	 * @param paragraph the paragraph to be splitted
	 * @return an array of sentences
	 */
	public String[] splitParagraph(String paragraph) {
		InputStream modelIn = null;
		String[] result = null;
		try {
			modelIn = this.getClass().getResourceAsStream("/en-sent.bin");
			SentenceModel model = new SentenceModel(modelIn);
			SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
			result = sentenceDetector.sentDetect(paragraph);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
					LOGGER.error(e);
				}
			}
		}
		return result;
	}
}
