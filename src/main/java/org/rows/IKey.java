package org.rows;

public interface IKey<T extends IEntity> {
	public void create(T entity);
	public T getEntity();
}
