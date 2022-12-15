package com.softwareacademy.projet9_front.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mediscreen-sprint-3", url = "localhost:8083")
public interface Sprint3Proxy {

}
