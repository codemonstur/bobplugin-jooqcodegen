package jooqcodegen;

import jooqcodegen.parsers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static bobthebuildtool.services.Log.logWarning;

public enum Functions {;

    public static Stream<String> readAllLines(final Path path) {
        try {
            return Files.readAllLines(path).stream();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int toNumber(final String name) {
        final int periodIndex = name.indexOf('.');
        final int underscoreIndex = name.indexOf("__");
        return ( periodIndex == -1 || underscoreIndex == -1 )
            ? 0
            : parseInt(name.substring(periodIndex+1, underscoreIndex), 0);
    }
    private static int parseInt(final String value, final int _default) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return _default;
        }
    }

    private static final List<StatementParser> parsers = Arrays.asList(new ForeignKeyChecks()
            , new NameUTF8(), new CreateTable(), new AlterTable(), new DropTable(), new CreateIndex());

    public static String toJooqSafeStatement(final String statement) {
        for (final StatementParser parser : parsers) {
            if (parser.matches(statement))
                return parser.convert(statement);
        }
        logWarning("No parser matched with statement: " + statement);
        return statement;
    }

    public static int findNextSeparator(final String input, final int offset) {
        int i = offset;
        while (i != -1 && i < input.length()) {
            if (input.charAt(i) == ',') return i;

            if (input.charAt(i) == '(')
                i = skipPast(input, ')', i);
            else if (input.charAt(i) == '`')
                i = skipPast(input, '`', i);
            else if (input.charAt(i) == '\'')
                i = skipPast(input, '\'', i);
            else
                i = i + 1;
        }
        return i;
    }

    // Skips past the closing bracket that matches the opening one at position openIndex.
    // Returns -1 when the bracket is unterminated (so no further separator can be found).
    private static int skipPast(final String input, final char closing, final int openIndex) {
        final int closingIndex = unescapedIndexOf(input, closing, openIndex + 1);
        return closingIndex == -1 ? -1 : closingIndex + 1;
    }

    public static int unescapedIndexOf(final String input, final char c, final int offset) {
        int i = offset;
        while (i != -1 && i < input.length()) {
            if (input.charAt(i) == c) return i;
            i = input.charAt(i) == '\\' ? i+2 : i+1;
        }
        return -1;
    }

}
