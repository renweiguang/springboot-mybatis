package com.rwg.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.rwg.service.RepairCreatePostConsumer;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rwg
 * @date 2021/9/7 9:43
 */

@RestController
@RequestMapping(value = "/pc/api/v1/monitor")
@RequiredArgsConstructor
public class AfterRepairConsumer {

    private final List<RepairCreatePostConsumer> postConsumers;

    @GetMapping(value = "/create")
    public String create() {
        final String repairId = "1";

        if (CollectionUtil.isNotEmpty(postConsumers)) {
            postConsumers.forEach(e -> e.postHandler(repairId));
        }

        return "success";
    }

}
