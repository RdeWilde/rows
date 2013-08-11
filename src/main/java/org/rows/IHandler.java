package org.rows;

public interface IHandler<I extends IInArgs> {
	public I accept(final IContext context);
}
