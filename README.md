# Placester

The following project is a Java application to process a sample paragraph and obtain an alphabetized list of all unique words based on their stem.

**Technical Information**
* Java JDK 1.8.0_45
* Apache Open NLP 1.8.4

**Input Paragraph**
>*Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word is any form of a word often communicated with essentially the same meaning. For example, fish and fishes could be defined as a unique word by using their stem fish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what unique sentence index position or positions the word is found. The following words should not be included in your analysis or result set: "a", "the", "and", "of", "in", "be", "also" and "as".  Your final result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.*

**Expected Output**
```json
{
  "results": [
    {
      "word": "ALL",
      "total-occurrences": 1,
      "sentence-indexes": [0]
    },
    {
      "word": "alphabetized",
      "total-occurrences": 1,
      "sentence-indexes": [0]
    },
   {
      "word": "analysis",
      "total-occurrences": 2,
      "sentence-indexes": [4, 5]
    },
   ...
  ]
}
```
**NOTICE**
In the given expected output is not clear how the sorting should be applied in a case-sensitive environment. For instance, in Linux all the CAPITALIZED words will be shown first followed by the lowercase ones.
