package org.rows;

public interface IKey<T extends IEntity> {
	public T create();
	public T getEntity();
}
