package jooqcodegen.parsers;

/**
 * The {@code StatementParser} interface.
 */
public interface StatementParser {
    /**
     * Returns the result of {@code matches}.
     *
     * @param statement the statement
     * @return whether the condition holds
     */
    boolean matches(String statement);
    /**
     * Returns the result of {@code convert}.
     *
     * @param statement the statement
     * @return the result
     */
    String convert(String statement);
}
