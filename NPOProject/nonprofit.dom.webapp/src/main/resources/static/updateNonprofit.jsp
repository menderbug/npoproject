<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="js/rest.js"></script>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
<title>Update Nonprofit</title>
</head>
<body>
    <div style="padding-left:50px;font-family:monospace;">
        <h2>Update User</h2>
        <form id="updateForm">
            <div style="width: 100px; text-align:left;">
                <div style="padding:15px;">
                    Nonprofit ID: <input name="NonprofitID" />
                </div>
                <div style="padding:10px;">
                    Name: <input name="npoName" />
                </div>
                <div style="padding:10px;">
                    npoAddress: <input name="npoAddress" />
                </div>
                <div style="padding:10px;">
                    npoEmail: <input name="npoEmail" />
                </div>
                <div style="padding:20px;text-align:center">
                    <input type="submit" value="Submit" />
                </div>
            </div>
        </form>
    </div>
</body>
</html>