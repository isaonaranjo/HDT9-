/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 * Clase association
 */
import java.util.Map;

public class Association<K,V> implements Map.Entry<K,V>{

    protected K key;
    protected V value;


    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Association(K llave) {
        this(llave, null);
    }
    
    @Override
    public boolean equals (Object objeto) {
        Association otroObjeto = (Association)objeto;
        return getKey().equals(otroObjeto.getKey());
    }

    @Override
    public V getValue() {
        return value;
    }


    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V setValue(V nuevoValor) {
        V valorViejo = value;
        value = nuevoValor;
        return valorViejo;
    }



}
