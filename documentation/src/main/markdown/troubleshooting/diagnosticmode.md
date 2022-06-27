# Diagnostic mode

[solution_name]'s diagnostic mode produces a diagnostic zip containing files needed for troubleshooting. 
If you contact [support] for help troubleshooting an issue, you will need to
provide a diagnostic zip from a [solution_name] run that exhibits the problem.

To enable diagnostic mode, add any one of the following to the command line:

* -d
* --diagnostic
* [--detect.diagnostic](../properties/configuration/debug.md#diagnostic-mode)

A diagnostic zip includes many files valuable for troubleshooting, such as:

* INFO, DEBUG, and TRACE level logs.
* The BDIO file produced by the run.
* Intermediary files generated by [solution_name], such as Gradle inspector output files.
* Various reports.
* Relevant package manager files.
* The output of commands executed by [solution_name] (package manager commands, etc.).
* Logs and output files from other executed tools ([blackduck_signature_scanner_name], etc.).

After running [solution_name] in diagnostic mode, log messages similar to the following provide the path to the diagnostic zip file.

```
2019-03-29 09:32:02 INFO  [main] --- Creating diagnostics zip.
2019-03-29 09:32:02 INFO  [main] --- Diagnostics zip location: C:\detect\blackduck\runs\detect-run-2019-03-29-13-31-50-492.zip
2019-03-29 09:32:03 INFO  [main] --- Diagnostics file created at: C:detect\blackduck\runs\detect-run-2019-03-29-13-31-50-492.zip
2019-03-29 09:32:03 INFO  [main] --- Diagnostic mode has completed.
```

To conserve disk space, be sure to disable diagnostic mode once it is no longer needed.