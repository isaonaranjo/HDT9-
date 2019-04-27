/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 */
import java.util.Map;
public class Asociacion<K,V> implements Map.Entry<K,V>{

    protected K key;
    protected V valor;

    // Constructor
    public Asociacion(K key, V valor) {
        this.key = key;
        this.valor = valor;
    }

    //Se crea a partir de una llave proporcionada
    public Asociacion(K key)
    {
        this(key, null);
    }

    //obtiene el valor
    @Override
    public V getValue()
    {
        return valor;
    }

    //Función que sirve para comparar objetos
    @Override
    public boolean equals (Object objeto) {
        Asociacion objetoNuevo = (Asociacion) objeto;
        return getKey().equals(objetoNuevo.getKey());
    }

    //obtiene la llave
    @Override
    public K getKey()
    {
        return key;
    }

    //Realiza un set para un nuevo valor de un Objeto
    @Override
    public V setValue(V nuevoValor) {
        V oldV = valor;
        valor = nuevoValor;
        return oldV;
    }


}
