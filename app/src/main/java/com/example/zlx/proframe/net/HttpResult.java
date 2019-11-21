package com.example.zlx.proframe.net;

public interface HttpResult<T> {

    /**
     * Consume the given value.
     * @param t the value
     * @throws Exception on error
     */
    void onSuccess(T t) throws Exception;

    void onError(Throwable throwable) throws Exception;
}

