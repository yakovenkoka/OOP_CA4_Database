package org.example.Exceptions;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }

    public DaoException()
    {
    }
}

