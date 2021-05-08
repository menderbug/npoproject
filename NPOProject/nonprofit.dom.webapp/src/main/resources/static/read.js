$(document).ready(function () {
 
$("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/Nonprofit',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var Nonprofit="";
            $(xml).find('Nonprofit').each(function(){
                $(this).find("NonprofitID").each(function(){
                    var NonprofitID = $(this).text();
                    console.log(NonprofitID);
                    Nonprofit = Nonprofit + " ID: " + NonprofitID;
                });
                $(this).find("npoName").each(function(){
                    var npoName = $(this).text();
                    console.log(npoName);
                    Nonprofit = Nonprofit + " npoName: " + npoName;
                });
                $(this).find("npoAddress").each(function(){
                    var npoAddress = $(this).text();
                    console.log(npoAddress);
                    Nonprofit = Nonprofit + " npoAddress: " + npoAddress; 
                });
                $(this).find("npoEmail").each(function(){
                	var npoEmail = $(this).text();
                	console.log(npoEmail);
                	Nonprofit = Nonprofit + " npoEmail: " + npoEmail; 
                });
            });
            alert(Nonprofit);
        }
    });
   return true;
 })
 
 $("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/Donor',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var Donor="";
            $(xml).find('Donor').each(function(){
                $(this).find("DonorID").each(function(){
                    var DonorID = $(this).text();
                    console.log(DonorID);
                    Donor = Donor + " DonorID: " + DonorID;
                });
                $(this).find("donorName").each(function(){
                    var donorName = $(this).text();
                    console.log(donorName);
                    Donor = Donor + " donorName: " + donorName;
                });
                $(this).find("donorAddress").each(function(){
                    var donorAddress = $(this).text();
                    console.log(donorAddress);
                    Donor = Donor + " donorAddress: " + donorAddress; 
                });
                $(this).find("donorEmail").each(function(){
                	var donorEmail = $(this).text();
                	console.log(donorEmail);
                	Donor = Donor + " donorEmail: " + donorEmail; 
                });
            });
            alert(Donor);
        }
    });
   return true;
 })
 
 $("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/Employee',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var Employee="";
            $(xml).find('Employee').each(function(){
                $(this).find("empID").each(function(){
                    var empID = $(this).text();
                    console.log(empID);
                    Employee = Employee + " empID: " + empID; 
                });
                $(this).find("NonprofitID").each(function(){
                    var NonprofitID = $(this).text();
                    console.log(NonprofitID);
                    Employee = Employee + " npoID: " + NonprofitID;
                });
                $(this).find("deptName").each(function(){
                    var deptName = $(this).text();
                    console.log(deptName);
                    Employee = Employee + " deptName: " + deptName;
                });
                $(this).find("empName").each(function(){
                    var empName = $(this).text();
                    console.log(empName);
                    Employee = Employee + " empName: " + empName;
                });
                $(this).find("empGender").each(function(){
                    var empGender = $(this).text();
                    console.log(empGender);
                    Employee = Employee + " empGender: " + empGender;
                });
                $(this).find("empAddress").each(function(){
                    var empAddress = $(this).text();
                    console.log(empAddress);
                    Employee = Employee + " empAddress: " + empAddress; 
                });
                $(this).find("phoneNumber").each(function(){
                    var phoneNumber = $(this).text();
                    console.log(phoneNumber);
                    Employee = Employee + " phoneNumber: " + phoneNumber;
                });
                $(this).find("empEmail").each(function(){
                	var empEmail = $(this).text();
                	console.log(empEmail);
                	Employee = Employee + " empEmail: " + empEmail; 
                });
                $(this).find("salary").each(function(){
                    var salary = $(this).text();
                    console.log(salary);
                    Employee = Employee + " salary: " + salary;
                });
            });
            alert(Employee);
        }
    });
   return true;
 })
 
 $("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/Expense',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var Expense="";
            $(xml).find('Expense').each(function(){
                $(this).find("expID").each(function(){
                    var expID = $(this).text();
                    console.log(expID);
                    Expense = Expense + " expID: " + expID; 
                });
                $(this).find("NonprofitID").each(function(){
                    var NonprofitID = $(this).text();
                    console.log(NonprofitID);
                    Expense = Expense + " npoID: " + NonprofitID;
                });
                $(this).find("year").each(function(){
                    var year = $(this).text();
                    console.log(year);
                    Expense = Expense + " year: " + year; 
                });
                $(this).find("month").each(function(){
                    var month = $(this).text();
                    console.log(month);
                    Expense = Expense + " month: " + month; 
                });
                $(this).find("day").each(function(){
                    var day = $(this).text();
                    console.log(day);
                    Expense = Expense + " day: " + day; 
                });
                $(this).find("type").each(function(){
                    var type = $(this).text();
                    console.log(type);
                    Expense = Expense + " type: " + type; 
                });
                $(this).find("amount").each(function(){
                    var amount = $(this).text();
                    console.log(amount);
                    Expense = Expense + " amount: " + amount; 
                });
            });
            alert(Expense);
        }
    });
   return true;
 })
 
 $("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/Department',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var Department="";
            $(xml).find('Department').each(function(){
                $(this).find("deptName").each(function(){
                    var deptName = $(this).text();
                    console.log(deptName);
                    Department = Department + " deptName: " + deptName; 
                });
                $(this).find("director").each(function(){
                    var director = $(this).text();
                    console.log(director);
                    Department = Department + " director: " + director; 
                });
                $(this).find("budget").each(function(){
                    var budget = $(this).text();
                    console.log(budget);
                    Department = Department + " budget: " + budget; 
                });
                $(this).find("NonprofitID").each(function(){
                    var NonprofitID = $(this).text();
                    console.log(NonprofitID);
                    Department = Department + " npoID: " + NonprofitID;
                });
            });
            alert(Department);
        }
    });
   return true;
 })
 
  $("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/Volunteer',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var Volunteer="";
            $(xml).find('Volunteer').each(function(){
                $(this).find("volID").each(function(){
                    var volID = $(this).text();
                    console.log(volID);
                    Volunteer = Volunteer + " volID: " + volID
                });
                $(this).find("NonprofitID").each(function(){
                    var NonprofitID = $(this).text();
                    console.log(NonprofitID);
                    Volunteer = Volunteer + " npoID: " + NonprofitID
                });
                $(this).find("deptName").each(function(){
                    var deptName = $(this).text();
                    console.log(deptName);
                    Volunteer = Volunteer + " deptName: " + deptName;
                });
                $(this).find("volName").each(function(){
                    var volName = $(this).text();
                    console.log(volName);
                    Volunteer = Volunteer + " volName: " + volName;
                });
                $(this).find("volGender").each(function(){
                    var volGender = $(this).text();
                    console.log(volGender);
                    Volunteer = Volunteer + " volGender: " + volGender;
                });
                $(this).find("volAddress").each(function(){
                    var volAddress = $(this).text();
                    console.log(volAddress);
                    Volunteer = Volunteer + " volAddress: " + volAddress; 
                });
                $(this).find("volEmail").each(function(){
                	var volEmail = $(this).text();
                	console.log(volEmail);
                	Volunteer = Volunteer + " volEmail: " + volEmail; 
                });
                $(this).find("phoneNumber").each(function(){
                    var phoneNumber = $(this).text();
                    console.log(phoneNumber);
                    Volunteer = Volunteer + " phoneNumber: " + phoneNumber;
                });
            });
            alert(Volunteer);
        }
    });
   return true;
 })
 
 $("#updateForm").on("submit", function(){
   
    $.ajax({
        url: 'read/VolunteerHours',
        type: 'PUT',
        dataType: "xml",
        data:$("#updateForm").serialize(),
        success: function(xml) {
            console.log(xml);
            var VolunteerHours="";
            $(xml).find('VolunteerHours').each(function(){
                $(this).find("volunteerID").each(function(){
                    var volunteerID = $(this).text();
                    console.log(volunteerID);
                    VolunteerHours = VolunteerHours + " volID: " + volunteerID; 
                });
                $(this).find("NonprofitID").each(function(){
                    var NonprofitID = $(this).text();
                    console.log(NonprofitID);
                    VolunteerHours = VolunteerHours + " npoID: " + NonprofitID;
                });
                $(this).find("year").each(function(){
                    var year = $(this).text();
                    console.log(year);
                    VolunteerHours = VolunteerHours + " year: " + year; 
                });
                $(this).find("month").each(function(){
                    var month = $(this).text();
                    console.log(month);
                    VolunteerHours = VolunteerHours + " month: " + month; 
                });
                $(this).find("day").each(function(){
                    var day = $(this).text();
                    console.log(day);
                    VolunteerHours = VolunteerHours + " day: " + day; 
                });
                $(this).find("numHours").each(function(){
                    var numHours = $(this).text();
                    console.log(numHours);
                    VolunteerHours = VolunteerHours + " numHours: " + numHours; 
                });
            });
            alert(VolunteerHours);
        }
    });
   return true;
 })
 });