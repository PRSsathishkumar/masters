function purchaseproduct() {
    var pur = "";
    pur += "<div class=\"pur\">";
    pur += "<h2> ADD PURCHASE <\/h2>";
    pur += "<table>";
    pur += "<tr>";
    pur += "<td> Purchase Id <\/td>";
    pur += "<td><input type = \"text\" placeholder=\"purchase Id\" id=\"pId\"><\/td>";
    pur += "<\/tr>";
    pur += "<tr>";
    pur += "<td> Bill Date <\/td>";
    pur += "<td><input type=\"date\" placeholder=\"Bill Date\" id=\"date\"><\/td>";
    pur += "<\/tr>";
    pur += "<tr>";
    pur += "<td> Value Added Tax <\/td>";
    pur += "<td><input type=\"text\" placeholder=\"Value Added Tax\" id=\"vat\"><\/td>";
    pur += "<\/tr>";
    pur += "<tr>";
    pur += "<td> Discount <\/td>";
    pur += "<td><input type=\"text\" placeholder=\"Discount\" id=\"discount\"><\/td>";
    pur += "<\/tr>";
    pur += "<tr>";
    pur += "<td> Bill Total <\/td>";
    pur += "<td><input type=\"text\" placeholder=\"Bill Total\" id=\"tot\"<\/td>";
    pur += "<td><img src=\"images/nextButton.png\" id=\"ima\"><\/td>";
    pur += "<\/tr>";
    pur += "<\/table>";
    pur += "<\/div>";
    $('#lists')[0].innerHTML = pur;
}

function purchasePayment() {
    pay = "";
    pay += "<div class=\"pay\">";
    pay += "<h2>Purchase Payment<\/h2>";
    pay += "<table>";
    pay += "<tr>";
    pay += "<td>Payment Date<\/td>";
    pay += "<td><input type=\"date\" id=\"Date\"><\/td>";
    pay += "<\/tr>";
    pay += "<tr>";
    pay += "<td>Paid Amount<\/td>";
    pay += "<td><input type=\"text\" placeholder=\"Paid Amount\" id=\"amount\"><\/td>";
    pay += "<\/tr>";
    pay += "<tr>";
    pay += "<td><input type=\"submit\" value=\"Add\" id=\"add\">";
    pay += "<input type=\"submit\" value=\"Update\" id=\"update\"><\/td>";
    pay += "<\/tr>";
    pay += "<\/table>";
    pay += "<\/div>";
    $('#lists')[0].innerHTML = pay;
}

function purchaseLineItem() {
    var purLine = "";
    purLine += "<div class=\"purLine\">";
    purLine += "<h2>PurchaseLineItem<\/h2>";
    purLine += "<table>";
    purLine += "<tr>";
    purLine += "<td>purchase Line Id:<\/td>";
    purLine += "<td><input type=\"text\" placeholder=\"purchase Line Id\" id=\"lineId\"><\/td>";
    purLine += "<\/tr>";
    purLine += "<tr>";
    purLine += "<td>Purchase Id:<\/td>";
    purLine += "<td><input type=\"text\" placeholder=\"Purchase Id\" id=\"pId\"><\/td>";
    purLine += "<\/tr>";
    purLine += "<tr>";
    purLine += "<td>Product Id:<\/td>";
    purLine += "<td><input type=\"text\" placeholder=\"product Id\" id=\"proId\"><\/td>";
    purLine += "<\/tr>";
    purLine += "<tr>";
    purLine += "<td>Quantity :<\/td>";
    purLine += "<td><input type=\"text\" placeholder=\"quantity\" id=\"quantity\"<\/td>";
    purLine += "<\/tr>";
    purLine += "<tr>";
    purLine += "<td>Buy Price:<\/td>";
    purLine += "<td><input type=\"text\" placeholder=\"Buy Price\" id=\"buy\"<\/td>";
    purLine += "<\/tr>";
    purLine += "<tr>";
    purLine += "<td>Sell Price:<\/td>";
    purLine += "<td><input type=\"text\" placeholder=\"Sell Price\" id=\"sel\"><\/td>";
    purLine += "<\/tr>";
    purLine += "<tr>";
    purLine += "<td><input type=\"submit\"  id=\"sub\">";
    purLine += "<input type=\"button\" value=\"Update\" id=\"up\"><\/td>";
    purLine += "<\/tr>";
    purLine += "<\/table>";
    purLine += "<\/div>";
    $('#lists')[0].innerHTML = purLine;
}
