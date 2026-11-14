package jooqcodegen;

import jcli.annotations.CliCommand;
import jcli.annotations.CliOption;
import org.jooq.meta.jaxb.Logging;

/**
 * The {@code CodegenArguments} class.
 */
@CliCommand(name = "jooq-codegen", description = "A bob plugin that generates JOOQ code")
public class CodegenArguments {

    /**
     * The {@code DEFAULT_INPUT_LOCATION} constant.
     */
    public static final String DEFAULT_INPUT_LOCATION = "src/main/resources/db/migration";

    /**
     * The {@code inputScript} field.
     */
    @CliOption(name = 'i', longName = "input-scripts", defaultValue = DEFAULT_INPUT_LOCATION)
    public String inputScript;
    /**
     * The {@code outputDir} field.
     */
    @CliOption(name = 'o', longName = "output-dir", defaultValue = "generate-sources/jooq")
    public String outputDir;

    /**
     * The {@code withJavadoc} field.
     */
    @CliOption(longName = "wj")
    public boolean withJavadoc;
    /**
     * The {@code withComments} field.
     */
    @CliOption(longName = "wc")
    public boolean withComments;
    /**
     * The {@code withEmptySchemas} field.
     */
    @CliOption(longName = "wes")
    public boolean withEmptySchemas;
    /**
     * The {@code withEmptyCatalogs} field.
     */
    @CliOption(longName = "wec")
    public boolean withEmptyCatalogs;
    /**
     * The {@code withGeneratedAnnotation} field.
     */
    @CliOption(longName = "wga")
    public boolean withGeneratedAnnotation;
    /**
     * The {@code withGlobalCatalogReferences} field.
     */
    @CliOption(longName = "wgcr")
    public boolean withGlobalCatalogReferences;
    /**
     * The {@code withDaos} field.
     */
    @CliOption(longName = "wd")
    public boolean withDaos;
    /**
     * The {@code withPojos} field.
     */
    @CliOption(longName = "wp")
    public boolean withPojos;
    /**
     * The {@code withIndexes} field.
     */
    @CliOption(longName = "wi")
    public boolean withIndexes;
    /**
     * The {@code withKeys} field.
     */
    @CliOption(longName = "wk")
    public boolean withKeys;
    /**
     * The {@code withRecords} field.
     */
    @CliOption(longName = "wr")
    public boolean withRecords;
    /**
     * The {@code withInstanceFields} field.
     */
    @CliOption(longName = "wif")
    public boolean withInstanceFields;

    /**
     * The {@code logging} field.
     */
    @CliOption(name = 'l', longName = "logging", defaultValue = "WARN")
    public Logging logging;
    /**
     * The {@code packageName} field.
     */
    @CliOption(name = 'n', longName = "package-name")
    public String packageName;
    /**
     * The {@code dontPreProcess} field.
     */
    @CliOption(name = 'd', longName = "dont-pre-process")
    public boolean dontPreProcess;

    /**
     * The {@code generationSqlFile} field.
     */
    @CliOption(longName = "pre-process-file", defaultValue = "instructions/schema.sql")
    public String generationSqlFile;


    /**
     * Creates a new instance.
     */
    public CodegenArguments() {
    }
}
