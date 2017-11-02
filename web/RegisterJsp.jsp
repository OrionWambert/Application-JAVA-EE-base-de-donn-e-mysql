<%-- 
    Document   : RegisterJsp
    Created on : 31 oct. 2017, 11:41:53
    Author     : Orion WAMBERT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Inscription</title>


    </head>
    <jsp:include page="style2.jsp" />

    <body>

        <header class="container-fluid">

            <div class="pull-left">Inscription</div>

        </header>

        <br><br><br>

        <div class="row">
            <div class="col-lg-5 col-md-5 pull-right">
                <table class="table table-bordered table-striped table-condensed">
                    <thead>
                    <th>id</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Age</th>
                    

                    </thead>
                    <tbody>

                        <c:forEach items="${listUser}" var="u"  varStatus="i">
                            <tr>

                                <td>${u.id}</td>
                                <td>${u.nom}</td>
                                <td>${u.prenom}</td>
                                 <td>${u.age}</td>
                                 <td>
                                     <form method="POST" action="<c:url value="/"/>">
                                         <input type="hidden" value="${u.id}" name="id">
                                         <input type="submit" name="btn1" value="remove" 
                                 class="btn btn-danger">
                                     </form>
                                 </td>
                                 
                                 <td>
                                     <form method="POST" action="<c:url value="/"/>">
                                         <input type="hidden" value="${u.id}" name="id2">
                                         <input type="submit" name="btn1" value="modification" 
                                 class="btn btn-danger">
                                     </form>
                                 </td>
                                 
                                

                                

                            </tr>                                                      
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class=" col-lg-6 col-md-6 box">

                    <form method="POST" action="<c:url value="/" />"                       >
                        <div class="form-group">
                            <label>Nom</label>
                            <input type="text" name="nom" value="${user!=null?user.nom:""}" class="form-control" />

                        </div>
                        <div class="form-group">
                            <label>Prenom</label>
                            <input type="text" name="prenom" value="${user!=null?user.prenom:""}" class="form-control" />
                        </div>



                        <div class="form-group">
                            <label>Age</label>
                            <input type="number" name="age" value="${user!=null?user.age:""}" class="form-control" >
                        </div>
                        <input type="hidden" value="${user!=null?user.id:""}" name="id3">
                        <button type="submit" name="btn1" value="1" class="btn btn-success">Valider</button>
                        <button type="submit" name="btn1" value="2" class="btn btn-success">voir</button>
                        <button type="submit" name="btn1" value="3" class="btn btn-success">modifier</button>





                </div><br>
                <div class="col-lg-6 col-md-6 top_div_register">
                    ${message!=null?message:""}
                </div>

            </div>


        </div>

    </body>

    <jsp:include page="/style.jsp" />

</html>




