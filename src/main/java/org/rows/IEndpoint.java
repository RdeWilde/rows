package org.rows;

public interface IEndpoint<I extends IInArgs, O extends IOutArgs> {
	public I 		accept(IContext context);
	public O 		process(I in);
	public Context 	output(O out);
}
