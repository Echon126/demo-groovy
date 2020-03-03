package com.example.demo.interfaces;

public abstract class TcCommonService<T> {

    //大回路比较
    public abstract void largeLoopCompare(T t);


    //遥测参数比对
    public abstract void tmArgumengCompare(T t);


    //小环比对
    public abstract void littleRingCompare(T t);


    //应答
    public abstract void responseCompare(T t);
}
