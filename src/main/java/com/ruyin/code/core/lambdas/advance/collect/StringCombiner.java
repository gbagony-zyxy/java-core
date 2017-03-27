package com.ruyin.code.core.lambdas.advance.collect;

/**
 * Created by ruyin on 2017/3/23.
 */
public final class StringCombiner {
    //分隔符
    private String delim;
    private String prefix;
    private String suffix;
    private StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        this.builder = new StringBuilder();
    }

   public StringCombiner add(String element){
        if(areAtStart())
            builder.append(prefix);
        else
            builder.append(delim);

        builder.append(element);
        return this;
   }

   private boolean areAtStart(){
       return builder.length() == 0;
   }

   public StringCombiner merge(StringCombiner other){
       if(other.builder.length() > 0){
           if(areAtStart())
               builder.append(prefix);
           else
               builder.append(delim);

           builder.append(other.builder,prefix.length(),other.builder.length());
       }
       return this;
   }

    @Override
    public String toString() {
    if(areAtStart()){
        builder.append(prefix);
    }
    builder.append(suffix);
    return builder.toString();
   }
}
