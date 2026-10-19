package jooqcodegen;

import jooqcodegen.parsers.AlterTable;
import jooqcodegen.parsers.CreateTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParsersTest {

    private final CreateTable createTable = new CreateTable();
    private final AlterTable alterTable = new AlterTable();

    @Test
    public void createTableHandlesUnterminatedParenthesis() {
        // Previously threw StringIndexOutOfBoundsException from findNextSeparator
        final String input = "CREATE TABLE `t` (col1 int, col2 int";
        // No closing paren, so the clause section is empty rather than blowing up
        assertEquals("CREATE TABLE `t` ();\n", createTable.convert(input));
    }

    @Test
    public void createTableHandlesMissingParenthesis() {
        final String input = "CREATE TABLE `t`";
        assertEquals("CREATE TABLE `t`;\n", createTable.convert(input));
    }

    @Test
    public void alterTableHandlesMissingClosingBacktick() {
        // Only one backtick, so convert bails out instead of throwing
        final String input = "ALTER TABLE `t MODIFY col INT";
        assertEquals(input + ";\n", alterTable.convert(input));
    }
}
