/*
 * Copyright 2019 Park Jun-Hong_(parkjunhong77@gmail.com)
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
 * Date  : 2019. 6. 20. 오후 6:06:16
 *
 * Author: Park_Jun_Hong_(parkjunhong77@gmail.com)
 * 
 */

package open.commons.core.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 데이터를 제공하는 대상을 기술하며, 데이터를 제공하는 타입에 설정합니다.
 * 
 * @since 2019. 6. 20.
 * @author Park_Jun_Hong_(parkjunhong77@gmail.com)
 * 
 * @see Setter
 */
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Getter {

    /** 데이터 이름 */
    String name() default "";

    /** 데이터 타입 */
    Class<?> type();
}