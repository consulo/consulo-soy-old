/*
 * Copyright 2010 - 2013 Ed Venaglia
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.venaglia.nondairy.soylang.lexer.cupparser.structure.expr;

/**
 * Created by IntelliJ IDEA.
 * User: ed
 * Date: Jul 23, 2010
 * Time: 10:12:43 PM
 */
public class NullCoalescingExpression<T> implements Expression {

    private final Expression value;
    private final Expression ifNull;

    public NullCoalescingExpression(Expression value, Expression ifNull) {
        this.value = value;
        this.ifNull = ifNull;
    }

    public Expression getValue() {
        return value;
    }

    public Expression getIfNull() {
        return ifNull;
    }


    public <T> T getValue(Class<T> conversion) {
        return null;
    }
}
