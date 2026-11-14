package jooqcodegen.parsers;

/**
 * The {@code DropTable} class.
 */
public final class DropTable implements StatementParser {
    /**
     * Returns the result of {@code matches}.
     *
     * @param statement the statement
     * @return whether the condition holds
     */
    @Override
    public boolean matches(final String statement) {
        return statement.startsWith("DROP TABLE `");
    }

    /**
     * Returns the result of {@code convert}.
     *
     * @param statement the statement
     * @return the result
     */
    @Override
    public String convert(final String statement) {
        return statement+";\n";
    }

    /**
     * Creates a new instance.
     */
    public DropTable() {
    }
}
