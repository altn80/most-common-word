/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.most.common.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author andre
 */
public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        List<WordCount> wordCounts = new ArrayList<>();
        paragraph = paragraph.replaceAll("([/,/./?/!/;/'])", "").toLowerCase();
        System.out.println(paragraph);
        String strBanned = Arrays.stream(banned).collect(Collectors.joining("*"));

        String[] splitParagraph = paragraph.split(" ");

        for (String word : splitParagraph) {
            WordCount wordCount = new WordCount(word, 0);
            if (wordCounts.indexOf(wordCount) != -1) {
                wordCounts.get(wordCounts.indexOf(wordCount)).add();
            } else if (!strBanned.contains(word)) {
                wordCounts.add(wordCount);
            }
        }
        Collections.sort(wordCounts);
        return wordCounts.get(0).word;
    }

    class WordCount implements Comparable<WordCount> {

        String word;
        Integer count;

        void add() {
            count++;
        }

        public WordCount(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount o) {
            return o.count.compareTo(this.count);
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + Objects.hashCode(this.word);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final WordCount other = (WordCount) obj;
            if (!Objects.equals(this.word, other.word)) {
                return false;
            }
            return true;
        }

    }
}
