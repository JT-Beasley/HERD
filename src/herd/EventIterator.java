/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

/**
 *
 * @author jerensuzuki
 */

import java.util.NoSuchElementException;

public interface EventIterator {
    Events next()throws NoSuchElementException;
    boolean hasNext(); 
}
