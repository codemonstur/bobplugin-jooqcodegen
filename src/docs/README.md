# bobplugin-jooqcodegen

A [bob](https://github.com/codemonstur/bobthebuildtool) plugin that generates
[jOOQ](https://www.jooq.org/) code from your project's SQL migration scripts.

Because jOOQ's codegen parser cannot consume many migration-script constructs
directly, the plugin **preprocesses** the scripts into a single parser-safe schema
file before handing them to jOOQ's `GenerationTool`.

> **Related:** [jooqpreprocessor](../jooqpreprocessor/src/docs/README.md) is the
> standalone Maven-plugin version of the same preprocessing idea (targeting jOOQ
> 3.18).

## Installation

```
plugin codemonstur/jooqcodegen:<version>
```

## Command

```
bob jooq-codegen [options]
```

### Input / output

| Option | Default | Description |
| --- | --- | --- |
| `-i` | `src/main/resources/db/migration` | Directory containing migration SQL scripts. |
| `-o` | `generate-sources/jooq` | Output directory for generated Java sources. |
| `-n` | — | Package name for generated code. |
| `-d` | — | Do **not** pre-process; pass scripts straight to jOOQ. |
| `--pre-process-file` | `instructions/schema.sql` | The merged, parser-safe schema file written by preprocessing. |

### jOOQ generation flags

| Flag | Effect |
| --- | --- |
| `-wj` | Include javadoc. |
| `-wc` | Include comments. |
| `-wes` / `-wec` | Omit empty schemas / catalogs. |
| `-wga` | `@Generated` annotation. |
| `-wgcr` | Generate catalog references. |
| `-wd` | Generate DAOs. |
| `-wp` | Generate POJOs. |
| `-wi` | Generate indexes. |
| `-wk` | Generate keys. |
| `-wr` | Generate records. |
| `-wif` | Use instance fields. |
| `-l` | Logging level. |

## Pipeline

1. Validate the input scripts directory.
2. Unless `-d` is given, run the embedded SQL parsers to merge the migration
   scripts into one jOOQ-parsable schema file.
3. Add the generated source directory to the project's source roots.
4. Invoke jOOQ `GenerationTool.generate(...)`.

## Embedded SQL parsers

`jooqcodegen.parsers` contains statement-level parsers used during preprocessing:

- `CreateTable`
- `AlterTable`
- `DropTable`
- `CreateIndex`
- `ForeignKeyChecks`
- `NameUTF8`

## Building

```sh
make build
```

## License

MIT
