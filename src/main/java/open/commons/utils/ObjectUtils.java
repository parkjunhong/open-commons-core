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
 * Date  : 2018. 1. 31. 오후 1:39:21
 *
 * Author: Park_Jun_Hong_(fafanmama_at_naver_com)
 * 
 */

package open.commons.utils;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import open.commons.annotation.Getter;
import open.commons.annotation.Setter;

/**
 * Object 타입의 데이터 처리를 지원하는 유틸리티 클래스.
 * 
 * @since 2018. 1. 31.
 * @author Park_Jun_Hong_(fafanmama_at_naver_com)
 */
public class ObjectUtils {

    private static final Function<Object, Short> shortFunction = o -> Short.parseShort(o.toString());
    private static final Function<Object, Byte> byteFunction = o -> Byte.parseByte(o.toString());
    private static final Function<Object, Integer> intFunction = o -> Integer.parseInt(o.toString());
    private static final Function<Object, Long> longFunction = o -> Long.parseLong(o.toString());
    private static final Function<Object, Float> floatFunction = o -> Float.parseFloat(o.toString());
    private static final Function<Object, Double> doubleFunction = o -> Double.parseDouble(o.toString());
    private static final Function<Object, Boolean> booleanFunction = o -> Boolean.parseBoolean(o.toString());
    private static final Function<Object, String> strFunction = o -> o.toString();

    // Prevent to create a new instance.
    private ObjectUtils() {
    }

    /**
     * 
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @param function
     * @return
     * @throws UnsupportedOperationException
     * @throws IllegalAccessException
     * @throws InstantiationException
     *
     * @since 2018. 1. 31.
     */
    private static <C extends Collection<Object>, T, R extends Collection<T>> R to(C objects, Class<R> classType, Function<Object, T> function)
            throws UnsupportedOperationException, InstantiationException, IllegalAccessException {

        if (classType.isInterface()) {
            throw new UnsupportedOperationException(
                    "Only support a class type not interface type!!! at " + Number.class.getName() + "." + ThreadUtils.getCurrentMethodName() + "()");
        }

        R r = classType.newInstance();

        if (objects.size() < 1) {
            return r;
        }

        objects.forEach(o -> r.add(function.apply(o)));

        return r;
    }

    /**
     * Object Type {@link Collection}을 Boolean Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Boolean>> R toBoolean(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, booleanFunction);
    }

    /**
     * Object Type {@link Collection}을 Double Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Byte>> R toByte(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, byteFunction);
    }

    /**
     * Object Type {@link Collection}을 Double Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Double>> R toDouble(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, doubleFunction);
    }

    /**
     * Object Type {@link Collection}을 Float Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Float>> R toFloat(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, floatFunction);
    }

    /**
     * Object Type {@link Collection}을 Integer Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Integer>> R toInteger(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, intFunction);
    }

    /**
     * Object Type {@link Collection}을 Long Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Long>> R toLong(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, longFunction);
    }

    /**
     * Object Type {@link Collection}을 Double Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws NullPointerException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<Short>> R toShort(C objects, Class<? extends R> classType)
            throws NullPointerException, UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, shortFunction);
    }

    /**
     * Object Type {@link Collection}을 String Type {@link Collection}으로 변환한여 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2018. 1. 31.     박준홍         최초 작성
     * </pre>
     *
     * @param objects
     * @param classType
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedOperationException
     *
     * @since 2018. 1. 31.
     */
    public static <C extends Collection<Object>, R extends Collection<String>> R toString(C objects, Class<? extends R> classType)
            throws UnsupportedOperationException, InstantiationException, IllegalAccessException {
        return to(objects, classType, strFunction);
    }

    /**
     * {@link Getter}, {@link Setter} 어노테이션이 적용된 객체를 변환하여 새로운 타입의 객체로 제공한다. <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜      | 작성자   |   내용
     * ------------------------------------------
     * 2019. 6. 20.     박준홍         최초 작성
     * </pre>
     *
     * @param src
     *            입력 데이타
     * @param targetType
     *            변환 타입
     * @return
     *
     * @since 2019. 6. 20.
     * @version
     * @author Park_Jun_Hong_(fafanmama_at_naver_com)
     * 
     * @see Getter
     * @see Setter
     */
    public static <S, D> D transform(S src, Class<D> targetType) {
        AssertUtils.assertNulls("'source' object or 'target' type MUST NOT be null !!!", IllegalArgumentException.class, src, targetType);

        List<Method> getters = AnnotationUtils.getAnnotatedMethods(src, Getter.class);
        if (getters.size() < 1) {
            return null;
        }

        List<Method> setters = AnnotationUtils.getAnnotatedMethods(targetType, Setter.class);
        if (setters.size() < 1) {
            try {
                return targetType.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        // #0. Setter 메소드 재정렬
        final Map<String, Method> setterMap = CollectionUtils.toMapHSV(setters, m -> {
            Setter annoSetter = m.getAnnotation(Setter.class);
            return String.join("-", annoSetter.name(), annoSetter.type().toString());
        }, m -> m);

        final Function<Method, String> GetterKeyGen = m -> {
            Getter annoGetter = m.getAnnotation(Getter.class);
            return String.join("-", annoGetter.name(), annoGetter.type().toString());
        };

        // #1. Setter와 동일한 식별정보를 갖는 Getter 추출
        List<Method> gettersFiltered = getters.stream().filter(m -> {
            return setterMap.containsKey(GetterKeyGen.apply(m));
        }).collect(Collectors.toList());

        // #2. Setter와 연결되는 Getter 메소드 재정렬
        Map<String, Method> getterMap = CollectionUtils.toMapHSV(gettersFiltered //
                , m -> {
                    Getter annoGetter = m.getAnnotation(Getter.class);
                    return String.join("-", annoGetter.name(), annoGetter.type().toString());
                }, m -> m);

        // #3. 객체 생성
        D target = null;
        try {
            target = targetType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }

        for (Entry<String, Method> entry : setterMap.entrySet()) {
            try {
                entry.getValue().invoke(target, getterMap.get(entry.getKey()).invoke(src));
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        return target;
    }
}
