/**
 * 
 */
package com.rainier.gc.system.gc.utils;

/**
 * @author Rambabu M
 *
 */
public abstract class AbstractDataPopulator<Source,Target> implements DataPopulator<Source, Target> {

	@Override
	public Target populate(Source source) {
	   return populate(source,createTarget());
	}
	
	protected abstract Target createTarget();

   

}
