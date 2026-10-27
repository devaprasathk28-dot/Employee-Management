<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Management</title>
    <style>
        body { margin: 0; font-family: Arial, sans-serif; color: #172033; background: #f1f5f9; }
        header { padding: 18px 7%; background: #123b73; color: white; font-weight: 700; }
        main { max-width: 900px; margin: 32px auto; padding: 0 18px; }
        section { background: white; padding: 26px; border-radius: 12px; margin-bottom: 22px; }
        label { display: block; font-weight: 600; margin: 12px 0 7px; }
        input { width: 100%; max-width: 420px; padding: 10px; border: 1px solid #cbd5e1; border-radius: 6px; }
        button { margin-top: 18px; padding: 10px 16px; border: 0; border-radius: 6px; background: #2563eb; color: white; cursor: pointer; }
        .error { color: #b91c1c; }
        table { width: 100%; border-collapse: collapse; }
        th, td { text-align: left; padding: 10px; border-bottom: 1px solid #e2e8f0; }
    </style>
</head>
<body>
<header>Employee Management</header>
<main>
    <section>
        <h1>Employee Management</h1>
        <c:if test="${not empty error}"><p class="error"><c:out value="${error}"/></p></c:if>
        <form action="${pageContext.request.contextPath}/employees" method="post">
            <label for="name">Name</label>
            <input id="name" name="name" required value="<c:out value='${name}'/>">
            <label for="department">Department</label>
            <input id="department" name="department" required value="<c:out value='${department}'/>">
            <br><button type="submit">Add Employee</button>
        </form>
    </section>
    <section>
        <h2>Employees</h2>
        <table>
            <tr><th>Name</th><th>Department</th></tr>
            <c:forEach var="employee" items="${employees}">
                <tr><td><c:out value="${employee.name}"/></td><td><c:out value="${employee.department}"/></td></tr>
            </c:forEach>
        </table>
    </section>
</main>
</body>
</html>
