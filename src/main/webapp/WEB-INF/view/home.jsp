<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link href="/css/home.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	$(document).ready(function() {

		post = function(url) {

			$.ajax({
				type : 'POST',
				url : url,
				headers : {
					'Access-Control-Allow-Origin' : '*',
					'Access-Control-Allow-Methods' : '*',
					'Access-Control-Allow-Headers' : 'api-key,content-type',
					'Access-Control-Allow-Credentials' : true
				},
				success : function(data) {
					location.reload();
				},
				error : function(exception) {
					alert('Exeption:' + exception);
				}
			});
		}
	});
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		
			<p class="text-center">Hello ${user}</p>


	

		<form:form method="POST" modelAttribute="task" action="/task/add">
			<div class="row">
				<div class="col-sm">
					
				</div>
				<div class="col-sm">
					<form:input path="description" type="text" class="form-control"
						placeholder="Enter task description" />
				</div>
				<form:hidden path="username" value="${user}" />
				<div class="col-sm">
					<button id="addTask" type="submit" class="btn btn-success">Add
						a task</button>
				</div>
			</div>
		</form:form>
		<c:if test="${empty tasks}">
			<div class="row">
				<div class="col-sm">You don't have any task</div>

			</div>
		</c:if>

		<div class="row">
		<div id="table-style">
			<form:form method="POST" action="/SpringMVCCRUDSimple/editsave">
				<table id="task-table" class="table table-striped">
					<thead>
						<tr>
							<th class="w-50" scope="col">Description</th>
							<th class="w-30" scope="col">Last Update</th>
							<th class="w-20"scope="col" ></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="task" items="${tasks}">
							<tr>
								<td>${task.description}</td>
								<td>${task.lastUpdate}</td>
								<td style='text-align: right;'><spring:url value="/users/${task.id}" var="userUrl" />
									<spring:url value="/task/${task.id}/delete" var="deleteUrl" />
								
									<button type="button" class="btn btn-danger"
										onclick="post('${deleteUrl}')">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form:form>
			</div>
		</div>

	</div>


</body>
</html>