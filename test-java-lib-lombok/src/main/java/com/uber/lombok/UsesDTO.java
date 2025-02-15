/*
 * Copyright (c) 2020 Uber Technologies, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.uber.lombok;

import javax.annotation.Nullable;

class UsesDTO {

  public static LombokDTO getDTOInstance(@Nullable String s1, String s2) {
    return LombokDTO.builder().nullableField(s1).field(s2).build();
  }

  public static String foo(LombokDTO ldto) {
    String s = "";
    s += ldto.getField().toString();
    s += " ";
    // Removing this nullness check produces a NullAway error
    s += (ldto.getNullableField() == null ? "" : ldto.getNullableField().toString());
    return s;
  }

  public static boolean callEquals(LombokDTO ldto, @Nullable Object o) {
    // No error should be reported since equals() parameter should be treated as @Nullable
    return ldto.equals(o);
  }
}
