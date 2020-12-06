package com.sqkb.loadbanalcer;

import java.util.Iterator;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午9:48
 */
public class ReadOnlyIterator<E> implements Iterator<E> {

    private final Iterator<E> delegate;

    private ReadOnlyIterator(Iterator<E> delegate) {
        this.delegate = delegate;
    }

    public static <E> Iterator<E> with(Iterator<E> delegate) {
        return new ReadOnlyIterator<E>(delegate);
    }

    @Override
    public boolean hasNext() {
        return delegate.hasNext();
    }

    @Override
    public E next() {
        return delegate.next();
    }
}