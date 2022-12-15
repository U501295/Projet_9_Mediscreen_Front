package com.softwareacademy.projet9_front.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "mediscreen-sprint-1", url = "localhost:8081")
public interface Sprint1Proxy {


}
