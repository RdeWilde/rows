package org.rows;


public class Endpoint<I extends IInArgs, O extends IOutArgs> implements IEndpoint<I, O> {
	protected IHandler<I> handler;
	protected IController<I,O> controller;
	protected IView<O> view;
	
	public Endpoint(final IHandler<I> handler, final IController<I,O> controller, final IView<O> view) {
		this.handler = handler;
		this.controller = controller;
		this.view = view;
	}
	
	public final I accept(IContext context) {
		return this.handler.accept(context);
	}
	
	public final O process(I in) {
		return this.controller.process(in);
	}
	
	public final Context output(O out) {
		return this.view.build(out);
	}

}
