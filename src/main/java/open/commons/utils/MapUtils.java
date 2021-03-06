/*
 * Copyright 2011 Park Jun-Hong (parkjunhong77/google/com)
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
* This file is generated under this project, "open-commons-core".
*
* Date  : 2015. 1. 6. 오후 4:00:34
*
* Author: Park_Jun_Hong_(fafanmama_at_naver_com)
* 
*/

package open.commons.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

/**
 * 
 * @since 2015. 1. 6.
 * @author Park_Jun_Hong_(fafanmama_at_naver_com)
 */
public class MapUtils {

    @SuppressWarnings("rawtypes")
    public static void clear(Map... maps) {
        for (Map map : maps) {
            if (map != null) {
                map.clear();
            }
        }
    }

    /**
     * {@link Map}에서 주어진 <code>key</code>에 해당하는 값을 제공한다.<br>
     * 존재하지 않는 경우 기본값(<code>defaultValue</code>)을 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2020. 3. 29.     박준홍         최초 작성
     * </pre>
     *
     * @param <K>
     * @param <V>
     * @param map
     * @param key
     *            찾고자하는 데이터 키
     * @param defaultValue
     *            기본값
     * @param insertIfNot
     *            {@link Map}에 존재하지 않는 경우 추가할지 여부
     * @return
     *
     * @since 1.7.0
     * @since 2020. 10. 23.
     * @author Park_Jun_Hong_(fafanmama_at_naver_com)
     */
    public static <K, V> V getOrDefault(Map<K, V> map, K key, Supplier<V> defaultValue, boolean insertIfNot) {

        if (map.containsKey(key)) {
            return map.get(key);
        }

        V v = defaultValue.get();
        if (insertIfNot) {
            map.put(key, v);
        }

        return v;
    }

    /**
     * {@link Map}에서 주어진 <code>key</code>에 해당하는 값을 제공한다.<br>
     * 존재하지 않는 경우 기본값(<code>defaultValue</code>)을 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2020. 3. 29.     박준홍         최초 작성
     * </pre>
     *
     * @param <K>
     * @param <V>
     * @param map
     * @param key
     *            찾고자하는 데이터 키
     * @param defaultValue
     *            기본값
     * @param insertIfNot
     *            {@link Map}에 존재하지 않는 경우 추가할지 여부
     * @return
     *
     * @since v1.6.18
     * @since 2020. 3. 29.
     * @author Park_Jun_Hong_(fafanmama_at_naver_com)
     * 
     * @see Map#getOrDefault(Object, Object)
     */
    public static <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue, boolean insertIfNot) {
        V v = map.getOrDefault(key, defaultValue);

        if (!map.containsKey(key) && insertIfNot) {
            map.put(key, v);
        }

        return v;
    }

    /**
     * 주어진 {@link List}에서 정해진 개수만큼 데이터를 반환한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2017. 10. 18.        박준홍         최초 작성
     * </pre>
     *
     * @param map
     * @param readCount
     *            읽어올 개수
     * @return
     *
     * @author Park_Jun_Hong_(fafanmama_at_naver_com)
     * @since 2017. 10. 18.
     */
    public static <K, V> Map<K, V> read(Map<K, V> map, int readCount) {

        Map<K, V> read = new HashMap<>();

        // #1. 데이터의 개수가 읽어올 개수보다 작거나 같은 경우
        // 모든 데이터 읽은 후 데이터 삭제
        if (readCount >= map.size()) {
            read.putAll(map);
            map.clear();

            return read;
        }

        // 읽혀진 데이터 키 저장
        List<K> keys = new ArrayList<>();

        // #2. 정해진 개수만큼 데이터 읽기
        int i = 0;
        for (Entry<K, V> entry : map.entrySet()) {

            read.put(entry.getKey(), entry.getValue());
            keys.add(entry.getKey());

            i++;

            if (i >= readCount) {
                break;
            }
        }

        // #3. 읽혀진 데이터 삭제
        for (K key : keys) {
            map.remove(key);
        }

        return read;
    }
}
