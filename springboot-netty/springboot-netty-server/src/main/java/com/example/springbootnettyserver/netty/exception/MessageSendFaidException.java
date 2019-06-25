package com.example.springbootnettyserver.netty.exception;

public class MessageSendFaidException extends Exception {
	
	public MessageSendFaidException() {
        super();
    }

    public MessageSendFaidException(String message) {
        super(message);
    }

    public MessageSendFaidException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageSendFaidException(Throwable cause) {
        super(cause);
    }
}
