<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="js/rest.js"></script>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
<title>Update Expense</title>
</head>
<body>
    <div style="padding-left:50px;font-family:monospace;">
        <h2>Update User</h2>
        <form id="updateForm">
            <div style="width: 100px; text-align:left;">
                <div style="padding:15px;">
                    Expense ID: <input name="ExpenseID" />
                </div>
                <div style="padding:10px;">
                    Nonprofit ID: <input name="NonprofitID" />
                </div>
                <div style="padding:10px;">
                    Year: <input name="year" />
                </div>
                <div style="padding:10px;">
                    month: <input name="month" />
                </div>
                <div style="padding:10px;">
                    day: <input name="day" />
                </div>
                <div style="padding:10px;">
                    type: <input name="type" />
                </div>
                <div style="padding:10px;">
                    amount: <input name="amount" />
                </div>
                <div style="padding:20px;text-align:center">
                    <input type="submit" value="Submit" />
                </div>
            </div>
        </form>
    </div>
</body>
</html>