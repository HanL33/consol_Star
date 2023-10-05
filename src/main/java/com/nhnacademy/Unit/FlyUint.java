package com.nhnacademy.Unit;

public interface FlyUint {
    default boolean fly(Species s){
        if(s instanceof FlyUint){
            return true;
        }
        return false;
    }
}
