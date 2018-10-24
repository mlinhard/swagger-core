package io.swagger.v3.core.util.reflection.resources2;


public class ClassB extends ClassC implements IFaceD {

    @Override
    public Integer dostuff(Integer a1, Integer a2) {
        return a1 + a2;
    }
}
