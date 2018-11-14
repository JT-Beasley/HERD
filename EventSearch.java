/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herd;
import java.util.*;

/**
 *
 * @author Emily
 */
public interface EventSearch {
    
    ArrayList<Events> search(ArrayList<Events> events, Users user);
    
}
