package jooqcodegen.parsers;

import java.util.regex.Pattern;

/**
 * The {@code ForeignKeyChecks} class.
 */
public final class ForeignKeyChecks implements StatementParser {

    private static final Pattern PATTERN = Pattern.compile("(SET|set) FOREIGN_KEY_CHECKS = [01]");

    /**
     * Returns the result of {@code matches}.
     *
     * @param statement the statement
     * @return whether the condition holds
     */
    @Override
    public boolean matches(final String statement) {
        return PATTERN.matcher(statement.trim()).matches();
    }

    /**
     * Returns the result of {@code convert}.
     *
     * @param statement the statement
     * @return the result
     */
    @Override
    public String convert(final String statement) {
        return "";
    }

    /**
     * Creates a new instance.
     */
    public ForeignKeyChecks() {
    }
}
