<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
    <title>Salary Page</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
</head>

<style>
    .ta {
        overflow: hidden;
        babckground-color: #DDDDDD;
        position: absolute;
        height: 50px;
        left: 50%;
        margin-left: -500px;

    }
    body {
        position: relative;
    }
    .tr {
        height: 50px;

    }
    #salaryTableBody {

    }
    .th {
        padding-right: 50px;
    }
</style>


<body>
<h1>Salary Page</h1>

<table class="ta">
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_modal_btn">你add</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">delete</button>
        </div>
    </div>
    <thead >
    <tr class="tr">
        <th class="th">Employee ID</th>
        <th class="th">Basic Salary</th>
        <th class="th">Allowance</th>
        <th class="th">Bonus</th>
        <th class="th">Deductions</th>
        <th class="th">Net Salary</th>
        <th class="th">Pay Date</th>
    </tr>
    </thead>
    <tbody id="salaryTableBody">
    <!-- The table body will be populated dynamically with data from the backend -->
    </tbody>
</table>

<script type="text/javascript">
    // Use AJAX to send a GET request to the backend API and fetch the salary data
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/TalentoHR_war/salary/all", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Parse the JSON response
            var salaryData = JSON.parse(xhr.responseText);

            // Generate HTML for each salary record and append it to the table body
            var salaryTableBody = document.getElementById("salaryTableBody");
            for (var i = 0; i < salaryData.length; i++) {
                var salary = salaryData[i];
                var row = document.createElement("tr");

                // Create table cells and populate them with salary data
                var empIdCell = document.createElement("td");
                empIdCell.textContent = salary.empId;
                row.appendChild(empIdCell);

                var basicSalaryCell = document.createElement("td");
                basicSalaryCell.textContent = salary.basicSalary;
                row.appendChild(basicSalaryCell);

                var allowanceCell = document.createElement("td");
                allowanceCell.textContent = salary.allowance;
                row.appendChild(allowanceCell);

                var bonusCell = document.createElement("td");
                bonusCell.textContent = salary.bonus;
                row.appendChild(bonusCell);

                var deductionsCell = document.createElement("td");
                deductionsCell.textContent = salary.deductions;
                row.appendChild(deductionsCell);

                var netSalaryCell = document.createElement("td");
                netSalaryCell.textContent = salary.netSalary;
                row.appendChild(netSalaryCell);

                var payDateCell = document.createElement("td");
                var payDate = new Date(salary.payDate);
                var formattedPayDate = payDate.getFullYear() + "-" + (payDate.getMonth() + 1) + "-" + payDate.getDate();
                payDateCell.textContent = formattedPayDate;
                row.appendChild(payDateCell);

                // Append the row to the table body
                salaryTableBody.appendChild(row);
            }
        }
    };
    xhr.send();

</script>
</body>
</html>
