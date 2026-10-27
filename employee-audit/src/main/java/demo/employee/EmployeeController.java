package demo.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String department,
                              Model model) {
        try {
            employeeService.addEmployee(name, department);
            return "redirect:/";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("name", name);
            model.addAttribute("department", department);
            model.addAttribute("employees", employeeService.getAllEmployees());
            return "employees";
        }
    }
}
