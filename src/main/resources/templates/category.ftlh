<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <h1>${category.categoryName}</h1>


    <h2>Our today menu!</h2>
    <div class="flex flex-wrap" id="itemList">
        <#list items as listItem>
            <div class="flex flex-column box flex-v-center">
                <img class="food-icon" src="/images/${listItem.product.image}" alt="${listItem.product.name}">
                <a href="/products/${listItem.id}">${listItem.name}</a>
            </div>
        </#list>
    </div>

    <#include "partials/pagination.ftlh">

    <div>
        <a href="/">Back to home page</a>
    </div>

</@main.renderWith>