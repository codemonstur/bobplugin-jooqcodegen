package jooqcodegen;

import org.junit.jupiter.api.Test;

import static jooqcodegen.Functions.findNextSeparator;
import static jooqcodegen.Functions.unescapedIndexOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTest {

    @Test
    void unescapedIndexOfReturnsIndexWhenFound() {
        assertEquals(2, unescapedIndexOf("ab`c", '`', 0));
    }

    @Test
    void unescapedIndexOfReturnsMinusOneWhenMissing() {
        assertEquals(-1, unescapedIndexOf("abc", '`', 0));
    }

    @Test
    void unescapedIndexOfSkipsEscapedCharacters() {
        // "a\'bc'": the backslash escapes the quote at index 2, so the real quote is at index 5
        assertEquals(5, unescapedIndexOf("a\\'bc'", '\'', 0));
    }

    @Test
    void findNextSeparatorFindsTopLevelComma() {
        // "a (b,c), d": the comma at index 4 is inside brackets, the top-level one is at index 7
        assertEquals(7, findNextSeparator("a (b,c), d", 0));
    }

    @Test
    void findNextSeparatorSkipsCommasInsideBrackets() {
        // "(a,b) , c": the comma at index 2 is inside brackets, the top-level one is at index 6
        assertEquals(6, findNextSeparator("(a,b) , c", 0));
    }

    @Test
    void findNextSeparatorReturnsMinusOneWhenUnterminatedBracket() {
        // Previously this returned length+1, causing substring to throw
        assertEquals(-1, findNextSeparator("a (b, c", 0));
    }

    @Test
    void findNextSeparatorReturnsLengthWhenNoMoreSeparators() {
        assertEquals(7, findNextSeparator("a (b) c", 0));
    }
}