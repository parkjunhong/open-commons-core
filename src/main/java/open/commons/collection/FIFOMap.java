/*
 * Copyright 2011 Park Jun-Hong (parkjunhong77@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
* 
* 
* This file is generated under this project, "open-commons-core".
*
* Date  : 2012. 11. 6. 오후 4:35:32
*
* Author: Park_Jun_Hong_(parkjunhong77@gmail.com)
*
*/
package open.commons.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 입력된 순서대로 정렬되는 {@link Map}
 * 
 * @author Park_Jun_Hong_(parkjunhong77@gmail.com)
 * 
 * @param <K>
 * @param <V>
 */
public class FIFOMap<K, V> implements Map<K, V> {

    private AtomicInteger seqSeed = new AtomicInteger();

    private Map<K, Integer> keys = new HashMap<K, Integer>();

    /** ordered keys */
    private TreeMap<Integer, K> orderedKeys = new TreeMap<Integer, K>();

    /** ordered values */
    private TreeMap<Integer, V> orderedValues = new TreeMap<Integer, V>();

    public Entry<K, V> atFirst() {
        Iterator<Entry<K, V>> itr = entrySet().iterator();

        return itr.hasNext() ? itr.next() : null;
    }

    /**
     * 
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2021. 5. 18.		박준홍			데이터({@link #orderedValues}) 미삭제 버그 수정
     * </pre>
     *
     *
     * @since 2021. 5. 18.
     * @author Park_Jun_Hong_(parkjunhong77@gmail.com)
     *
     * @see java.util.Map#clear()
     */
    @Override
    public synchronized void clear() {
        seqSeed.set(0);
        keys.clear();
        orderedKeys.clear();
        orderedValues.clear();
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        return orderedKeys.containsValue(key);
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        return orderedValues.containsValue(value);
    }

    @Override
    public synchronized Set<Map.Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new FIFOSet<Map.Entry<K, V>>();

        K key = null;
        V value = null;
        for (Entry<Integer, K> keyEntry : orderedKeys.entrySet()) {
            key = keyEntry.getValue();
            value = orderedValues.get(keyEntry.getKey());

            entrySet.add(new FIFOEntry(key, value));
        }

        return entrySet;
    }

    @Override
    public synchronized V get(Object key) {
        Integer sequence = keys.get(key);

        return sequence != null ? orderedValues.get(sequence) : null;
    }

    @Override
    public synchronized boolean isEmpty() {
        return orderedKeys.isEmpty();
    }

    @Override
    public synchronized Set<K> keySet() {
        Set<K> keySet = new FIFOSet<K>();

        keySet.addAll(orderedKeys.values());

        return keySet;
    }

    @Override
    public synchronized V put(K key, V value) {
        V oldValue = null;

        if (key != null) {
            Integer sequence = null;
            if (keys.containsKey(key)) {
                sequence = keys.get(key);
                oldValue = orderedValues.put(sequence, value);
            } else {
                try {
                    sequence = seqSeed.getAndIncrement();

                    keys.put(key, sequence);
                    orderedKeys.put(sequence, key);
                    oldValue = orderedValues.put(sequence, value);
                } catch (Exception e) {
                    if (sequence != null) {
                        seqSeed.set(sequence);
                    }
                }
            }
        }

        return oldValue;
    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> m) {
        if (m != null) {
            for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public synchronized V remove(Object key) {
        V value = null;

        if (key != null) {
            Integer sequence = keys.remove(key);

            if (sequence != null) {
                orderedKeys.remove(sequence);
                value = orderedValues.remove(sequence);
            }
        }

        return value;
    }

    @Override
    public synchronized int size() {
        return orderedKeys.size();
    }

    @Override
    public String toString() {
        Iterator<Entry<K, V>> itr = entrySet().iterator();

        if (!itr.hasNext()) {
            return "{}";
        }

        StringBuffer sb = new StringBuffer();
        sb.append('{');

        Entry<K, V> entry = null;
        K key = null;
        V value = null;
        do {
            entry = itr.next();
            key = entry.getKey();
            value = entry.getValue();

            sb.append(key == this ? "(this Map)" : key);
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value);

            if (itr.hasNext()) {
                sb.append(',');
                sb.append(' ');
            } else {
                break;
            }
        } while (true);

        sb.append('}');

        return sb.toString();
    }

    @Override
    public synchronized Collection<V> values() {
        return orderedValues.values();
    }

    public class FIFOEntry implements Entry<K, V> {

        private K key;

        private V value;

        private FIFOEntry(K k) {
            this.key = k;
        }

        private FIFOEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

    }
}
