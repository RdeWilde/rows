package org.rows;


public interface IView<O extends IOutArgs> {
	public Context build(final O out);
}
