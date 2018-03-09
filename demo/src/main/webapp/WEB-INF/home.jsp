<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a>HELLOM</a>

	<form:form role="form" modelAttribute="user" method="post" action="/tcrecog/tcRecognition">
		<div class="box-body">
			<div class="form-group">
				<label>TC No Doğrulama</label> <input type="text"
					class="form-control" id="tcNo" name="tcNo" value="${user.tcNo}"
					placeholder="TC NO:">
			</div> 
			<output class="form-control" id="result" name="result">${user.result}</output>
			
			
		</div>
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Kaydet</button>
		</div>
		
		
	</form:form>

</body>

<script>
function inputValidationControl() {
    var x, text;

    // Get the value of the input field with id="numb"
    x = document.getElementById("numb").value;

    // If x is Not a Number or less than one or greater than 10
    if (isNaN(x) || x < 10000000000 || x > 100000000000) {
        alert("Hatalı Giriş Yapıldı.");
        return false;
    } else {
        alert("Kontrol Ediliyor.");
        return true;
    }
    document.getElementById("demo").innerHTML = text;
}
</script>


</html>