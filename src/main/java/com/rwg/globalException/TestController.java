package com.rwg.globalException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renwg
 * @date 2022/11/18
 */
@RestController
@RequestMapping("exception")
public class TestController {

    @GetMapping("test")
    public void testGlobalException() {
        throw new BusinessException(ErrorEnum.NO_PERMISSION.getErrorCode(), ErrorEnum.NO_PERMISSION.getErrorMsg());
    }
}
