package com.softwareacademy.projet9_front.proxies;

import org.springframework.cloud.openfeign.FeignClient;

    @FeignClient(name = "mediscreen-sprint-2", url = "localhost:8082")
    public interface Sprint2Proxy {

    }
