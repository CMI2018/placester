package com.resolvit.placester.output;

import java.util.SortedSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.resolvit.placester.Occurrence;

/**
 * Generates the output with JSON format.
 * 
 * @author miriarte
 * 
 */
public class JsonOutput implements IOutput {
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	/**
	 * Prints the result in JSON format.
	 */
	@Override
	public void generateOutput(SortedSet<Occurrence> result) {
		System.out.println(gson.toJson(result));
	}
}
