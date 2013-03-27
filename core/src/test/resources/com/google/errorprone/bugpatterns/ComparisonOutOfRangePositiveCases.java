/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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

package com.google.errorprone.bugpatterns;

import java.io.IOException;
import java.io.Reader;

/**
 * @author  Bill Pugh (bill.pugh@gmail.com)
 */
public class ComparisonOutOfRangePositiveCases {

  public boolean testByteEquality(byte[] b, byte x) {

    //BUG: Suggestion includes "x == -1"
    if (x == 255)
      return true;
    //BUG: Suggestion includes "x == 1"
    if (x == -255)
      return true;
    //BUG: Suggestion includes "x == -128"
    if (x == 128)
      return true;
    //BUG: Suggestion includes "x != -1"
    if (x != 255)
      return true;

    //BUG: Suggestion includes "b[0] == -1"
    if (b[0] == 255)
      return true;
    //BUG: Suggestion includes "b[0] == -128"
    if (b[0] == 128)
      return true;
    //BUG: Suggestion includes "b[0] == 1"
    if (b[0] == -255)
      return true;

    return false;
  }
  
  public boolean testCharEquality(char c, Reader r) throws IOException {
    //BUG: Suggestion includes "false"
    if (c == -1) {
      return true;
    }

    char d;
    //BUG: Suggestion includes "false"
    if ((d = (char) r.read()) == -1) {
      return true;
    }

    return false;
  }
}

