function validate(frm){
  frm.vflag.value="yes";
  //set styles to errorMsg
  document.getElementById("nameErr").innerHTML="";
  document.getElementById("ageErr").innerHTML="";
  document.getElementById("nameErr").style="color.red";
  document.getElementById("nameErr").style="color.red";
  
  //read form data
    var name=frm.pname.value;
     var age=frm.page.value;
  //perform client side form validation
  
 
   if(name==""){
     //alert("please enter name");
    document.getElementById("errname").innerHTML="please Enter Name::";
     frm.pname.focus();
      return false;
   }
   if(age==""){
     //alert("please enter age::");
     document.getElementById("errage").innerHTML="please Enter Age::";
      frm.page.focus();
       return false;
   } 
   
   
   else{
       if(isNaN(age)){
        //alert("Please enter age must be nemeric value");
        document.getElementById("errage").innerHTML="Please Enter Numeric Age::";
        frm.page.focus();
         return false;
          }
        } 
     
   if(age<1 || age>125){
	 // alert("Please ENter age between 1year to 125 year");
	 document.getElementById("errage").innerHTML="Please Enter Age Between 1 year to 125 Year";
	  frm.page.focus();
        return false;
   }
       return true;
}