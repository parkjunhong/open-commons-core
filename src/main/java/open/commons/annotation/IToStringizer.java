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
* Date  : 2012. 11. 8. 오후 12:52:54
*
* Author: Park_Jun_Hong_(parkjunhong77@gmail.com)
*
*/
package open.commons.annotation;

public interface IToStringizer {

    String fieldToString(Object fieldValue);

    public static final class NullToStringizer implements IToStringizer {
        @Override
        public String fieldToString(Object fieldValue) {
            String toString = null;
            if (fieldValue != null) {
                toString = fieldValue.toString();
            }
            return toString;
        }
    }
}
