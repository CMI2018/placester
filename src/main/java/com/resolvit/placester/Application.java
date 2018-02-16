package com.resolvit.placester;

import java.io.IOException;
import java.util.SortedSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.resolvit.placester.output.IOutput;
import com.resolvit.placester.output.JsonOutput;
import com.resolvit.placester.sources.ISource;
import com.resolvit.placester.sources.StringSource;

/**
 * Application Class.
 * 
 * @author miriarte
 * 
 */
public class Application {
	private static final Logger LOGGER = LogManager.getLogger(Application.class);

	private Application() {
	}

	public static void main(String[] args) {
		final String paragraph = "Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word is any form of a word often communicated with essentially the same meaning. For example, fish and fishes could be defined as a unique word by using their stem fish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what unique sentence index position or positions the word is found. The following words should not be included in your analysis or result set: \"a\", \"the\", \"and\", \"of\", \"in\", \"be\", \"also\" and \"as\".  Your final result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.";
		ISource source = new StringSource(paragraph);
		SortedSet<Occurrence> uniqueWords = null;
		ParagraphProcessor processor = new ParagraphProcessor(source.getContent());
		try {
			uniqueWords = processor.getUniqueWordsByStem();
		} catch (IOException e) {
			LOGGER.error("Error al procesar", e);
		}

		if (uniqueWords != null) {
			IOutput output = new JsonOutput();
			output.generateOutput(uniqueWords);
		}
	}
}
