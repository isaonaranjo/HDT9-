/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 * Factory
 */
import java.util.PriorityQueue;

class Factory {

    // Constructor
    public Factory(){}
    Object Imp;

    public Object getImp(String imp) {
    // Opciones
        if(imp.equals("1"))
        {   
            Imp = new SplayTree<>();
        }else if (imp.equals("2")){
            Imp = new RedBlackBST<>();
        } 
        return Imp;
   }

}
