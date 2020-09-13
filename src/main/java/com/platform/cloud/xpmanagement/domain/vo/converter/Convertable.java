package com.platform.cloud.xpmanagement.domain.vo.converter;

public interface Convertable<SOURCE, TARGET> {

    TARGET convertToTarget(SOURCE source);

}
