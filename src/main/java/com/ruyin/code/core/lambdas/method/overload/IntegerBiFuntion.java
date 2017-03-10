package com.ruyin.code.core.lambdas.method.overload;

import java.util.function.BinaryOperator;

/**
 * Created by ruyin on 2017/3/10.
 * IntegerBiFuntion是相对于BinaryOperator更具体的类型，javac在重载判断类型时会优先选择该类
 */
public interface IntegerBiFuntion extends BinaryOperator<Integer>{


}
