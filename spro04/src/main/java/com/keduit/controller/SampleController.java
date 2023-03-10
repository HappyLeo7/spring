package com.keduit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keduit.domain.SampleVO;
import com.keduit.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

      @GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
      public String getText() {
         log.info("Mime Type : " + MediaType.TEXT_PLAIN_VALUE);
         return "안녕하세요";
      }
      
      
      
      /* mediaTyep.APPLICATION_[sample]_VALUE 
          보여주는 파일 형식이 달라짐. */ 
      @GetMapping(value = "/getSample",
         produces= {MediaType.APPLICATION_JSON_VALUE, 
                  MediaType.APPLICATION_XML_VALUE})
      public SampleVO getSample() {
         return new SampleVO(555, "홍", "길동");
      }
      
      @GetMapping(value = "/getSample2")
      public SampleVO getSample2() {
         return new SampleVO(664, "김", "자바");
      }
      
      // mapToObj 중간 연산 ~ collect 최종 연산
      @GetMapping("/getlist")
      public List<SampleVO> getList() {
         return IntStream.range(1, 10)
                     .mapToObj(i -> new SampleVO(i, i+"First", i+"Last"))
                     .collect(Collectors.toList());
      }
      
      @GetMapping("/getmap")
      public Map<String, SampleVO> getMap(){
         Map<String, SampleVO> map = new HashMap<>();
         map.put("First", new SampleVO(567, "나는야 퉁퉁이", "골목대장이라네"));
         
         return map;
      }
      
      //   height가 151이상일시 BAD, 150이하일시 OK
      @GetMapping(value="/check", params= {"height", "weight"})
      public ResponseEntity<SampleVO> check(Double height, Double weight){
         SampleVO vo = new SampleVO(0, "" + height, "" + weight);
         ResponseEntity <SampleVO> result = null;
         
         if(height > 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
         } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
         }
         return result;
      }
      
      @GetMapping("/product/{cat}/{pid}")
      public String[] getPath(
            @PathVariable("cat") 
            String cat,
            @PathVariable("pid") 
            Integer pid) {
         
         return new String[] {"category : " + cat, "productid : " + pid};   
      }
      
		
		 @PostMapping("/ticket") 
		 public Ticket convert(@RequestBody Ticket ticket) {
		  log.info(".......... convert .......... ticket -->" + ticket); return ticket;
		 }
		 

}