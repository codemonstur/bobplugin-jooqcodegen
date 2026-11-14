package jooqcodegen.parsers;

/**
 * The {@code NameUTF8} class.
 */
public final class NameUTF8 implements StatementParser {

    /**
     * Returns the result of {@code matches}.
     *
     * @param statement the statement
     * @return whether the condition holds
     */
    @Override
    public boolean matches(final String statement) {
        return statement.trim().equals("SET NAMES utf8mb4");
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
    public NameUTF8() {
    }
}
