package org.rows;

public interface IController<I extends IInArgs, O extends IOutArgs> {
	public O process(final I in);
}
