package org.stapledon.sumo;

import java.io.IOException;

public class NoBackupException extends RuntimeException {
    public NoBackupException(IOException e) {
        super(e);
    }
}
