<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>TODO list</title>
<script type="text/javascript">
var post;
$( document ).ready(function() {
	post = function (url) {

	$.ajax({
		   type:'POST',
		   url :url, 
		   headers: {'Access-Control-Allow-Origin': '*',
		   'Access-Control-Allow-Methods': '*',
		   'Access-Control-Allow-Headers': 'api-key,content-type',
		   'Access-Control-Allow-Credentials': true},
		   success: function(data) {
		        console.log('success',data);
		   },
		   error:function(exception){alert('Exeption:'+exception);}
		}); 
}});

</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<div class="row">
			<div class="col-sm mx-auto">Hello ${user}</div>

		</div>
		<c:if test="${empty tasks}">
			<div class="row">
				<div class="col-sm">You don't have any task</div>

			</div>
		</c:if>
		<c:if test="${not empty tasks}">
			<div class="row">
				<form:form method="POST" action="/SpringMVCCRUDSimple/editsave">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Description</th>
								<th scope="col">Last Update</th>
								<th scope="col">#</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks}">
								<tr>
									<td>${task.description}</td>
									<td>${task.lastUpdate}</td>
									<td><spring:url value="/users/${task.id}" var="userUrl" />
										<spring:url value="/task/${task.id}/delete" var="deleteUrl" />
										<spring:url value="/users/${task.id}/update" var="updateUrl" />
										<button type="button" class="btn btn-primary editbtn">Edit</button>
										<button type="button" class="btn btn-danger"
											onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
										<button type="button" class="btn btn-success">Add</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form:form>
			</div>
		</c:if>
	</div>


</body>
</html>