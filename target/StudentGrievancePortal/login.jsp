<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <title>Login | Student Grievance Portal</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="auth-page">

    <div class="auth-container">

        <!-- Left Branding Section -->
        <div class="auth-brand">

            <div class="brand-icon">🎓</div>

            <h1>Student<br>Grievance Portal</h1>

            <p>
                A smarter way to raise, track and resolve
                college complaints.
            </p>

            <div class="brand-line"></div>

            <div class="feature">
                <span>✓</span>
                Easy complaint submission
            </div>

            <div class="feature">
                <span>✓</span>
                Track complaint status
            </div>

            <div class="feature">
                <span>✓</span>
                Faster communication
            </div>

        </div>


        <!-- Login Section -->
        <div class="auth-card">

            <div class="mobile-brand">
                🎓 Student Grievance Portal
            </div>

            <div class="login-heading">
                <span class="small-title">WELCOME BACK</span>

                <h2>Sign in to your account</h2>

                <p>
                    Enter your details to continue.
                </p>
            </div>


            <% if(request.getAttribute("error") != null) { %>

                <div class="alert">
                    <%= request.getAttribute("error") %>
                </div>

            <% } %>


            <% if(request.getParameter("registered") != null) { %>

                <div class="success">
                    Registration successful. Please login.
                </div>

            <% } %>


            <form method="post" action="login">

                <div class="input-group">

                    <label>Email Address</label>

                    <input
                        name="email"
                        type="email"
                        placeholder="Enter your email"
                        required>

                </div>


                <div class="input-group">

                    <label>Password</label>

                    <input
                        name="password"
                        type="password"
                        placeholder="Enter your password"
                        required>

                </div>


                <button type="submit" class="login-btn">
                    Login
                    <span>→</span>
                </button>

            </form>


            <div class="register-text">
                Don't have an account?
                <a href="register.jsp">Create account</a>
            </div>


            <div class="demo-box">

                <div class="demo-title">
                    DEMO ACCOUNTS
                </div>

                <div class="demo-account">
                    <strong>Admin</strong>
                    <span>admin@college.com</span>
                    <small>admin123</small>
                </div>

                <div class="demo-account">
                    <strong>Student</strong>
                    <span>student@college.com</span>
                    <small>student123</small>
                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>