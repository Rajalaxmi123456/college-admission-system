<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Admission </title>

<script src="https://kit.fontawesome.com/1ea45b4a27.js" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
   integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
  </script>
  
  <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
  

</head>

<style>
.box{
   border: 4px solid black;
}

.title{
   position:absolute;
   top:140px;
   left:180px;
   background-color:white;
}

.container{
   background-color:skyblue;
}

</style>

<body>

<c:if test="$ {msg eq 'success'}">
<script>
toastr.success('admission success');
</script>
</c:if>

<c:if test="$ {msg eq 'error'}">
<script>
toastr.error('admission failed');
</script>
</c:if>


<div class="container">
         <div class="h2  bg-dark text-light text-center p-2">College Admission From</div>
          
          <span class="text-danger" style="float:right">*mandatory fields </span>
          
         <form method="post" action="./saveAdmission" enctype="multipart/form-data" class="" id="form" onsubmit="return validateForm();" name="admForm">
         
          <div class="row">
          
               <div class="col-md-4">
                    <label>College Name <span class="text-danger">*</span></label>
                    <select class="form-control" id="cId" name="college" onchange="getBranch()" name="college" required>
                        <option value="-1">-- select --</option>
                        <c:forEach items="${cList}" var="c">
                           <option value="${c.collegeId}">${c.collegeName}</option>
                         </c:forEach> 
                     </select>
                </div> 
            
                <div class="col-md-4"> 
                     <label>Branch Name  <span class="text-danger">*</span></label>
                     <select id="bId" class="form-control" name="branch" onchange="getFee()">
                        <option value="-1">-- select --</option>
                     </select> 
                </div>
                
                <div class="col-md-4">
                     <label>Fees(Rs.)</label>
                     <div id="feeInp">
                          <input type="text" class="form-control" disabled>
                     </div>
                </div>
                     
      <div>
         <div class="box mt-4 p-3">
             <div class="title px-3"><u><b>Applicant Details</b></u></div>
             
              <div class="row">       
                <div class="col-md-4"> 
                    <label>Name  <span class="text-danger">*</span> </label>
                    <input type="text" name="name" class="form-control" placeholder="enter your name" id="name">
                </div>
                
                 <div class="col-md-4">
                     <label>Email  <span class="text-danger">*</span></label>
                     <input type="email" name="email" class="form-control" placeholder="enter your email" id="email">
                 </div>
                 
                <div class="col-md-4">
                     <label>Mobile No. <span class="text-danger">*</span></label>
                     <input type="text" name="mobile" class="form-control"  placeholder="enter phone number" id="mobile"> 
                </div>
                
                <div class="col-md-4"> 
                     <label>DOB  <span class="text-danger">*</span> </label>
                     <input type="date" name="dob" class="form-control" id="dob">
               </div>
               
                <div class="col-md-4 p-3 text-center"> 
                     <label class="px-2">Gender  <span class="text-danger">*</span></label> <br> 
                     <input type="radio" name="gender" value="m">Male
                     <input type="radio" name="gender" value="f">Female        
                 </div>
                 
                 <div class="col-md-4"> 
                     <label>Upload Photo  <span class="text-danger">*</span></label>
                     <input type="file" name="photo" class="form-control" id="photo">
               </div>
               
               <div class=" text-center mt-4">
                   <button class="btn btn-success" type="submit" style="box-shadow:5px 5px lightgrey">Submit</button>
                   <button class="btn btn-danger" type="reset" style="box-shadow:5px 5px lightgrey">Reset</button>
               </div>
            </div> 
          </div> 
            </div>   
    </form>
</div>
      <!--  ${regList}-->
      <div class=" bg-light mt-4">
           <div class="h2 bg-secondary text-center text-light">Registration Details</div>

   <table class="table table-bordered table-striped">
       <thead class="bg-primary text-light">
           <tr>
              <th>Sl</th>
              <th>Name</th>
              <th>Email</th>
              <th>Moblie</th>
              <th>Image</th>
              <th>College</th>
              <th>Branch</th>
               <th>Action</th>
           </tr>
       </thead>
       
       <tbody>
          <c:forEach var="reg" items="${regList}" varStatus="counter">
              <tr>
                 <td>${counter.count}</td> 
                 <td>${reg.appName}</td>
                 <td>${reg.email}</td> 
                 <td>${reg.mobile}</td> 
                 <td>${reg.imagepath}</td> 
                 <td>${reg.collegeMaster.collegeName}</td> 
                 <td>${reg.collegeMaster.collegeName}-
                     ${reg.branchMaster.branchName}</td> 
                 <td><a href="./deleteRegDetails?regId=${reg.regId}"> <span class="btn btn-danger"><i class="fa-solid fa-xmark"></i></span></td>  
              </tr>
           </c:forEach>   
       </tbody>
   </table>
</div> 

<script>
function getBranch(){
	 
	 let collegeId=$("#cId").val();
	 
	 $.ajax({
		 url: "./getBranch",
		 type:"post",
		 data:"cId=" +collegeId,
		 success: function(response){
			 $("#bId").empty();
			 $("#bId").append(response);
		 }
	 });
}

function validateForm(){
     let collage = $("#cId").val();
     let branch = $("#bId").val();
     let name = $("#name").val();
     let email = $("#email").val();
     let mobile = $("#mobile").val();
     let dob = $("#dob"). val();
     let gender = $('input[name="gender"]:checked').val();
     let photo = $("#photo").val();
     
		if (collage === "-1") {
			toastr.error('Please select a College.');
			return false;
		}
		
		if (branch === "-1" ){
			toastr.error('Please select a Branch.'); 
			return false;
		}
		if (!name || name.trim() ===""){
			toastr.error('Name is required.');
			 $("#name").focus();
			 return false;
		}
		if (!email || email.trim() ===""){
			toastr.error('Email is required.');
			    $("#email").focus();
			    return false;
		    }
		
		if (!mobile || mobile.trim() ===""){
			toastr.error('Mobile number is required. ');
			$("#mobile").focus();
			return false;
		}
	    if (mobile && mobile.length <10){
	    	toastr.error('Mobile number is invalid.');
	    	 $("#mobile").focus(); 
	    	 return false;
	    }
		if (!dob || dob.trim() === ""){
			toastr.error('Date of Birth is required.');
			 $("#dob").focus();
			 return false;
		}
		if (!gender){
			toastr.error('Please select Gender.'); 
			return false;
		}
		if (!photo || photo.trim() === ""){
			toastr.error('Please upload a Photo.');
			$("#photo").focus();
			return false;
		}
		
		 return true;
}

function getFee(){
    let branchId=$("#bId").val();
	 
	 $.ajax({
		 url: "./getFeeByBranch",
		 type:"post",
		 data : "bId=" + branchId,
		 success : function (response){
			<!-- alert(response)-->
			 $("#feeInp").empty();
			 $("#feeInp").append(response);
		 }
	 });
	 
}
</script>
</body>
</html>