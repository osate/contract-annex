# Repository guidance

## Working agreements

- When asked to commit, use a concise subject, a blank line, and a descriptive body explaining what changed and why. Use a subject-only commit only when explicitly requested.
- Inspect `git status --short --branch` before editing and preserve existing user changes.
- Explain the diagnosis, proposed fix, and validation plan before making substantive code changes. Keep changes focused on the requested behavior.

## Project structure

This repository implements the Assurance Contract Annex for OSATE using Eclipse
plugins, Xtext, EMF, and Xsemantics. Maven builds use Tycho and inherit configuration
from the OSATE parent POM.

- `org.osate.contract`: language runtime, grammar, type system, interpreter,
  validation, execution, generators, and GSN support.
- `org.osate.contract.annex`: integration with OSATE annex parsing, linking, and
  unparsing.
- `org.osate.contract.ide` and `org.osate.contract.ui`: IDE services and Eclipse
  editor integration.
- `org.osate.contract.evaluation.ui`: commands for evaluating contracts, executing
  plans, and generating GSN output.
- `org.osate.contract.tests`: JUnit tests and AADL model fixtures.
- `org.osate.fia.contrib`: fault impact analysis integration and property definitions.
- `org.osate.contract.feature` and `org.osate.contract.repository`: Eclipse feature
  and p2 update-site packaging.
- `org.osate.contract.help/markdown/ContractAnnex.md`: language documentation.
- `examples`, `PubSubExample`, and `SARExercises`: example models and exercises.

## Source and generated code

- Edit handwritten code under each plugin's `src/` directory.
- The grammar is `org.osate.contract/src/org/osate/contract/Contract.xtext`; its
  workflow is the adjacent `GenerateContract.mwe2`.
- Type-system and interpreter rules are in
  `org.osate.contract/src/org/osate/contract/typing/contract.xsemantics` and
  `contract-interpreter.xsemantics`.
- Treat `src-gen/`, `xtend-gen/`, `xsemantics-gen/`, and `model/generated/` as
  generator output. Change the corresponding sources instead of patching generated
  implementations. Review generated diffs for unrelated changes.
- Respect any user-specified Eclipse/manual generation boundary; do not run
  generation or a build that triggers it across that boundary.
- Follow neighboring Java/Xtend formatting and include the complete surrounding
  copyright/license header in new source files. See `LICENSE.txt`.
- Keep reusable language behavior in the runtime plugin and editor-specific code
  in the appropriate integration plugin.
- Eclipse dependencies and packaged resources also require updates to
  `META-INF/MANIFEST.MF`, `plugin.xml`, or `build.properties` where applicable.

## Build and validation

Run Maven with `-T3` (three build threads). See `../osate2/agents.md` for
additional Maven build guidance.

The build command recorded in `Jenkinsfile` is:

```sh
mvn -T 3 -s seisettings.xml clean install -U -Dtycho.disableP2Mirrors=true -DfailIfNoTests=false
```

This is a CI reference, not a verified portable local command:

- `seisettings.xml` configures SEI proxies and local p2 mirrors. Check whether the
  environment supports these settings before using them.
- The root POM currently inherits `org.osate:osate2.main-pom:2.21.0-SNAPSHOT`.
  Resolving that parent and the OSATE p2 dependencies is required.
- Jenkins selects Java 21. At initialization, existing working-tree changes
  request Java 21 in several plugins while the runtime still declares Java 17.
  Inspect current manifests and compiler settings before selecting a JDK; avoid
  overwriting an in-progress migration.
- The root POM includes `org.osate.contract.tests` only with the `with-tests`
  profile. Use `mvn -T3 -Pwith-tests verify` with environment-appropriate Maven
  settings. A successful default reactor build does **not** establish that tests
  ran. The CI flag
  `-DfailIfNoTests=false` also permits missing tests.
- For behavior changes, add or update focused regressions under
  `org.osate.contract.tests/src/` with fixtures under `org.osate.contract.tests/models/`.
  Follow existing JUnit Jupiter, `InjectionExtension`, `ContractInjectorProvider`,
  and OSATE `TestHelper` patterns.
- Run relevant tests in a configured OSATE Eclipse test environment, or through
  Tycho with `-Pwith-tests`. Report the actual
  test count and any dependency or execution blockers.
- Review the final diff and run `git diff --check`. Documentation-only changes
  normally need no Maven build.

Runtime evaluation uses Python and Z3; see `INSTALL.md` for installation and OSATE
Python preference setup. Its compatibility notes are historical and should be
checked before changing supported versions.
