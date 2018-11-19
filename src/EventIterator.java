/**
 *
 * @author jerensuzuki
 */

import java.util.NoSuchElementException;

public interface EventIterator {
    Events next()throws NoSuchElementException;
    boolean hasNext(); 
}
