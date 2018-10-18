package com.blackducksoftware.integration.hub.detect.workflow.exit;

import com.blackducksoftware.integration.hub.detect.exitcode.ExitCodeType;

public class ExitCodeRequest {
    private final ExitCodeType exitCodeType;
    private final String reason;

    public ExitCodeRequest(ExitCodeType exitCodeType, String reason) {
        this.exitCodeType = exitCodeType;
        this.reason = reason;
    }

    public ExitCodeRequest(ExitCodeType exitCodeType) {
        this(exitCodeType, null);
    }
}