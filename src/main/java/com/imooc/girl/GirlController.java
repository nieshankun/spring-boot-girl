package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/girls")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping()
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping()
    public Girl addGirl(@RequestParam String cupSize, @RequestParam Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/{id}")
    public Girl getGirlById(@PathVariable Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/{id}")
    public Girl updateGirlById(@PathVariable Integer id, @RequestParam Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGirlById(@PathVariable Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/age")
    public List<Girl> getGirlByAge(@RequestParam Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping("/between")
    public List<Girl> getGirlListByAgeLimit(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return girlRepository.queryGirlsByAgeBetween(minAge, maxAge);
    }

    @PutMapping("/origin/{id}")
    public Girl updateGirl(@PathVariable Integer id,
                           @RequestParam(required = false) Integer age,
                           @RequestParam(required = false) String cupSize) {
        girlRepository.updateGirl(age, cupSize, id);
        return girlRepository.findOne(id);
    }

    @GetMapping("/criteria")
    public List<Girl> getGirlsByAgeAndCupSize(@RequestParam(required = false) Integer age,
                                              @RequestParam(required = false) String cupSize) {
        return girlRepository.getGirlsByAgeAndCupSize(age, cupSize);
    }

    @PostMapping("/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

}
