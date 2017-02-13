package com.hucet.userservice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu on 2017-02-11.
 */
@RestController
@Validated
public class DuplicateController {
//    @Autowired
//    AccountStreamService userService;
//
//    // {:.+} email format xx@xxx.com (dot .) truncate
//    @RequestMapping(value = "/check-email/{userEmail:.+}", method = RequestMethod.HEAD)
//    ResponseEntity<Void> duplicatedUserEmail(
//            @PathVariable("userEmail")
//            @Email
//            @NotEmpty
//                    String userEmail) {
//        if (!userService.duplicatedUserEmail(userEmail)) {
//            return new ResponseEntity<Void>(HttpStatus.OK);
//        } else {
//            throw new DuplicatedFieldException("동일한 UserEmail이 존재합니다.");
//        }
//    }
//
//    @RequestMapping(value = "/check-username/{userName}", method = RequestMethod.GET)
//    ResponseEntity<Void> duplicatedUserName(
//            @PathVariable
//            @NotEmpty
//                    String userName) {
//        if (!userService.duplicatedUserName(userName)) {
//            return new ResponseEntity<Void>(HttpStatus.OK);
//        } else {
//            throw new DuplicatedFieldException("동일한 UserName이 존재합니다.");
//        }
//    }
//
//    @ExceptionHandler(value = {ConstraintViolationException.class})
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public String pathVariableExceptionHandler(ConstraintViolationException e) {
//        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//        StringBuilder strBuilder = new StringBuilder();
//        for (ConstraintViolation<?> violation : violations) {
//            strBuilder.append(violation.getMessage() + "\n");
//        }
//        return strBuilder.toString();
//    }
//
//    // PathVariable 의 Validation을 체크하기 위하여 선언
//    @Configuration
//    public static class PathVariableValidationForBean {
//        @Bean
//        public MethodValidationPostProcessor methodValidationPostProcessorBean() {
//            return new MethodValidationPostProcessor();
//        }
//    }
}
