package com.resolvit.placester.output;

import java.util.SortedSet;

import com.resolvit.placester.Occurrence;

/**
 * Interface to implement on the different output formats.
 * 
 * @author miriarte
 * 
 */
@FunctionalInterface
public interface IOutput {
	public void generateOutput(SortedSet<Occurrence> uniqueWords);
}
