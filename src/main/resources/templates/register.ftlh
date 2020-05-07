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
            <p class="label-input-text">Имя:</p>
            <input type="text" name="name" placeholder="ваше имя"  value="${(form.name)!''}">
        </label>
    </div>
    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">Имя:</p>
            <input type="text" name="address" placeholder="ваш адрес"  value="${(form.address)!''}">
        </label>
    </div>
    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">Имя:</p>
            <input type="text" name="phoneNumber" placeholder="ваш телефон"  value="${(form.phoneNumber)!''}">
        </label>
    </div>
    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">Адрес почты:</p>
            <input type="text" name="email" placeholder="ваш адрес почты"  value="${(form.email)!''}" >
        </label>
    </div>


    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">Пароль:</p>
            <input type="text" name="password" placeholder="ваш пароль"  value="${(form.password)!''}" >
        </label>
    </div>
    <div>
        <button type="submit">Регистрация</button>
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