package com.asimgasimzade.check24challenge.framework.di

interface DependencyProvider<INSTANCE_TYPE> {
    fun getInstance(): INSTANCE_TYPE
}
