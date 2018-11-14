/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;
import java.util.*;

import java.io.IOException;

/**
 *
 * @author jtbea
 */
public class HERD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        DataReader data = new FileDataReader();
        data.load();
        EventSystem es = data.getEventSystem();
        
        HERDLoginFrame hLogin = new HERDLoginFrame();
        
        //HERDFrame hFrame = new HERDFrame();
    }
    
}
