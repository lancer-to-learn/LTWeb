<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="/">Home</a></li>
            <li><a href="/user-account">My Account</a></li>
            <li><a href="/cart">Cart</a></li>
            <li class="active">Checkout</li>

        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <h1>Checkout</h1>
            <!-- BEGIN CHECKOUT PAGE -->
            <div class="panel-group checkout-page accordion scrollable" id="checkout-page">
            <form method="get" action="pay">
              <!-- BEGIN CHECKOUT -->
              <!-- END CHECKOUT -->

              <!-- BEGIN PAYMENT ADDRESS -->
              <!-- END PAYMENT ADDRESS -->

              <!-- BEGIN SHIPPING ADDRESS -->
              <div id="shipping-address" class="panel panel-default">
                <div class="panel-heading">
                  <h2 class="panel-title">
                    <a data-toggle="collapse" data-parent="#checkout-page" href="#shipping-address-content" class="accordion-toggle">
                      Step 1: Choose your city
                    </a>
                  </h2>
                </div>
                <div id="shipping-address-content" class="panel-collapse collapse">
                  <div class="panel-body row">
                    <div class="col-md-6 col-sm-6">
                      <div class="form-group">
                        <label for="country-dd">City <span class="require">*</span></label>
                        <select class="form-control input-sm" id="mySelect" name="city"
                        	onChange="ship(); document.getElementById('selectedValue').innerHTML = this.value; ">
                          <option>--Please Select--</option>
                          <c:forEach items="${ listCity }" var="city"> 

                          <option>${ city.name }</option>
                          
                          </c:forEach>
                        </select>  
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- END SHIPPING ADDRESS -->

              <!-- BEGIN SHIPPING METHOD -->
              <!-- END SHIPPING METHOD -->

              <!-- BEGIN PAYMENT METHOD -->
              <div id="payment-method" class="panel panel-default">
                <div class="panel-heading">
                  <h2 class="panel-title">
                    <a data-toggle="collapse" data-parent="#checkout-page" href="#payment-method-content" class="accordion-toggle">
                      Step 2: Payment Method
                    </a>
                  </h2>
                </div>
                <div id="payment-method-content" class="panel-collapse collapse">
                  <div class="panel-body row">
                    <div class="col-md-12">
                      <p>Please select the preferred payment method to use on this order.</p>
                      <div class="radio-list">
                        <label>
                          <input type="radio" name="paymentmethod"> Cash On Delivery
                        </label>
                      </div>
                      <div class="radio-list">
                        <label>
                          <input type="radio" name="paymentmethod"> Pay With Credit Cart
                        </label>
                      </div>
                      <button class="btn btn-primary  pull-right" type="submit" id="button-payment-method" data-toggle="collapse" data-parent="#checkout-page" data-target="#confirm-content">Continue</button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- END PAYMENT METHOD -->

              <!-- BEGIN CONFIRM -->
              <div id="confirm" class="panel panel-default">
                <div class="panel-heading">
                  <h2 class="panel-title">
                    <a data-toggle="collapse" data-parent="#checkout-page" href="#confirm-content" class="accordion-toggle">
                      Step 3: Confirm Order
                    </a>
                  </h2>
                </div>
                <div id="confirm-content" class="panel-collapse collapse">
                  <div class="panel-body row">
                    <div class="col-md-12 clearfix">
                      <div class="table-wrapper-responsive">
                      <table>
                        <tr>
                          <th class="goods-page-image">Image</th>
                          <th class="goods-page-description">Description</th>
                          <th class="goods-page-quantity">Quantity</th>
                          <th class="goods-page-price">Unit price</th>
                          <th class="goods-page-total" colspan="2">Total</th>
                        <c:forEach items="${ sessionScope.cart }" var="item">
                        <tr>
                          <td class="goods-page-image">
                            <a href="productdetail?pid=${ item.value.product.pId }"><img src="${ item.value.product.pImage }" alt="${ item.value.product.pName }"></a>
                          </td>
                          <td class="goods-page-description"> 
                            <h3><a href="productdetail?pid=${ item.value.product.pId }">${ item.value.product.pName }</a></h3>
                          </td>
                          <td class="goods-page-quantity">
                            <div class="product-quantity">
                                <input type="number" 
                                value= "${ item.value.quantity }" 
                                class = "form-control" id="product-quantity" disabled>
                              </div> 
                          </td>
                          <td class="goods-page-price">
                            <strong><span>$</span>${ item.value.price }</strong>
                          </td>
                          <td class="goods-page-total">
                            <strong><span>$</span>${ item.value.quantity*item.value.price }</strong>
                          </td>
                        </tr>
                        </c:forEach>
                      </table>
                      </div>
                      <div class="checkout-total-block">
                          <ul>
                            <li>
                              <em>Number of products: </em>
                              <strong class="price"><span id = "cart_quantity">${ sessionScope.cart_quantity }</span></strong>
                            </li>
                            
                            <li>
                              <em>City: </em>
                              <strong class="price"><span id="selectedValue"></span></strong>
                            </li>
                            
                            <li class="shopping-total-price">
                              <em>Total Pay: </em>
                              <strong class="price"><span id="totalPay"></span></strong>
                            </li>
                          </ul>
                      </div>
                      <div class="clearfix"></div>
                      <button class="btn btn-primary pull-right" type="submit" onclick = "confirm_order()" value = "Thanh toan" id="button-confirm"> Confirm Order</button>
                      <a href="cart-item"><button type="button" class="btn btn-default pull-right margin-right-20">Cancel</button></a>
                    </div>
                  </div>
                </div>
              </div>
              <!-- END CONFIRM -->
              </form>
            </div>
            
            <!-- END CHECKOUT PAGE -->
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>
    
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>    
 function ship(){	
		/*  tạo viên amount để Gọi và đếm classname là product */
		var city = $('#mySelect').val();
		var tt = ${total};
		$.ajax({
			url : "/Laptop/ship",
			type : "get", //send it through get method
			data : ({
				cityName : city,
				total: tt
			}),
			success : function(data) {
				//cách 1
				//$('#totalPay').val(data);
				//alert("ok");
				//cách 2
				var row = document.getElementById('totalPay');
				row.innerText = data.value;
				alert("ok");
				
			},
			error : function(xhr) {
				alert("err");
			}
		});
	 };
</script>
