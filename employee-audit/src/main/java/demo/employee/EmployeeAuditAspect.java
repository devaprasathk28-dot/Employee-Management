package demo.employee;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAuditAspect {
    @Before("execution(* demo.employee.EmployeeService.*(..))")
    public void beforeServiceCall(JoinPoint joinPoint) {
        System.out.println("[AUDIT] Calling " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* demo.employee.EmployeeService.*(..))")
    public void afterServiceCall(JoinPoint joinPoint) {
        System.out.println("[AUDIT] Completed " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* demo.employee.EmployeeService.*(..))", throwing = "ex")
    public void serviceFailed(JoinPoint joinPoint, Throwable ex) {
        System.out.println("[AUDIT] Failed " + joinPoint.getSignature().getName() + ": " + ex.getMessage());
    }
}
