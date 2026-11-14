package jooqcodegen.parsers;

/**
 * The {@code CreateIndex} class.
 */
public final class CreateIndex implements StatementParser {

    /**
     * Returns the result of {@code matches}.
     *
     * @param statement the statement
     * @return whether the condition holds
     */
    @Override public boolean matches(final String statement) {
        return statement.startsWith("CREATE INDEX ");
    }

    /**
     * Returns the result of {@code convert}.
     *
     * @param statement the statement
     * @return the result
     */
    @Override public String convert(final String statement) {
        return "";
    }


    /**
     * Creates a new instance.
     */
    public CreateIndex() {
    }
}
