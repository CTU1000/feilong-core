/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.feilong.test.User;

import static com.feilong.core.bean.ConvertUtil.toEnumeration;

/**
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.8.5
 */
public class ValidatorData{

    public static Iterable<Object[]> buildData(){
        List<String> emptyList = new ArrayList<String>();
        Object[] nullOrEmptyElement = {
                                        null,
                                        "", //
                                        "   ",
                                        new ArrayList<String>(),
                                        new LinkedHashMap<String, String>(),
                                        // **********Array*********************************
                                        new String[] {},
                                        new Integer[][] {},
                                        new User[] {},
                                        new int[] {},
                                        new double[] {},
                                        new long[] {},
                                        new float[] {},
                                        new boolean[] {},
                                        new byte[] {},
                                        new char[] {},
                                        new short[] {},
                                        emptyList.iterator(),
                                        toEnumeration(emptyList),
                                        new Iterator<User>(){

                                            @Override
                                            public boolean hasNext(){
                                                return false;
                                            }

                                            @Override
                                            public User next(){
                                                return null;
                                            }

                                            @Override
                                            public void remove(){
                                            }
                                        }

        };

        Object[] notNullOrEmptyElement = {
                                           new Integer[] { 2 }, //
                                           new Long[] { 2L },
                                           new int[] { 1, 2 },
                                           new double[] { 1.2d },
                                           new long[] { 200L },
                                           new float[] { 5.8f },
                                           new boolean[] { true },
                                           new char[] { 'a' },
                                           new short[] { 5 } };
        return TestUtil.toDataList(nullOrEmptyElement, notNullOrEmptyElement);
    }

}
