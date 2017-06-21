/**
 * 
 */
package ts.tzfood.mappers;

import java.util.List;



/**
 * @author Aramis
 *
 */
public interface Mapper<O,J> {

	public J mapToJsonModel(O object);
	public O mapToObject(J model);
	
	public List<J> mapToJsonModel(List<O> objects);
	public List<O> mapToObject(List<J> models);
}
