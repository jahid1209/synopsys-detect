# Requirements

## General requirements

Requirements for [solution_name]

* Normally, access to the internet is required to download and run [solution_name] and components from GitHub and other locations. For running without internet access,
refer to [Air Gap Mode](../downloadingandinstalling/airgap.md).
* Minimum 8GB RAM.
* Java: OpenJDK 64-bit version 8, 11, 13, 14, 15, 16, or 17. If using Java 11: 11.0.5 or higher is required.
* curl versions 7.34.0 or later.
* Bash.
* If using [powershell_script_name]: PowerShell versions 4.0 or higher.
* The tools required to build your project source code.

## [blackduck_product_name] requirements

For connecting to [blackduck_product_name]:

* Licensed installation of the current version of [blackduck_product_name] with access credentials.
Visit the [Black Duck release page](https://github.com/blackducksoftware/hub/releases) to determine the current version of [blackduck_product_name].
* The [blackduck_product_name] notifications module must be enabled.
* A [blackduck_product_name] user with the [required roles](usersandroles.md).
* On Alpine Linux you will also need to override the Java installation used by the [blackduck_signature_scanner_name] as
described [here](../troubleshooting/solutions.md#black-duck-signature-scanner-fails-on-alpine-linux).

## Project type-specific requirements

In general, the detectors require:

* All dependencies must be resolvable. This generally means that each dependency has been installed using the package manager's cache, virtual environment, and others.
* The package manager / build tool must be installed and in the path.

Refer to the applicable [package manager sections](../packagemgrs/overview.md) for information on specific detectors. This is particularly important for the [Docker Inspector](../packagemgrs/docker/intro.md) and the [NuGet Inspector](../packagemgrs/nuget.md).

## Risk report requirements

The risk report requires that the following fonts are installed:

* Helvetica
* Helvetica bold

