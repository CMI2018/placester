package com.resolvit.placester.output;

import java.util.SortedSet;

import com.resolvit.placester.Occurrence;

/**
 * Generates the output with YAML format.
 * 
 * @author miriarte
 * 
 */public class YamlOutput implements IOutput {

	@Override
	public void generateOutput(SortedSet<Occurrence> result) {
		// TODO Implement output code for a YAML based result.
		System.out.println("YAML result");
	}

}
