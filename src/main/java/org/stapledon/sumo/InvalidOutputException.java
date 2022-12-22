package org.stapledon.sumo;

import java.io.IOException;

public class InvalidOutputException extends RuntimeException{
    public InvalidOutputException(IOException e) {
        super(e);
    }
}
