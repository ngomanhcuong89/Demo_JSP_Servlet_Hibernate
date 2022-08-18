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
                <form action=${not empty AddOrEdit?"editproduct":"addproduct"} method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="productId">Product ID: </label>
                        <input type="text" id="productId" name="productId" value="${AddOrEdit.productId}" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="Category">Category: </label>
                        <select name="Category" id="Category" class="form-control">
                            <c:forEach items="${Category}" var="item">
                                <option value="${item.categoryId}">${item.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="name">Name: </label>
                        <input type="text" id="name" name="name" value="${AddOrEdit.productName}" class="form-control"/>                  
                    </div>
                    <div class="form-group">
                        <label for="image">Image: </label>
                    </div>
                    <div class="form-group">
                        <c:if test="${not empty AddOrEdit}">
                            <img src="uploads/${AddOrEdit.image}" alt="${AddOrEdit.image}" width="100px" height="100px" style="margin: 5px 0px"/>
                        </c:if>
                        <input type="file" id="image" name="image" class="form-control"/>                  
                    </div>         
                    <div class="form-group">
                        <label for="quantity">Quantity: </label>
                        <input type="text" id="quantity" name="quantity" value="${AddOrEdit.quantity}" class="form-control"/>                  
                    </div>   
                    <div class="form-group">
                        <label for="price">Price: </label>
                        <input type="text" id="price" name="price" value="${AddOrEdit.price}" class="form-control"/>                  
                    </div>
                    <div class="form-group">
                        <label for="status">Status: </label>
                        <select name="status" id="status" class="form-control">
                            <option value="instock">In-Stock</option>
                            <option value="outstock">Out-Stock</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="date">Manufactured Date: </label>
                        <input type="text" name="date" id="date" value="${AddOrEdit.manufacturedDate}" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description: </label>
                        <textarea type="text" name="description" id="description" value="${AddOrEdit.description}" class="form-control"></textarea>
                    </div>

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