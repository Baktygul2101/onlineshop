<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<form action="/register" method="post">
    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">email: </p>
            <input type="email" name="email" placeholder="Your email" value="${(form.email)}">
        </label>
    </div>


    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">Name: </p>
            <input type="text" name="name" placeholder="Your name" value="${(form.name)}">

        </label>
    </div>
    <div>
        <button type="submit">Registration</button>
    </div>
    <div>
        <#if errors?? >
            <p>Enter data with errors</p>
            <#list errors as fieldErrors>
                <p>${fieldErrors.field} - ${fieldErrors.defaultMessage!'--------no mesage!-------'} </p>
            </#list>
        </#if>
    </div>
</form>
</body>
</html>