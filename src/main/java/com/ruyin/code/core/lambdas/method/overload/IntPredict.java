package com.ruyin.code.core.lambdas.method.overload;

/**
 * Created by ruyin on 2017/3/10.
 * 该类未继承Predicate,故在判断类型时无法确定哪种类型更匹配重载方法的参数，此时无法编译通过
 */
public interface IntPredict  {
    boolean test(int value);
}
