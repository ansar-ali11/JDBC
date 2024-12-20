<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Page</title>
    <style>
        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f9f9f9;
            padding: 20px;
        }

        .order-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #004080;
            margin-bottom: 10px;
        }

        p {
            text-align: center;
            margin-bottom: 20px;
            color: #555;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        .form-group input,
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }

        .form-group textarea {
            resize: none;
            height: 100px;
        }

        .btn-submit {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #004080;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-submit:hover {
            background-color: #00509e;
        }
    </style>
</head>
<body>
   

        <form action="order" method="post">
            <!-- Full Name -->
            <div class="form-group">
                <label for="name">Full Name</label>
                <input type="text" name="name"  placeholder="enter name">
        
            </div>
            <div class="form-group">
                <label for="product">Select Product</label>
                <select id="product" name="product" required>
                    <option value="">-- Choose a Product --</option>
                    <option value="Laptop">Laptop</option>
                    <option value="Smartphone">Smartphone</option>
                    <option value="Tablet">Tablet</option>
                    <option value="Headphones">Headphones</option>
                    <option value="Smartwatch">Smartwatch</option>
                </select>
            </div>

            <!-- Email -->
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" name="email"  placeholder="enter email">
            </div>
            <button type="submit" class="btn-submit">Submit Order</button>
              <!-- Product Selection -->
            

            
        </form>
        
        
    
</body>
</html>