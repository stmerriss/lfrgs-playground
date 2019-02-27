package com.lfrgs.tools.api;

/**
 * @author Andrew Betts
 */
public interface TriFunction<R, A, B, C> {

	public R get(A a, B b, C c);

}