/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package art;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Test907 {
  public static void run() throws Exception {
    doTest();
  }

  public static void doTest() throws Exception {
    // Ensure some classes are loaded.
    A a = new A();
    B b = new B();
    A[] aArray = new A[5];

    String[] classes = getLoadedClasses();
    HashSet<String> classesSet = new HashSet<>(Arrays.asList(classes));

    String[] shouldBeLoaded = new String[] {
        "java.lang.Object", "java.lang.Class", "java.lang.String", "art.Test907$A",
        "art.Test907$B", "[Lart.Test907$A;"
    };

    boolean error = false;
    for (String s : shouldBeLoaded) {
      if (!classesSet.contains(s)) {
        System.out.println("Did not find " + s);
        error = true;
      }
    }

    if (error) {
      System.out.println(Arrays.toString(classes));
    }
  }

  static class A {
  }

  static class B {
  }

  private static native String[] getLoadedClasses();
}
