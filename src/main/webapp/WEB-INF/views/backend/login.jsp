<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-wrapper">
	<div class="page-content--bge5">
		<div class="container">
			<div class="login-wrap">
				<div class="login-content">
					<div class="login-logo">
						<a href="#"> <img
							src="<c:url value="/assets/login/images/icon/logo.png"/>"
							alt="CoolAdmin">
						</a>
					</div>
					<div class="login-form">
						<h4 style="color: red; font-weight: bold">${failed}</h4>
						<form action="<c:url value='j_spring_security_login' />"
							name='loginForm' method="post">

							<div class="form-group">
								<label>Tên tài khoản</label> <input
									class="au-input au-input--full" type="text" name="username"
									required="required" placeholder="Email">
							</div>
							<div class="form-group">
								<label>Mật khẩu</label> <input class="au-input au-input--full"
									required="required" type="password" name="password"
									placeholder="Password">
							</div>
							<!-- <div class="login-checkbox">
								<label> <input type="checkbox" name="remember">Remember
									Me
								</label> <label> <a href="#">Forgotten Password?</a>
								</label>
							</div> -->
							<button class="au-btn au-btn--block au-btn--green m-b-20"
								type="submit">sign in</button>
							<!-- <div class="social-login-content">
								<div class="social-button">
									<button class="au-btn au-btn--block au-btn--blue m-b-20">sign
										in with facebook</button>
									<button class="au-btn au-btn--block au-btn--blue2">sign
										in with twitter</button>
								</div>
							</div> -->
						</form>
						<!-- <div class="register-link">
							<p>
								Don't you have account? <a href="#">Sign Up Here</a>
							</p>
						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>

</div>




