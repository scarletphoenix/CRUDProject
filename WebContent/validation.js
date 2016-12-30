
function validateID(){
var id = document.myForm.id.value;
if(id==null || id==0){
	alert("ID NOT ENTERED");
	return false;
	}
else if(!id.match(/^\d+/)){
	alert("INVALID CHARACTERS ENTERED!Enter only numeric characters!");
	return false;
	}



}

function validate(){
	var id = document.myForm.id.value;
	var name = document.myForm.name.value;
	var salary = document.myForm.salary.value;
	if(id==null || id==0){
		alert("ID NOT ENTERED");
		return false;
		}
	else if(isNaN(id)){
		alert("INVALID CHARACTERS ENTERED for ID!Enter only numeric characters!");
		return false;
		}
	else if(name==null || name==""){
		alert("NAME NOT ENTERED");
		return false;
	}
	else if(!/^[a-zA-Z]*$/g.test(name)){
		alert("INVALID CHARACTERS ENTERED for Name! No numbers allowed");
		return false;
		}
	
	else if(salary==0){
		alert("Salary NOT ENTERED");
		return false;
	}
	else if(isNaN(salary)){
		alert("INVALID CHARACTERS ENTERED for Salary! Only numbers allowed");
		return false;
		}
	}