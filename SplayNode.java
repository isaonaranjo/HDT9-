/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 * Obtenido de: https://www.sanfoundry.com/java-program-implement-splay-tree/
 */

 class SplayNode<E>
 {    
     SplayNode<E> left, right, parent;
     protected Asociacion <String,String> element;
 
     // Constructor
     public SplayNode()
     {
         this(null, null, null, null);
     }          
     
     // Constructor
     public SplayNode(Asociacion<String,String> ele)
     {
         this(ele, null, null, null);
     } 
     
    // Constructor
     public SplayNode(Asociacion<String,String> ele, SplayNode left, SplayNode right, SplayNode parent) {
         this.left = left;
         this.right = right;
         this.parent = parent;
         this.element = ele;                  
     }    
     
     public String getKey(){
         return element.key;
     }
     
     public String getValue(){
         return element.value;
     }
     
 }
