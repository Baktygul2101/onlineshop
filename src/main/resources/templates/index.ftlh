<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
</head>
<body>
<h1>Содержимое страницы</h1>

<ul>
    <#list products as pr>
        <li>
            <p>${pr.id} - ${pr.name} - ${pr.image} - ${pr.quantity} -${pr.description}-${pr.price}</p>
        </li>
    </#list>
</ul>

</body>
</html>
