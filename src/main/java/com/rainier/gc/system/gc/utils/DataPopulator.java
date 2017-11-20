/**
 * 
 */
package com.rainier.gc.system.gc.utils;

/**
 * @author Ram
 *
 */
public interface DataPopulator<Source,Target>
{

    public Target populate(Source source,Target target) ;

    public Target populate(Source source) ;
}
