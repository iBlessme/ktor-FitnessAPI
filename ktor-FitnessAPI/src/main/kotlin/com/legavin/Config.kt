package com.legavin

interface EntityWithModel<T>{
    fun toModel(): T
}