package com.imooc.girl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author nsk
 * 2018/6/25 21:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GirlApplication.class)
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void insertTwo() throws Exception {
        girlService.insertTwo();
        System.out.println("11111111111");
    }

    @Test
    public void getIdById(){
        Integer id = 10;
        Girl girl = girlService.getGirlById(id);
        assertEquals(girl.getId(),id);
        System.out.println(girl.getCupSize());
    }

}