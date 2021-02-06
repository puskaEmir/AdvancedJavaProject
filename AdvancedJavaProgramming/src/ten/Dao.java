package ten;

import java.util.List;

//T table -> INSERT , UPDATE, SELECT , DELETE
public interface Dao<T> {
	public T insert(T object);
	
	public T update(T object);
	
	public boolean delete(T object);
	
	public T retrieve(int id);
	
	public List<T> retrieveAll();
	
	public List<T> retrieveAll(int limit);
}
