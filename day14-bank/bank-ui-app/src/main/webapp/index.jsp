<html>
    <body>
        <h1>Welcome to training bank</h1>
        <form method="post">
            <input type="text" placeholder="Account number" name="accountnumber"> <br/>
            <input type="number" placeholder="Amount" name="amount"> <br/>
            <button formaction="/bank/deposit">Deposit</button>
            <button formaction="/bank/withdraw">Withdraw</button>
            <h2>
                <% out.println(session.getAttribute("message")); %>
            </h2>
        </form>
    </body>
</html>