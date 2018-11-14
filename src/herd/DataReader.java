/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;

import java.io.IOException;

/**
 *
 * @author jerensuzuki
 */
public interface DataReader {
    void load() throws IOException, ClassNotFoundException;
    
    public EventSystem getEventSystem();
    void save(EventSystem es);
}
