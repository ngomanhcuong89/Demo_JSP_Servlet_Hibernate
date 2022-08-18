<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="row">
    <article class="col">
        <div class="card">
            <div class="card-header">
                ${empty AddOrEdit?"Add New Category":"Edit Category"}
            </div>
            <ul class="card-body">
                <form action=${not empty AddOrEdit?"editcategory":"addcategory"} method="post">
                    <c:if test="${not empty AddOrEdit}">
                        <div class="form-group">
                            <label for="categoryId">Category ID: </label>
                            <input type="text" class="form-control" id="categoryId" name="categoryId" value="${AddOrEdit.getCategoryId()}"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Name: </label>
                            <input type="text" class="form-control" id="name" name="name" value="${AddOrEdit.getCategoryName()}"/>                  
                        </div>
                    </c:if>              
                    <c:if test="${empty AddOrEdit}">
                        <div class="form-group">
                            <label for="categoryId">Category ID: </label>
                            <input type="text" class="form-control" id="categoryId" name="categoryId"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Name: </label>
                            <input type="text" class="form-control" id="name" name="name"/>                  
                        </div>
                    </c:if>  
                    
                    <div class="form-group" style="margin-top: 5px;"> 
                        <c:if test="${empty AddOrEdit}">
                            <input type="submit" class="btn btn-primary" value="Add New"/>
                        </c:if>
                        <c:if test="${not empty AddOrEdit}">
                            <input type="submit" class="btn btn-primary" value="Edit Now"/>
                        </c:if>                  
                    </div> 
                </form>
            </ul>
        </div>
    </article>
</section>
<%@include file="../../common/templates/backend/footer.jsp" %>